package com.assistant.task;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDateTime;

public class TaskService {
    private final Map<Long, Task> taskMap = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public Task addTask(Task task) {
        long id = idGen.getAndIncrement();
        task.setId(id);
        taskMap.put(id, task);
        return task;
    }

    public List<Task> getAllTasksSorted() {
        List<Task> list = new ArrayList<>(taskMap.values());
        list.sort(Comparator.comparing(Task::getId));
        return list;
    }

    public Task getTask(Long id) {
        return taskMap.get(id);
    }

    public void updateTask(Long id, Task task) {
        taskMap.put(id, task);
    }

    public void deleteTask(Long id) {
        taskMap.remove(id);
    }

    public void setTaskCompleted(Long id, boolean completed) {
        Task t = taskMap.get(id);
        if (t != null) t.setCompleted(completed);
    }

    public List<Task> queryTasks(Integer priority, String keyword, LocalDateTime start, LocalDateTime end, Long typeId) {
        List<Task> result = new ArrayList<>();
        for (Task t : taskMap.values()) {
            if (priority != null && t.getPriority() != priority) continue;
            if (keyword != null && !keyword.isEmpty() && (t.getTitle() == null || !t.getTitle().contains(keyword))) continue;
            if (start != null && (t.getDueTime() == null || t.getDueTime().isBefore(start))) continue;
            if (end != null && (t.getDueTime() == null || t.getDueTime().isAfter(end))) continue;
            if (typeId != null && (t.getTypeId() == null || !t.getTypeId().equals(typeId))) continue;
            result.add(t);
        }
        return result;
    }

    public Map<Long, List<Task>> groupByType() {
        Map<Long, List<Task>> map = new HashMap<>();
        for (Task t : taskMap.values()) {
            map.computeIfAbsent(t.getTypeId(), k -> new ArrayList<>()).add(t);
        }
        return map;
    }
} 