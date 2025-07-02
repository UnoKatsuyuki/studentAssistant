package com.assistant.gui;

import com.assistant.task.Task;
import com.assistant.task.TaskService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskGUI extends JFrame {
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color DANGER_COLOR = new Color(231, 76, 60);
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    
    private TaskService taskService;
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JComboBox<String> priorityFilter;
    
    public TaskGUI() {
        this.taskService = new TaskService();
        initializeGUI();
        loadTasks();
    }
    
    private void initializeGUI() {
        setTitle("任务提醒模块");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // 主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(SECONDARY_COLOR);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // 顶部面板
        JPanel topPanel = createTopPanel();
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        // 中间面板 - 任务列表
        JPanel centerPanel = createCenterPanel();
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
        JLabel titleLabel = new JLabel("任务管理", SwingConstants.LEFT);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        
        // 搜索和过滤面板
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        filterPanel.setBackground(PRIMARY_COLOR);
        
        JLabel searchLabel = new JLabel("搜索:");
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        searchField = new JTextField(15);
        searchField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        JLabel priorityLabel = new JLabel("优先级:");
        priorityLabel.setForeground(Color.WHITE);
        priorityLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        priorityFilter = new JComboBox<>(new String[]{"全部", "高", "中", "低"});
        priorityFilter.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        JButton searchButton = createStyledButton("搜索", SUCCESS_COLOR);
        searchButton.addActionListener(e -> filterTasks());
        
        filterPanel.add(searchLabel);
        filterPanel.add(searchField);
        filterPanel.add(Box.createHorizontalStrut(10));
        filterPanel.add(priorityLabel);
        filterPanel.add(priorityFilter);
        filterPanel.add(Box.createHorizontalStrut(10));
        filterPanel.add(searchButton);
        
        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(filterPanel, BorderLayout.EAST);
        
        return topPanel;
    }
    
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // 创建表格
        String[] columnNames = {"ID", "标题", "描述", "优先级", "截止时间", "提醒时间", "状态"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        taskTable = new JTable(tableModel);
        taskTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        taskTable.setRowHeight(35);
        taskTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));
        taskTable.getTableHeader().setBackground(SECONDARY_COLOR);
        taskTable.getTableHeader().setForeground(TEXT_COLOR);
        taskTable.setSelectionBackground(new Color(174, 214, 241));
        taskTable.setGridColor(new Color(189, 195, 199));
        taskTable.setShowHorizontalLines(true);
        taskTable.setShowVerticalLines(false);
        taskTable.setIntercellSpacing(new Dimension(0, 0));
        taskTable.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        // 设置列宽
        taskTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        taskTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        taskTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        taskTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        taskTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        taskTable.getColumnModel().getColumn(5).setPreferredWidth(150);
        taskTable.getColumnModel().getColumn(6).setPreferredWidth(80);
        
        // 自定义渲染器
        // taskTable.getColumnModel().getColumn(3).setCellRenderer(new PriorityRenderer());
        // taskTable.getColumnModel().getColumn(6).setCellRenderer(new StatusRenderer());
        
        JScrollPane scrollPane = new JScrollPane(taskTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true));
        
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        return centerPanel;
    }
    
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        bottomPanel.setBackground(SECONDARY_COLOR);
        
        JButton addButton = createStyledButton("添加任务", SUCCESS_COLOR);
        addButton.addActionListener(e -> showAddTaskDialog());
        
        JButton editButton = createStyledButton("编辑任务", WARNING_COLOR);
        editButton.addActionListener(e -> editSelectedTask());
        
        JButton deleteButton = createStyledButton("删除任务", DANGER_COLOR);
        deleteButton.addActionListener(e -> deleteSelectedTask());
        
        JButton completeButton = createStyledButton("标记完成", PRIMARY_COLOR);
        completeButton.addActionListener(e -> toggleTaskCompletion());
        
        JButton refreshButton = createStyledButton("刷新", new Color(52, 73, 94));
        refreshButton.addActionListener(e -> loadTasks());
        
        bottomPanel.add(addButton);
        bottomPanel.add(editButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(completeButton);
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
    
    private void loadTasks() {
        tableModel.setRowCount(0);
        List<Task> tasks = taskService.getAllTasksSorted();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        
        for (Task task : tasks) {
            Object[] row = {
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                getPriorityText(task.getPriority()),
                task.getDueTime() != null ? task.getDueTime().format(formatter) : "",
                task.getRemindTime() != null ? task.getRemindTime().format(formatter) : "",
                task.isCompleted() ? "已完成" : "未完成"
            };
            tableModel.addRow(row);
        }
    }
    
    private void filterTasks() {
        String keyword = searchField.getText().trim();
        Integer priority = null;
        String priorityText = (String) priorityFilter.getSelectedItem();
        if (!"全部".equals(priorityText)) {
            priority = getPriorityValue(priorityText);
        }
        
        List<Task> filteredTasks = taskService.queryTasks(priority, keyword.isEmpty() ? null : keyword, null, null, null);
        
        tableModel.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        
        for (Task task : filteredTasks) {
            Object[] row = {
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                getPriorityText(task.getPriority()),
                task.getDueTime() != null ? task.getDueTime().format(formatter) : "",
                task.getRemindTime() != null ? task.getRemindTime().format(formatter) : "",
                task.isCompleted() ? "已完成" : "未完成"
            };
            tableModel.addRow(row);
        }
    }
    
    private void showAddTaskDialog() {
        TaskDialog dialog = new TaskDialog(this, "添加任务", null);
        dialog.setVisible(true);
        
        if (dialog.isConfirmed()) {
            Task newTask = dialog.getTask();
            taskService.addTask(newTask);
            loadTasks();
        }
    }
    
    private void editSelectedTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择要编辑的任务", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Long taskId = (Long) tableModel.getValueAt(selectedRow, 0);
        Task task = taskService.getTask(taskId);
        
        TaskDialog dialog = new TaskDialog(this, "编辑任务", task);
        dialog.setVisible(true);
        
        if (dialog.isConfirmed()) {
            Task updatedTask = dialog.getTask();
            updatedTask.setId(taskId);
            taskService.updateTask(taskId, updatedTask);
            loadTasks();
        }
    }
    
    private void deleteSelectedTask() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择要删除的任务", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int result = JOptionPane.showConfirmDialog(this, "确定要删除选中的任务吗？", "确认删除", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            Long taskId = (Long) tableModel.getValueAt(selectedRow, 0);
            taskService.deleteTask(taskId);
            loadTasks();
        }
    }
    
    private void toggleTaskCompletion() {
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择要操作的任务", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Long taskId = (Long) tableModel.getValueAt(selectedRow, 0);
        Task task = taskService.getTask(taskId);
        taskService.setTaskCompleted(taskId, !task.isCompleted());
        loadTasks();
    }
    
    private String getPriorityText(int priority) {
        switch (priority) {
            case 1: return "高";
            case 2: return "中";
            case 3: return "低";
            default: return "未知";
        }
    }
    
    private int getPriorityValue(String priorityText) {
        switch (priorityText) {
            case "高": return 1;
            case "中": return 2;
            case "低": return 3;
            default: return 2;
        }
    }
}

