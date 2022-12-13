package com.cykj.view.game;

//import com.sun.Controller.ChooseMapActLis;

import com.cykj.controller.CliChooseMapActLis;
import com.cykj.controller.CliController;
import com.cykj.model.Data;

import javax.swing.*;
import java.awt.*;

public class ChooseMapPanel extends JPanel {
    public CliController con;
    public JButton backBtn;
//    public JButton startBtn;
    public JButton map1_Btn;
    public JButton map2_Btn;
    public JButton map3_Btn;
    public static int mapNum = 0;//地图序号

    public ChooseMapPanel(CliController con) {
        this.con = con;
        setLayout(null);
        //返回大厅
        backBtn = new JButton("返回大厅");
        backBtn.setBounds(50, 500, 110, 50);
//        backBtn.setContentAreaFilled(false);//透明
        add(backBtn);

        //选择地图按钮
        map1_Btn = new JButton();
        map1_Btn.setBounds(0,0,270,300);
        map1_Btn.setContentAreaFilled(false);
        add(map1_Btn);

        map2_Btn = new JButton();
        map2_Btn.setBounds(290,0,270,300);
        map2_Btn.setContentAreaFilled(false);
        add(map2_Btn);

        map3_Btn = new JButton();
        map3_Btn.setBounds(580,0,270,300);
        map3_Btn.setContentAreaFilled(false);
        add(map3_Btn);

//        //开始
//        startBtn = new JButton("开始游戏");
//        startBtn.setBounds(450, 500, 110, 50);
////        startBtn.setContentAreaFilled(false);
//        add(startBtn);

        //注册和安装监听
        CliChooseMapActLis chooseMapActLis = new CliChooseMapActLis(con);
        backBtn.addActionListener(chooseMapActLis);
        backBtn.setActionCommand("back");
//        startBtn.addActionListener(chooseMapActLis);
//        startBtn.setActionCommand("start");
        map1_Btn.addActionListener(chooseMapActLis);
        map1_Btn.setActionCommand("map1");
        map2_Btn.addActionListener(chooseMapActLis);
        map2_Btn.setActionCommand("map2");
        map3_Btn.addActionListener(chooseMapActLis);
        map3_Btn.setActionCommand("map3");

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(Data.CHOOSE_MAP_BG,0,0,850,600,null);
    }
}
