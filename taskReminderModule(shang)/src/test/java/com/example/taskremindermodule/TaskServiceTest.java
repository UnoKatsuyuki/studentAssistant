package com.example.taskremindermodule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    private TaskService service;

    @BeforeEach
    void setUp() {
        service = new TaskService();
    }

    @Test
    void testAddAndCompleteTask() {
        Task t = new Task(null, "测试完成", "desc", 1, LocalDateTime.now().plusDays(1), null);
        Task saved = service.addTask(t);
        assertFalse(saved.isCompleted());
        service.setTaskCompleted(saved.getId(), true);
        Task updated = service.getTask(saved.getId());
        assertTrue(updated.isCompleted());
    }

    @Test
    void testGetTasksByCompleted() {
        Task t1 = service.addTask(new Task(null, "未完成1", null, 1, LocalDateTime.now().plusDays(1), null));
        Task t2 = service.addTask(new Task(null, "已完成2", null, 2, LocalDateTime.now().plusDays(2), null));
        service.setTaskCompleted(t2.getId(), true);
        List<Task> uncompleted = service.getTasksByCompleted(false);
        List<Task> completed = service.getTasksByCompleted(true);
        assertTrue(uncompleted.stream().anyMatch(t -> t.getId().equals(t1.getId())));
        assertTrue(completed.stream().anyMatch(t -> t.getId().equals(t2.getId())));
    }

    @Test
    void testSearchTasksByTitle() {
        service.addTask(new Task(null, "关键字测试A", null, 1, LocalDateTime.now().plusDays(1), null));
        service.addTask(new Task(null, "无关B", null, 2, LocalDateTime.now().plusDays(2), null));
        List<Task> result = service.searchTasksByTitle("关键字");
        assertEquals(1, result.size());
        assertTrue(result.get(0).getTitle().contains("关键字"));
    }

    @Test
    void testBatchDelete() {
        Task t1 = service.addTask(new Task(null, "批量1", null, 1, LocalDateTime.now().plusDays(1), null));
        Task t2 = service.addTask(new Task(null, "批量2", null, 2, LocalDateTime.now().plusDays(2), null));
        service.deleteTasks(Arrays.asList(t1.getId(), t2.getId()));
        assertNull(service.getTask(t1.getId()));
        assertNull(service.getTask(t2.getId()));
    }

    @Test
    void testRemindDueAndUncompleted() {
        LocalDateTime now = LocalDateTime.now();
        Task t1 = service.addTask(new Task(null, "提醒1", null, 1, now.plusDays(1), now.minusMinutes(1)));
        Task t2 = service.addTask(new Task(null, "提醒2", null, 2, now.plusDays(2), now.plusDays(1)));
        service.setTaskCompleted(t1.getId(), true);
        List<Task> result = service.getRemindDueAndUncompleted(now);
        assertTrue(result.stream().noneMatch(t -> t.getId().equals(t1.getId())));
        assertTrue(result.stream().noneMatch(t -> t.getId().equals(t2.getId())));
    }
} 