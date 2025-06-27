package com.example.studytracker;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class StudyRecordTest {

    @Test
    void testStudyRecordCreation() {
        LocalDate date = LocalDate.of(2025, 1, 1);
        String subject = "Math";
        int duration = 60;
        StudyRecord record = new StudyRecord(date, subject, duration);

        assertEquals(date, record.getDate());
        assertEquals(subject, record.getSubject());
        assertEquals(duration, record.getDurationMinutes());
    }

    @Test
    void testStudyRecordCreationWithZeroDuration() {
        LocalDate date = LocalDate.of(2025, 1, 1);
        String subject = "Math";
        int duration = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StudyRecord(date, subject, duration);
        });
        assertEquals("学习时长必须大于0分钟。", exception.getMessage());
    }

    @Test
    void testStudyRecordCreationWithNegativeDuration() {
        LocalDate date = LocalDate.of(2025, 1, 1);
        String subject = "Math";
        int duration = -30;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new StudyRecord(date, subject, duration);
        });
        assertEquals("学习时长必须大于0分钟。", exception.getMessage());
    }
}


