package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;

public class CliImgJFrame extends JFrame{
    public CliController con;
    public CliImgPanel imgPanel;
    public JScrollPane jScrollPane;;
    public CliImgJFrame(CliController con){
        this.con = con;
        setSize(200,200);//窗口大小
//        setLocationRelativeTo(null);//界面居中
        setBounds(1365,650,200,200);
        imgPanel = new CliImgPanel(con);
        add(imgPanel);

        jScrollPane = new JScrollPane(imgPanel);
        add(jScrollPane);
//        setVisible(true);
    }
}
