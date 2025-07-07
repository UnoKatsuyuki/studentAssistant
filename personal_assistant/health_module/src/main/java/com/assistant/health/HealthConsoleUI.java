package com.assistant.health;

import java.time.LocalDate;
import java.util.*;

public class HealthConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final HealthService healthService; // 只声明

    public HealthConsoleUI() {
        // 在构造函数中手动完成依赖注入
        HealthRepository repository = new HealthRepository();
        this.healthService = new HealthService(repository);
    }

    public void start() {
        // ... start 方法的内部逻辑保持不变
        System.out.println("欢迎使用健康习惯打卡模块！");
        while (true) {
            System.out.println("\n请选择操作：");
            System.out.println("1. 今日打卡");
            System.out.println("2. 查看详细打卡记录");
            System.out.println("3. 返回主菜单");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    handlePunch();
                    break;
                case "2":
                    displayAllRecords();
                    break;
                case "3":
                    System.out.println("--- 返回主菜单 ---");
                    return;
                default:
                    System.out.println("无效输入，请重新选择！");
            }
        }
    }

    // ... handlePunch 和 displayAllRecords 方法保持不变
    private void handlePunch() {
        Map<String, String> habits = healthService.getSupportedHabits();
        System.out.println("可打卡项目：" + String.join("、", habits.keySet()));
        System.out.print("请输入要打卡的项目：");
        String habit = scanner.nextLine().trim();

        if (!habits.containsKey(habit)) {
            System.out.println("输入无效，请输入有效项目名。");
            return;
        }

        System.out.print("请输入" + habit + "的" + habits.get(habit) + "数值：");
        String valueInput = scanner.nextLine().trim();
        double value;
        try {
            value = Double.parseDouble(valueInput);
            if (value <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("输入无效，必须是正数！");
            return;
        }

        try {
            HealthRecord record = healthService.addRecord(habit, value);
            System.out.println("打卡成功！详细记录：" + record);
        } catch (IllegalArgumentException e) {
            System.out.println("打卡失败：" + e.getMessage());
        }
    }

    private void displayAllRecords() {
        Map<LocalDate, List<HealthRecord>> recordsByDate = healthService.getRecordsGroupedByDate();

        if (recordsByDate.isEmpty()) {
            System.out.println("暂无打卡记录。");
            return;
        }

        System.out.println("详细打卡记录如下：");
        List<LocalDate> sortedDates = new ArrayList<>(recordsByDate.keySet());
        Collections.sort(sortedDates);

        for (LocalDate date : sortedDates) {
            System.out.println("【" + date + "】");
            for (HealthRecord record : recordsByDate.get(date)) {
                System.out.println("  " + record);
            }
        }
    }

    public static void main(String[] args) {
        new HealthConsoleUI().start();
    }
}
