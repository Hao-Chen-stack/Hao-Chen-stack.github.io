package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.view.UI;
import com.cykj.view.game.ChooseMapPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CliChooseMapActLis implements ActionListener {
    public CliController con;
    public CliChooseMapActLis(CliController con){
        this.con = con;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "map1":
                ChooseMapPanel.mapNum = 1;
                con.levels = 0;
                UI.chooseMap.cliWaitRoomPanel.repaint();
                UI.chooseMapFrame.setVisible(false);
                break;
            case "map2":
                ChooseMapPanel.mapNum = 2;
                con.levels = 1;
                UI.chooseMap.cliWaitRoomPanel.repaint();
                UI.chooseMapFrame.setVisible(false);
                break;
            case "map3":
                ChooseMapPanel.mapNum = 3;
                con.levels = 2;
                UI.chooseMap.cliWaitRoomPanel.repaint();
                UI.chooseMapFrame.setVisible(false);
                break;
            case "back":
                UI.chooseMapFrame.setVisible(false);
                break;
        }
    }

}
