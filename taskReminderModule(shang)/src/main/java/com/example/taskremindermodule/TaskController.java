package com.example.taskremindermodule;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service = new TaskService();

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return service.getTask(id);
    }

    @GetMapping
    public List<Task> getAllTasksSorted() {
        return service.getAllTasksSorted();
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id) {
        return service.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    @GetMapping("/dueBefore/{time}")
    public List<Task> getTasksDueBefore(@PathVariable String time) {
        LocalDateTime dateTime = LocalDateTime.parse(time);
        return service.getTasksDueBefore(dateTime);
    }

    @GetMapping("/completed/{completed}")
    public List<Task> getTasksByCompleted(@PathVariable boolean completed) {
        return service.getTasksByCompleted(completed);
    }

    @GetMapping("/search")
    public List<Task> searchTasksByTitle(@RequestParam String keyword) {
        return service.searchTasksByTitle(keyword);
    }

    @PostMapping("/batchDelete")
    public void deleteTasks(@RequestBody List<Long> ids) {
        service.deleteTasks(ids);
    }

    @GetMapping("/remindDueUncompleted")
    public List<Task> getRemindDueAndUncompleted() {
        return service.getRemindDueAndUncompleted(java.time.LocalDateTime.now());
    }

    @PostMapping("/{id}/completed")
    public Task setTaskCompleted(@PathVariable Long id, @RequestParam boolean completed) {
        return service.setTaskCompleted(id, completed);
    }

    @GetMapping("/query")
    public List<Task> queryTasks(@RequestParam(required = false) Integer priority,
                                 @RequestParam(required = false) String keyword,
                                 @RequestParam(required = false) String start,
                                 @RequestParam(required = false) String end,
                                 @RequestParam(required = false) Long typeId) {
        java.time.LocalDateTime startTime = start == null ? null : java.time.LocalDateTime.parse(start);
        java.time.LocalDateTime endTime = end == null ? null : java.time.LocalDateTime.parse(end);
        return service.queryTasks(priority, keyword, startTime, endTime, typeId);
    }

    @GetMapping("/groupByType")
    public java.util.Map<Long, java.util.List<Task>> groupByType() {
        return service.groupByType();
    }

    @PatchMapping("/{id}")
    public Task patchTask(@PathVariable Long id, @RequestBody java.util.Map<String, Object> updates) {
        Task task = service.getTask(id);
        if (task == null) return null;
        if (updates.containsKey("title")) task.setTitle((String) updates.get("title"));
        if (updates.containsKey("description")) task.setDescription((String) updates.get("description"));
        if (updates.containsKey("priority")) task.setPriority((Integer) updates.get("priority"));
        if (updates.containsKey("dueTime")) task.setDueTime(java.time.LocalDateTime.parse((String) updates.get("dueTime")));
        if (updates.containsKey("remindTime")) task.setRemindTime(java.time.LocalDateTime.parse((String) updates.get("remindTime")));
        if (updates.containsKey("typeId")) task.setTypeId(Long.valueOf(updates.get("typeId").toString()));
        service.updateTask(id, task);
        return task;
    }
} 