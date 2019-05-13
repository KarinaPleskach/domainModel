package by.training.entity.performer.impl;

import by.training.entity.performer.Performer;

public class Band implements Performer {

    private String title;

    public Band(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return title;
    }

    @Override
    public String toString() {
        return " Band " + title;
    }
}
