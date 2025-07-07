package com.assistant.health;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// 使用 Mockito 扩展来简化 Mock 对象的创建
@ExtendWith(MockitoExtension.class)
class HealthServiceTest {

    // @Mock: 创建一个 HealthRepository 的模拟对象
    @Mock
    private HealthRepository healthRepository;

    // @InjectMocks: 创建一个 HealthService 实例，并自动将 @Mock 对象注入其中
    @InjectMocks
    private HealthService healthService;

    @Test
    void addRecord_successWhenHabitIsValidAndNotPunched() {
        // 1. 准备 (Arrange)
        // 当测试代码调用 repository.findAll() 时，让它返回一个空列表
        when(healthRepository.findAll()).thenReturn(Collections.emptyList());

        // 2. 执行 (Act)
        HealthRecord result = healthService.addRecord("运动", 30);

        // 3. 断言 (Assert)
        assertNotNull(result); // 结果不应为空
        assertEquals("运动", result.getHabit()); // 检查习惯名称
        assertEquals(30, result.getValue()); // 检查值

        // 验证 repository.add() 方法是否被调用了1次
        verify(healthRepository, times(1)).add(any(HealthRecord.class));
    }

    @Test
    void addRecord_throwsExceptionWhenHabitIsInvalid() {
        // 1. 准备 (Arrange) - 无需准备，因为该逻辑不依赖 repository

        // 2. 执行 & 3. 断言 (Act & Assert)
        // 断言当执行 addRecord 时，会抛出 IllegalArgumentException 异常
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            healthService.addRecord("看电视", 60);
        });

        // 验证异常信息是否正确
        assertEquals("不支持该打卡项目。", exception.getMessage());

        // 验证 repository.add() 方法从未被调用
        verify(healthRepository, never()).add(any());
    }

    @Test
    void addRecord_throwsExceptionWhenHabitAlreadyPunchedToday() {
        // 1. 准备 (Arrange)
        // 创建一个今天的、已存在的“运动”记录
        HealthRecord existingRecord = new HealthRecord(1L, LocalDateTime.now(), "运动", 60, "分钟");
        List<HealthRecord> records = new ArrayList<>();
        records.add(existingRecord);

        // 当测试代码调用 repository.findAll() 时，返回包含上述记录的列表
        when(healthRepository.findAll()).thenReturn(records);

        // 2. 执行 & 3. 断言 (Act & Assert)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            healthService.addRecord("运动", 30); // 尝试再次添加“运动”
        });

        assertEquals("今日已打卡该项目，不能重复打卡！", exception.getMessage());
        verify(healthRepository, never()).add(any());
    }

    @Test
    void getRecordsGroupedByDate_returnsCorrectlyGroupedMap() {
        // 1. 准备 (Arrange)
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);

        HealthRecord record1 = new HealthRecord(1L, today, "喝水", 1500, "毫升");
        HealthRecord record2 = new HealthRecord(2L, yesterday, "睡眠", 8, "小时");
        HealthRecord record3 = new HealthRecord(3L, today, "运动", 45, "分钟");

        List<HealthRecord> records = List.of(record1, record2, record3);
        when(healthRepository.findAll()).thenReturn(records);

        // 2. 执行 (Act)
        Map<LocalDate, List<HealthRecord>> result = healthService.getRecordsGroupedByDate();

        // 3. 断言 (Assert)
        assertEquals(2, result.size()); // 应该有两个日期分组
        assertTrue(result.containsKey(today.toLocalDate())); // 包含今天
        assertTrue(result.containsKey(yesterday.toLocalDate())); // 包含昨天
        assertEquals(2, result.get(today.toLocalDate()).size()); // 今天的分组里应该有2条记录
        assertEquals(1, result.get(yesterday.toLocalDate()).size()); // 昨天的分组里应该有1条记录
    }
}
