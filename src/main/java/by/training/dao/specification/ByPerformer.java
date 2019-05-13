package by.training.dao.specification;

import by.training.dao.Specification;
import by.training.entity.Composition;
import by.training.entity.Record;

public class ByPerformer implements Specification<Record> {

    private static final char paramDelimiter = ' ';

    private String searchName;

    public ByPerformer(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        if (record instanceof Composition) {
            Composition composition = (Composition) record;
            String performer = composition.getPerformer().toString().trim();
            performer = performer.substring(0, performer.indexOf(paramDelimiter));
            return performer.equalsIgnoreCase(searchName);
        } else {
            return false;
        }
    }
}
