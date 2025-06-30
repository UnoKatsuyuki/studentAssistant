package com.example.taskremindermodule;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private int priority; // 1-高，2-中，3-低
    private LocalDateTime dueTime;
    private LocalDateTime remindTime;
    private boolean completed = false;
    private Long typeId;

    public Task() {}

    public Task(Long id, String title, String description, int priority, LocalDateTime dueTime, LocalDateTime remindTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueTime = dueTime;
        this.remindTime = remindTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public LocalDateTime getDueTime() { return dueTime; }
    public void setDueTime(LocalDateTime dueTime) { this.dueTime = dueTime; }
    public LocalDateTime getRemindTime() { return remindTime; }
    public void setRemindTime(LocalDateTime remindTime) { this.remindTime = remindTime; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public Long getTypeId() { return typeId; }
    public void setTypeId(Long typeId) { this.typeId = typeId; }
} 