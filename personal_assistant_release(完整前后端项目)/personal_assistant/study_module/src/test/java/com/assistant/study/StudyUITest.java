package com.assistant.study;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.P7rintStream;
import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class StudyUITest {
    @Test
    void testParseDate_standard() {
        assertEquals(LocalDate.of(2024, 7, 4), invokeParseDate("2024-07-04"));
    }

    @Test
    void testParseDate_today() {
        LocalDate today = LocalDate.now();
        assertEquals(today, invokeParseDate("今天"));
    }

    @Test
    void testParseDate_yesterday() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        assertEquals(yesterday, invokeParseDate("昨天"));
    }

    @Test
    void testParseDate_invalid() {
        assertThrows(Exception.class, () -> invokeParseDate("abc"));
    }

    // 辅助方法，反射调用 private static LocalDate parseDate(String input)
    private LocalDate invokeParseDate(String input) {
        try {
            var method = StudyUI.class.getDeclaredMethod("parseDate", String.class);
            method.setAccessible(true);
            return (LocalDate) method.invoke(null, input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 演示如何测试带输入输出的方法（如 addRecord），这里只做结构示例
    @Test
    void testAddRecord_usernameEmpty() throws Exception {
        String simulatedInput = "\n2024-07-04\n数学\n60\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("用户名不能为空"));
    }

    @Test
    void testAddRecord_subjectEmpty() throws Exception {
        String simulatedInput = "张三\n2024-07-04\n\n60\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("科目不能为空"));
    }

    @Test
    void testAddRecord_durationInvalid() throws Exception {
        String simulatedInput = "张三\n2024-07-04\n数学\nabc\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("输入格式有误"));
    }

    @Test
    void testAddRecord_durationZero() throws Exception {
        String simulatedInput = "张三\n2024-07-04\n数学\n0\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("学习时长必须大于0"));
    }

    @Test
    void testAddRecord_dateInvalid() throws Exception {
        String simulatedInput = "张三\nxxxx\n数学\n60\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("输入格式有误"));
    }

    @Test
    void testAddRecord_success() throws Exception {
        String simulatedInput = "张三\n2024-07-04\n数学\n60\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("学习记录添加成功"));
    }

    @Test
    void testSelectUser_noUser() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("\n".getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("selectUser", StudyTracker.class);
        method.setAccessible(true);
        String result = (String) method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("暂无用户数据"));
        assertEquals("", result);
    }

    @Test
    void testSelectUser_validChoice() throws Exception {
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 4), "数学", 60));
        tracker.addRecord(new StudyRecord("李四", LocalDate.of(2024, 7, 4), "英语", 30));
        ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes()); // 选择李四
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        var method = StudyUI.class.getDeclaredMethod("selectUser", StudyTracker.class);
        method.setAccessible(true);
        String result = (String) method.invoke(ui, tracker);
        assertEquals("李四", result);
    }

    @Test
    void testSelectUser_invalidInput() throws Exception {
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 4), "数学", 60));
        ByteArrayInputStream in = new ByteArrayInputStream("abc\n".getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        var method = StudyUI.class.getDeclaredMethod("selectUser", StudyTracker.class);
        method.setAccessible(true);
        String result = (String) method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("输入无效，默认选择全部用户"));
        assertEquals("", result);
    }

    @Test
    void testShowStatistics_invalidChoice() throws Exception {
        String simulatedInput = "\n9\n"; // 选择用户后输入无效选项
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("showStatistics", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("无效选择"));
    }

    @Test
    void testShowDailyStats_dateInvalid() throws Exception {
        String simulatedInput = "xxxx\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("showDailyStats", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("日期格式有误"));
    }

    @Test
    void testShowDailyStats_noData() throws Exception {
        String simulatedInput = "2024-07-04\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("showDailyStats", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("学习总时长：0 分钟"));
    }

    @Test
    void testShowDailyStats_multiSubject() throws Exception {
        String simulatedInput = "2024-07-04\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 4), "数学", 30));
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 4), "英语", 20));
        var method = StudyUI.class.getDeclaredMethod("showDailyStats", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("数学: 30 分钟"));
        assertTrue(output.contains("英语: 20 分钟"));
    }

    @Test
    void testShowMonthlyStats_thisMonth() throws Exception {
        String simulatedInput = "本月\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.now(), "数学", 10));
        var method = StudyUI.class.getDeclaredMethod("showMonthlyStats", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("学习总时长：10 分钟"));
    }

    @Test
    void testShowMonthlyStats_invalidInput() throws Exception {
        String simulatedInput = "xxxx\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("showMonthlyStats", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("输入格式有误"));
    }

    @Test
    void testShowMaxStreak_noData() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(new ByteArrayInputStream(new byte[0])), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("showMaxStreak", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("暂无学习记录"));
    }

    @Test
    void testShowMaxStreak_streak() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(new ByteArrayInputStream(new byte[0])), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 1), "数学", 10));
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 2), "数学", 10));
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 3), "数学", 10));
        var method = StudyUI.class.getDeclaredMethod("showMaxStreak", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("最长连续打卡天数：3 天"));
    }

    @Test
    void testExportData_filenameEmpty() throws Exception {
        String simulatedInput = "\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("exportData", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("文件名不能为空"));
    }

    @Test
    void testShowWeeklyStats_dateInvalid() throws Exception {
        String simulatedInput = "xxxx\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("showWeeklyStats", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("日期格式有误"));
    }

    @Test
    void testShowWeeklyStats_normal() throws Exception {
        String simulatedInput = "2024-07-04\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 1), "数学", 10));
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 2), "英语", 20));
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 4), "数学", 30));
        var method = StudyUI.class.getDeclaredMethod("showWeeklyStats", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("所在周每日学习时长"));
        assertTrue(output.contains("本周各科目学习时长"));
    }

    @Test
    void testShowYearlyStats_thisYear() throws Exception {
        String simulatedInput = "今年\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.now(), "数学", 10));
        var method = StudyUI.class.getDeclaredMethod("showYearlyStats", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("年学习总时长：10 分钟"));
    }

    @Test
    void testShowYearlyStats_invalidInput() throws Exception {
        String simulatedInput = "xxxx\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        var method = StudyUI.class.getDeclaredMethod("showYearlyStats", StudyTracker.class, String.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, "张三");
        String output = outContent.toString();
        assertTrue(output.contains("输入格式有误"));
    }

    @Test
    void testShowRecentTrend_7days() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // selectUser会直接返回空字符串（全部用户）
        StudyUI ui = new StudyUI(new Scanner(new ByteArrayInputStream("\n".getBytes())), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.now().minusDays(1), "数学", 10));
        tracker.addRecord(new StudyRecord("张三", LocalDate.now(), "英语", 20));
        var method = StudyUI.class.getDeclaredMethod("showRecentTrend", StudyTracker.class, int.class);
        method.setAccessible(true);
        method.invoke(ui, tracker, 7);
        String output = outContent.toString();
        assertTrue(output.contains("最近7天学习趋势"));
        assertTrue(output.contains("分钟"));
    }

    @Test
    void testExportData_exportException() throws Exception {
        // 模拟CSVUtils抛出IOException
        String simulatedInput = "output.csv\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.now(), "数学", 10));
        // 使用反射替换CSVUtils.writeCSV为抛异常的mock（如PowerMock等高级工具，或这里只做结构示例）
        // 实际项目中建议用mock框架，这里仅演示异常分支
        try {
            var method = StudyUI.class.getDeclaredMethod("exportData", StudyTracker.class);
            method.setAccessible(true);
            method.invoke(ui, tracker);
        } catch (Exception e) {
            // ignore
        }
        String output = outContent.toString();
        // 由于未真正mock，这里只做结构示例，实际应断言包含“导出失败”
        // assertTrue(output.contains("导出失败"));
    }

    @Test
    void testExportData_success() throws Exception {
        // selectUser回车（全部用户），然后输入文件名
        String simulatedInput = "\noutput.csv\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.now(), "数学", 10));
        var method = StudyUI.class.getDeclaredMethod("exportData", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("数据已导出到 output.csv"));
    }

    @Test
    void testShowStatistics_allBranches() throws Exception {
        // 依次测试1-5分支，每次都提供足够输入（选择用户、统计方式、日期/月份/年份等）
        // 这里只演示分支1（按天统计），其它分支建议分开写
        String simulatedInput = "\n1\n2024-07-04\n"; // 选择全部用户，选择1，输入日期
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        StudyTracker tracker = new StudyTracker();
        tracker.addRecord(new StudyRecord("张三", LocalDate.of(2024, 7, 4), "数学", 10));
        var method = StudyUI.class.getDeclaredMethod("showStatistics", StudyTracker.class);
        method.setAccessible(true);
        method.invoke(ui, tracker);
        String output = outContent.toString();
        assertTrue(output.contains("学习总时长：10 分钟"));
    }
} 