package com.example.studytracker;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class StudyRecordTest {

    @Test
    void testStudyRecordCreation() {
        String username = "alice";
        LocalDate date = LocalDate.of(2025, 1, 1);
        String subject = "Math";
        int duration = 60;
        StudyRecord record = new StudyRecord(username, date, subject, duration);

        assertEquals(username, record.getUsername());
        assertEquals(date, record.getDate());
        assertEquals(subject, record.getSubject());
        assertEquals(duration, record.getDurationMinutes());
    }

    @Test
    void testStudyRecordCreationWithZeroDuration() {
        String username = "bob";
        LocalDate date = LocalDate.of(2025, 1, 1);
        String subject = "Math";
        int duration = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StudyRecord(username, date, subject, duration);
        });
        assertEquals("学习时长必须大于0分钟。", exception.getMessage());
    }

    @Test
    void testStudyRecordCreationWithNegativeDuration() {
        String username = "bob";
        LocalDate date = LocalDate.of(2025, 1, 1);
        String subject = "Math";
        int duration = -30;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StudyRecord(username, date, subject, duration);
        });
        assertEquals("学习时长必须大于0分钟。", exception.getMessage());
    }

    @Test
    void testToCSVRowAndFromCSVRow() {
        String username = "charlie";
        LocalDate date = LocalDate.of(2025, 2, 2);
        String subject = "English";
        int duration = 45;
        StudyRecord record = new StudyRecord(username, date, subject, duration);
        String[] csv = record.toCSVRow();
        assertArrayEquals(new String[]{"charlie", "2025-02-02", "English", "45"}, csv);
        StudyRecord parsed = StudyRecord.fromCSVRow(csv);
        assertEquals(username, parsed.getUsername());
        assertEquals(date, parsed.getDate());
        assertEquals(subject, parsed.getSubject());
        assertEquals(duration, parsed.getDurationMinutes());
    }
}


