package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;
import java.awt.*;

public class CliPersonalCenterFrame extends JFrame {

    public CliController con;
    public CliPersonalCenterPanel personalCenterPanel;
    public CliPersonalCenterFrame(CliController con){
        this.con = con;
        setTitle("个人中心窗口  姓名：陈浩   学号：JX220913");
        setSize(800,600);//窗口大小
        setLocationRelativeTo(null);//界面居中
        setResizable(false);//不可更改大小
        setDefaultCloseOperation(CliPersonalCenterFrame.EXIT_ON_CLOSE);//点击×不做任何事情

        //将personalCenterPanel实例
        personalCenterPanel = new CliPersonalCenterPanel(con);
        add(personalCenterPanel);
//        setVisible(true);
    }
}
