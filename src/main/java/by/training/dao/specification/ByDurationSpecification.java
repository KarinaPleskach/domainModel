package by.training.dao.specification;

import by.training.dao.Specification;
import by.training.entity.Record;
import by.training.entity.music.Duration;

public class ByDurationSpecification implements Specification<Record> {

    private static final String paramDelimiter = "-";

    private String searchName;

    public ByDurationSpecification(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public boolean match(Record record) {
        boolean match;
        Duration duration = record.getDuration();
        if (searchName.equalsIgnoreCase("all")) {
            match = true;
        } else if(searchName.indexOf(paramDelimiter) == -1) {
            Duration searchDuration = parse(searchName);
            match = searchDuration.equals(duration);
        } else {
            String[] values = searchName.split(paramDelimiter);
            Duration from = parse(values[0]);
            Duration to = parse(values[1]);
            match = between(from, to, duration);
        }
        return match;
    }

    private Duration parse(String duration) {
        double primitiveDuration = Double.parseDouble(duration);
        int minutes = (int)primitiveDuration;
        duration = duration.substring(duration.indexOf(".") + 1);
        int seconds = Integer.parseInt(duration);
        return new Duration(minutes, seconds);
    }

    private boolean between(Duration from, Duration to, Duration what) {
        boolean between = false;
        int secFrom = from.getMinutes()*60 + from.getSeconds();
        int secTo = to.getMinutes()*60 + to.getSeconds();
        int secWhat = what.getMinutes()*60 + what.getSeconds();
        return (secWhat <= secTo && secWhat >= secFrom);
    }

}
