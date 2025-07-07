package com.assistant.gui;

import com.assistant.study.StudyRecord;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StudyRecordDialog extends JDialog {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    
    private JTextField usernameField;
    private JTextField dateField;
    private JTextField subjectField;
    private JSpinner durationSpinner;
    
    private boolean confirmed = false;
    private StudyRecord studyRecord;
    
    public StudyRecordDialog(Frame parent, String title) {
        super(parent, title, true);
        initializeDialog();
    }
    
    private void initializeDialog() {
        setSize(500, 600);
        setResizable(true);
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
        JScrollPane formScrollPane = new JScrollPane(formPanel);
        formScrollPane.setBorder(null);
        formScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        // 按钮面板
        JPanel buttonPanel = createButtonPanel();
        
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(formScrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
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
    }
    
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 15, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // 用户名
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(createLabel("用户名:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        usernameField.setText("默认用户");
        formPanel.add(usernameField, gbc);
        
        // 日期
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        formPanel.add(createLabel("日期:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        dateField = new JTextField(20);
        dateField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        dateField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        dateField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        dateField.setToolTipText("格式: yyyy-MM-dd (例: 2024-12-31)");
        formPanel.add(dateField, gbc);
        
        // 科目
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        formPanel.add(createLabel("科目:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        subjectField = new JTextField(20);
        subjectField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        subjectField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));
        formPanel.add(subjectField, gbc);
        
        // 学习时长
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(createLabel("学习时长(分钟):"), gbc);
        
        gbc.gridx = 1;
        durationSpinner = new JSpinner(new SpinnerNumberModel(60, 1, 1440, 1));
        durationSpinner.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) durationSpinner.getEditor();
        editor.getTextField().setHorizontalAlignment(JTextField.CENTER);
        formPanel.add(durationSpinner, gbc);
        
        return formPanel;
    }
    
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("微软雅黑", Font.BOLD, 14));
        label.setForeground(new Color(44, 62, 80));
        return label;
    }
    
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(SECONDARY_COLOR);
        
        JButton confirmButton = new JButton("确认添加");
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
        
        try {
            String username = usernameField.getText().trim();
            LocalDate date = LocalDate.parse(dateField.getText().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String subject = subjectField.getText().trim();
            int duration = (Integer) durationSpinner.getValue();
            
            studyRecord = new StudyRecord(username, date, subject, duration);
            confirmed = true;
            dispose();
            
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, 
                "日期格式错误，请使用格式: yyyy-MM-dd", 
                "输入错误", 
                JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, 
                e.getMessage(), 
                "输入错误", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateInput() {
        if (usernameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入用户名", "输入错误", JOptionPane.ERROR_MESSAGE);
            usernameField.requestFocus();
            return false;
        }
        
        if (dateField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入日期", "输入错误", JOptionPane.ERROR_MESSAGE);
            dateField.requestFocus();
            return false;
        }
        
        if (subjectField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入科目", "输入错误", JOptionPane.ERROR_MESSAGE);
            subjectField.requestFocus();
            return false;
        }
        
        return true;
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    public StudyRecord getStudyRecord() {
        return studyRecord;
    }
}

