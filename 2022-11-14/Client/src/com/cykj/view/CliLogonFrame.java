package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliLogonFrame extends JFrame {
    public CliController con;
    public CliLogonPanel cliLogonPanel;
    public CliLogonFrame(CliController con){
        this.con = con;

        setSize(800,600);
        setLocationRelativeTo(null);//居中
        setTitle("注册");//标题
        setResizable(false);//窗口大小锁死
        setDefaultCloseOperation(EXIT_ON_CLOSE);//点×退出游戏进程


        //初始化LogonPanel
        cliLogonPanel = new CliLogonPanel(con);
        add(cliLogonPanel);
//        setVisible(true);
    }
}
