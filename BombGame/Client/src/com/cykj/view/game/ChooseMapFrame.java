package com.cykj.view.game;

import com.cykj.controller.CliController;

import javax.swing.*;
import java.awt.*;

public class ChooseMapFrame extends JFrame {
    public CliController con;
    public ChooseMapPanel chooseMapPanel;
    public ChooseMapFrame(CliController con)  {
        this.con = con;
        //设置界面的大小
        setSize(850,600);
        //界面居中
        setLocationRelativeTo(null);
        //标题
        setTitle("选择地图");
        //设置JFrame大小不变
        setResizable(false);
        //点击窗口后关闭窗口
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        chooseMapPanel = new ChooseMapPanel(con);
        add(chooseMapPanel);

//        setVisible(true);

    }
}
