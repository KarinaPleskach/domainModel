package by.training.dao.specification;

import by.training.dao.Specification;
import by.training.entity.Composition;
import by.training.entity.Record;
import by.training.entity.performer.impl.Band;
import by.training.entity.performer.impl.SoloArtist;

public class BySoloArtist  implements Specification<Record> {

    private static final char paramDelimiter = ' ';

    private String searchName;

    public BySoloArtist(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        if (record instanceof Composition) {
            Composition composition = (Composition) record;
            if (((Composition) record).getPerformer() instanceof SoloArtist) {
                String performer = composition.getPerformer().getPerformer();
                return performer.equalsIgnoreCase(searchName);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}