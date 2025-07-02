package com.assistant.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.formdev.flatlaf.FlatLightLaf;

public class MainGUI extends JFrame {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color ACCENT_COLOR = new Color(46, 204, 113);
    private static final Color TEXT_COLOR = new Color(44, 62, 80);

    public MainGUI() {
        // 启用 FlatLaf 现代主题
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("无法设置FlatLaf主题");
        }
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("大学生个人管理助手");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        // 使用默认外观

        // 创建主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(SECONDARY_COLOR);

        // 创建标题面板
        JPanel titlePanel = createTitlePanel();
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // 创建功能模块面板
        JPanel modulePanel = createModulePanel();
        mainPanel.add(modulePanel, BorderLayout.CENTER);

        // 创建底部面板
        JPanel bottomPanel = createBottomPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(PRIMARY_COLOR);
        titlePanel.setPreferredSize(new Dimension(800, 80));
        titlePanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("大学生个人管理助手", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);

        JLabel subtitleLabel = new JLabel("让生活更有序，让学习更高效", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(189, 195, 199));

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(PRIMARY_COLOR);
        textPanel.add(titleLabel, BorderLayout.CENTER);
        textPanel.add(subtitleLabel, BorderLayout.SOUTH);

        titlePanel.add(textPanel, BorderLayout.CENTER);

        return titlePanel;
    }

    private JPanel createModulePanel() {
        JPanel modulePanel = new JPanel();
        modulePanel.setLayout(new GridLayout(2, 2, 20, 20));
        modulePanel.setBackground(SECONDARY_COLOR);
        modulePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // 创建四个功能模块卡片
        JPanel taskCard = createModuleCard("任务提醒", "管理您的日常任务和提醒", "📋", () -> openTaskModule());
        JPanel studyCard = createModuleCard("学习打卡", "记录学习时间和进度", "📚", () -> openStudyModule());
        JPanel financeCard = createModuleCard("收支记账", "管理个人财务收支", "💰", () -> openFinanceModule());
        JPanel healthCard = createModuleCard("健康习惯", "培养健康的生活习惯", "🏃", () -> openHealthModule());

        modulePanel.add(taskCard);
        modulePanel.add(studyCard);
        modulePanel.add(financeCard);
        modulePanel.add(healthCard);

        return modulePanel;
    }

    private JPanel createModuleCard(String title, String description, String icon, Runnable action) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.setPreferredSize(new Dimension(180, 180));
        card.setMaximumSize(new Dimension(220, 220));
        card.setMinimumSize(new Dimension(160, 160));
        card.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.setAlignmentY(Component.CENTER_ALIGNMENT);
        card.setFocusable(false);
        card.setToolTipText(title);

        // 图标标签
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 48));

        // 标题标签
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        titleLabel.setForeground(TEXT_COLOR);

        // 描述标签
        JLabel descLabel = new JLabel(description, SwingConstants.CENTER);
        descLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        descLabel.setForeground(new Color(127, 140, 141));

        // 按钮
        JButton button = new JButton("进入模块");
        button.setBackground(PRIMARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("微软雅黑", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setMargin(new Insets(6, 16, 6, 16));

        button.addActionListener(e -> action.run());

        // 布局
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.add(iconLabel, BorderLayout.CENTER);

        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.setOpaque(false);
        middlePanel.add(titleLabel, BorderLayout.CENTER);
        middlePanel.add(descLabel, BorderLayout.SOUTH);

        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(middlePanel, BorderLayout.CENTER);
        contentPanel.add(button, BorderLayout.SOUTH);

        card.add(contentPanel, BorderLayout.CENTER);

        return card;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(52, 73, 94));
        bottomPanel.setPreferredSize(new Dimension(800, 40));

        JLabel footerLabel = new JLabel("© 2024 大学生个人管理助手 - 让生活更美好", SwingConstants.CENTER);
        footerLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        footerLabel.setForeground(new Color(189, 195, 199));

        bottomPanel.add(footerLabel);

        return bottomPanel;
    }

    private void openTaskModule() {
        SwingUtilities.invokeLater(() -> {
            TaskGUI taskGUI = new TaskGUI();
            taskGUI.setVisible(true);
        });
    }

    private void openStudyModule() {
        SwingUtilities.invokeLater(() -> {
            StudyGUI studyGUI = new StudyGUI();
            studyGUI.setVisible(true);
        });
    }

    private void openFinanceModule() {
        SwingUtilities.invokeLater(() -> {
            FinanceGUI financeGUI = new FinanceGUI();
            financeGUI.setVisible(true);
        });
    }

    private void openHealthModule() {
        SwingUtilities.invokeLater(() -> {
            HealthGUI healthGUI = new HealthGUI();
            healthGUI.setVisible(true);
        });
    }

    public static void main(String[] args) {
        try {
            FlatLightLaf.setup();
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.put("Button.arc", 20);
            UIManager.put("Component.arc", 15);
            UIManager.put("Table.arc", 15);
            UIManager.put("ScrollBar.thumbArc", 15);
            UIManager.put("Component.shadowWidth", 8);
            UIManager.put("defaultFont", new java.awt.Font("微软雅黑", java.awt.Font.PLAIN, 16));
            UIManager.put("Component.accentColor", new java.awt.Color(33, 150, 243));
            UIManager.put("Table.showHorizontalLines", true);
            UIManager.put("Table.showVerticalLines", false);
            UIManager.put("Table.selectionBackground", new java.awt.Color(232, 240, 254));
            UIManager.put("Table.selectionForeground", java.awt.Color.BLACK);
        } catch (Exception ex) {
            System.err.println("无法设置FlatLaf主题: " + ex);
        }
        new MainGUI().setVisible(true);
    }
}

