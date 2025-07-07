package com.assistant.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class StudyTrackerTest {

    private StudyTracker studyTracker;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        studyTracker = new StudyTracker();
    }

    @Test
    void testAddRecord() {
        StudyRecord record = new StudyRecord("user1", LocalDate.now(), "Math", 60);
        studyTracker.addRecord(record);
        assertEquals(1, studyTracker.getRecords().size());
        assertEquals(record, studyTracker.getRecords().get(0));
    }

    @Test
    void testAddNullRecordThrowsException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            studyTracker.addRecord(null);
        });
        assertEquals("学习记录不能为空。", thrown.getMessage());
    }

    @Test
    void testGetRecordsByUser() {
        studyTracker.addRecord(new StudyRecord("user1", LocalDate.now(), "Math", 60));
        studyTracker.addRecord(new StudyRecord("user2", LocalDate.now(), "Physics", 90));
        studyTracker.addRecord(new StudyRecord("user1", LocalDate.now(), "Chemistry", 45));

        List<StudyRecord> user1Records = studyTracker.getRecordsByUser("user1");
        assertEquals(2, user1Records.size());
        assertTrue(user1Records.stream().allMatch(r -> r.getUsername().equals("user1")));

        List<StudyRecord> user3Records = studyTracker.getRecordsByUser("user3");
        assertTrue(user3Records.isEmpty());
    }

    @Test
    void testGetWeeklyStudySummary() {
        LocalDate date = LocalDate.of(2024, 7, 4); // A Thursday
        studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60)); // Monday
        studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 4), "Physics", 90)); // Thursday
        studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 7), "Chemistry", 30)); // Sunday
        studyTracker.addRecord(new StudyRecord("user2", LocalDate.of(2024, 7, 4), "Biology", 120)); // Other user

        Map<LocalDate, Integer> summary = studyTracker.getWeeklyStudySummary(date, "user1");

        assertEquals(7, summary.size());
        assertEquals(60, summary.get(LocalDate.of(2024, 7, 1)));
        assertEquals(0, summary.get(LocalDate.of(2024, 7, 2)));
        assertEquals(0, summary.get(LocalDate.of(2024, 7, 3)));
        assertEquals(90, summary.get(LocalDate.of(2024, 7, 4)));
        assertEquals(0, summary.get(LocalDate.of(2024, 7, 5)));
        assertEquals(0, summary.get(LocalDate.of(2024, 7, 6)));
        assertEquals(30, summary.get(LocalDate.of(2024, 7, 7)));
    }

    @Test
    void testGetWeeklySubjectSummary() {
        LocalDate date = LocalDate.of(2024, 7, 4); // A Thursday
        studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60));
        studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 4), "Physics", 90));
        studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 4), "Math", 30));
        studyTracker.addRecord(new StudyRecord("user2", LocalDate.of(2024, 7, 4), "Biology", 120));

        Map<String, Integer> summary = studyTracker.getWeeklySubjectSummary(date, "user1");

        assertEquals(2, summary.size());
        assertEquals(90, summary.get("Math"));
        assertEquals(90, summary.get("Physics"));
        assertNull(summary.get("Biology"));
    }

    @Test
    void testGetRecentDaysSummary() {
        LocalDate today = LocalDate.now();
        studyTracker.addRecord(new StudyRecord("user1", today, "Math", 60));
        studyTracker.addRecord(new StudyRecord("user1", today.minusDays(1), "Physics", 90));
        studyTracker.addRecord(new StudyRecord("user1", today.minusDays(2), "Chemistry", 30));
        studyTracker.addRecord(new StudyRecord("user1", today.minusDays(5), "Biology", 120)); // Outside 3 days

        Map<LocalDate, Integer> summary = studyTracker.getRecentDaysSummary(3, "user1");

        assertEquals(3, summary.size());
        assertEquals(30, summary.get(today.minusDays(2)));
        assertEquals(90, summary.get(today.minusDays(1)));
        assertEquals(60, summary.get(today));
        assertNull(summary.get(today.minusDays(5)));
    }

    @Test
    void testLoadAndSaveToCSV() throws IOException {
        Path csvFile = tempDir.resolve("study_records.csv");

        studyTracker.addRecord(new StudyRecord("user1", LocalDate.now(), "Math", 60));
        studyTracker.addRecord(new StudyRecord("user2", LocalDate.now(), "Physics", 90));

        studyTracker.saveToCSV(csvFile.toString());

        StudyTracker newTracker = new StudyTracker();
        newTracker.loadFromCSV(csvFile.toString());

        assertEquals(2, newTracker.getRecords().size());
        assertEquals("user1", newTracker.getRecords().get(0).getUsername());
        assertEquals("Physics", newTracker.getRecords().get(1).getSubject());
    }

    @Test
    void testLoadFromNonExistentCSV() {
        Path nonExistentFile = tempDir.resolve("non_existent.csv");
        assertThrows(IOException.class, () -> studyTracker.loadFromCSV(nonExistentFile.toString()));
    }
}


