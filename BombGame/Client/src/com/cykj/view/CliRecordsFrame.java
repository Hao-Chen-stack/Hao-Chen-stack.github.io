package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliRecordsFrame extends JFrame {
    public CliController con;
    public CliRecordPanel cliRecordPanel;
    public CliRecordsFrame(CliController con){
        this.con = con;

        setSize(600,300);
        setLocationRelativeTo(null);//居中
        setTitle("群聊聊天记录窗口");//标题
        setResizable(false);//窗口大小锁死
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//点×关闭当前窗口


        //将CliRecordPanel实例化
        cliRecordPanel = new CliRecordPanel(con);
        add(cliRecordPanel);

//        setVisible(true);
    }
}
