package com.cykj.view.game;

import com.cykj.controller.CliController;

import javax.swing.*;

public class GameFrame extends JFrame {
    public CliController con;
    public GameLeftPanel gameLeftPanel;

    public GameFrame(CliController con){
        this.con = con;
        setSize(1020,750);
        setLocationRelativeTo(null);//居中
        setTitle("游戏界面     姓名：陈浩     班级：JX2209班   学号：JX220913");
        setResizable(false);//窗口锁死无法拉动大小
        setDefaultCloseOperation(EXIT_ON_CLOSE);//点×的时候什么都不干

        gameLeftPanel = new GameLeftPanel(con);
        add(gameLeftPanel);

//        setVisible(true);
    }
}
