package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.view.CliSendOneFrame;
import com.cykj.view.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CliSendOneActLis implements ActionListener {
    public CliController con;
    public Object selectedValue;
    public String string;
    public String userId;

    public CliSendOneActLis(CliController con) {
        this.con = con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "sendOne":
                //获取北京时间
                Locale locale = Locale.CHINA;
                String pattern = "yyyy-MM-dd kk:mm:ss";
                SimpleDateFormat df = new SimpleDateFormat(pattern, locale);
                Date date = new Date();
                String bjTime = df.format(date);

                //获取要发给的人
                Object selectedValue = UI.gameFrame.gamePanel.getFriendJList().getSelectedValue();
                String string = selectedValue.toString();//转换成字符串
                String[] split = string.split("--");
                userId = split[1];

               //定义一个新的JSON来接
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("action", "sendOne");
                jsonObject.put("to", userId);
                //拿到账户输入框
                jsonObject.put("from", UI.loginFrame.loginPanel.getUserTxt().getText());
                //拿到消息输入框
                jsonObject.put("msg", UI.sendOneFrame.sendOnePanel.getMsgTextField().getText());
                UI.sendOneFrame.sendOnePanel.msgMode.addElement(bjTime+"来自账户"+UI.loginFrame.loginPanel.getUserTxt().getText()+"的消息：");//自己这边也要显示
                UI.sendOneFrame.sendOnePanel.msgMode.addElement(UI.sendOneFrame.sendOnePanel.getMsgTextField().getText());//自己这边也要显示
                System.out.println("私聊发送" + jsonObject.toJSONString());
                CliController.cliReadThread.send(jsonObject.toJSONString());
                break;
            case "showMsg":
                //获取要发给的人
                selectedValue = UI.gameFrame.gamePanel.getFriendJList().getSelectedValue();
                string = selectedValue.toString();//转换成字符串
                String[] split2 = string.split("--");
                userId = split2[1];
                UI.sendOneRecFrame.setVisible(true);
                JSONObject jsRec = new JSONObject();
                jsRec.put("sendId",UI.loginFrame.loginPanel.getUserTxt().getText());
                jsRec.put("recvId",userId);
                jsRec.put("action","recSendOneShow");
                CliController.cliReadThread.send(jsRec.toJSONString());
                break;
            case "up":
                //获取要发给的人
                selectedValue = UI.gameFrame.gamePanel.getFriendJList().getSelectedValue();
                string = selectedValue.toString();//转换成字符串
                String[] split3 = string.split("--");
                userId = split3[1];
                JSONObject upJs = new JSONObject();
                upJs.put("upSendId",UI.loginFrame.loginPanel.getUserTxt().getText());
                upJs.put("upRecvId",userId);
                upJs.put("action","up");
                CliController.cliReadThread.send(upJs.toJSONString());
                break;
            case "down":
                //获取要发给的人
                selectedValue = UI.gameFrame.gamePanel.getFriendJList().getSelectedValue();
                string = selectedValue.toString();//转换成字符串
                String[] split4 = string.split("--");
                userId = split4[1];
                JSONObject downJs = new JSONObject();
                downJs.put("downSendId",UI.loginFrame.loginPanel.getUserTxt().getText());
                downJs.put("downRecvId",userId);
                downJs.put("action","down");
                CliController.cliReadThread.send(downJs.toJSONString());
                break;
        }
    }

}
