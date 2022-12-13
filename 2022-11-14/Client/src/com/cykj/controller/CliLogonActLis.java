package com.cykj.controller;
import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.CliUserBean;
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
                String user = UI.logonFrame.cliLogonPanel.getAccField().getText();//账号输入框
                String name = UI.logonFrame.cliLogonPanel.getNameField().getText();//姓名输入框
                String psw = new String(UI.logonFrame.cliLogonPanel.getPwdField().getPassword());//密码输入框
                String isPsw = new String(UI.logonFrame.cliLogonPanel.getIsPwdField().getPassword());//确认密码输入框
                String age = UI.logonFrame.cliLogonPanel.getAgeField().getText();//年龄输入框
                String address = UI.logonFrame.cliLogonPanel.getAddressField().getText();//地址输入框
                    if (user.equals("") || name.equals("") || psw.equals("") ||
                            isPsw.equals("") || age.equals("") ||address.equals("")){
                        JOptionPane.showConfirmDialog(null,
                                "输入为空", "信息提示g", JOptionPane.DEFAULT_OPTION);
                    }else if (!psw.equals(isPsw)){
                        JOptionPane.showConfirmDialog(null,
                                "两次输入密码不一致", "信息提示", JOptionPane.DEFAULT_OPTION);
                    }else {
                        //发送消息给服务端
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("action","logon");
                        jsonObject.put("qqid",user);
                        jsonObject.put("name",name);
                        jsonObject.put("psw",psw);
                        jsonObject.put("age",age);
                        jsonObject.put("address",address);
                        String str = jsonObject.toJSONString();
                        con.cliReadThread.send(str);
                    }
                break;
            case "exit":
                System.exit(0);
                break;

        }
    }
}
