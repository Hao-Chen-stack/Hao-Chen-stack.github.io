package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;


public class ProgressBar extends JWindow {
    public CliController con;
    public ProBarPanel barPanel;
    public ProgressBar(CliController con){
        this.con = con;
        setSize(600,100);//窗口大小
        setLocationRelativeTo(null);//界面居中
        barPanel = new ProBarPanel(con);
        add(barPanel);
//        setVisible(true);
    }
}

class ProBarPanel extends JPanel{
    public CliController con;
    public JLabel waitLabel;
    public ProBarPanel(CliController con){
        this.con = con;
        setLayout(null);
        waitLabel = new JLabel("正在检测资源完整性");
        waitLabel.setBounds(230,0,600,50);
        add(waitLabel);
    }
}
