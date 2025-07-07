
package com.assistant.study;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class StudyRecordTest {

    @Test
    void testStudyRecordCreation() {
        StudyRecord record = new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60);
        assertNotNull(record);
        assertEquals("user1", record.getUsername());
        assertEquals(LocalDate.of(2024, 7, 1), record.getDate());
        assertEquals("Math", record.getSubject());
        assertEquals(60, record.getDurationMinutes());
    }

    @Test
    void testStudyRecordCreationWithInvalidDuration() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 0);
        });
        assertEquals("学习时长必须大于0分钟。", thrown.getMessage());
    }

    @Test
    void testToCSVRow() {
        StudyRecord record = new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60);
        String[] csvRow = record.toCSVRow();
        assertNotNull(csvRow);
        assertEquals(4, csvRow.length);
        assertEquals("user1", csvRow[0]);
        assertEquals("2024-07-01", csvRow[1]);
        assertEquals("Math", csvRow[2]);
        assertEquals("60", csvRow[3]);
    }

    @Test
    void testFromCSVRow() {
        String[] csvRow = {"user2", "2024-07-02", "Physics", "90"};
        StudyRecord record = StudyRecord.fromCSVRow(csvRow);
        assertNotNull(record);
        assertEquals("user2", record.getUsername());
        assertEquals(LocalDate.of(2024, 7, 2), record.getDate());
        assertEquals("Physics", record.getSubject());
        assertEquals(90, record.getDurationMinutes());
    }

    @Test
    void testFromCSVRowWithInvalidFormat() {
        String[] csvRow = {"user2", "2024-07-02", "Physics"};
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            StudyRecord.fromCSVRow(csvRow);
        });
        assertEquals("CSV行格式错误", thrown.getMessage());
    }

    @Test
    void testToString() {
        StudyRecord record = new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60);
        String expected = "StudyRecord{username=\'user1\', date=2024-07-01, subject=\'Math\', durationMinutes=60}";
        assertEquals(expected, record.toString());
    }
}


