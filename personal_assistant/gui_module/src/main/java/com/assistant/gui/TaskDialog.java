package com.assistant.gui;

import com.assistant.task.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TaskDialog extends JDialog {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JComboBox<String> priorityCombo;
    private JTextField dueTimeField;
    private JTextField remindTimeField;
    private JCheckBox completedCheckBox;
    
    private boolean confirmed = false;
    private Task task;
    
    public TaskDialog(Frame parent, String title, Task existingTask) {
        super(parent, title, true);
        this.task = existingTask;
        initializeDialog();
        if (existingTask != null) {
            populateFields(existingTask);
        }
    }
    
    private void initializeDialog() {
        setSize(500, 600);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        // 标题面板
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(PRIMARY_COLOR);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel titleLabel = new JLabel(getTitle());
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        
        // 表单面板
        JPanel formPanel = createFormPanel();
        
        // 按钮面板
        JPanel buttonPanel = createButtonPanel();
        
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // 标题
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(createLabel("任务标题:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        titleField = new JTextField(20);
        titleField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        titleField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        formPanel.add(titleField, gbc);
        
        // 描述
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        formPanel.add(createLabel("任务描述:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.BOTH; gbc.weightx = 1.0; gbc.weighty = 0.3;
        descriptionArea = new JTextArea(4, 20);
        descriptionArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descScrollPane = new JScrollPane(descriptionArea);
        descScrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));
        formPanel.add(descScrollPane, gbc);
        
        // 优先级
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0; gbc.weighty = 0;
        formPanel.add(createLabel("优先级:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        priorityCombo = new JComboBox<>(new String[]{"高", "中", "低"});
        priorityCombo.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        priorityCombo.setSelectedIndex(1); // 默认选择"中"
        formPanel.add(priorityCombo, gbc);
        
        // 截止时间
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(createLabel("截止时间:"), gbc);
        
        gbc.gridx = 1;
        dueTimeField = new JTextField(20);
        dueTimeField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        dueTimeField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        dueTimeField.setToolTipText("格式: yyyy-MM-ddTHH:mm (例: 2024-12-31T23:59)");
        formPanel.add(dueTimeField, gbc);
        
        // 提醒时间
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(createLabel("提醒时间:"), gbc);
        
        gbc.gridx = 1;
        remindTimeField = new JTextField(20);
        remindTimeField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        remindTimeField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        remindTimeField.setToolTipText("格式: yyyy-MM-ddTHH:mm (例: 2024-12-31T20:00)");
        formPanel.add(remindTimeField, gbc);
        
        // 完成状态
        gbc.gridx = 0; gbc.gridy = 5;
        formPanel.add(createLabel("完成状态:"), gbc);
        
        gbc.gridx = 1;
        completedCheckBox = new JCheckBox("已完成");
        completedCheckBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        completedCheckBox.setBackground(Color.WHITE);
        formPanel.add(completedCheckBox, gbc);
        
        return formPanel;
    }
    
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label.setForeground(new Color(44, 62, 80));
        return label;
    }
    
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(SECONDARY_COLOR);
        
        JButton confirmButton = new JButton("确认");
        confirmButton.setBackground(SUCCESS_COLOR);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        confirmButton.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(e -> confirmAction());
        
        JButton cancelButton = new JButton("取消");
        cancelButton.setBackground(DANGER_COLOR);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("微软雅黑", Font.BOLD, 14));
        cancelButton.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(e -> dispose());
        
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        
        return buttonPanel;
    }
    
    private void populateFields(Task task) {
        titleField.setText(task.getTitle());
        descriptionArea.setText(task.getDescription());
        
        switch (task.getPriority()) {
            case 1: priorityCombo.setSelectedIndex(0); break;
            case 2: priorityCombo.setSelectedIndex(1); break;
            case 3: priorityCombo.setSelectedIndex(2); break;
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        if (task.getDueTime() != null) {
            dueTimeField.setText(task.getDueTime().format(formatter));
        }
        if (task.getRemindTime() != null) {
            remindTimeField.setText(task.getRemindTime().format(formatter));
        }
        
        completedCheckBox.setSelected(task.isCompleted());
    }
    
    private void confirmAction() {
        if (!validateInput()) {
            return;
        }
        
        try {
            String title = titleField.getText().trim();
            String description = descriptionArea.getText().trim();
            int priority = priorityCombo.getSelectedIndex() + 1;
            
            LocalDateTime dueTime = null;
            LocalDateTime remindTime = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            
            String dueTimeText = dueTimeField.getText().trim();
            if (!dueTimeText.isEmpty()) {
                dueTime = LocalDateTime.parse(dueTimeText, formatter);
            }
            
            String remindTimeText = remindTimeField.getText().trim();
            if (!remindTimeText.isEmpty()) {
                remindTime = LocalDateTime.parse(remindTimeText, formatter);
            }
            
            if (task == null) {
                task = new Task(null, title, description, priority, dueTime, remindTime);
            } else {
                task.setTitle(title);
                task.setDescription(description);
                task.setPriority(priority);
                task.setDueTime(dueTime);
                task.setRemindTime(remindTime);
            }
            
            task.setCompleted(completedCheckBox.isSelected());
            
            confirmed = true;
            dispose();
            
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, 
                "时间格式错误，请使用格式: yyyy-MM-ddTHH:mm (如 2024-05-20T12:00)", 
                "输入错误", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateInput() {
        if (titleField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入任务标题", "输入错误", JOptionPane.ERROR_MESSAGE);
            titleField.requestFocus();
            return false;
        }
        
        return true;
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    public Task getTask() {
        return task;
    }
}

