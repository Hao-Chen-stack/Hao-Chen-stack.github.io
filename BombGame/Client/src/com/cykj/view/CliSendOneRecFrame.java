package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliSendOneRecFrame extends JFrame {
    public CliController con;
    public CliSendOneRecPanel sendOneRecPanel;
    public CliSendOneRecFrame(CliController con){
        this.con = con;
        setSize(600,300);
        setLocationRelativeTo(null);//居中
        setTitle("私聊聊天记录窗口");//标题
        setResizable(false);//窗口大小锁死
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//点×关闭当前窗口

        //CliSendOneRecPanel的实例化
        sendOneRecPanel = new CliSendOneRecPanel(con);
        add(sendOneRecPanel);

//        setVisible(true);

    }
}
