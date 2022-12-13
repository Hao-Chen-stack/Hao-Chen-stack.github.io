package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;
import java.awt.*;

public class CliGameRoomFrame extends JFrame {
    public CliController con;
    public CliGameRoomPanel gameRoomPanel;
    public JScrollPane JsPane;
    public CliGameRoomFrame(CliController con){
        this.con = con;
        setTitle("房间选择窗口  姓名：陈浩   学号：JX220913");
        setSize(800,600);//窗口大小
        setLocationRelativeTo(null);//界面居中
        setResizable(false);//不可更改大小
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//点击×不做任何事情

        //将gameRoomPanel实例
        gameRoomPanel = new CliGameRoomPanel(con);
        add(gameRoomPanel);

        //添加滚动条
        JsPane = new JScrollPane(gameRoomPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(JsPane);
//        setVisible(true);
    }
}
