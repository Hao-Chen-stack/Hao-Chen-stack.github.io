package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CliLogonActLis implements ActionListener {
    public CliController con;

    public CliLogonActLis(CliController con) {
        this.con = con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "logon":
                String user = UI.logonFrame.logonPanel.getAccField().getText();//账号输入框
                String name = UI.logonFrame.logonPanel.getNameField().getText();//姓名输入框
                String psw = new String(UI.logonFrame.logonPanel.getPwdField().getPassword());//密码输入框
                String isPsw = new String(UI.logonFrame.logonPanel.getIsPwdField().getPassword());//确认密码输入框
                    if (user.equals("") || name.equals("") || psw.equals("") || isPsw.equals("")){
                        JOptionPane.showConfirmDialog(null,
                                "输入为空", "信息提示", JOptionPane.DEFAULT_OPTION);
                    }else if (!psw.equals(isPsw)){
                        JOptionPane.showConfirmDialog(null,
                                "两次输入密码不一致", "信息提示", JOptionPane.DEFAULT_OPTION);
                    }else if (!checkUserId(user) || !checkUserId(psw)){
                        JOptionPane.showConfirmDialog(null,
                                "输入格式有误", "信息提示", JOptionPane.DEFAULT_OPTION);
                    }else {
                        //发送消息给服务端
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("action","logon");
                        jsonObject.put("userid",user);
                        jsonObject.put("username",name);
                        jsonObject.put("userpwd",psw);
                        System.out.println("按下注册按钮发送了："+jsonObject.toJSONString());
                        CliController.cliReadThread.send(jsonObject.toJSONString());
                    }
                break;
            case "toLogin":
                UI.logonFrame.setVisible(false);
                UI.loginFrame.setVisible(true);
                break;
            case "exit":
                System.exit(0);
                break;

        }
    }
    //正则表达式限制输入
    private static boolean checkUserId(String userInput){
        //匹配帐号是否合法(只允许输入英文和数字)
        return userInput.matches("^^[A-Za-z0-9]+$+\\S*");
    }
}
