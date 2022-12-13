package com.cykj.view;

import com.cykj.controller.Controller;
import com.cykj.controller.LoginActLis;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    public JLabel userLabel;
    public JLabel pswLabel;
    private JTextField userTxt;
    private JPasswordField userPsw;
    private JButton loginBtn;
    private JButton toLogonBtn;
    private JButton quitBtn;

    public JTextField getUserTxt() {
        return userTxt;
    }

    public void setUserTxt(JTextField userTxt) {
        this.userTxt = userTxt;
    }

    public JPasswordField getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(JPasswordField userPsw) {
        this.userPsw = userPsw;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(JButton loginBtn) {
        this.loginBtn = loginBtn;
    }

    public JButton getQuitBtn() {
        return quitBtn;
    }

    public void setQuitBtn(JButton quitBtn) {
        this.quitBtn = quitBtn;
    }

    public LoginPanel(Controller con){
        this.con = con;
        setLayout(null);//自由布局

        //文字
        userLabel = new JLabel("账号：");
        userLabel.setBounds(210,150,100,30);
        add(userLabel);
        userLabel.setFont(font);//字体

        pswLabel = new JLabel("密码：");
        pswLabel.setBounds(210,210,100,30);
        add(pswLabel);
        pswLabel.setFont(font);//字体

        //文本输入框
        userTxt = new JTextField(20);//账号
        userTxt.setBounds(280,150,240,40);
        add(userTxt);
        userTxt.setFont(font);//输入字体

        userPsw = new JPasswordField(20);//密码
        userPsw.setBounds(280,210,240,40);
        add(userPsw);

        //按钮
        loginBtn = new JButton("登录");
        loginBtn.setBounds(230,260,100,50);
        add(loginBtn);

        toLogonBtn = new JButton("注册");
        toLogonBtn.setBounds(350,260,100,50);
        add(toLogonBtn);

        quitBtn = new JButton("退出");
        quitBtn.setBounds(470,260,100,50);
        add(quitBtn);

        //注册监听
        LoginActLis loginActLis = new LoginActLis(con);
        loginBtn.addActionListener(loginActLis);
        loginBtn.setActionCommand("login");
        toLogonBtn.addActionListener(loginActLis);
        toLogonBtn.setActionCommand("toLogon");
        quitBtn.addActionListener(loginActLis);
        quitBtn.setActionCommand("quit");

    }
}
