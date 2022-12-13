package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CliLoginActLis implements ActionListener {
    public CliController con;

    public CliLoginActLis(CliController con) {
        this.con = con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":
                String user = UI.loginUserFrame.loginPanel.getUserTxt().getText();//账号输入框
                String psw = new String(UI.loginUserFrame.loginPanel.getUserPsw().getPassword());//密码输入框

                    if (user.equals("") || psw.equals("")){
                        JOptionPane.showConfirmDialog(null,
                                "输入为空", "信息提示", JOptionPane.DEFAULT_OPTION);
                    }else {
                        //为服务端发送账号和密码
//                        String data = "login%" + user + "%" + psw;
//                        System.out.println("发送登录信息" + data);
//                        con.cliReadThread.send(data);
//                        jsonObject.put("action","login");
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("action","login");
                        jsonObject.put("acc",user);
                        jsonObject.put("psw",psw);
                        String str = jsonObject.toJSONString();
                        System.out.println("发送："+str);
                        con.cliReadThread.send(str);
                    }
                break;
            case "toLogon":
                UI.loginUserFrame.setVisible(false);
                UI.logonFrame.setVisible(true);
                break;
            case "quit":
                System.exit(0);
                break;
        }
    }
}
