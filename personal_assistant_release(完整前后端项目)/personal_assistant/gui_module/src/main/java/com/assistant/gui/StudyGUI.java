package com.assistant.gui;

import com.assistant.study.StudyRecord;
import com.assistant.study.StudyTracker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class StudyGUI extends JFrame {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    
    private StudyTracker studyTracker;
    private JTable recordTable;
    private DefaultTableModel tableModel;
    private JTextField usernameField;
    private JLabel totalTimeLabel;
    private JLabel weeklyTimeLabel;
    private JTextArea summaryArea;
    
    public StudyGUI() {
        this.studyTracker = new StudyTracker();
        initializeGUI();
        loadStudyRecords();
        updateStatistics();
    }
    
    private void initializeGUI() {
        setTitle("学习打卡模块");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // 主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(SECONDARY_COLOR);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // 顶部面板
        JPanel topPanel = createTopPanel();
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        // 中间面板 - 分为左右两部分
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(SECONDARY_COLOR);
        
        // 左侧 - 记录列表
        JPanel leftPanel = createRecordPanel();
        centerPanel.add(leftPanel, BorderLayout.CENTER);
        
        // 右侧 - 统计信息
        JPanel rightPanel = createStatisticsPanel();
        centerPanel.add(rightPanel, BorderLayout.EAST);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // 底部面板 - 操作按钮
        JPanel bottomPanel = createBottomPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(PRIMARY_COLOR);
        topPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        
        // 标题
        JLabel titleLabel = new JLabel("学习打卡", SwingConstants.LEFT);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        
        // 用户筛选面板
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        filterPanel.setBackground(PRIMARY_COLOR);
        
        JLabel userLabel = new JLabel("用户名:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        usernameField = new JTextField(15);
        usernameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameField.setText("默认用户");
        
        JButton filterButton = createStyledButton("筛选", SUCCESS_COLOR);
        filterButton.addActionListener(e -> updateStatistics());
        
        filterPanel.add(userLabel);
        filterPanel.add(usernameField);
        filterPanel.add(Box.createHorizontalStrut(10));
        filterPanel.add(filterButton);
        
        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(filterPanel, BorderLayout.EAST);
        
        return topPanel;
    }
    
    private JPanel createRecordPanel() {
        JPanel recordPanel = new JPanel(new BorderLayout());
        recordPanel.setBackground(Color.WHITE);
        recordPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
            "学习记录",
            0, 0,
            new Font("微软雅黑", Font.BOLD, 16),
            TEXT_COLOR
        ));
        recordPanel.setPreferredSize(new Dimension(600, 0));
        
        // 创建表格
        String[] columnNames = {"用户名", "日期", "科目", "时长(分钟)"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        recordTable = new JTable(tableModel);
        recordTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        recordTable.setRowHeight(30);
        recordTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));
        recordTable.getTableHeader().setBackground(SECONDARY_COLOR);
        recordTable.getTableHeader().setForeground(TEXT_COLOR);
        recordTable.setSelectionBackground(new Color(174, 214, 241));
        recordTable.setGridColor(new Color(189, 195, 199));
        recordTable.setShowHorizontalLines(true);
        recordTable.setShowVerticalLines(false);
        recordTable.setIntercellSpacing(new Dimension(0, 0));
        recordTable.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        // 设置列宽
        recordTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        recordTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        recordTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        recordTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        JScrollPane scrollPane = new JScrollPane(recordTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true));
        
        recordPanel.add(scrollPane, BorderLayout.CENTER);
        
        return recordPanel;
    }
    
    private JPanel createStatisticsPanel() {
        JPanel statsPanel = new JPanel(new BorderLayout());
        statsPanel.setBackground(Color.WHITE);
        statsPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
            "学习统计",
            0, 0,
            new Font("微软雅黑", Font.BOLD, 16),
            TEXT_COLOR
        ));
        statsPanel.setPreferredSize(new Dimension(350, 0));
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // 总学习时间
        JPanel totalPanel = createStatCard("总学习时间", "0 分钟");
        totalTimeLabel = (JLabel) ((JPanel) totalPanel.getComponent(1)).getComponent(0);
        contentPanel.add(totalPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        
        // 本周学习时间
        JPanel weeklyPanel = createStatCard("本周学习时间", "0 分钟");
        weeklyTimeLabel = (JLabel) ((JPanel) weeklyPanel.getComponent(1)).getComponent(0);
        contentPanel.add(weeklyPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        
        // 科目统计
        JPanel subjectPanel = new JPanel(new BorderLayout());
        subjectPanel.setBackground(new Color(248, 249, 250));
        subjectPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JLabel subjectTitle = new JLabel("科目统计");
        subjectTitle.setFont(new Font("微软雅黑", Font.BOLD, 16));
        subjectTitle.setForeground(TEXT_COLOR);
        
        summaryArea = new JTextArea(8, 20);
        summaryArea.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        summaryArea.setBackground(Color.WHITE);
        summaryArea.setEditable(false);
        summaryArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JScrollPane summaryScrollPane = new JScrollPane(summaryArea);
        summaryScrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));
        
        subjectPanel.add(subjectTitle, BorderLayout.NORTH);
        subjectPanel.add(summaryScrollPane, BorderLayout.CENTER);
        
        contentPanel.add(subjectPanel);
        
        statsPanel.add(contentPanel, BorderLayout.CENTER);
        
        return statsPanel;
    }
    
    private JPanel createStatCard(String title, String value) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(248, 249, 250));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        titleLabel.setForeground(TEXT_COLOR);
        
        JPanel valuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        valuePanel.setBackground(new Color(248, 249, 250));
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        valueLabel.setForeground(PRIMARY_COLOR);
        
        valuePanel.add(valueLabel);
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valuePanel, BorderLayout.CENTER);
        
        return card;
    }
    
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        bottomPanel.setBackground(SECONDARY_COLOR);
        
        JButton addButton = createStyledButton("添加记录", SUCCESS_COLOR);
        addButton.addActionListener(e -> showAddRecordDialog());
        
        JButton deleteButton = createStyledButton("删除记录", DANGER_COLOR);
        deleteButton.addActionListener(e -> deleteSelectedRecord());
        
        JButton exportButton = createStyledButton("导出数据", WARNING_COLOR);
        exportButton.addActionListener(e -> exportData());
        
        JButton importButton = createStyledButton("导入数据", PRIMARY_COLOR);
        importButton.addActionListener(e -> importData());
        
        JButton refreshButton = createStyledButton("刷新", new Color(52, 73, 94));
        refreshButton.addActionListener(e -> {
            loadStudyRecords();
            updateStatistics();
        });
        
        bottomPanel.add(addButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(exportButton);
        bottomPanel.add(importButton);
        bottomPanel.add(refreshButton);
        
        return bottomPanel;
    }
    
    private JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("微软雅黑", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        
        // 添加悬停效果
        Color originalColor = backgroundColor;
        Color hoverColor = backgroundColor.darker();
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
        
        return button;
    }
    
    private void loadStudyRecords() {
        try {
            studyTracker.loadFromCSV("study_records.csv");
        } catch (Exception e) {
            // 如果文件不存在或读取失败，创建一些示例数据
            studyTracker = new StudyTracker();
            addSampleData();
        }
        
        tableModel.setRowCount(0);
        List<StudyRecord> records = studyTracker.getRecords();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        for (StudyRecord record : records) {
            Object[] row = {
                record.getUsername(),
                record.getDate().format(formatter),
                record.getSubject(),
                record.getDurationMinutes()
            };
            tableModel.addRow(row);
        }
    }
    
    private void addSampleData() {
        // 添加一些示例数据
        LocalDate today = LocalDate.now();
        studyTracker.addRecord(new StudyRecord("默认用户", today, "数学", 120));
        studyTracker.addRecord(new StudyRecord("默认用户", today.minusDays(1), "英语", 90));
        studyTracker.addRecord(new StudyRecord("默认用户", today.minusDays(2), "计算机科学", 150));
        studyTracker.addRecord(new StudyRecord("默认用户", today.minusDays(3), "物理", 100));
    }
    
    private void updateStatistics() {
        String username = usernameField.getText().trim();
        if (username.isEmpty()) {
            username = "默认用户";
        }
        
        List<StudyRecord> userRecords = studyTracker.getRecordsByUser(username);
        
        // 计算总学习时间
        int totalMinutes = userRecords.stream()
            .mapToInt(StudyRecord::getDurationMinutes)
            .sum();
        totalTimeLabel.setText(formatTime(totalMinutes));
        
        // 计算本周学习时间
        Map<LocalDate, Integer> weeklyData = studyTracker.getWeeklyStudySummary(LocalDate.now(), username);
        int weeklyMinutes = weeklyData.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
        weeklyTimeLabel.setText(formatTime(weeklyMinutes));
        
        // 科目统计
        Map<String, Integer> subjectData = studyTracker.getWeeklySubjectSummary(LocalDate.now(), username);
        StringBuilder summary = new StringBuilder();
        summary.append("本周科目学习时间统计:\n\n");
        
        if (subjectData.isEmpty()) {
            summary.append("暂无学习记录");
        } else {
            subjectData.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    summary.append(String.format("%-12s: %s\n", 
                        entry.getKey(), formatTime(entry.getValue())));
                });
        }
        
        summaryArea.setText(summary.toString());
    }
    
    private String formatTime(int minutes) {
        if (minutes < 60) {
            return minutes + " 分钟";
        } else {
            int hours = minutes / 60;
            int remainingMinutes = minutes % 60;
            return String.format("%d 小时 %d 分钟", hours, remainingMinutes);
        }
    }
    
    private void showAddRecordDialog() {
        StudyRecordDialog dialog = new StudyRecordDialog(this, "添加学习记录");
        dialog.setVisible(true);
        
        if (dialog.isConfirmed()) {
            StudyRecord newRecord = dialog.getStudyRecord();
            studyTracker.addRecord(newRecord);
            loadStudyRecords();
            updateStatistics();
            saveData();
        }
    }
    
    private void deleteSelectedRecord() {
        int selectedRow = recordTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择要删除的记录", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int result = JOptionPane.showConfirmDialog(this, "确定要删除选中的记录吗？", "确认删除", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            // 由于没有ID，我们需要重新构建记录列表
            List<StudyRecord> records = studyTracker.getRecords();
            if (selectedRow < records.size()) {
                records.remove(selectedRow);
                // 重新创建StudyTracker
                studyTracker = new StudyTracker();
                for (StudyRecord record : records) {
                    studyTracker.addRecord(record);
                }
                loadStudyRecords();
                updateStatistics();
                saveData();
            }
        }
    }
    
    private void exportData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("导出学习记录");
        fileChooser.setSelectedFile(new java.io.File("study_records_export.csv"));
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                studyTracker.saveToCSV(fileChooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(this, "数据导出成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "导出失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void importData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("导入学习记录");
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                studyTracker.loadFromCSV(fileChooser.getSelectedFile().getAbsolutePath());
                loadStudyRecords();
                updateStatistics();
                JOptionPane.showMessageDialog(this, "数据导入成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "导入失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void saveData() {
        try {
            studyTracker.saveToCSV("study_records.csv");
        } catch (Exception e) {
            System.err.println("保存数据失败: " + e.getMessage());
        }
    }
}

