package by.training.creator;

import by.training.entity.Minus;
import by.training.entity.Record;
import by.training.entity.Ringtone;
import by.training.entity.Song;
import by.training.entity.music.Duration;
import by.training.entity.music.Styles;
import by.training.entity.music.Timbre;
import by.training.entity.performer.impl.Band;
import by.training.entity.performer.impl.SoloArtist;

class RecordCreator implements Creator<Record> {

    private static final String paramDelimiter = " ";

    @Override
    public Record create(String line) {
        Record record = null;
        String[] recordArr = line.split(paramDelimiter);
        if (recordArr[0].equals("Minus")) {
            if (recordArr[4].equals("Band")) {
                record = new Minus(recordArr[1], new Duration(Integer.parseInt(recordArr[2]), Integer.parseInt(recordArr[3])), new Band(recordArr[5]), Styles.valueOf(recordArr[6]));
            } else {
                record = new Minus(recordArr[1], new Duration(Integer.parseInt(recordArr[2]), Integer.parseInt(recordArr[3])), new SoloArtist(recordArr[5]), Styles.valueOf(recordArr[6]));
            }
        } else if (recordArr[0].equals("Ringtone")) {
            record = new Ringtone(recordArr[1], new Duration(Integer.parseInt(recordArr[2]), Integer.parseInt(recordArr[3])));
        } else if (recordArr[0].equals("Song")) {
            if (recordArr[4].equals("Band")) {
                record = new Song(recordArr[1], new Duration(Integer.parseInt(recordArr[2]), Integer.parseInt(recordArr[3])), new Band(recordArr[5]), Styles.valueOf(recordArr[6]), Timbre.valueOf(recordArr[7]));
            } else {
                record = new Song(recordArr[1], new Duration(Integer.parseInt(recordArr[2]), Integer.parseInt(recordArr[3])), new SoloArtist(recordArr[5]), Styles.valueOf(recordArr[6]), Timbre.valueOf(recordArr[7]));
            }
        }
        return record;
    }
}
