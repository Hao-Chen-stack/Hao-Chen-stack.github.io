package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.util.ImageButton;
import com.cykj.view.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CliGameRoomActLis implements ActionListener {
    public CliController con;
    boolean flag = true;
    public CliGameRoomActLis(CliController con){
        this.con = con;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "createRoom":
                //获取账号文本框内容
                String userId = UI.loginFrame.loginPanel.getUserTxt().getText();
                JSONObject createJs = new JSONObject();
                createJs.put("action","roomCreate");
                createJs.put("Cid",userId);
                if (flag){
                    CliController.cliReadThread.send(createJs.toJSONString());
                    UI.gameRoomFrame.setVisible(false);
                    UI.chooseMap.cliWaitRoomPanel.getCreateRoomLabel().setText(userId+"的房间");
                    UI.chooseMap.setVisible(true);
                    flag = false;
                }
//                UI.gameRoomFrame.setVisible(false);
                break;
            case "returnCen":
                UI.gameRoomFrame.setVisible(false);
                JSONObject deleteJs = new JSONObject();
                deleteJs.put("action","deleteRoom");
                deleteJs.put("CreateUserId",UI.loginFrame.loginPanel.getUserTxt().getText());
                CliController.cliReadThread.send(deleteJs.toJSONString());
                UI.gameFrame.setVisible(true);
                break;
            case "newRoom":
                String antherPlayerId = UI.loginFrame.loginPanel.getUserTxt().getText();
                ImageButton button = (ImageButton)e.getSource();
                String ansRoomNum = button.getText().split("的")[0];// //拿到所点击的房间号
                JSONObject joinRoomJs = new JSONObject();
                joinRoomJs.put("action","joinRoom");
                joinRoomJs.put("playerId",antherPlayerId);
                joinRoomJs.put("roomId",ansRoomNum);
                CliController.cliReadThread.send(joinRoomJs.toJSONString());
                break;
        }
    }
}
