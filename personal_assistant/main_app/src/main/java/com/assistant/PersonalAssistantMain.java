package com.assistant;

// 导入GUI模块
import com.assistant.gui.MainGUI;

import javax.swing.*;

public class PersonalAssistantMain {

    public static void main(String[] args) {
        // 启动GUI界面
        SwingUtilities.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }
}
