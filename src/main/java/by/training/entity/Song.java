package by.training.entity;

import by.training.entity.music.Duration;
import by.training.entity.music.Styles;
import by.training.entity.music.Timbre;
import by.training.entity.performer.Performer;

import java.util.Objects;

public class Song extends Composition {

    Timbre timbre;

    public Song(String songName, Duration duration, Performer performer, Styles style, Timbre timbre) {
        super(songName, duration, performer, style);
        this.timbre = timbre;
    }

    public Timbre getTimbre() {
        return timbre;
    }

    public void setTimbre(Timbre timbre) {
        this.timbre = timbre;
    }

    @Override
    public String toString() {
        return "Song " +
                getSongName() +
                getDuration() +
                getPerformer() +
                " " + getStyle() +
                " " + getTimbre() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Song song = (Song) o;
        return timbre == song.timbre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timbre);
    }
}
