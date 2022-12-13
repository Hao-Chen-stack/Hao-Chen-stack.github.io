package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliLoginFrame extends JFrame {
    public CliController con;
    public CliLoginPanel loginPanel;
    public CliLoginFrame(CliController con){
        this.con = con;
        setTitle("登录窗口  姓名：陈浩   学号：JX220913");
        setSize(800,600);//窗口大小
        setLocationRelativeTo(null);//界面居中
        setResizable(false);//不可更改大小

        //将loginPanel实例化
        loginPanel = new CliLoginPanel(con);
        add(loginPanel);

        setDefaultCloseOperation(CliLoginFrame.EXIT_ON_CLOSE);//点击×关闭进程
        setVisible(true);//窗口可见


    }
}
