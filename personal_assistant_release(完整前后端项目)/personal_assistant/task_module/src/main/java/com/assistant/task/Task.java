package com.assistant.task;

public class Task {
    private Long id;
    private String title;
    private String description;
    private int priority; // 1高 2中 3低
    private java.time.LocalDateTime dueTime;
    private java.time.LocalDateTime remindTime;
    private Long typeId;
    private boolean completed;

    public Task(Long id, String title, String description, int priority, java.time.LocalDateTime dueTime, java.time.LocalDateTime remindTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueTime = dueTime;
        this.remindTime = remindTime;
        this.completed = false;
    }
    // getter/setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public java.time.LocalDateTime getDueTime() { return dueTime; }
    public void setDueTime(java.time.LocalDateTime dueTime) { this.dueTime = dueTime; }
    public java.time.LocalDateTime getRemindTime() { return remindTime; }
    public void setRemindTime(java.time.LocalDateTime remindTime) { this.remindTime = remindTime; }
    public Long getTypeId() { return typeId; }
    public void setTypeId(Long typeId) { this.typeId = typeId; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
} 