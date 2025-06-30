package com.example.taskremindermodule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class TaskService {
    private final TaskRepository repository = new TaskRepository();

    // 输入验证
    private void validateTask(Task task) {
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("任务标题不能为空");
        }
        if (task.getPriority() < 1 || task.getPriority() > 3) {
            throw new IllegalArgumentException("优先级必须为1(高)、2(中)、3(低)");
        }
        if (task.getDueTime() != null && task.getRemindTime() != null && task.getRemindTime().isAfter(task.getDueTime())) {
            throw new IllegalArgumentException("提醒时间不能晚于截止时间");
        }
    }

    public Task addTask(Task task) {
        validateTask(task);
        if (task.getDueTime() != null && task.getDueTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("截止时间不能早于当前时间");
        }
        return repository.addTask(task);
    }

    public Task getTask(Long id) {
        return repository.getTask(id);
    }

    public List<Task> getAllTasksSorted() {
        return repository.getTasksSortedByPriorityAndDueTime();
    }

    public boolean deleteTask(Long id) {
        return repository.deleteTask(id);
    }

    public Task updateTask(Long id, Task task) {
        validateTask(task);
        if (task.getDueTime() != null && task.getDueTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("截止时间不能早于当前时间");
        }
        return repository.updateTask(id, task);
    }

    public List<Task> getTasksDueBefore(LocalDateTime time) {
        return repository.getTasksDueBefore(time);
    }

    public List<Task> getTasksByCompleted(boolean completed) {
        return repository.findByCompleted(completed);
    }

    public List<Task> searchTasksByTitle(String keyword) {
        return repository.findByTitleContains(keyword);
    }

    public void deleteTasks(List<Long> ids) {
        repository.deleteTasks(ids);
    }

    public List<Task> getRemindDueAndUncompleted(LocalDateTime now) {
        return repository.findRemindDueAndUncompleted(now);
    }

    public Task setTaskCompleted(Long id, boolean completed) {
        Task task = repository.getTask(id);
        if (task != null) {
            task.setCompleted(completed);
            repository.updateTask(id, task);
        }
        return task;
    }

    public List<Task> queryTasks(Integer priority, String keyword, LocalDateTime start, LocalDateTime end, Long typeId) {
        return repository.queryTasks(priority, keyword, start, end, typeId);
    }

    public Map<Long, List<Task>> groupByType() {
        return repository.groupByType();
    }
} 