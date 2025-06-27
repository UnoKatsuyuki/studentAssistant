package com.example.studytracker;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudyTracker {
    private List<StudyRecord> records;

    public StudyTracker() {
        this.records = new ArrayList<>();
    }

    public void addRecord(StudyRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("学习记录不能为空。");
        }
        this.records.add(record);
    }

    public List<StudyRecord> getRecords() {
        return new ArrayList<>(records);
    }

    /**
     * 获取指定日期所在周的学习时长统计。
     * 周从周一到周日。
     * @param date 指定日期
     * @return Map，键为日期，值为当天的学习总时长（分钟）
     */
    public Map<LocalDate, Integer> getWeeklyStudySummary(LocalDate date) {
        LocalDate startOfWeek = date.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = date.with(DayOfWeek.SUNDAY);

        Map<LocalDate, Integer> weeklySummary = new HashMap<>();
        for (LocalDate d = startOfWeek; !d.isAfter(endOfWeek); d = d.plusDays(1)) {
            weeklySummary.put(d, 0);
        }

        for (StudyRecord record : records) {
            if (!record.getDate().isBefore(startOfWeek) && !record.getDate().isAfter(endOfWeek)) {
                weeklySummary.put(record.getDate(), weeklySummary.getOrDefault(record.getDate(), 0) + record.getDurationMinutes());
            }
        }
        return weeklySummary;
    }

    /**
     * 获取指定日期所在周的科目学习时长统计。
     * @param date 指定日期
     * @return Map，键为科目，值为该科目在该周的学习总时长（分钟）
     */
    public Map<String, Integer> getWeeklySubjectSummary(LocalDate date) {
        LocalDate startOfWeek = date.with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = date.with(DayOfWeek.SUNDAY);

        Map<String, Integer> subjectSummary = new HashMap<>();
        for (StudyRecord record : records) {
            if (!record.getDate().isBefore(startOfWeek) && !record.getDate().isAfter(endOfWeek)) {
                subjectSummary.put(record.getSubject(), subjectSummary.getOrDefault(record.getSubject(), 0) + record.getDurationMinutes());
            }
        }
        return subjectSummary;
    }
}


