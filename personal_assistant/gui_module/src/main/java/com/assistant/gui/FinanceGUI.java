package com.assistant.gui;

import com.assistant.finance.Transaction;
import com.assistant.finance.TransactionRepository;
import com.assistant.finance.TransactionService;
import com.assistant.finance.TransactionType;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FinanceGUI extends JFrame {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    private static final Color INCOME_COLOR = new Color(39, 174, 96);
    private static final Color EXPENSE_COLOR = new Color(192, 57, 43);
    
    private TransactionRepository repository;
    private TransactionService transactionService;
    private JTable transactionTable;
    private DefaultTableModel tableModel;
    private JLabel totalIncomeLabel;
    private JLabel totalExpenseLabel;
    private JLabel balanceLabel;
    private JComboBox<String> monthFilter;
    private JComboBox<String> yearFilter;
    
    public FinanceGUI() {
        this.repository = new TransactionRepository();
        this.transactionService = new TransactionService(repository);
        initializeGUI();
        addSampleData();
        loadTransactions();
        updateStatistics();
    }
    
    private void initializeGUI() {
        setTitle("收支记账模块");
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
        
        // 左侧 - 交易列表
        JPanel leftPanel = createTransactionPanel();
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
        JLabel titleLabel = new JLabel("收支记账", SwingConstants.LEFT);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        
        // 筛选面板
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        filterPanel.setBackground(PRIMARY_COLOR);
        
        JLabel yearLabel = new JLabel("年份:");
        yearLabel.setForeground(Color.WHITE);
        yearLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        yearFilter = new JComboBox<>();
        int currentYear = LocalDate.now().getYear();
        for (int i = currentYear - 5; i <= currentYear + 1; i++) {
            yearFilter.addItem(String.valueOf(i));
        }
        yearFilter.setSelectedItem(String.valueOf(currentYear));
        yearFilter.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        JLabel monthLabel = new JLabel("月份:");
        monthLabel.setForeground(Color.WHITE);
        monthLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        monthFilter = new JComboBox<>(new String[]{"全部", "1月", "2月", "3月", "4月", "5月", "6月", 
                                                  "7月", "8月", "9月", "10月", "11月", "12月"});
        monthFilter.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        JButton filterButton = createStyledButton("筛选", SUCCESS_COLOR);
        filterButton.addActionListener(e -> {
            loadTransactions();
            updateStatistics();
        });
        
        filterPanel.add(yearLabel);
        filterPanel.add(yearFilter);
        filterPanel.add(Box.createHorizontalStrut(10));
        filterPanel.add(monthLabel);
        filterPanel.add(monthFilter);
        filterPanel.add(Box.createHorizontalStrut(10));
        filterPanel.add(filterButton);
        
        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(filterPanel, BorderLayout.EAST);
        
        return topPanel;
    }
    
    private JPanel createTransactionPanel() {
        JPanel transactionPanel = new JPanel(new BorderLayout());
        transactionPanel.setBackground(Color.WHITE);
        transactionPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
            "收支记录",
            0, 0,
            new Font("微软雅黑", Font.BOLD, 16),
            TEXT_COLOR
        ));
        transactionPanel.setPreferredSize(new Dimension(600, 0));
        
        // 创建表格
        String[] columnNames = {"日期", "类型", "金额", "描述"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        transactionTable = new JTable(tableModel);
        transactionTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        transactionTable.setRowHeight(35);
        transactionTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));
        transactionTable.getTableHeader().setBackground(SECONDARY_COLOR);
        transactionTable.getTableHeader().setForeground(TEXT_COLOR);
        transactionTable.setSelectionBackground(new Color(174, 214, 241));
        transactionTable.setGridColor(new Color(189, 195, 199));
        transactionTable.setShowHorizontalLines(true);
        transactionTable.setShowVerticalLines(false);
        transactionTable.setIntercellSpacing(new Dimension(0, 0));
        transactionTable.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        // 设置列宽
        transactionTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        transactionTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        transactionTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        transactionTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        // 自定义渲染器
        // transactionTable.getColumnModel().getColumn(1).setCellRenderer(new TypeRenderer());
        // transactionTable.getColumnModel().getColumn(2).setCellRenderer(new AmountRenderer());
        
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true));
        
        transactionPanel.add(scrollPane, BorderLayout.CENTER);
        
        return transactionPanel;
    }
    
    private JPanel createStatisticsPanel() {
        JPanel statsPanel = new JPanel(new BorderLayout());
        statsPanel.setBackground(Color.WHITE);
        statsPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true),
            "财务统计",
            0, 0,
            new Font("微软雅黑", Font.BOLD, 16),
            TEXT_COLOR
        ));
        statsPanel.setPreferredSize(new Dimension(350, 0));
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // 总收入
        JPanel incomePanel = createStatCard("总收入", "¥0.00", INCOME_COLOR);
        totalIncomeLabel = (JLabel) ((JPanel) incomePanel.getComponent(1)).getComponent(0);
        contentPanel.add(incomePanel);
        contentPanel.add(Box.createVerticalStrut(15));
        
        // 总支出
        JPanel expensePanel = createStatCard("总支出", "¥0.00", EXPENSE_COLOR);
        totalExpenseLabel = (JLabel) ((JPanel) expensePanel.getComponent(1)).getComponent(0);
        contentPanel.add(expensePanel);
        contentPanel.add(Box.createVerticalStrut(15));
        
        // 结余
        JPanel balancePanel = createStatCard("结余", "¥0.00", PRIMARY_COLOR);
        balanceLabel = (JLabel) ((JPanel) balancePanel.getComponent(1)).getComponent(0);
        contentPanel.add(balancePanel);
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
        
        JButton addIncomeButton = createStyledButton("添加收入", SUCCESS_COLOR);
        addIncomeButton.addActionListener(e -> showAddTransactionDialog(TransactionType.INCOME));
        
        JButton addExpenseButton = createStyledButton("添加支出", DANGER_COLOR);
        addExpenseButton.addActionListener(e -> showAddTransactionDialog(TransactionType.EXPENSE));
        
        JButton deleteButton = createStyledButton("删除记录", WARNING_COLOR);
        deleteButton.addActionListener(e -> deleteSelectedTransaction());
        
        JButton exportButton = createStyledButton("导出报表", PRIMARY_COLOR);
        exportButton.addActionListener(e -> exportReport());
        
        JButton refreshButton = createStyledButton("刷新", new Color(52, 73, 94));
        refreshButton.addActionListener(e -> {
            loadTransactions();
            updateStatistics();
        });
        
        bottomPanel.add(addIncomeButton);
        bottomPanel.add(addExpenseButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(exportButton);
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
    
    private void addSampleData() {
        // 添加一些示例数据
        LocalDate today = LocalDate.now();
        try {
            transactionService.addTransaction(3000.0, TransactionType.INCOME, today.minusDays(5), "兼职工资");
            transactionService.addTransaction(500.0, TransactionType.EXPENSE, today.minusDays(4), "生活费");
            transactionService.addTransaction(200.0, TransactionType.EXPENSE, today.minusDays(3), "书籍购买");
            transactionService.addTransaction(1500.0, TransactionType.INCOME, today.minusDays(2), "奖学金");
            transactionService.addTransaction(300.0, TransactionType.EXPENSE, today.minusDays(1), "聚餐");
            transactionService.addTransaction(100.0, TransactionType.EXPENSE, today, "交通费");
        } catch (Exception e) {
            System.err.println("添加示例数据失败: " + e.getMessage());
        }
    }
    
    private void loadTransactions() {
        tableModel.setRowCount(0);
        List<Transaction> transactions = repository.getAllTransactions();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // 筛选条件
        String selectedYear = (String) yearFilter.getSelectedItem();
        String selectedMonth = (String) monthFilter.getSelectedItem();
        
        for (Transaction transaction : transactions) {
            // 应用筛选条件
            if (selectedYear != null && !String.valueOf(transaction.getDate().getYear()).equals(selectedYear)) {
                continue;
            }
            
            if (!"全部".equals(selectedMonth)) {
                int monthIndex = monthFilter.getSelectedIndex();
                if (monthIndex > 0 && transaction.getDate().getMonthValue() != monthIndex) {
                    continue;
                }
            }
            
            Object[] row = {
                transaction.getDate().format(formatter),
                transaction.getType() == TransactionType.INCOME ? "收入" : "支出",
                String.format("%.2f", transaction.getAmount()),
                transaction.getDescription()
            };
            tableModel.addRow(row);
        }
    }
    
    private void updateStatistics() {
        List<Transaction> transactions = repository.getAllTransactions();
        
        // 筛选条件
        String selectedYear = (String) yearFilter.getSelectedItem();
        String selectedMonth = (String) monthFilter.getSelectedItem();
        
        double totalIncome = 0;
        double totalExpense = 0;
        
        for (Transaction transaction : transactions) {
            // 应用筛选条件
            if (selectedYear != null && !String.valueOf(transaction.getDate().getYear()).equals(selectedYear)) {
                continue;
            }
            
            if (!"全部".equals(selectedMonth)) {
                int monthIndex = monthFilter.getSelectedIndex();
                if (monthIndex > 0 && transaction.getDate().getMonthValue() != monthIndex) {
                    continue;
                }
            }
            
            if (transaction.getType() == TransactionType.INCOME) {
                totalIncome += transaction.getAmount();
            } else {
                totalExpense += transaction.getAmount();
            }
        }
        
        double balance = totalIncome - totalExpense;
        
        totalIncomeLabel.setText(String.format("¥%.2f", totalIncome));
        totalExpenseLabel.setText(String.format("¥%.2f", totalExpense));
        balanceLabel.setText(String.format("¥%.2f", balance));
        
        // 根据结余设置颜色
        if (balance > 0) {
            balanceLabel.setForeground(INCOME_COLOR);
        } else if (balance < 0) {
            balanceLabel.setForeground(EXPENSE_COLOR);
        } else {
            balanceLabel.setForeground(PRIMARY_COLOR);
        }
    }
    
    private void showAddTransactionDialog(TransactionType type) {
        TransactionDialog dialog = new TransactionDialog(this, 
            type == TransactionType.INCOME ? "添加收入记录" : "添加支出记录", type);
        dialog.setVisible(true);
        
        if (dialog.isConfirmed()) {
            Transaction newTransaction = dialog.getTransaction();
            try {
                transactionService.addTransaction(
                    newTransaction.getAmount(),
                    newTransaction.getType(),
                    newTransaction.getDate(),
                    newTransaction.getDescription()
                );
                loadTransactions();
                updateStatistics();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "添加记录失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void deleteSelectedTransaction() {
        int selectedRow = transactionTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择要删除的记录", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int result = JOptionPane.showConfirmDialog(this, "确定要删除选中的记录吗？", "确认删除", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            // 由于没有删除方法，我们需要重新构建记录列表
            List<Transaction> transactions = repository.getAllTransactions();
            if (selectedRow < transactions.size()) {
                // 这里需要实现删除功能，暂时显示提示
                JOptionPane.showMessageDialog(this, "删除功能需要在TransactionRepository中实现", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private void exportReport() {
        JOptionPane.showMessageDialog(this, "导出功能敬请期待", "提示", JOptionPane.INFORMATION_MESSAGE);
    }
}

