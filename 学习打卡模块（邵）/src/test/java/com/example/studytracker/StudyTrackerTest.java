package com.example.studytracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StudyTrackerTest {

    private StudyTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new StudyTracker();
    }

    @Test
    void testAddRecord() {
        StudyRecord record = new StudyRecord(LocalDate.now(), "Java", 60);
        tracker.addRecord(record);
        assertEquals(1, tracker.getRecords().size());
        assertTrue(tracker.getRecords().contains(record));
    }

    @Test
    void testAddNullRecord() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tracker.addRecord(null);
        });
        assertEquals("学习记录不能为空。", exception.getMessage());
    }

    @Test
    void testGetWeeklyStudySummaryEmpty() {
        LocalDate date = LocalDate.of(2025, 6, 27);
        Map<LocalDate, Integer> summary = tracker.getWeeklyStudySummary(date);
        assertEquals(7, summary.size()); // A week has 7 days
        assertTrue(summary.values().stream().allMatch(duration -> duration == 0));
    }

    @Test
    void testGetWeeklyStudySummarySingleRecord() {
        LocalDate recordDate = LocalDate.of(2025, 6, 25); // Wednesday
        tracker.addRecord(new StudyRecord(recordDate, "Math", 90));

        LocalDate dateInSameWeek = LocalDate.of(2025, 6, 27); // Friday
        Map<LocalDate, Integer> summary = tracker.getWeeklyStudySummary(dateInSameWeek);

        assertEquals(7, summary.size());
        assertEquals(90, summary.get(recordDate));
        assertEquals(0, summary.get(recordDate.minusDays(1))); // Tuesday
    }

    @Test
    void testGetWeeklyStudySummaryMultipleRecordsSameDay() {
        LocalDate recordDate = LocalDate.of(2025, 6, 25);
        tracker.addRecord(new StudyRecord(recordDate, "Math", 30));
        tracker.addRecord(new StudyRecord(recordDate, "Physics", 60));

        Map<LocalDate, Integer> summary = tracker.getWeeklyStudySummary(recordDate);
        assertEquals(90, summary.get(recordDate));
    }

    @Test
    void testGetWeeklyStudySummaryMultipleRecordsDifferentWeeks() {
        LocalDate date1 = LocalDate.of(2025, 6, 23); // Monday
        LocalDate date2 = LocalDate.of(2025, 6, 30); // Next Monday

        tracker.addRecord(new StudyRecord(date1, "Java", 60));
        tracker.addRecord(new StudyRecord(date2, "Python", 120));

        Map<LocalDate, Integer> summary = tracker.getWeeklyStudySummary(date1);
        assertEquals(60, summary.get(date1));
        assertNull(summary.get(date2)); // Should not include next week's record

        Map<LocalDate, Integer> summaryNextWeek = tracker.getWeeklyStudySummary(date2);
        assertEquals(120, summaryNextWeek.get(date2));
        assertNull(summaryNextWeek.get(date1)); // Should not include previous week's record
    }

    @Test
    void testGetWeeklySubjectSummaryEmpty() {
        LocalDate date = LocalDate.of(2025, 6, 27);
        Map<String, Integer> summary = tracker.getWeeklySubjectSummary(date);
        assertTrue(summary.isEmpty());
    }

    @Test
    void testGetWeeklySubjectSummarySingleRecord() {
        LocalDate recordDate = LocalDate.of(2025, 6, 25);
        tracker.addRecord(new StudyRecord(recordDate, "Math", 90));

        Map<String, Integer> summary = tracker.getWeeklySubjectSummary(recordDate);
        assertEquals(1, summary.size());
        assertEquals(90, summary.get("Math"));
    }

    @Test
    void testGetWeeklySubjectSummaryMultipleRecordsSameSubject() {
        LocalDate recordDate = LocalDate.of(2025, 6, 25);
        tracker.addRecord(new StudyRecord(recordDate, "Math", 30));
        tracker.addRecord(new StudyRecord(recordDate, "Math", 60));

        Map<String, Integer> summary = tracker.getWeeklySubjectSummary(recordDate);
        assertEquals(90, summary.get("Math"));
    }

    @Test
    void testGetWeeklySubjectSummaryMultipleRecordsDifferentSubjects() {
        LocalDate recordDate = LocalDate.of(2025, 6, 25);
        tracker.addRecord(new StudyRecord(recordDate, "Math", 30));
        tracker.addRecord(new StudyRecord(recordDate, "Physics", 60));

        Map<String, Integer> summary = tracker.getWeeklySubjectSummary(recordDate);
        assertEquals(30, summary.get("Math"));
        assertEquals(60, summary.get("Physics"));
    }

    @Test
    void testGetWeeklySubjectSummaryMultipleRecordsDifferentWeeks() {
        LocalDate date1 = LocalDate.of(2025, 6, 23);
        LocalDate date2 = LocalDate.of(2025, 6, 30);

        tracker.addRecord(new StudyRecord(date1, "Java", 60));
        tracker.addRecord(new StudyRecord(date2, "Python", 120));

        Map<String, Integer> summary = tracker.getWeeklySubjectSummary(date1);
        assertEquals(60, summary.get("Java"));
        assertNull(summary.get("Python"));

        Map<String, Integer> summaryNextWeek = tracker.getWeeklySubjectSummary(date2);
        assertEquals(120, summaryNextWeek.get("Python"));
        assertNull(summaryNextWeek.get("Java"));
    }
}


