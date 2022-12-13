package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.view.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CliPersonalCenterActLis implements ActionListener {
    public CliController con;
    public CliPersonalCenterActLis(CliController con){
        this.con = con;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "p1":
                UI.personalCenterFrame.personalCenterPanel.num = 1;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "p2":
                UI.personalCenterFrame.personalCenterPanel.num = 2;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "p3":
                UI.personalCenterFrame.personalCenterPanel.num = 3;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "p4":
                UI.personalCenterFrame.personalCenterPanel.num = 4;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "p5":
                UI.personalCenterFrame.personalCenterPanel.num = 5;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "p6":
                UI.personalCenterFrame.personalCenterPanel.num = 6;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "p7":
                UI.personalCenterFrame.personalCenterPanel.num = 7;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "p8":
                UI.personalCenterFrame.personalCenterPanel.num = 8;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "hat1":
                UI.personalCenterFrame.personalCenterPanel.hitNum = 1;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "hat2":
                UI.personalCenterFrame.personalCenterPanel.hitNum = 2;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "hat3":
                UI.personalCenterFrame.personalCenterPanel.hitNum = 3;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "dress1":
                UI.personalCenterFrame.personalCenterPanel.dressNum = 1;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "dress2":
                UI.personalCenterFrame.personalCenterPanel.dressNum = 2;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "dress3":
                UI.personalCenterFrame.personalCenterPanel.dressNum = 3;
                UI.personalCenterFrame.personalCenterPanel.repaint();
                break;
            case "startGame":
                int num = UI.personalCenterFrame.personalCenterPanel.num;
                int hitNum  = UI.personalCenterFrame.personalCenterPanel.hitNum;
                int dressNum = UI.personalCenterFrame.personalCenterPanel.dressNum;
                JSONObject startGameJs = new JSONObject();
                startGameJs.put("action","saveStyle");
                startGameJs.put("num",num);
                startGameJs.put("hitNum",hitNum);
                startGameJs.put("dressNum",dressNum);
                CliController.cliReadThread.send(startGameJs.toJSONString());
                break;
            case "returnCenter":
                UI.personalCenterFrame.setVisible(false);
                UI.gameFrame.setVisible(true);
                break;
        }
    }
}
