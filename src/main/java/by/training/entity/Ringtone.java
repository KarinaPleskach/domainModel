package by.training.entity;

import by.training.entity.music.Duration;

public class Ringtone extends Record {

    public Ringtone(String songName, Duration duration) {
        super(songName, duration);
    }

    @Override
    public String toString() {
        return "Ringtone " +
                getSongName() +
                getDuration() + "\n";
    }


}
