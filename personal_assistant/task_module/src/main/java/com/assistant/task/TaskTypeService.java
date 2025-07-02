package com.assistant.task;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class TaskTypeService {
    private final Map<Long, TaskType> typeMap = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public TaskType addType(String name) {
        long id = idGen.getAndIncrement();
        TaskType type = new TaskType(id, name);
        typeMap.put(id, type);
        return type;
    }

    public List<TaskType> getAllTypes() {
        return new ArrayList<>(typeMap.values());
    }

    public TaskType getType(Long id) {
        return typeMap.get(id);
    }
} 