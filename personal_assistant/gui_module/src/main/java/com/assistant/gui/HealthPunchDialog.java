package com.assistant.gui;

import javax.swing.*;
import java.awt.*;

public class HealthPunchDialog extends JDialog {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color HEALTH_COLOR = new Color(26, 188, 156);
    
    private JSpinner valueSpinner;
    private String habit;
    private String unit;
    
    private boolean confirmed = false;
    private double value;
    
    public HealthPunchDialog(Frame parent, String title, String habit, String unit) {
        super(parent, title, true);
        this.habit = habit;
        this.unit = unit;
        initializeDialog();
    }
    
    private void initializeDialog() {
        setSize(400, 350);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        // 标题面板
        JPanel titlePanel = createTitlePanel();
        
        // 表单面板
        JPanel formPanel = createFormPanel();
        
        // 按钮面板
        JPanel buttonPanel = createButtonPanel();
        
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(HEALTH_COLOR);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel titleLabel = new JLabel(getTitle());
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        return titlePanel;
    }
    
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 15, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        
        // 习惯说明
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        JLabel habitLabel = new JLabel("今日" + habit + "打卡");
        habitLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        habitLabel.setForeground(new Color(44, 62, 80));
        habitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(habitLabel, gbc);
        
        // 数值输入
        gbc.gridy = 1; gbc.gridwidth = 1;
        JLabel valueLabel = new JLabel("数值:");
        valueLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        valueLabel.setForeground(new Color(44, 62, 80));
        formPanel.add(valueLabel, gbc);
        
        gbc.gridx = 1;
        JPanel valuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        valuePanel.setBackground(Color.WHITE);
        
        // 根据习惯设置默认值和范围
        SpinnerNumberModel model = getSpinnerModel(habit);
        valueSpinner = new JSpinner(model);
        valueSpinner.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        valueSpinner.setPreferredSize(new Dimension(100, 35));
        
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) valueSpinner.getEditor();
        editor.getTextField().setHorizontalAlignment(JTextField.CENTER);
        
        JLabel unitLabel = new JLabel(" " + unit);
        unitLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        unitLabel.setForeground(new Color(127, 140, 141));
        
        valuePanel.add(valueSpinner);
        valuePanel.add(unitLabel);
        formPanel.add(valuePanel, gbc);
        
        // 建议信息
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        JLabel suggestionLabel = new JLabel(getSuggestion(habit));
        suggestionLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        suggestionLabel.setForeground(new Color(127, 140, 141));
        suggestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(suggestionLabel, gbc);
        
        return formPanel;
    }
    
    private SpinnerNumberModel getSpinnerModel(String habit) {
        switch (habit) {
            case "睡眠":
                return new SpinnerNumberModel(8.0, 0.0, 24.0, 0.5);
            case "运动":
                return new SpinnerNumberModel(30.0, 0.0, 1440.0, 5.0);
            case "喝水":
                return new SpinnerNumberModel(2000.0, 0.0, 10000.0, 100.0);
            default:
                return new SpinnerNumberModel(1.0, 0.0, 1000.0, 1.0);
        }
    }
    
    private String getSuggestion(String habit) {
        switch (habit) {
            case "睡眠":
                return "建议每天睡眠7-9小时";
            case "运动":
                return "建议每天运动30分钟以上";
            case "喝水":
                return "建议每天饮水2000毫升以上";
            default:
                return "坚持每天打卡，养成好习惯";
        }
    }
    
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(SECONDARY_COLOR);
        
        JButton confirmButton = new JButton("确认打卡");
        confirmButton.setBackground(SUCCESS_COLOR);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        confirmButton.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));
        confirmButton.setFocusPainted(false);
        confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        confirmButton.addActionListener(e -> confirmAction());
        
        JButton cancelButton = new JButton("取消");
        cancelButton.setBackground(DANGER_COLOR);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        cancelButton.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));
        cancelButton.setFocusPainted(false);
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton.addActionListener(e -> dispose());
        
        // 添加悬停效果
        addHoverEffect(confirmButton, SUCCESS_COLOR);
        addHoverEffect(cancelButton, DANGER_COLOR);
        
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        
        return buttonPanel;
    }
    
    private void addHoverEffect(JButton button, Color originalColor) {
        Color hoverColor = originalColor.darker();
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }
    
    private void confirmAction() {
        if (!validateInput()) {
            return;
        }
        
        if (valueSpinner.getValue() instanceof Number) {
            value = ((Number) valueSpinner.getValue()).doubleValue();
            confirmed = true;
            dispose();
        }
    }
    
    private boolean validateInput() {
        if (valueSpinner.getValue() instanceof Number) {
            double val = ((Number) valueSpinner.getValue()).doubleValue();
            if (val <= 0) {
                JOptionPane.showMessageDialog(this, "数值必须大于0", "输入错误", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            // 根据习惯进行特殊验证
            switch (habit) {
                case "睡眠":
                    if (val > 24) {
                        JOptionPane.showMessageDialog(this, "睡眠时间不能超过24小时", "输入错误", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    break;
                case "运动":
                    if (val > 1440) {
                        JOptionPane.showMessageDialog(this, "运动时间不能超过1440分钟", "输入错误", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    break;
                case "喝水":
                    if (val > 10000) {
                        JOptionPane.showMessageDialog(this, "饮水量不能超过10000毫升", "输入错误", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    break;
            }
            
            return true;
        }
        
        JOptionPane.showMessageDialog(this, "请输入有效的数值", "输入错误", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    public double getValue() {
        return value;
    }
}

