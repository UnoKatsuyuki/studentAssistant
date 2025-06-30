package com.example.taskremindermodule;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/types")
public class TaskTypeController {
    private final TaskTypeService service = new TaskTypeService();

    @PostMapping
    public TaskType addType(@RequestParam String name) {
        return service.addType(name);
    }
    @GetMapping
    public List<TaskType> getAllTypes() {
        return service.getAllTypes();
    }
    @DeleteMapping("/{id}")
    public boolean deleteType(@PathVariable Long id) {
        return service.deleteType(id);
    }
} 