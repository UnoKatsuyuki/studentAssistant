package com.assistant;

// 导入来自不同模块的UI类
import com.assistant.task.TaskConsoleUI;
import com.assistant.study.StudyUI;
import com.assistant.finance.TransactionUI;
import com.assistant.health.HealthConsoleUI;

import java.util.Scanner;

public class PersonalAssistantMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 为每个模块创建UI控制器实例
        TaskConsoleUI taskUI = new TaskConsoleUI();
        StudyUI studyUI = new StudyUI();
        TransactionUI financeUI = new TransactionUI();
        HealthConsoleUI healthUI = new HealthConsoleUI();

        while (true) {
            System.out.println("\n===================================");
            System.out.println("  欢迎使用大学生个人管理助手");
            System.out.println("===================================");
            System.out.println("请选择要进入的模块：");
            System.out.println("1. 任务提醒模块");
            System.out.println("2. 学习打卡模块");
            System.out.println("3. 收支记账模块");
            System.out.println("4. 健康习惯打卡模块");
            System.out.println("5. 退出程序");
            System.out.print("请输入选项 (1-5): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    taskUI.start(); // 调用任务模块的启动方法
                    break;
                case "2":
                    studyUI.start(); // 调用学习模块的启动方法
                    break;
                case "3":
                    financeUI.start(); // 调用收支模块的启动方法
                    break;
                case "4":
                    healthUI.start(); // 调用健康模块的启动方法
                    break;
                case "5":
                    System.out.println("感谢使用，再见！");
                    scanner.close();
                    return; // 正常结束main方法，退出程序
                default:
                    System.out.println("无效的选项，请重新输入。");
            }
        }
    }
}
