package com.assistant.gui;

import com.assistant.health.HealthRecord;
import com.assistant.health.HealthService;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class HealthGUI extends JFrame {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    private static final Color HEALTH_COLOR = new Color(26, 188, 156);
    
    private HealthService healthService;
    private JTable recordTable;
    private DefaultTableModel tableModel;
    private JLabel todayCountLabel;
    private JLabel totalCountLabel;
    private JPanel habitCardsPanel;
    private Map<String, JLabel> habitStatusLabelMap = new HashMap<>();
    
    public HealthGUI() {
        this.healthService = new HealthService();
        initializeGUI();
        loadHealthRecords();
        updateStatistics();
    }
    
    private void initializeGUI() {
        setTitle("健康习惯打卡模块");
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
        
        // 中间面板 - 分为上下两部分
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(SECONDARY_COLOR);
        
        // 上部 - 习惯卡片
        JPanel habitPanel = createHabitPanel();
        centerPanel.add(habitPanel, BorderLayout.NORTH);
        
        // 下部 - 记录列表和统计
        JPanel bottomCenterPanel = new JPanel(new BorderLayout());
        bottomCenterPanel.setBackground(SECONDARY_COLOR);
        
        // 左侧 - 记录列表
        JPanel leftPanel = createRecordPanel();
        bottomCenterPanel.add(leftPanel, BorderLayout.CENTER);
        
        // 右侧 - 统计信息
        JPanel rightPanel = createStatisticsPanel();
        bottomCenterPanel.add(rightPanel, BorderLayout.EAST);
        
        centerPanel.add(bottomCenterPanel, BorderLayout.CENTER);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        // 底部面板 - 操作按钮
        JPanel bottomPanel = createBottomPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(HEALTH_COLOR);
        topPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)));
        
        // 标题
        JLabel titleLabel = new JLabel("健康习惯打卡", SwingConstants.LEFT);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        
        // 日期显示
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        datePanel.setBackground(HEALTH_COLOR);
        
        LocalDate today = LocalDate.now();
        JLabel dateLabel = new JLabel("今天是 " + today.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
        dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        dateLabel.setForeground(Color.WHITE);
        
        datePanel.add(dateLabel);
        
        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(datePanel, BorderLayout.EAST);
        
        return topPanel;
    }
    
    private JPanel createHabitPanel() {
        JPanel habitPanel = new JPanel(new BorderLayout());
        habitPanel.setBackground(Color.WHITE);
        habitPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
            "今日打卡",
            0, 0,
            new Font("微软雅黑", Font.BOLD, 16),
            TEXT_COLOR
        ));
        habitPanel.setPreferredSize(new Dimension(0, 150));
        
        habitCardsPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        habitCardsPanel.setBackground(Color.WHITE);
        habitCardsPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        // 创建习惯卡片
        Map<String, String> supportedHabits = healthService.getSupportedHabits();
        for (Map.Entry<String, String> entry : supportedHabits.entrySet()) {
            JPanel card = createHabitCard(entry.getKey(), entry.getValue());
            habitCardsPanel.add(card);
        }
        
        habitPanel.add(habitCardsPanel, BorderLayout.CENTER);
        
        return habitPanel;
    }
    
    private JPanel createHabitCard(String habit, String unit) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(248, 249, 250));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        // 顶部显示习惯名称
        JLabel habitNameLabel = new JLabel(habit, SwingConstants.CENTER);
        habitNameLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        habitNameLabel.setForeground(TEXT_COLOR);
        card.add(habitNameLabel, BorderLayout.NORTH);
        // 状态和按钮
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(248, 249, 250));
        JLabel statusLabel = new JLabel("未打卡", SwingConstants.CENTER);
        statusLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        statusLabel.setForeground(new Color(127, 140, 141));
        habitStatusLabelMap.put(habit, statusLabel);
        JButton punchButton = createStyledButton("立即打卡", HEALTH_COLOR);
        punchButton.addActionListener(e -> showPunchDialog(habit, unit));
        bottomPanel.add(statusLabel, BorderLayout.CENTER);
        bottomPanel.add(punchButton, BorderLayout.SOUTH);
        card.add(bottomPanel, BorderLayout.SOUTH);
        return card;
    }
    
    private JPanel createRecordPanel() {
        JPanel recordPanel = new JPanel(new BorderLayout());
        recordPanel.setBackground(Color.WHITE);
        recordPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
            "健康记录",
            0, 0,
            new Font("微软雅黑", Font.BOLD, 16),
            TEXT_COLOR
        ));
        recordPanel.setPreferredSize(new Dimension(600, 0));
        
        // 创建表格
        String[] columnNames = {"日期", "习惯", "数值", "单位"};
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
            "健康统计",
            0, 0,
            new Font("微软雅黑", Font.BOLD, 16),
            TEXT_COLOR
        ));
        statsPanel.setPreferredSize(new Dimension(350, 0));
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // 今日打卡数
        JPanel todayPanel = createStatCard("今日打卡", "0 项", HEALTH_COLOR);
        todayCountLabel = (JLabel) ((JPanel) todayPanel.getComponent(1)).getComponent(0);
        contentPanel.add(todayPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        
        // 总打卡数
        JPanel totalPanel = createStatCard("总打卡数", "0 次", PRIMARY_COLOR);
        totalCountLabel = (JLabel) ((JPanel) totalPanel.getComponent(1)).getComponent(0);
        contentPanel.add(totalPanel);
        contentPanel.add(Box.createVerticalStrut(20));
        
        statsPanel.add(contentPanel, BorderLayout.CENTER);
        
        return statsPanel;
    }
    
    private JPanel createStatCard(String title, String value, Color valueColor) {
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
        valueLabel.setForeground(valueColor);
        
        valuePanel.add(valueLabel);
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valuePanel, BorderLayout.CENTER);
        
        return card;
    }
    
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        bottomPanel.setBackground(SECONDARY_COLOR);
        
        JButton refreshButton = createStyledButton("刷新", HEALTH_COLOR);
        refreshButton.addActionListener(e -> {
            loadHealthRecords();
            updateStatistics();
            updateHabitCards();
        });
        
        JButton exportButton = createStyledButton("导出数据", PRIMARY_COLOR);
        exportButton.addActionListener(e -> exportData());
        
        JButton settingsButton = createStyledButton("设置", new Color(52, 73, 94));
        settingsButton.addActionListener(e -> showSettings());
        
        bottomPanel.add(refreshButton);
        bottomPanel.add(exportButton);
        bottomPanel.add(settingsButton);
        
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
        
        // 悬停高亮
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
    
    private void loadHealthRecords() {
        tableModel.setRowCount(0);
        Map<LocalDate, List<HealthRecord>> recordsGrouped = healthService.getRecordsGroupedByDate();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        
        // 按日期倒序显示记录
        recordsGrouped.entrySet().stream()
            .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
            .forEach(entry -> {
                List<HealthRecord> records = entry.getValue();
                records.forEach(record -> {
                    Object[] row = {
                        record.getDate().format(dateFormatter),
                        record.getHabit(),
                        String.format("%.1f", record.getValue()),
                        record.getUnit()
                    };
                    tableModel.addRow(row);
                });
            });
    }
    
    private void updateStatistics() {
        Map<LocalDate, List<HealthRecord>> recordsGrouped = healthService.getRecordsGroupedByDate();
        
        // 今日打卡数
        LocalDate today = LocalDate.now();
        int todayCount = recordsGrouped.getOrDefault(today, List.of()).size();
        todayCountLabel.setText(todayCount + " 项");
        
        // 总打卡数
        int totalCount = recordsGrouped.values().stream()
            .mapToInt(List::size)
            .sum();
        totalCountLabel.setText(totalCount + " 次");
    }
    
    private void updateHabitCards() {
        // 更新习惯卡片状态
        Map<LocalDate, List<HealthRecord>> recordsGrouped = healthService.getRecordsGroupedByDate();
        LocalDate today = LocalDate.now();
        List<HealthRecord> todayRecords = recordsGrouped.getOrDefault(today, List.of());
        // 先全部设为未打卡
        for (JLabel label : habitStatusLabelMap.values()) {
            label.setText("未打卡");
            label.setForeground(new Color(127, 140, 141));
        }
        // 标记已打卡
        for (HealthRecord record : todayRecords) {
            JLabel label = habitStatusLabelMap.get(record.getHabit());
            if (label != null) {
                label.setText("已打卡");
                label.setForeground(new Color(46, 204, 113)); // 绿色
            }
        }
    }
    
    private void showPunchDialog(String habit, String unit) {
        HealthPunchDialog dialog = new HealthPunchDialog(this, "打卡 - " + habit, habit, unit);
        dialog.setVisible(true);
        if (dialog.isConfirmed()) {
            try {
                double value = dialog.getValue();
                healthService.addRecord(habit, value);
                loadHealthRecords();
                updateStatistics();
                updateHabitCards(); // 打卡后刷新状态
                JOptionPane.showMessageDialog(this, 
                    "打卡成功！" + habit + ": " + value + " " + unit, 
                    "成功", 
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, 
                    e.getMessage(), 
                    "打卡失败", 
                    JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void exportData() {
        JOptionPane.showMessageDialog(this, "导出功能敬请期待", "提示", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showSettings() {
        JOptionPane.showMessageDialog(this, "设置功能敬请期待", "提示", JOptionPane.INFORMATION_MESSAGE);
    }
}

