package by.training.entity;

import by.training.entity.music.Duration;
import by.training.entity.music.Styles;
import by.training.entity.performer.Performer;

public class Minus extends Composition {

    public Minus(String songName, Duration duration, Performer performer, Styles style) {
        super(songName, duration, performer, style);
    }

    @Override
    public String toString() {
        return "Minus " +
                getSongName() +
                getDuration() +
                getPerformer() +
                " " + getStyle() + "\n";
    }


}
