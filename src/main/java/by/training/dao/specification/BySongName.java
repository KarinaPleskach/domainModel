package by.training.dao.specification;

import by.training.dao.Specification;
import by.training.entity.Record;

public class BySongName implements Specification<Record> {

    private String searchName;

    public BySongName(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        return (record.getSongName().equalsIgnoreCase(searchName));
    }
}