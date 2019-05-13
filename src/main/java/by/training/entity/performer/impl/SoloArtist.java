package by.training.entity.performer.impl;

import by.training.entity.performer.Performer;

public class SoloArtist implements Performer {

    private String name;

    public SoloArtist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " SoloArtist " + name;
    }

    public String getPerformer() {
        return toString();
    }
}
