package com.example.taskremindermodule;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class TaskRepository {
    private final Map<Long, Task> taskMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Task addTask(Task task) {
        long id = idGenerator.getAndIncrement();
        task.setId(id);
        taskMap.put(id, task);
        return task;
    }

    public Task getTask(Long id) {
        return taskMap.get(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskMap.values());
    }

    public boolean deleteTask(Long id) {
        return taskMap.remove(id) != null;
    }

    public Task updateTask(Long id, Task newTask) {
        if (!taskMap.containsKey(id)) return null;
        newTask.setId(id);
        taskMap.put(id, newTask);
        return newTask;
    }

    public List<Task> getTasksSortedByPriorityAndDueTime() {
        return taskMap.values().stream()
                .sorted(Comparator.comparingInt(Task::getPriority)
                        .thenComparing(Task::getDueTime))
                .collect(Collectors.toList());
    }

    public List<Task> getTasksDueBefore(LocalDateTime time) {
        return taskMap.values().stream()
                .filter(task -> task.getDueTime() != null && !task.getDueTime().isAfter(time))
                .collect(Collectors.toList());
    }

    public List<Task> findByCompleted(boolean completed) {
        return taskMap.values().stream().filter(t -> t.isCompleted() == completed).collect(Collectors.toList());
    }

    public List<Task> findByTitleContains(String keyword) {
        return taskMap.values().stream().filter(t -> t.getTitle() != null && t.getTitle().contains(keyword)).collect(Collectors.toList());
    }

    public void deleteTasks(List<Long> ids) {
        ids.forEach(taskMap::remove);
    }

    public List<Task> findRemindDueAndUncompleted(LocalDateTime now) {
        return taskMap.values().stream().filter(t -> !t.isCompleted() && t.getRemindTime() != null && !t.getRemindTime().isAfter(now)).collect(Collectors.toList());
    }

    public List<Task> queryTasks(Integer priority, String keyword, java.time.LocalDateTime start, java.time.LocalDateTime end, Long typeId) {
        return taskMap.values().stream()
            .filter(t -> priority == null || t.getPriority() == priority)
            .filter(t -> keyword == null || (t.getTitle() != null && t.getTitle().contains(keyword)))
            .filter(t -> start == null || (t.getDueTime() != null && !t.getDueTime().isBefore(start)))
            .filter(t -> end == null || (t.getDueTime() != null && !t.getDueTime().isAfter(end)))
            .filter(t -> typeId == null || (t.getTypeId() != null && t.getTypeId().equals(typeId)))
            .collect(java.util.stream.Collectors.toList());
    }

    public java.util.Map<Long, java.util.List<Task>> groupByType() {
        return taskMap.values().stream().collect(java.util.stream.Collectors.groupingBy(Task::getTypeId));
    }
} 