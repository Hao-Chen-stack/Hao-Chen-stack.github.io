package controller;

import view.LogonPanel;
import view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogonActLis implements ActionListener {
    public Controller con;
    public LogonPanel logonPanel;
    public LogonActLis(Controller con,LogonPanel logonPanel){
        this.con = con;
        this.logonPanel = logonPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case "logon":
                con.logon(logonPanel);
                break;
            case "登录":
                UI.loginFrame.setVisible(true);
                UI.logonFrame.setVisible(false);
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
