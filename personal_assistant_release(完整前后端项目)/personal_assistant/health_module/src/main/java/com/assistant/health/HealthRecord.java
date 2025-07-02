package com.assistant.health;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HealthRecord {
    private long id;
    private LocalDateTime timestamp;
    private String habit;
    private double value;
    private String unit;

    // 用于从CSV创建对象的构造函数
    public HealthRecord(long id, LocalDateTime timestamp, String habit, double value, String unit) {
        this.id = id;
        this.timestamp = timestamp;
        this.habit = habit;
        this.value = value;
        this.unit = unit;
    }

    // 用于创建新记录的构造函数
    public HealthRecord(LocalDateTime timestamp, String habit, double value, String unit) {
        this.timestamp = timestamp;
        this.habit = habit;
        this.value = value;
        this.unit = unit;
    }

    // --- Getters and Setters ---
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public LocalDate getDate() { return timestamp.toLocalDate(); }
    public String getHabit() { return habit; }
    public double getValue() { return value; }
    public String getUnit() { return unit; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + formatter.format(timestamp) + "] " + habit + "：" + value + " " + unit;
    }

    /**
     * 将记录转换为CSV行格式
     */
    public String[] toCsvRow() {
        return new String[]{
                String.valueOf(id),
                timestamp.toString(),
                habit,
                String.valueOf(value),
                unit
        };
    }

    /**
     * 从CSV行创建HealthRecord对象
     */
    public static HealthRecord fromCsvRow(String[] row) {
        if (row.length != 5) throw new IllegalArgumentException("CSV行格式错误");
        return new HealthRecord(
                Long.parseLong(row[0]),
                LocalDateTime.parse(row[1]),
                row[2],
                Double.parseDouble(row[3]),
                row[4]
        );
    }
}