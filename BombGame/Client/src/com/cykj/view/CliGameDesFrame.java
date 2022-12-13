package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliGameDesFrame extends JFrame {
    public CliController con;
    public CliGameDesPanel gameDesPanel;
    public CliGameDesFrame(CliController con){
        this.con = con;
        setTitle("游戏说明窗口  姓名：陈浩   学号：JX220913");
        setSize(800,600);//窗口大小
        setLocationRelativeTo(null);//界面居中
        setResizable(false);//不可更改大小
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//点击×不做任何事情

        gameDesPanel = new CliGameDesPanel(con);
        add(gameDesPanel);

//        setVisible(true);

    }
}
