package by.training.service.impl;

import by.training.creator.Creator;
import by.training.creator.CreatorFabric;
import by.training.dao.Repository;
import by.training.dao.fabric.RepositoryFabric;
import by.training.entity.Record;
import by.training.exception.DAOException;
import by.training.exception.ParserException;
import by.training.exception.ServiceException;
import by.training.parser.ResourceParser;
import by.training.parser.ResourceParserFabric;
import by.training.service.DiskService;
import by.training.validator.LinesValidator;
import by.training.validator.LinesValidatorFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DiskServiceImpl implements DiskService<Record> {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String paramDelimiter = " ";

    @Override
    public void update(Path path) throws ServiceException {
        LOGGER.info("start update in Service");

        List<Record> recordList = new ArrayList<>();

        List<String> lines;

        ResourceParser parser = ResourceParserFabric.getParser();
        LinesValidator validator = LinesValidatorFabric.getValidator();
        Creator creator = CreatorFabric.getCreator();

        try {
            lines = parser.parse(path);
        } catch (ParserException e) {
            LOGGER.error("Can not parse in update(Path path)");
            throw new ServiceException();
        }
        if (validator.valid(lines).isValid()) {
            for (String line: lines) {
                recordList.add((Record)creator.create(line));
            }
        } else {
            LOGGER.error("invalid file in update(Path pat)");
            throw new ServiceException();
        }
        Repository repository = RepositoryFabric.getRepository();
        try {
            repository.update(recordList);
        } catch (DAOException e) {
            LOGGER.error("exception with update from DAO");
            throw new ServiceException();
        }
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
        LOGGER.info("start show in Service");

        Repository repository = RepositoryFabric.getRepository();
        List<Record> recordList;

        String[] criteria = request.split(paramDelimiter);
        if
        try {
            recordList = repository.find();
        } catch (DAOException e) {
            LOGGER.warn("unuseful result from DAO");
            throw new ServiceException();
        }
        return recordList;
    }
    try {
        String[] par = parameters.split("\\s+");
        Specificator[] specificators = new Specificator[par.length/2];
        if(par.length%2!=0) {
            log.warn("Illegal attribute count");
            throw new ServiceException();
        }
        for(int i = 0, k = 0; i<par.length;i+=2){
            specificators[k++] = new PlaneSpecificatorFactory(par[i+1].replace("_", " ")).createSearchSpecificator(par[i]);
        }
        List<Plane> list = repository.query(specificators);
        return list;
    } catch (DaoException e) {
        throw new ServiceException(e);
    }
}
