package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliGameFrame extends JFrame {
    public CliController con;
    public CliGamePanel gamePanel;
    public CliGameFrame(CliController con){
        this.con = con;
        setTitle("游戏大厅窗口  姓名：陈浩   学号：JX220913");
        setSize(800,760);//窗口大小
        setLocationRelativeTo(null);//界面居中
        setResizable(false);//不可更改大小

        //将gamePanel实例化
        gamePanel = new CliGamePanel(con);
        add(gamePanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);//点击×关闭进程

//        setVisible(true);
    }
}
