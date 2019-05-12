package by.training.entity;

import by.training.entity.music.Duration;

import java.util.List;

public class Disk {

    private List<Record> recordList;
    private Duration durationSum;

    public Disk(List<Record> recordList) {
        this.recordList = recordList;
        durationSum = countDurationSum();
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public Duration getDurationSum() {
        return countDurationSum();
    }

    private Duration countDurationSum(){
        int minutes = 0;
        int seconds = 0;
        for (Record record: recordList){
            minutes += record.getDuration().getMinutes();
            seconds += record.getDuration().getSeconds();
        }
        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }
        return new Duration(minutes, seconds);
    }
}
