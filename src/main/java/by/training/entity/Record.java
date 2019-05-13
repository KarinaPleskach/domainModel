package by.training.entity;

import by.training.entity.music.Duration;

import java.util.Objects;
import java.util.UUID;

public abstract class Record {

    private String songName;
    private Duration duration;

    public Record(String songName, Duration duration) {
        this.songName = songName;
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public abstract String toString();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(songName, record.songName) &&
                Objects.equals(duration, record.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songName, duration);
    }
}
