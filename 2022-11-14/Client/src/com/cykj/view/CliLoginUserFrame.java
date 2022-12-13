package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliLoginUserFrame extends JFrame {
    public CliController con;
    public CliLoginPanel loginPanel;
    public CliLoginUserFrame(CliController con){
        this.con = con;
        setTitle("登录");
        setSize(800,600);
        setLocationRelativeTo(null);//居中
        setResizable(false);//不可更改大小

        //loginPanel的实例化
        loginPanel = new CliLoginPanel(con);
        add(loginPanel);

        setDefaultCloseOperation(CliLoginUserFrame.EXIT_ON_CLOSE);//点击×关闭进程
        setVisible(true);
    }
}
