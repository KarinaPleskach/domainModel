package by.training.comporator;

import by.training.entity.Composition;
import by.training.entity.Record;

import java.util.Comparator;

public enum RecordComparator implements Comparator<Record> {

    STYLE_SORT {
        public int compare(Record o1, Record o2) {
            if ((o1 instanceof Composition) && (o2 instanceof Composition)) {
                Composition c1 = (Composition) o1;
                Composition c2 = (Composition) o2;
                return c1.getStyle().name().compareTo(c2.getStyle().name());
            } else if (o1 instanceof Composition) {
                return -1;
            } else if (o2 instanceof Composition) {
                return 1;
            } else {
                return 0;
            }
        }},
    SONG_NAME_SORT {
        public int compare(Record o1, Record o2) {
            return o1.getSongName().compareTo(o2.getSongName());
        }};

    public static Comparator<Record> descending(final Comparator<Record> other) {
        return new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                return -1 * other.compare(o1, o2);
            }
        };
    }

    public static Comparator<Record> ascending(final Comparator<Record> other) {
        return new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                return other.compare(o1, o2);
            }
        };
    }

    public static Comparator<Record> getComparator(final RecordComparator... multipleOptions) {
        return new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                for (RecordComparator option : multipleOptions) {
                    int result = option.compare(o1, o2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        };
    }

}