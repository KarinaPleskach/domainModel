package by.training.dao.specification;

import by.training.dao.Specification;
import by.training.entity.Record;
import by.training.entity.Song;

public class ByTimbre implements Specification<Record> {

    private String searchName;

    public ByTimbre(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        if (record instanceof Song) {
            Song composition = (Song) record;
            return composition.getTimbre().name().equals(searchName.toUpperCase());
        } else {
            return false;
        }
    }
}