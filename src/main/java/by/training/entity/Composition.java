package by.training.entity;

import by.training.entity.music.Duration;
import by.training.entity.music.Styles;
import by.training.entity.performer.Performer;

import java.util.Objects;

public abstract class Composition extends Record {

    private Performer performer;
    private Styles style;

    public Composition(String songName, Duration duration, Performer performer, Styles style) {
        super(songName, duration);
        this.performer = performer;
        this.style = style;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public Styles getStyle() {
        return style;
    }

    public void setStyle(Styles style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Composition that = (Composition) o;
        return Objects.equals(performer, that.performer) &&
                style == that.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), performer, style);
    }
}
