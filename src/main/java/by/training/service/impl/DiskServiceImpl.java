package by.training.service.impl;

import by.training.comporator.RecordComparator;
import by.training.creator.Creator;
import by.training.creator.CreatorFabric;
import by.training.dao.Repository;
import by.training.dao.Specification;
import by.training.dao.fabric.RepositoryFabric;
import by.training.dao.fabric.SpecificationFabric;
import by.training.entity.Record;
import by.training.entity.music.Duration;
import by.training.exception.DAOException;
import by.training.exception.ParserException;
import by.training.exception.ServiceException;
import by.training.exception.ValidatorException;
import by.training.parser.ResourceParser;
import by.training.parser.fabric.RequestParserFabric;
import by.training.parser.fabric.ResourceParserFabric;
import by.training.service.DiskService;
import by.training.validator.LinesValidator;
import by.training.validator.LinesValidatorFabric;
import by.training.validator.request.RequestLineValidator;
import by.training.validator.request.RequestValidatorFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiskServiceImpl implements DiskService<Record> {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String paramDelimiter = " ";

    @Override
    public void update(Path path) throws ServiceException {
        LOGGER.info("start update in Service");

        Repository repository = RepositoryFabric.getRepository();
        try {
            repository.update(get(path));
        } catch (DAOException e) {
            LOGGER.error("exception with update from DAO");
            throw new ServiceException();
        }
    }

    @Override
    public void add(List<Record> beans) throws ServiceException {
        LOGGER.info("start add in Service");

        Repository repository = RepositoryFabric.getRepository();
        try {
            repository.add(beans);
        } catch (DAOException e) {
            LOGGER.error("exception with add from DAO");
            throw new ServiceException();
        }
    }

    public List<Record> get(Path path) throws ServiceException {

        List<String> lines;

        ResourceParser parser = ResourceParserFabric.getParser();

        try {
            lines = parser.parse(path);
        } catch (ParserException e) {
            LOGGER.error("Can not parse in update(Path path)");
            throw new ServiceException();
        }

        return get(lines);
    }

    public List<Record> get(List<String> lines) throws ServiceException {
        List<Record> recordList = new ArrayList<>();

        LinesValidator validator = LinesValidatorFabric.getValidator();
        Creator creator = CreatorFabric.getCreator();

        if (validator.valid(lines).isValid()) {
            for (String line: lines) {
                recordList.add((Record)creator.create(line));
            }
        } else {
            LOGGER.error("invalid file in update(Path pat)");
            throw new ServiceException();
        }
        return recordList;
    }

    @Override
    public List<Record> show() throws ServiceException {
        LOGGER.info("start show in Service");

        Repository repository = RepositoryFabric.getRepository();
        List<Record> recordList;
        try {
            recordList = repository.find();
        } catch (DAOException e) {
            LOGGER.warn("unuseful result from DAO");
            throw new ServiceException();
        }
        return recordList;
    }

    @Override
    public List<Record> find(String request) throws ServiceException {
        LOGGER.info("start find in Service");

        Repository repository = RepositoryFabric.getRepository();
        RequestParserFabric parserFabric = RequestParserFabric.getInstance();
        ResourceParser parser;
        try {
            parser = parserFabric.getRequestParser("one");
        } catch (ParserException e) {
            LOGGER.warn("Illegal request in find(String request)");
            throw new ServiceException();
        }
        RequestValidatorFabric validatorFabric = RequestValidatorFabric.getInstance();
        RequestLineValidator validator;
        try {
            validator = validatorFabric.getRequestValidator("find");
        } catch (ValidatorException e) {
            LOGGER.warn("Illegal request in find(String request)");
            throw new ServiceException();
        }

        List<Record> recordList;
        List<String> criteriars;
        Specification[] specifications;

        if (validator.valid(request)) {
            try {
                criteriars = parser.parse(request.trim());
                specifications = new Specification[criteriars.size()/2];
                for (int i = 0, j = 0; i < criteriars.size(); i += 2) {
                    specifications[j++] = new SpecificationFabric(criteriars.get(i + 1)).getSpecification(criteriars.get(i));
                }
            } catch (ParserException | DAOException e) {
                LOGGER.warn("Illegal request in find(String request)");
                throw new ServiceException();
            }
        } else {
            LOGGER.warn("Illegal request in find(String request)");
            throw new ServiceException();
        }

        try {
            recordList = repository.find(specifications);
        } catch (DAOException e) {
            LOGGER.warn("unuseful result from DAO");
            throw new ServiceException();
        }
        return recordList;
    }

    @Override
    public void delete(String request) throws ServiceException {
        LOGGER.info("start delete in Service");

        Repository repository = RepositoryFabric.getRepository();
        if (request.indexOf(paramDelimiter) == -1) {
            repository.delete();
        } else {
            List<Record> recordList = find(request);
            try {
                repository.delete(recordList);
            } catch (DAOException e) {
                LOGGER.warn("Exception from DAO");
                throw new ServiceException();
            }
        }
    }

    @Override
    public void save(String path) throws ServiceException {
        LOGGER.info("start save in Service");

        Repository repository = RepositoryFabric.getRepository();
        List<Record> recordList;
        try {
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            recordList = repository.find();
            for (Record record : recordList) {
                writer.println(record);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            LOGGER.error("invalid file in save(String path)");
            throw new ServiceException();
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("invalid file in save(String path)");
            throw new ServiceException();
        } catch (DAOException e) {
            LOGGER.warn("unuseful result from DAO");
        }
    }

    public Duration sum(String request) throws ServiceException {
        LOGGER.info("start sum in Service");

        List<Record> recordList = find(request);

        int minutes = 0;
        int seconds = 0;

        for (Record record : recordList) {
            minutes += record.getDuration().getMinutes();
            seconds += record.getDuration().getSeconds();
        }

        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }
        return new Duration(minutes, seconds);
    }

    @Override
    public void sort(String request) throws ServiceException {
        LOGGER.info("start sort in Service");

        Repository repository = RepositoryFabric.getRepository();
        RequestParserFabric parserFabric = RequestParserFabric.getInstance();
        ResourceParser parser;
        try {
            parser = parserFabric.getRequestParser("one");
        } catch (ParserException e) {
            LOGGER.warn("Illegal request in sort(String request)");
            throw new ServiceException();
        }
        RequestValidatorFabric validatorFabric = RequestValidatorFabric.getInstance();
        RequestLineValidator validator;
        try {
            validator = validatorFabric.getRequestValidator("sort");
        } catch (ValidatorException e) {
            LOGGER.warn("Illegal request in sort(String request)");
            throw new ServiceException();
        }

        List<Record> recordList = show();
        List<String> criteriars;

        if (validator.valid(request)) {
            try {
                criteriars = parser.parse(request.trim());
                RecordComparator[] options = new RecordComparator[criteriars.size() - 1];
                for (int i = 0; i < options.length; ++i) {
                    options[i] = RecordComparator.valueOf(criteriars.get(i + 1).toUpperCase());
                }
                if (criteriars.get(0).equals("descending")) {
                    Collections.sort(recordList, RecordComparator.descending(RecordComparator.getComparator(options)));
                } else {
                    Collections.sort(recordList, RecordComparator.ascending(RecordComparator.getComparator(options)));
                }
                repository.update(recordList);
            } catch (ParserException | DAOException e) {
                LOGGER.warn("Illegal request in sort(String request)");
                throw new ServiceException();
            }
        } else {
            LOGGER.warn("Illegal request in sort(String request)");
            throw new ServiceException();
        }
    }
}
