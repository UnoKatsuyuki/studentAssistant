package com.example.studytracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.IOException;

public class Main {
    private static final String DATA_FILE = "study_records.csv";
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        StudyTracker tracker = new StudyTracker();
        // 加载历史数据
        try {
            tracker.loadFromCSV(DATA_FILE);
            System.out.println("已加载历史学习记录。");
        } catch (IOException e) {
            System.out.println("未找到历史数据，将新建数据文件。");
        }

        while (true) {
            System.out.println("\n===== 学习打卡系统 =====");
            System.out.println("1. 添加学习记录");
            System.out.println("2. 查看学习统计");
            System.out.println("3. 最近7天趋势分析");
            System.out.println("4. 最近30天趋势分析");
            System.out.println("5. 导出数据为CSV");
            System.out.println("6. 退出");
            System.out.print("请选择操作（1-6）：");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    addRecord(tracker);
                    break;
                case "2":
                    showStatistics(tracker);
                    break;
                case "3":
                    showRecentTrend(tracker, 7);
                    break;
                case "4":
                    showRecentTrend(tracker, 30);
                    break;
                case "5":
                    exportData(tracker);
                    break;
                case "6":
                    try {
                        tracker.saveToCSV(DATA_FILE);
                        System.out.println("数据已保存，程序退出。");
                    } catch (IOException e) {
                        System.out.println("保存数据时出错：" + e.getMessage());
                    }
                    return;
                default:
                    System.out.println("无效选择，请重新输入。");
            }
        }
    }

    private static void addRecord(StudyTracker tracker) {
        try {
            System.out.print("请输入用户名：");
            String username = scanner.nextLine().trim();
            if (username.isEmpty()) {
                System.out.println("用户名不能为空。");
                return;
            }
            System.out.print("请输入日期（yyyy-MM-dd，或输入'今天'/'昨天'）：");
            String dateStr = scanner.nextLine().trim();
            LocalDate date = parseDate(dateStr);
            System.out.print("请输入科目：");
            String subject = scanner.nextLine().trim();
            if (subject.isEmpty()) {
                System.out.println("科目不能为空。");
                return;
            }
            System.out.print("请输入学习时长（分钟，正整数）：");
            String durationStr = scanner.nextLine().trim();
            int duration = Integer.parseInt(durationStr);
            if (duration <= 0) {
                System.out.println("学习时长必须大于0。");
                return;
            }
            tracker.addRecord(new StudyRecord(username, date, subject, duration));
            tracker.saveToCSV(DATA_FILE);
            System.out.println("学习记录添加成功！");
        } catch (DateTimeParseException | NumberFormatException e) {
            System.out.println("输入格式有误，请重试。");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("保存数据时出错：" + e.getMessage());
        }
    }

    private static String selectUser(StudyTracker tracker) {
        Set<String> users = new HashSet<>();
        for (StudyRecord r : tracker.getRecords()) {
            users.add(r.getUsername());
        }
        if (users.isEmpty()) {
            System.out.println("暂无用户数据。");
            return "";
        }
        List<String> userList = new ArrayList<>(users);
        Collections.sort(userList);
        System.out.println("请选择用户：");
        System.out.println("0. 全部用户");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println((i + 1) + ". " + userList.get(i));
        }
        System.out.print("请输入序号：");
        String input = scanner.nextLine().trim();
        int idx = 0;
        try {
            idx = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("输入无效，默认选择全部用户。");
            return "";
        }
        if (idx == 0) return "";
        if (idx > 0 && idx <= userList.size()) return userList.get(idx - 1);
        System.out.println("输入无效，默认选择全部用户。");
        return "";
    }

    private static void showStatistics(StudyTracker tracker) {
        String username = selectUser(tracker);
        System.out.println("\n--- 统计方式 ---");
        System.out.println("1. 按天统计");
        System.out.println("2. 按周统计");
        System.out.println("3. 按月统计");
        System.out.println("4. 按年统计");
        System.out.println("5. 最长连续打卡天数");
        System.out.print("请选择（1-5）：");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1":
                showDailyStats(tracker, username);
                break;
            case "2":
                showWeeklyStats(tracker, username);
                break;
            case "3":
                showMonthlyStats(tracker, username);
                break;
            case "4":
                showYearlyStats(tracker, username);
                break;
            case "5":
                showMaxStreak(tracker, username);
                break;
            default:
                System.out.println("无效选择。");
        }
    }

    private static void showDailyStats(StudyTracker tracker, String username) {
        System.out.print("请输入要统计的日期（yyyy-MM-dd，或'今天'/'昨天'）：");
        String dateStr = scanner.nextLine().trim();
        try {
            LocalDate date = parseDate(dateStr);
            int total = tracker.getRecordsByUser(username).stream()
                    .filter(r -> r.getDate().equals(date))
                    .mapToInt(StudyRecord::getDurationMinutes)
                    .sum();
            System.out.println(date + " 学习总时长：" + total + " 分钟");
            Map<String, Integer> subjectMap = new HashMap<>();
            for (StudyRecord r : tracker.getRecordsByUser(username)) {
                if (r.getDate().equals(date)) {
                    subjectMap.put(r.getSubject(), subjectMap.getOrDefault(r.getSubject(), 0) + r.getDurationMinutes());
                }
            }
            if (!subjectMap.isEmpty()) {
                System.out.println("各科目学习时长：");
                subjectMap.forEach((k, v) -> System.out.println("  " + k + ": " + v + " 分钟"));
            }
        } catch (DateTimeParseException e) {
            System.out.println("日期格式有误。");
        }
    }

    private static void showWeeklyStats(StudyTracker tracker, String username) {
        System.out.print("请输入要统计的某一天（yyyy-MM-dd，或'今天'/'昨天'）：");
        String dateStr = scanner.nextLine().trim();
        try {
            LocalDate date = parseDate(dateStr);
            Map<LocalDate, Integer> daily = tracker.getWeeklyStudySummary(date, username);
            System.out.println(date + " 所在周每日学习时长：");
            daily.forEach((d, v) -> System.out.println("  " + d + ": " + v + " 分钟"));
            Map<String, Integer> subject = tracker.getWeeklySubjectSummary(date, username);
            System.out.println("本周各科目学习时长：");
            subject.forEach((k, v) -> System.out.println("  " + k + ": " + v + " 分钟"));
        } catch (DateTimeParseException e) {
            System.out.println("日期格式有误。");
        }
    }

    private static void showMonthlyStats(StudyTracker tracker, String username) {
        System.out.print("请输入要统计的月份（yyyy-MM，或'本月'）：");
        String monthStr = scanner.nextLine().trim();
        LocalDate now = LocalDate.now();
        int year, month;
        try {
            if (monthStr.equals("本月")) {
                year = now.getYear();
                month = now.getMonthValue();
            } else {
                String[] arr = monthStr.split("-");
                year = Integer.parseInt(arr[0]);
                month = Integer.parseInt(arr[1]);
            }
            int total = tracker.getRecordsByUser(username).stream()
                    .filter(r -> r.getDate().getYear() == year && r.getDate().getMonthValue() == month)
                    .mapToInt(StudyRecord::getDurationMinutes)
                    .sum();
            System.out.println(year + "年" + month + "月学习总时长：" + total + " 分钟");
        } catch (Exception e) {
            System.out.println("输入格式有误。");
        }
    }

    private static void showYearlyStats(StudyTracker tracker, String username) {
        System.out.print("请输入要统计的年份（yyyy，或'今年'）：");
        String yearStr = scanner.nextLine().trim();
        LocalDate now = LocalDate.now();
        int year;
        try {
            if (yearStr.equals("今年")) {
                year = now.getYear();
            } else {
                year = Integer.parseInt(yearStr);
            }
            int total = tracker.getRecordsByUser(username).stream()
                    .filter(r -> r.getDate().getYear() == year)
                    .mapToInt(StudyRecord::getDurationMinutes)
                    .sum();
            System.out.println(year + "年学习总时长：" + total + " 分钟");
        } catch (Exception e) {
            System.out.println("输入格式有误。");
        }
    }

    private static void showMaxStreak(StudyTracker tracker, String username) {
        List<LocalDate> dates = new ArrayList<>();
        for (StudyRecord r : tracker.getRecordsByUser(username)) {
            dates.add(r.getDate());
        }
        if (dates.isEmpty()) {
            System.out.println("暂无学习记录。");
            return;
        }
        Set<LocalDate> uniqueDates = new HashSet<>(dates);
        List<LocalDate> sorted = new ArrayList<>(uniqueDates);
        Collections.sort(sorted);
        int maxStreak = 1, curStreak = 1;
        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i - 1).plusDays(1).equals(sorted.get(i))) {
                curStreak++;
                maxStreak = Math.max(maxStreak, curStreak);
            } else {
                curStreak = 1;
            }
        }
        System.out.println("最长连续打卡天数：" + maxStreak + " 天");
    }

    private static void showRecentTrend(StudyTracker tracker, int days) {
        String username = selectUser(tracker);
        Map<LocalDate, Integer> trend = tracker.getRecentDaysSummary(days, username);
        System.out.println("最近" + days + "天学习趋势（每天总时长）：");
        trend.forEach((date, duration) -> System.out.println(date + ": " + duration + " 分钟"));
    }

    private static void exportData(StudyTracker tracker) {
        String username = selectUser(tracker);
        System.out.print("请输入导出文件名（如 output.csv）：");
        String fileName = scanner.nextLine().trim();
        if (fileName.isEmpty()) {
            System.out.println("文件名不能为空。");
            return;
        }
        try {
            List<StudyRecord> exportList = tracker.getRecordsByUser(username);
            List<String[]> data = new ArrayList<>();
            for (StudyRecord record : exportList) {
                data.add(record.toCSVRow());
            }
            CSVUtils.writeCSV(fileName, data);
            System.out.println("数据已导出到 " + fileName);
        } catch (IOException e) {
            System.out.println("导出失败：" + e.getMessage());
        }
    }

    private static LocalDate parseDate(String input) {
        input = input.trim();
        if (input.equals("今天")) {
            return LocalDate.now();
        } else if (input.equals("昨天")) {
            return LocalDate.now().minusDays(1);
        } else {
            return LocalDate.parse(input, DATE_FORMAT);
        }
    }
}


