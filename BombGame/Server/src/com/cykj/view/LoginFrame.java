package com.cykj.view;

import com.cykj.controller.Controller;

import javax.swing.*;

public class LoginFrame extends JFrame {
    public Controller con;
    public LoginPanel loginPanel;
    public LoginFrame(Controller con){
        this.con = con;
        setTitle("管理员登录窗口  姓名：陈浩   学号：JX220913");
        setSize(800,600);//窗口大小
        setLocationRelativeTo(null);//界面居中
        setResizable(false);//不可更改大小

        //将loginPanel实例化
        loginPanel = new LoginPanel(con);
        add(loginPanel);

        setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);//点击×关闭进程
        setVisible(true);//窗口可见
    }

}
