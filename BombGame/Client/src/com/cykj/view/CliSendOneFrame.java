package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliSendOneFrame extends JFrame {
    public CliController con;
    public CliSendOnePanel sendOnePanel;
    public CliSendOneFrame(CliController con){
        this.con = con;

        setTitle("聊天窗口  姓名：陈浩   学号：JX220913");
        setSize(800,760);//窗口大小
        setLocationRelativeTo(null);//界面居中
        setResizable(false);//不可更改大小

        //sendOnePanel的实例化
        sendOnePanel = new CliSendOnePanel(con);
        add(sendOnePanel);

        setDefaultCloseOperation(CliSendOneFrame.DISPOSE_ON_CLOSE);//点击×关闭进程

//        setVisible(true);
    }
}
