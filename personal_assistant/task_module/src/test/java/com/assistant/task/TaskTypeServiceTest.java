package com.assistant.task;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TaskTypeServiceTest {
    private TaskTypeService typeService;
    
    @Before
    public void setUp() {
        typeService = new TaskTypeService();
    }
    
    @Test
    public void testAddType() {
        // 测试添加任务类型
        TaskType type = typeService.addType("工作");
        
        assertNotNull("添加的类型不应为空", type);
        assertNotNull("类型ID不应为空", type.getId());
        assertEquals("类型名称应匹配", "工作", type.getName());
    }
    
    @Test
    public void testGetAllTypes_Empty() {
        // 测试获取空列表
        List<TaskType> types = typeService.getAllTypes();
        
        assertNotNull("返回的列表不应为空对象", types);
        assertTrue("初始状态应返回空列表", types.isEmpty());
    }
    
    @Test
    public void testGetAllTypes_WithTypes() {
        // 测试获取包含类型的列表
        typeService.addType("工作");
        typeService.addType("学习");
        typeService.addType("生活");
        
        List<TaskType> types = typeService.getAllTypes();
        
        assertNotNull("返回的列表不应为空对象", types);
        assertEquals("应返回3个类型", 3, types.size());
        
        // 验证类型名称
        boolean hasWork = false;
        boolean hasStudy = false;
        boolean hasLife = false;
        
        for (TaskType type : types) {
            if ("工作".equals(type.getName())) hasWork = true;
            if ("学习".equals(type.getName())) hasStudy = true;
            if ("生活".equals(type.getName())) hasLife = true;
        }
        
        assertTrue("应包含'工作'类型", hasWork);
        assertTrue("应包含'学习'类型", hasStudy);
        assertTrue("应包含'生活'类型", hasLife);
    }
    
    @Test
    public void testGetType_Existing() {
        // 测试获取已存在的类型
        TaskType addedType = typeService.addType("工作");
        
        TaskType retrievedType = typeService.getType(addedType.getId());
        
        assertNotNull("应能获取已存在的类型", retrievedType);
        assertEquals("获取的类型ID应匹配", addedType.getId(), retrievedType.getId());
        assertEquals("获取的类型名称应匹配", "工作", retrievedType.getName());
    }
    
    @Test
    public void testGetType_NonExisting() {
        // 测试获取不存在的类型
        TaskType retrievedType = typeService.getType(999L);
        
        assertNull("不存在的类型ID应返回null", retrievedType);
    }
    
    @Test
    public void testTaskTypeSetters() {
        // 测试TaskType类的setter方法
        TaskType type = new TaskType(1L, "原始类型");
        
        // 测试setId
        type.setId(2L);
        assertEquals("ID应正确设置", 2L, (long)type.getId());
        
        // 测试setName
        type.setName("更新类型");
        assertEquals("名称应正确设置", "更新类型", type.getName());
    }
} 