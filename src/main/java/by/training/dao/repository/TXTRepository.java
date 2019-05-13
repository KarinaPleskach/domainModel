package by.training.dao.repository;

import by.training.dao.Repository;
import by.training.dao.Specification;
import by.training.entity.Record;
import by.training.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TXTRepository implements Repository<Record> {

    private static final Logger LOGGER = LogManager.getLogger();

    private List<Record> recordList = new ArrayList<>();

    @Override
    public void add(List<Record> beans) throws DAOException {
        isNull(beans, "add(List<Record> beans)");
        for (Record record : beans) {
            isNull(record, "add(List<Record> beans)");
            if (!contains(record)) {
                recordList.add(record);
            }
        }
    }

    @Override
    public void update(List<Record> beans) throws DAOException {
        isNull(beans, "update(List<Record> beans)");
        for (Record record : beans) {
            isNull(record, "update(List<Record> beans)");
        }
        recordList = new ArrayList<>();
        recordList.addAll(beans);
    }

    @Override
    public void delete() {
        LOGGER.info("start delete in DAO");
        recordList = new ArrayList<>();
    }

    @Override
    public void delete(List<Record> beans) throws DAOException {
        isNull(beans, "List<Record> beans");
        for(Record record : beans){
            recordList.remove(record);
        }
    }

    @Override
    public List<Record> find(Specification<Record>... specifications) throws DAOException {
        LOGGER.info("start find in DAO");

        List<Record> result = new ArrayList<>();

        for (Record record : recordList) {
            boolean matches = true;
            for (Specification<Record> specification : specifications) {
                if (!specification.match(record)) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                result.add(record);
            }
        }
        if (result.size() == 0) {
            LOGGER.warn("zero size list in List<Record> find()");
            throw new DAOException();
        }
        return result;
    }

    @Override
    public List<Record> find() throws DAOException {
        LOGGER.info("start show in DAO");

        List<Record> result = new ArrayList<>(recordList);
        if (result.size() == 0) {
            LOGGER.warn("zero size list in List<Record> find()");
            throw new DAOException();
        }
        return result;
    }

    private boolean contains(Record searchedRecord) {
        for(Record record : recordList){
            if(record.equals(searchedRecord)) {
                return true;
            }
        }
        return false;
    }

    private void isNull (Object obj, String methodName) throws DAOException {
        if (obj == null) {
            String message = "Null object in " + methodName;
            LOGGER.warn(message);
            throw new DAOException(message);
        }
    }
}
