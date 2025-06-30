package com.example.taskremindermodule;

import java.util.List;

public class TaskTypeService {
    private final TaskTypeRepository repository = new TaskTypeRepository();

    public TaskType addType(String name) {
        return repository.addType(name);
    }
    public TaskType getType(Long id) {
        return repository.getType(id);
    }
    public List<TaskType> getAllTypes() {
        return repository.getAllTypes();
    }
    public boolean deleteType(Long id) {
        return repository.deleteType(id);
    }
} 