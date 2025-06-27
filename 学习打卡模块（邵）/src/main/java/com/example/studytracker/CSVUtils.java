package com.example.studytracker;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    public static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> records = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return records;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(",", -1));
            }
        }
        return records;
    }

    public static void writeCSV(String filePath, List<String[]> data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        }
    }
} 