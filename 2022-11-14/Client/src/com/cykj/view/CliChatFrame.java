package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliChatFrame extends JFrame {
    public CliController con;
    public CliChatPanel cliChatPanel;
    public CliChatFrame(CliController con){
        this.con = con;

        setSize(800,600);
        setLocationRelativeTo(null);//居中
        setTitle("QQ聊天窗口");//标题
        setResizable(false);//窗口大小锁死
        setDefaultCloseOperation(EXIT_ON_CLOSE);//点×退出游戏进程

        //实例化cliChatPanel
        cliChatPanel =new CliChatPanel(con);
        add(cliChatPanel);
//        setVisible(true);
    }
}
