package by.training.dao.specification;

import by.training.dao.Specification;
import by.training.entity.Composition;
import by.training.entity.Record;

public class ByStyle implements Specification<Record> {

    private String searchName;

    public ByStyle(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        if (record instanceof Composition) {
            Composition composition = (Composition) record;
            return composition.getStyle().name().equals(searchName.toUpperCase());
        } else {
            return false;
        }
    }
}
