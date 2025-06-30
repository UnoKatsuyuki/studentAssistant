package com.example.taskremindermodule;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class TaskTypeRepository {
    private final Map<Long, TaskType> typeMap = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public TaskType addType(String name) {
        Long id = idGen.getAndIncrement();
        TaskType type = new TaskType(id, name);
        typeMap.put(id, type);
        return type;
    }
    public TaskType getType(Long id) {
        return typeMap.get(id);
    }
    public List<TaskType> getAllTypes() {
        return new ArrayList<>(typeMap.values());
    }
    public boolean deleteType(Long id) {
        return typeMap.remove(id) != null;
    }
} 