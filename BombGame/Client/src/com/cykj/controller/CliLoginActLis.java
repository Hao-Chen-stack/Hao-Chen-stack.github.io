package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.Thread.ConnectThread;
import com.cykj.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

public class CliLoginActLis implements ActionListener {
    public CliController con;

    public CliLoginActLis(CliController con) {
        this.con = con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":
                String user = UI.loginFrame.loginPanel.getUserTxt().getText();//账号输入框
                String psw = new String(UI.loginFrame.loginPanel.getUserPsw().getPassword());//密码输入框
                String pcCode = showCode();
                String userCode = JOptionPane.showInputDialog("验证码为"+pcCode);
                if (user.equals("") || psw.equals("")){
                    JOptionPane.showConfirmDialog(null,
                            "输入为空", "信息提示", JOptionPane.DEFAULT_OPTION);
                }else if (!checkUserId(user)){
                    JOptionPane.showMessageDialog(null,
                            "输入格式不正确", "信息提示", JOptionPane.ERROR_MESSAGE);
                }else if(!pcCode.equalsIgnoreCase(userCode)){
                    System.out.println("验证码错误");
                    JOptionPane.showConfirmDialog(null,
                            "验证码错误", "失败", JOptionPane.DEFAULT_OPTION);
                }
                else {
                    //为服务端发送账号和密码
                    JSONObject loginJson = new JSONObject();
                    loginJson.put("action","login");
                    loginJson.put("acc",user);
                    loginJson.put("psw",psw);
                    System.out.println("按下登录按钮发送了："+loginJson.toJSONString());
                    CliController.cliReadThread.send(loginJson.toJSONString());

                }
                break;
            case "toLogon":
                UI.loginFrame.setVisible(false);
                UI.logonFrame.setVisible(true);
                break;
            case "quit":
                System.exit(0);
                break;
        }
    }
    //正则表达式限制输入
    private static boolean checkUserId(String userId){
        //匹配帐号是否合法(只允许输入英文和数字)
        return userId.matches("^^[A-Za-z0-9]+$+\\S*");
    }

    //生成验证码方法
    public String showCode() {
        String codeBox = "qwertyuipasdfghjkzxcvbnmQWERTYUPASDFGHJKLZXCVBNM" +
                "23456789";
        //要求四位验证码   并且  拿来比较
        String pcCode = "";
        for (int i = 0; i < 4; i++) {
            int ranNum = new Random().nextInt(codeBox.length());
            pcCode += codeBox.charAt(ranNum);
        }
        return pcCode;
    }
}
