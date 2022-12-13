package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.view.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CliWaitRoomActLis implements ActionListener {
    public CliController con;
    public CliWaitRoomActLis(CliController con){
        this.con = con;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "showMap":
                String checkMapId = UI.loginFrame.loginPanel.getUserTxt().getText();
                JSONObject checkJs = new JSONObject();
                checkJs.put("action","checkMap");
                checkJs.put("checkMapId",checkMapId);
                CliController.cliReadThread.send(checkJs.toJSONString());
//                UI.chooseMapFrame.setVisible(true);
                break;
            case "reCen":
                String loginUserId = UI.loginFrame.loginPanel.getUserTxt().getText();//
                JSONObject reJS = new JSONObject();
                reJS.put("action","reCen");
                reJS.put("loginUserId",loginUserId);
                CliController.cliReadThread.send(reJS.toJSONString());
//                UI.chooseMap.setVisible(false);
//                UI.gameFrame.setVisible(true);
                break;
            case "ready":
                String userId = UI.loginFrame.loginPanel.getUserTxt().getText();
                JSONObject readyJS = new JSONObject();
                readyJS.put("action","ready");
                readyJS.put("readerId",userId);
                CliController.cliReadThread.send(readyJS.toJSONString());
                break;
            case "startGame":
//                String isStartId = UI.loginFrame.loginPanel.getUserTxt().getText();
                JSONObject startJs = new JSONObject();
                startJs.put("action","startGame");
//                startJs.put("startId",isStartId);
                CliController.cliReadThread.send(startJs.toJSONString());
                break;

        }
    }
}
