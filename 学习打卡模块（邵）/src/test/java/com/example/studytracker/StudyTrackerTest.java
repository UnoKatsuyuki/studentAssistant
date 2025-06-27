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
        StudyRecord record = new StudyRecord("alice", LocalDate.now(), "Java", 60);
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
    void testGetRecordsByUser() {
        tracker.addRecord(new StudyRecord("alice", LocalDate.of(2025, 6, 25), "Math", 90));
        tracker.addRecord(new StudyRecord("bob", LocalDate.of(2025, 6, 25), "Math", 60));
        tracker.addRecord(new StudyRecord("alice", LocalDate.of(2025, 6, 26), "English", 30));
        List<StudyRecord> aliceRecords = tracker.getRecordsByUser("alice");
        assertEquals(2, aliceRecords.size());
        for (StudyRecord r : aliceRecords) {
            assertEquals("alice", r.getUsername());
        }
        List<StudyRecord> bobRecords = tracker.getRecordsByUser("bob");
        assertEquals(1, bobRecords.size());
        assertEquals("bob", bobRecords.get(0).getUsername());
    }

    @Test
    void testGetWeeklyStudySummaryMultipleUsers() {
        LocalDate monday = LocalDate.of(2025, 6, 23);
        LocalDate tuesday = LocalDate.of(2025, 6, 24);
        tracker.addRecord(new StudyRecord("alice", monday, "Java", 60));
        tracker.addRecord(new StudyRecord("bob", monday, "Java", 120));
        tracker.addRecord(new StudyRecord("alice", tuesday, "Math", 30));
        Map<LocalDate, Integer> aliceSummary = tracker.getWeeklyStudySummary(monday, "alice");
        assertEquals(60, aliceSummary.get(monday));
        assertEquals(30, aliceSummary.get(tuesday));
        Map<LocalDate, Integer> bobSummary = tracker.getWeeklyStudySummary(monday, "bob");
        assertEquals(120, bobSummary.get(monday));
        assertEquals(0, bobSummary.get(tuesday));
    }

    @Test
    void testGetWeeklySubjectSummaryMultipleUsers() {
        LocalDate monday = LocalDate.of(2025, 6, 23);
        tracker.addRecord(new StudyRecord("alice", monday, "Java", 60));
        tracker.addRecord(new StudyRecord("bob", monday, "Java", 120));
        tracker.addRecord(new StudyRecord("alice", monday, "Math", 30));
        Map<String, Integer> aliceSubject = tracker.getWeeklySubjectSummary(monday, "alice");
        assertEquals(60, aliceSubject.get("Java"));
        assertEquals(30, aliceSubject.get("Math"));
        Map<String, Integer> bobSubject = tracker.getWeeklySubjectSummary(monday, "bob");
        assertEquals(120, bobSubject.get("Java"));
        assertNull(bobSubject.get("Math"));
    }

    @Test
    void testGetRecentDaysSummary() {
        LocalDate today = LocalDate.now();
        tracker.addRecord(new StudyRecord("alice", today.minusDays(2), "Java", 60));
        tracker.addRecord(new StudyRecord("alice", today.minusDays(1), "Math", 30));
        tracker.addRecord(new StudyRecord("bob", today.minusDays(1), "Java", 45));
        Map<LocalDate, Integer> aliceTrend = tracker.getRecentDaysSummary(3, "alice");
        assertEquals(60, aliceTrend.get(today.minusDays(2)));
        assertEquals(30, aliceTrend.get(today.minusDays(1)));
        assertEquals(0, aliceTrend.get(today));
        Map<LocalDate, Integer> bobTrend = tracker.getRecentDaysSummary(3, "bob");
        assertEquals(0, bobTrend.get(today.minusDays(2)));
        assertEquals(45, bobTrend.get(today.minusDays(1)));
        assertEquals(0, bobTrend.get(today));
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


