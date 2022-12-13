package controller;

import view.LoginPanel;
import view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActLis implements ActionListener {
    public Controller con;
    public LoginPanel loginPanel;
    public LoginActLis(Controller con,LoginPanel loginPanel){
        this.con = con;
        this.loginPanel = loginPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(1);
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case "toLogon":
                UI.loginFrame.setVisible(false);
                UI.logonFrame.setVisible(true);
                break;
            case "login":
                if (con.login(loginPanel)){
                    UI.gameFrame.setVisible(true);
                    UI.loginFrame.setVisible(false);
                }else {
                    JOptionPane.showConfirmDialog(null,
                            "登录失败", "", JOptionPane.DEFAULT_OPTION);
                }
                break;
            case "注册":
                UI.logonFrame.setVisible(true);
                UI.loginFrame.setVisible(false);
                break;
            case "关于游戏":
                JOptionPane.showConfirmDialog(null,
                        "暂时没有什么可以介绍的", "游戏介绍", JOptionPane.DEFAULT_OPTION);
                break;
            case "关于作者":
                JOptionPane.showConfirmDialog(null,
                        "作者：陈浩", "制作者姓名", JOptionPane.DEFAULT_OPTION);
                break;
        }
    }
}
