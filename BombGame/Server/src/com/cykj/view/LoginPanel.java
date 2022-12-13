package com.cykj.view;

import com.cykj.controller.Controller;

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
        userLabel.setBounds(350,150,100,30);
        add(userLabel);
        userLabel.setFont(font);//字体

        pswLabel = new JLabel("密码：");
        pswLabel.setBounds(350,210,100,30);
        add(pswLabel);
        pswLabel.setFont(font);//字体

        //文字颜色
        userLabel.setForeground(new Color(255,0,0));
        pswLabel.setForeground(new Color(255,0,0));
        //文本输入框
        userTxt = new JTextField(20);//账号
        userTxt.setBounds(420,150,240,40);
        add(userTxt);
        userTxt.setFont(font);//输入字体

        userPsw = new JPasswordField(20);//密码
        userPsw.setBounds(420,210,240,40);
        add(userPsw);

        //按钮
        loginBtn = new JButton("登录");
        loginBtn.setBounds(370,260,100,50);
        add(loginBtn);

        quitBtn = new JButton("退出");
        quitBtn.setBounds(610,260,100,50);
        add(quitBtn);



    }
}
