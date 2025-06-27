package com.example.studytracker;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudyTracker tracker = new StudyTracker();

        // 添加一些学习记录
        tracker.addRecord(new StudyRecord(LocalDate.of(2025, 6, 23), "Java编程", 90));
        tracker.addRecord(new StudyRecord(LocalDate.of(2025, 6, 23), "数据结构", 60));
        tracker.addRecord(new StudyRecord(LocalDate.of(2025, 6, 24), "Java编程", 120));
        tracker.addRecord(new StudyRecord(LocalDate.of(2025, 6, 25), "算法", 75));
        tracker.addRecord(new StudyRecord(LocalDate.of(2025, 6, 26), "数据结构", 45));
        tracker.addRecord(new StudyRecord(LocalDate.of(2025, 6, 27), "Java编程", 180));
        tracker.addRecord(new StudyRecord(LocalDate.of(2025, 6, 28), "算法", 90));
        tracker.addRecord(new StudyRecord(LocalDate.of(2025, 7, 1), "Java编程", 60)); // 下一周的记录

        System.out.println("所有学习记录:");
        tracker.getRecords().forEach(System.out::println);
        System.out.println("\n");

        // 获取当前周（假设当前日期是 2025-06-27）的学习统计
        LocalDate today = LocalDate.of(2025, 6, 27);
        Map<LocalDate, Integer> weeklySummaryByDate = tracker.getWeeklyStudySummary(today);
        System.out.println("当前周（" + today + "所在周）每日学习时长统计:");
        weeklySummaryByDate.forEach((date, duration) -> System.out.println(date + ": " + duration + "分钟"));
        System.out.println("\n");

        Map<String, Integer> weeklySummaryBySubject = tracker.getWeeklySubjectSummary(today);
        System.out.println("当前周（" + today + "所在周）科目学习时长统计:");
        weeklySummaryBySubject.forEach((subject, duration) -> System.out.println(subject + ": " + duration + "分钟"));
    }
}


