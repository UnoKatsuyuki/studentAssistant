package com.assistant.task;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class TaskServiceTest {
    private TaskService taskService;
    private LocalDateTime now;
    
    @Before
    public void setUp() {
        taskService = new TaskService();
        now = LocalDateTime.now();
    }
    
    @Test
    public void testAddTask_Normal() {
        // 测试正常添加任务
        Task task = new Task(null, "测试任务", "测试描述", 2, now, now.plusHours(1));
        Task addedTask = taskService.addTask(task);
        
        assertNotNull("添加的任务不应为空", addedTask);
        assertNotNull("任务ID不应为空", addedTask.getId());
        assertEquals("任务标题应匹配", "测试任务", addedTask.getTitle());
        assertEquals("任务描述应匹配", "测试描述", addedTask.getDescription());
        assertEquals("任务优先级应匹配", 2, addedTask.getPriority());
        assertEquals("任务截止时间应匹配", now, addedTask.getDueTime());
        assertEquals("任务提醒时间应匹配", now.plusHours(1), addedTask.getRemindTime());
        assertFalse("新任务默认应为未完成", addedTask.isCompleted());
    }
    
    @Test
    public void testAddTask_EmptyTitle() {
        // 测试标题为空的异常情况
        Task task = new Task(null, "", "测试描述", 2, now, now.plusHours(1));
        Task addedTask = taskService.addTask(task);
        
        assertNotNull("即使标题为空也应该添加成功", addedTask);
        assertEquals("空标题应该被保留", "", addedTask.getTitle());
        
        // 验证可以通过查询找到该任务
        List<Task> tasks = taskService.getAllTasksSorted();
        boolean found = false;
        for (Task t : tasks) {
            if (t.getId().equals(addedTask.getId())) {
                found = true;
                break;
            }
        }
        assertTrue("应能在任务列表中找到空标题任务", found);
    }
    
    @Test
    public void testAddTask_InvalidPriority() {
        // 测试无效优先级的异常情况
        Task task = new Task(null, "测试任务", "测试描述", 5, now, now.plusHours(1));
        Task addedTask = taskService.addTask(task);
        
        assertNotNull("即使优先级无效也应该添加成功", addedTask);
        assertEquals("无效优先级应该被保留", 5, addedTask.getPriority());
    }
    
    @Test
    public void testGetTask_Existing() {
        // 测试获取已存在的任务
        Task task = new Task(null, "测试任务", "测试描述", 2, now, now.plusHours(1));
        Task addedTask = taskService.addTask(task);
        
        Task retrievedTask = taskService.getTask(addedTask.getId());
        assertNotNull("应能获取已存在的任务", retrievedTask);
        assertEquals("获取的任务ID应匹配", addedTask.getId(), retrievedTask.getId());
        assertEquals("获取的任务标题应匹配", "测试任务", retrievedTask.getTitle());
    }
    
    @Test
    public void testGetTask_NonExisting() {
        // 测试获取不存在的任务
        Task retrievedTask = taskService.getTask(999L);
        assertNull("不存在的任务ID应返回null", retrievedTask);
    }
    
    @Test
    public void testUpdateTask() {
        // 测试更新任务
        Task task = new Task(null, "原始任务", "原始描述", 2, now, now.plusHours(1));
        Task addedTask = taskService.addTask(task);
        
        Task updatedTask = new Task(addedTask.getId(), "更新后的任务", "更新后的描述", 1, now.plusDays(1), now.plusDays(1).minusHours(2));
        taskService.updateTask(addedTask.getId(), updatedTask);
        
        Task retrievedTask = taskService.getTask(addedTask.getId());
        assertNotNull("更新后的任务不应为空", retrievedTask);
        assertEquals("更新后的任务标题应匹配", "更新后的任务", retrievedTask.getTitle());
        assertEquals("更新后的任务描述应匹配", "更新后的描述", retrievedTask.getDescription());
        assertEquals("更新后的任务优先级应匹配", 1, retrievedTask.getPriority());
    }
    
    @Test
    public void testDeleteTask() {
        // 测试删除任务
        Task task = new Task(null, "待删除任务", "待删除描述", 3, now, now.plusHours(1));
        Task addedTask = taskService.addTask(task);
        
        taskService.deleteTask(addedTask.getId());
        
        Task retrievedTask = taskService.getTask(addedTask.getId());
        assertNull("已删除的任务应返回null", retrievedTask);
    }
    
    @Test
    public void testSetTaskCompleted_True() {
        // 测试将任务标记为已完成
        Task task = new Task(null, "测试任务", "测试描述", 2, now, now.plusHours(1));
        Task addedTask = taskService.addTask(task);
        
        taskService.setTaskCompleted(addedTask.getId(), true);
        
        Task retrievedTask = taskService.getTask(addedTask.getId());
        assertTrue("任务应被标记为已完成", retrievedTask.isCompleted());
    }
    
    @Test
    public void testSetTaskCompleted_False() {
        // 测试将已完成任务标记为未完成
        Task task = new Task(null, "测试任务", "测试描述", 2, now, now.plusHours(1));
        Task addedTask = taskService.addTask(task);
        
        taskService.setTaskCompleted(addedTask.getId(), true);
        taskService.setTaskCompleted(addedTask.getId(), false);
        
        Task retrievedTask = taskService.getTask(addedTask.getId());
        assertFalse("任务应被标记为未完成", retrievedTask.isCompleted());
    }
    
    @Test
    public void testQueryTasks_ByPriority() {
        // 测试按优先级查询任务
        taskService.addTask(new Task(null, "高优先级任务", "描述", 1, now, now.plusHours(1)));
        taskService.addTask(new Task(null, "中优先级任务1", "描述", 2, now, now.plusHours(1)));
        taskService.addTask(new Task(null, "中优先级任务2", "描述", 2, now, now.plusHours(1)));
        taskService.addTask(new Task(null, "低优先级任务", "描述", 3, now, now.plusHours(1)));
        
        List<Task> highPriorityTasks = taskService.queryTasks(1, null, null, null, null);
        assertEquals("应有1个高优先级任务", 1, highPriorityTasks.size());
        assertEquals("高优先级任务标题应匹配", "高优先级任务", highPriorityTasks.get(0).getTitle());
        
        List<Task> mediumPriorityTasks = taskService.queryTasks(2, null, null, null, null);
        assertEquals("应有2个中优先级任务", 2, mediumPriorityTasks.size());
    }
    
    @Test
    public void testQueryTasks_ByKeyword() {
        // 测试按关键字查询任务
        taskService.addTask(new Task(null, "软件测试作业", "描述", 1, now, now.plusHours(1)));
        taskService.addTask(new Task(null, "数据结构作业", "描述", 2, now, now.plusHours(1)));
        taskService.addTask(new Task(null, "软件工程作业", "描述", 2, now, now.plusHours(1)));
        
        List<Task> softwareTasks = taskService.queryTasks(null, "软件", null, null, null);
        assertEquals("应有2个包含'软件'的任务", 2, softwareTasks.size());
    }
    
    @Test
    public void testQueryTasks_ByTimeRange() {
        // 测试按时间范围查询任务
        LocalDateTime yesterday = now.minusDays(1);
        LocalDateTime tomorrow = now.plusDays(1);
        LocalDateTime nextWeek = now.plusDays(7);
        
        taskService.addTask(new Task(null, "昨天任务", "描述", 1, yesterday, yesterday));
        taskService.addTask(new Task(null, "今天任务", "描述", 2, now, now));
        taskService.addTask(new Task(null, "明天任务", "描述", 2, tomorrow, tomorrow));
        taskService.addTask(new Task(null, "下周任务", "描述", 3, nextWeek, nextWeek));
        
        List<Task> recentTasks = taskService.queryTasks(null, null, yesterday, tomorrow, null);
        assertEquals("应有3个在指定时间范围内的任务", 3, recentTasks.size());
    }
    
    @Test
    public void testGroupByType() {
        // 测试按类型分组
        Task task1 = new Task(null, "工作任务1", "描述", 1, now, now);
        task1.setTypeId(1L);
        taskService.addTask(task1);
        
        Task task2 = new Task(null, "工作任务2", "描述", 2, now, now);
        task2.setTypeId(1L);
        taskService.addTask(task2);
        
        Task task3 = new Task(null, "学习任务", "描述", 2, now, now);
        task3.setTypeId(2L);
        taskService.addTask(task3);
        
        Task task4 = new Task(null, "未分类任务", "描述", 3, now, now);
        taskService.addTask(task4);
        
        Map<Long, List<Task>> groupedTasks = taskService.groupByType();
        
        assertEquals("应有3个分组（包括null组）", 3, groupedTasks.size());
        assertEquals("工作类型应有2个任务", 2, groupedTasks.get(1L).size());
        assertEquals("学习类型应有1个任务", 1, groupedTasks.get(2L).size());
        assertEquals("未分类应有1个任务", 1, groupedTasks.get(null).size());
    }
    
    @Test
    public void testGetAllTasksSorted() {
        // 测试获取所有任务并按ID排序
        taskService.addTask(new Task(null, "任务1", "描述", 1, now, now));
        taskService.addTask(new Task(null, "任务2", "描述", 2, now, now));
        taskService.addTask(new Task(null, "任务3", "描述", 3, now, now));
        
        List<Task> allTasks = taskService.getAllTasksSorted();
        
        assertEquals("应返回所有3个任务", 3, allTasks.size());
        assertTrue("任务应按ID升序排序", 
                   allTasks.get(0).getId() < allTasks.get(1).getId() && 
                   allTasks.get(1).getId() < allTasks.get(2).getId());
    }
    
    @Test
    public void testTaskSetters() {
        // 测试Task类的setter方法
        Task task = new Task(null, "", "", 1, null, null);
        
        // 测试setTitle
        task.setTitle("测试标题");
        assertEquals("标题应正确设置", "测试标题", task.getTitle());
        
        // 测试setDescription
        task.setDescription("测试描述");
        assertEquals("描述应正确设置", "测试描述", task.getDescription());
        
        // 测试setPriority
        task.setPriority(1);
        assertEquals("优先级应正确设置", 1, task.getPriority());
        
        // 测试setDueTime
        LocalDateTime dueTime = LocalDateTime.now().plusDays(1);
        task.setDueTime(dueTime);
        assertEquals("截止时间应正确设置", dueTime, task.getDueTime());
        
        // 测试setRemindTime
        LocalDateTime remindTime = LocalDateTime.now().plusHours(12);
        task.setRemindTime(remindTime);
        assertEquals("提醒时间应正确设置", remindTime, task.getRemindTime());
        
        // 测试setTypeId
        Long typeId = 5L;
        task.setTypeId(typeId);
        assertEquals("类型ID应正确设置", typeId, task.getTypeId());
        
        // 测试setCompleted
        task.setCompleted(true);
        assertTrue("完成状态应正确设置", task.isCompleted());
    }
} 