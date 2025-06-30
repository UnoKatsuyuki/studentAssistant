package com.example.taskremindermodule;

import java.time.LocalDateTime;
import java.util.*;

public class TaskConsoleUITest {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskService taskService = new TaskService();
    private static final TaskTypeService typeService = new TaskTypeService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== 任务提醒模块测试UI ====");
            System.out.println("1. 新建任务类型");
            System.out.println("2. 查看所有类型");
            System.out.println("3. 新建任务");
            System.out.println("4. 查看所有任务");
            System.out.println("5. 多条件查询任务");
            System.out.println("6. 按类型分组查看任务");
            System.out.println("7. 修改任务");
            System.out.println("8. 删除任务");
            System.out.println("9. 退出");
            System.out.println("10. 标记任务为完成/未完成");
            System.out.print("请选择操作: ");
            String op = scanner.nextLine();
            switch (op) {
                case "1": addType(); break;
                case "2": listTypes(); break;
                case "3": addTask(); break;
                case "4": listTasks(); break;
                case "5": queryTasks(); break;
                case "6": groupByType(); break;
                case "7": updateTask(); break;
                case "8": deleteTask(); break;
                case "9": System.exit(0);
                case "10": completeTask(); break;
                default: System.out.println("无效操作");
            }
        }
    }

    private static void addType() {
        System.out.print("输入新类型名称: ");
        String name = scanner.nextLine();
        TaskType type = typeService.addType(name);
        System.out.println("已添加类型: " + type.getId() + " - " + type.getName());
    }

    private static void listTypes() {
        List<TaskType> types = typeService.getAllTypes();
        System.out.println("所有类型:");
        for (TaskType t : types) {
            System.out.println(t.getId() + ": " + t.getName());
        }
    }

    private static void addTask() {
        System.out.print("标题: ");
        String title = scanner.nextLine();
        System.out.print("描述: ");
        String desc = scanner.nextLine();
        System.out.print("优先级(1高/2中/3低): ");
        int priority = Integer.parseInt(scanner.nextLine());
        System.out.print("截止时间(yyyy-MM-ddTHH:mm, 可空): ");
        String dueStr = scanner.nextLine();
        LocalDateTime due = dueStr.isEmpty() ? null : LocalDateTime.parse(dueStr);
        System.out.print("提醒时间(yyyy-MM-ddTHH:mm, 可空): ");
        String remindStr = scanner.nextLine();
        LocalDateTime remind = remindStr.isEmpty() ? null : LocalDateTime.parse(remindStr);
        listTypes();
        System.out.print("类型ID(可空): ");
        String typeIdStr = scanner.nextLine();
        Long typeId = typeIdStr.isEmpty() ? null : Long.valueOf(typeIdStr);
        Task task = new Task(null, title, desc, priority, due, remind);
        task.setTypeId(typeId);
        taskService.addTask(task);
        System.out.println("任务已添加。");
    }

    private static void listTasks() {
        List<Task> tasks = taskService.getAllTasksSorted();
        printTasks(tasks);
    }

    private static void queryTasks() {
        System.out.print("优先级(1/2/3, 可空): ");
        String pStr = scanner.nextLine();
        Integer priority = pStr.isEmpty() ? null : Integer.valueOf(pStr);
        System.out.print("标题关键字(可空): ");
        String keyword = scanner.nextLine();
        System.out.print("开始时间(yyyy-MM-ddTHH:mm, 可空): ");
        String startStr = scanner.nextLine();
        LocalDateTime start = startStr.isEmpty() ? null : LocalDateTime.parse(startStr);
        System.out.print("结束时间(yyyy-MM-ddTHH:mm, 可空): ");
        String endStr = scanner.nextLine();
        LocalDateTime end = endStr.isEmpty() ? null : LocalDateTime.parse(endStr);
        listTypes();
        System.out.print("类型ID(可空): ");
        String typeIdStr = scanner.nextLine();
        Long typeId = typeIdStr.isEmpty() ? null : Long.valueOf(typeIdStr);
        List<Task> tasks = taskService.queryTasks(priority, keyword, start, end, typeId);
        printTasks(tasks);
    }

    private static void groupByType() {
        Map<Long, List<Task>> map = taskService.groupByType();
        for (Map.Entry<Long, List<Task>> entry : map.entrySet()) {
            Long typeId = entry.getKey();
            String typeName = typeId == null ? "未分组" : Optional.ofNullable(typeService.getType(typeId)).map(TaskType::getName).orElse("未知类型");
            System.out.println("类型: " + typeName);
            printTasks(entry.getValue());
        }
    }

    private static void updateTask() {
        listTasks();
        System.out.print("输入要修改的任务ID: ");
        Long id = Long.valueOf(scanner.nextLine());
        Task task = taskService.getTask(id);
        if (task == null) {
            System.out.println("任务不存在");
            return;
        }
        System.out.print("新标题(留空不改): ");
        String title = scanner.nextLine();
        if (!title.isEmpty()) task.setTitle(title);
        System.out.print("新描述(留空不改): ");
        String desc = scanner.nextLine();
        if (!desc.isEmpty()) task.setDescription(desc);
        System.out.print("新优先级(1/2/3, 留空不改): ");
        String pStr = scanner.nextLine();
        if (!pStr.isEmpty()) task.setPriority(Integer.valueOf(pStr));
        System.out.print("新截止时间(yyyy-MM-ddTHH:mm, 留空不改): ");
        String dueStr = scanner.nextLine();
        if (!dueStr.isEmpty()) task.setDueTime(LocalDateTime.parse(dueStr));
        System.out.print("新提醒时间(yyyy-MM-ddTHH:mm, 留空不改): ");
        String remindStr = scanner.nextLine();
        if (!remindStr.isEmpty()) task.setRemindTime(LocalDateTime.parse(remindStr));
        listTypes();
        System.out.print("新类型ID(留空不改): ");
        String typeIdStr = scanner.nextLine();
        if (!typeIdStr.isEmpty()) task.setTypeId(Long.valueOf(typeIdStr));
        taskService.updateTask(id, task);
        System.out.println("任务已更新。");
    }

    private static void deleteTask() {
        listTasks();
        System.out.print("输入要删除的任务ID: ");
        Long id = Long.valueOf(scanner.nextLine());
        taskService.deleteTask(id);
        System.out.println("任务已删除。");
    }

    private static void completeTask() {
        listTasks();
        System.out.print("输入要标记的任务ID: ");
        Long id = Long.valueOf(scanner.nextLine());
        Task task = taskService.getTask(id);
        if (task == null) {
            System.out.println("任务不存在");
            return;
        }
        System.out.print("是否标记为完成？(y/n): ");
        String yn = scanner.nextLine();
        boolean completed = yn.trim().equalsIgnoreCase("y");
        taskService.setTaskCompleted(id, completed);
        System.out.println("任务已更新为" + (completed ? "完成" : "未完成"));
    }

    private static void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("无任务");
            return;
        }
        System.out.println("ID | 标题 | 描述 | 优先级 | 截止时间 | 提醒时间 | 类型ID | 完成");
        for (Task t : tasks) {
            System.out.printf("%d | %s | %s | %d | %s | %s | %s | %s\n",
                    t.getId(), t.getTitle(), t.getDescription(), t.getPriority(),
                    t.getDueTime(), t.getRemindTime(),
                    t.getTypeId(), t.isCompleted() ? "是" : "否");
        }
    }
} 