package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.controller.CliLoginActLis;
import com.cykj.model.Data;

import javax.swing.*;
import java.awt.*;

public class CliLoginPanel extends JPanel {
    public CliController con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    public JLabel userLabel;
    public JLabel pswLabel;

    private JTextField userTxt;
    private JPasswordField userPsw;
    private JLabel reLinkLabel;
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

    public JLabel getReLinkLabel() {
        return reLinkLabel;
    }

    public void setReLinkLabel(JLabel reLinkLabel) {
        this.reLinkLabel = reLinkLabel;
    }

    public JButton getToLogonBtn() {
        return toLogonBtn;
    }

    public void setToLogonBtn(JButton toLogonBtn) {
        this.toLogonBtn = toLogonBtn;
    }

    public JButton getQuitBtn() {
        return quitBtn;
    }

    public void setQuitBtn(JButton quitBtn) {
        this.quitBtn = quitBtn;
    }

    public CliLoginPanel(CliController con){
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

        reLinkLabel = new JLabel("     ");
        reLinkLabel.setBounds(550,330,200,30);
        add(reLinkLabel);
        reLinkLabel.setFont(font);

        //文字颜色
        userLabel.setForeground(new Color(255,0,0));
        pswLabel.setForeground(new Color(255,0,0));
        reLinkLabel.setForeground(new Color(0,255,0));
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

        toLogonBtn = new JButton("去注册");
        toLogonBtn.setBounds(490,260,100,50);
        add(toLogonBtn);

        quitBtn = new JButton("退出");
        quitBtn.setBounds(610,260,100,50);
        add(quitBtn);

        //注册监听
        CliLoginActLis loginActLis = new CliLoginActLis(con);
        loginBtn.addActionListener(loginActLis);
        loginBtn.setActionCommand("login");
        toLogonBtn.addActionListener(loginActLis);
        toLogonBtn.setActionCommand("toLogon");
        quitBtn.addActionListener(loginActLis);
        quitBtn.setActionCommand("quit");
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(Data.LOGIN_BG,0,0,800,600,null);
    }
}
