package com.assistant.gui;

import com.assistant.finance.Transaction;
import com.assistant.finance.TransactionType;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TransactionDialog extends JDialog {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color INCOME_COLOR = new Color(39, 174, 96);
    private static final Color EXPENSE_COLOR = new Color(192, 57, 43);
    
    private JTextField amountField;
    private JTextField dateField;
    private JTextArea descriptionArea;
    private TransactionType transactionType;
    
    private boolean confirmed = false;
    private Transaction transaction;
    
    public TransactionDialog(Frame parent, String title, TransactionType type) {
        super(parent, title, true);
        this.transactionType = type;
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
        JPanel titlePanel = createTitlePanel();
        
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
    }
    
    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        Color bgColor = transactionType == TransactionType.INCOME ? INCOME_COLOR : EXPENSE_COLOR;
        titlePanel.setBackground(bgColor);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        String icon = transactionType == TransactionType.INCOME ? "💰" : "💸";
        JLabel titleLabel = new JLabel(icon + " " + getTitle());
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
        gbc.anchor = GridBagConstraints.WEST;
        
        // 金额
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(createLabel("金额:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JPanel amountPanel = new JPanel(new BorderLayout());
        amountPanel.setBackground(Color.WHITE);
        
        JLabel currencyLabel = new JLabel("¥");
        currencyLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        currencyLabel.setForeground(new Color(44, 62, 80));
        currencyLabel.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 8));
        
        amountField = new JTextField(15);
        amountField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        amountField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(10, 8, 10, 12)
        ));
        amountField.setHorizontalAlignment(JTextField.RIGHT);
        
        JPanel amountInputPanel = new JPanel(new BorderLayout());
        amountInputPanel.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));
        amountInputPanel.add(currencyLabel, BorderLayout.WEST);
        amountInputPanel.add(amountField, BorderLayout.CENTER);
        
        amountPanel.add(amountInputPanel, BorderLayout.CENTER);
        formPanel.add(amountPanel, gbc);
        
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
        
        // 描述
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        formPanel.add(createLabel("描述:"), gbc);
        
        gbc.gridx = 1; gbc.fill = GridBagConstraints.BOTH; gbc.weightx = 1.0; gbc.weighty = 1.0;
        descriptionArea = new JTextArea(6, 20);
        descriptionArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        
        JScrollPane descScrollPane = new JScrollPane(descriptionArea);
        descScrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199)));
        descScrollPane.setPreferredSize(new Dimension(300, 160));
        formPanel.add(descScrollPane, gbc);
        
        // 添加类型提示
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weighty = 0;
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        typePanel.setBackground(Color.WHITE);
        
        String typeText = transactionType == TransactionType.INCOME ? "收入" : "支出";
        Color typeColor = transactionType == TransactionType.INCOME ? INCOME_COLOR : EXPENSE_COLOR;
        
        JLabel typeLabel = new JLabel("类型: " + typeText);
        typeLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        typeLabel.setForeground(typeColor);
        
        typePanel.add(typeLabel);
        formPanel.add(typePanel, gbc);
        
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
        
        Color confirmColor = transactionType == TransactionType.INCOME ? INCOME_COLOR : EXPENSE_COLOR;
        String confirmText = transactionType == TransactionType.INCOME ? "确认添加收入" : "确认添加支出";
        
        JButton confirmButton = new JButton(confirmText);
        confirmButton.setBackground(confirmColor);
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
        addHoverEffect(confirmButton, confirmColor);
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
            double amount = Double.parseDouble(amountField.getText().trim());
            LocalDate date = LocalDate.parse(dateField.getText().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String description = descriptionArea.getText().trim();
            
            if (description.isEmpty()) {
                description = transactionType == TransactionType.INCOME ? "收入" : "支出";
            }
            
            transaction = new Transaction(amount, transactionType, date, description);
            confirmed = true;
            dispose();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "请输入有效的金额", 
                "输入错误", 
                JOptionPane.ERROR_MESSAGE);
            amountField.requestFocus();
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, 
                "日期格式错误，请使用格式: yyyy-MM-dd", 
                "输入错误", 
                JOptionPane.ERROR_MESSAGE);
            dateField.requestFocus();
        }
    }
    
    private boolean validateInput() {
        String amountText = amountField.getText().trim();
        if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入金额", "输入错误", JOptionPane.ERROR_MESSAGE);
            amountField.requestFocus();
            return false;
        }
        
        try {
            double amount = Double.parseDouble(amountText);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "金额必须大于0", "输入错误", JOptionPane.ERROR_MESSAGE);
                amountField.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字", "输入错误", JOptionPane.ERROR_MESSAGE);
            amountField.requestFocus();
            return false;
        }
        
        if (dateField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入日期", "输入错误", JOptionPane.ERROR_MESSAGE);
            dateField.requestFocus();
            return false;
        }
        
        return true;
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
    
    public Transaction getTransaction() {
        return transaction;
    }
}

