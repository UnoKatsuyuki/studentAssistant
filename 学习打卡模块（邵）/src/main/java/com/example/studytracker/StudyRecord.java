package com.example.studytracker;

import java.time.LocalDate;

public class StudyRecord {
    private LocalDate date;
    private String subject;
    private int durationMinutes;

    public StudyRecord(LocalDate date, String subject, int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("学习时长必须大于0分钟。");
        }
        this.date = date;
        this.subject = subject;
        this.durationMinutes = durationMinutes;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSubject() {
        return subject;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return "StudyRecord{" +
               "date=" + date +
               ", subject=\'" + subject + '\'' +
               ", durationMinutes=" + durationMinutes +
               '}';
    }
}


