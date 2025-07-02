package com.assistant.health;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class HealthRepository {

    private static final String FILE_PATH = "health_records.csv";
    private final List<HealthRecord> recordsCache;
    private final AtomicLong idGenerator;

    public HealthRepository() {
        this.recordsCache = new ArrayList<>();
        this.load(); // 初始化时加载数据
        long maxId = recordsCache.stream().mapToLong(HealthRecord::getId).max().orElse(0L);
        this.idGenerator = new AtomicLong(maxId);
    }

    /**
     * 从CSV文件加载所有记录到内存缓存
     */
    private void load() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return; // 文件不存在，无需加载
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    recordsCache.add(HealthRecord.fromCsvRow(line.split(",")));
                }
            }
        } catch (IOException e) {
            System.err.println("读取健康记录文件失败: " + e.getMessage());
        }
    }

    /**
     * 将内存缓存中的所有记录保存到CSV文件
     */
    private void save() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH), StandardCharsets.UTF_8))) {
            for (HealthRecord record : recordsCache) {
                bw.write(String.join(",", record.toCsvRow()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("保存健康记录文件失败: " + e.getMessage());
        }
    }

    /**
     * 添加一条新记录并立即保存
     */
    public void add(HealthRecord record) {
        record.setId(idGenerator.incrementAndGet());
        this.recordsCache.add(record);
        save();
    }

    /**
     * 获取所有记录
     */
    public List<HealthRecord> findAll() {
        return new ArrayList<>(recordsCache);
    }
}