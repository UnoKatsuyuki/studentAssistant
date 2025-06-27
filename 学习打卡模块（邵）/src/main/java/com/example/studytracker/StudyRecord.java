package com.example.studytracker;

import java.time.LocalDate;

public class StudyRecord {
    private String username;
    private LocalDate date;
    private String subject;
    private int durationMinutes;

    public StudyRecord(String username, LocalDate date, String subject, int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("学习时长必须大于0分钟。");
        }
        this.username = username;
        this.date = date;
        this.subject = subject;
        this.durationMinutes = durationMinutes;
    }

    public String getUsername() {
        return username;
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
               "username='" + username + '\'' +
               ", date=" + date +
               ", subject='" + subject + '\'' +
               ", durationMinutes=" + durationMinutes +
               '}';
    }

    public String[] toCSVRow() {
        return new String[] {
            username,
            date.toString(),
            subject,
            String.valueOf(durationMinutes)
        };
    }

    public static StudyRecord fromCSVRow(String[] row) {
        if (row.length != 4) throw new IllegalArgumentException("CSV行格式错误");
        return new StudyRecord(
            row[0],
            java.time.LocalDate.parse(row[1]),
            row[2],
            Integer.parseInt(row[3])
        );
    }
}


