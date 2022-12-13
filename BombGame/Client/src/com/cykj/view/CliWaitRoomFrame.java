package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliWaitRoomFrame extends JFrame {
    public CliController con;
    public CliWaitRoomPanel cliWaitRoomPanel;
    public CliWaitRoomFrame(CliController con){
        this.con = con;
        setTitle("地图选择窗口  姓名：陈浩   学号：JX220913");
        setSize(850,600);//窗口大小
        setLocationRelativeTo(null);//界面居中
        setResizable(false);//不可更改大小
        setDefaultCloseOperation(EXIT_ON_CLOSE);//点击×关闭进程

        cliWaitRoomPanel = new CliWaitRoomPanel(con);
        add(cliWaitRoomPanel);

//        setVisible(true);

    }
}
