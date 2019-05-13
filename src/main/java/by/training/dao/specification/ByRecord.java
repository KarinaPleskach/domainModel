package by.training.dao.specification;

import by.training.dao.Specification;
import by.training.entity.Record;

public class ByRecord implements Specification<Record> {

    private String searchName;

    public ByRecord(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        return record.getClass().getSimpleName().equalsIgnoreCase(searchName);
    }
}
