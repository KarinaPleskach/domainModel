package by.training.entity.music;

import java.util.Objects;

public class Duration {

    private int minutes;
    private int seconds;

    public Duration(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return " " + minutes +
                " " + seconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration = (Duration) o;
        return minutes == duration.minutes &&
                seconds == duration.seconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes, seconds);
    }
}
