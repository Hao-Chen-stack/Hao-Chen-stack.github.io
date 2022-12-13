package com.cykj.view;

import com.cykj.controller.Controller;

import javax.swing.*;

public class LoginUserFrame  extends JFrame {
    public Controller con;
    public LoginPanel loginPanel;
    public LoginUserFrame(Controller con){
        this.con = con;
        setTitle("登录");
        setSize(800,600);
        setLocationRelativeTo(null);//居中
        setResizable(false);//不可更改大小

        //loginPanel的实例化
        loginPanel = new LoginPanel(con);
        add(loginPanel);

        setDefaultCloseOperation(LoginUserFrame.EXIT_ON_CLOSE);//点击×关闭进程
//        setVisible(true);
    }
}
