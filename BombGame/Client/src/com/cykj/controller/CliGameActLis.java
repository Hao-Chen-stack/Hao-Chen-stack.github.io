package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.model.Data;
import com.cykj.util.GameMusic;
import com.cykj.view.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class CliGameActLis extends MouseAdapter implements ActionListener{
    public CliController con;
    public static GameMusic gameMusic = new GameMusic("Client/music/Yoohsic-Roomz-Eutopia.wav");
    public CliGameActLis(CliController con){
        this.con = con;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "sendOutAll":
                String sendTxt = UI.gameFrame.gamePanel.getMsgTextField().getText();//群聊消息输入框
                String userId = UI.loginFrame.loginPanel.getUserTxt().getText();//登录界面账号输入框
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("action","sendOutAll");
                jsonObject.put("sendTxt",sendTxt);
                jsonObject.put("from",userId);
                String str = jsonObject.toJSONString();
                CliController.cliReadThread.send(str);
                break;
            case "allMsg":
                UI.recordsFrame.setVisible(true);
                JSONObject jsRec = new JSONObject();
                jsRec.put("action","recShow");
                CliController.cliReadThread.send(jsRec.toJSONString());
                break;
            case "upPage":
                JSONObject upJs = new JSONObject();
                upJs.put("action","upPage");
                CliController.cliReadThread.send(upJs.toJSONString());
                break;
            case "downPage":
                JSONObject downJs = new JSONObject();
                downJs.put("action","downPage");
                CliController.cliReadThread.send(downJs.toJSONString());
                break;
            case "img":
                UI.imgJWindow.setVisible(true);
                break;
            case "startGame":
                JSONObject showRoom = new JSONObject();
                showRoom.put("action","showrooms");
                CliController.cliReadThread.send(showRoom.toJSONString());
                UI.gameFrame.setVisible(false);
//                UI.loginFrame.setVisible(false);
                UI.gameRoomFrame.setVisible(true);
                break;
            case "playerCenter":
                UI.gameFrame.setVisible(false);
                JSONObject playerCenterJs = new JSONObject();
                playerCenterJs.put("action","downFile");
                File file = new File("Client/image/player");
                if (!file.exists()) {
                    CliController.cliReadThread.send(playerCenterJs.toJSONString());
                    UI.progressBar.setVisible(true);
                }else {
//                    UI.gameFrame.setVisible(false);
                    UI.personalCenterFrame.setVisible(true);
                    Data.initImage();
                }
                break;
            case "gameDes":
                UI.gameDesFrame.setVisible(true);
                break;
            case "startMusic":
                gameMusic.play();
                break;
            case "stopMusic":
                gameMusic.over();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object selectedValue = UI.gameFrame.gamePanel.getFriendJList().getSelectedValue();
        System.out.println(selectedValue);
        String string = selectedValue.toString();//转换成字符串
        System.out.println(string);
        String[] split = string.split("--");
        String userId = split[1];
        String userName = split[0];

        int clickCount = e.getClickCount();//点击的次数
        if (clickCount == 2){//双击打开私聊界面
//            UI.sendOneFrame = new CliSendOneFrame(con);
            //每次点开就清空一次，防止下一次点开有残留
            UI.sendOneFrame.sendOnePanel.msgMode.removeAllElements();
//            UI.sendOneFrame.sendOnePanel.msgMode = new DefaultListModel();
            JSONObject js = new JSONObject();
            js.put("action","isClick");
            js.put("isRecvId",userId);
            CliController.cliReadThread.send(js.toJSONString());
            UI.sendOneFrame.setVisible(true);
        }
        UI.sendOneFrame.sendOnePanel.getFriendLabel().setText("与用户："+userName+"--"+userId+"的聊天");

    }
}
