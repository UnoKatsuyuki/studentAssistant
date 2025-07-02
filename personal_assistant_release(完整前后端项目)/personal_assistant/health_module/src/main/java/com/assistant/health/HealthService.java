package com.assistant.health;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HealthService {
    private final HealthRepository repository;
    private final Map<String, String> supportedHabits;

    public HealthService() {
        this.repository = new HealthRepository();
        this.supportedHabits = Map.of(
                "睡眠", "小时",
                "运动", "分钟",
                "喝水", "毫升"
        );
    }

    public Map<String, String> getSupportedHabits() {
        return supportedHabits;
    }

    /**
     * 添加一条打卡记录
     * @return 添加成功的记录
     * @throws IllegalArgumentException 如果当天已打卡该项目
     */
    public HealthRecord addRecord(String habit, double value) throws IllegalArgumentException {
        if (!supportedHabits.containsKey(habit)) {
            throw new IllegalArgumentException("不支持该打卡项目。");
        }

        // 检查今日是否已打卡该项目
        LocalDate today = LocalDate.now();
        boolean alreadyPunched = repository.findAll().stream()
                .anyMatch(r -> r.getDate().equals(today) && r.getHabit().equals(habit));

        if (alreadyPunched) {
            throw new IllegalArgumentException("今日已打卡该项目，不能重复打卡！");
        }

        String unit = supportedHabits.get(habit);
        HealthRecord record = new HealthRecord(LocalDateTime.now(), habit, value, unit);
        repository.add(record);
        return record;
    }

    /**
     * 获取按日期分组的所有记录
     */
    public Map<LocalDate, List<HealthRecord>> getRecordsGroupedByDate() {
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(HealthRecord::getDate));
    }
}