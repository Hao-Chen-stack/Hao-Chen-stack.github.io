package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliLogonFrame extends JFrame {
    public CliController con;
    public CliLogonPanel logonPanel;
    public CliLogonFrame(CliController con){
        this.con = con;

        setSize(800,600);
        setTitle("注册窗口   姓名：陈浩   学号：JX220913");
        setLocationRelativeTo(null);//居中
        setResizable(false);//窗口大小禁止修改
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//点×退出游戏进程

        //初始化LogonPanel
        logonPanel = new CliLogonPanel(con);
        add(logonPanel);

//        setVisible(true);

    }
}
