package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.controller.CliLogonActLis;
import com.cykj.model.Data;

import javax.swing.*;
import java.awt.*;

public class CliLogonPanel extends JPanel {
    public CliController con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    public JLabel accLabel = new JLabel("账号：");//文字
    public JLabel nameLabel = new JLabel("姓名：");//文字
    public JLabel pwdLabel = new JLabel("密码：");//文字
    public JLabel isPwdLabel = new JLabel("确认密码：");//文字
    private JLabel reLinkLabel = new JLabel("     ");//重新连接字样
    private JTextField accField = new JTextField(20);//账号输入框
    private JTextField nameField = new JTextField(20);//姓名输入框
    private JPasswordField pwdField = new JPasswordField(20);//密码输入框
    private JPasswordField isPwdField = new JPasswordField(20);//确认密码输入框
    private JButton logonBtn = new JButton("注册");
    private JButton toLoginBtn = new JButton("去登陆");
    private JButton exitBtn = new JButton("退出");

    public JLabel getReLinkLabel() {
        return reLinkLabel;
    }

    public void setReLinkLabel(JLabel reLinkLabel) {
        this.reLinkLabel = reLinkLabel;
    }

    public JTextField getAccField() {
        return accField;
    }

    public void setAccField(JTextField accField) {
        this.accField = accField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JPasswordField getPwdField() {
        return pwdField;
    }

    public void setPwdField(JPasswordField pwdField) {
        this.pwdField = pwdField;
    }

    public JPasswordField getIsPwdField() {
        return isPwdField;
    }

    public void setIsPwdField(JPasswordField isPwdField) {
        this.isPwdField = isPwdField;
    }

    public JButton getLogonBtn() {
        return logonBtn;
    }

    public void setLogonBtn(JButton logonBtn) {
        this.logonBtn = logonBtn;
    }

    public JButton getToLoginBtn() {
        return toLoginBtn;
    }

    public void setToLoginBtn(JButton toLoginBtn) {
        this.toLoginBtn = toLoginBtn;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public void setExitBtn(JButton exitBtn) {
        this.exitBtn = exitBtn;
    }

    public CliLogonPanel(CliController con){
        this.con = con;
        setLayout(null);//自由布局

        //文字及其位置
        reLinkLabel.setFont(font);
        accLabel.setFont(font);
        nameLabel.setFont(font);
        pwdLabel.setFont(font);
        isPwdLabel.setFont(font);

        add(reLinkLabel);
        add(accLabel);
        add(nameLabel);
        add(pwdLabel);
        add(isPwdLabel);
        reLinkLabel.setBounds(400,350,180,30);
        accLabel.setBounds(225,155,120,80);
        nameLabel.setBounds(225,195,120,80);
        pwdLabel.setBounds(225,235,120,80);
        isPwdLabel.setBounds(175,275,150,80);

        //文字颜色
        reLinkLabel.setForeground(new Color(255,0,0));
        accLabel.setForeground(new Color(255,0,0));
        nameLabel.setForeground(new Color(255,0,0));
        pwdLabel.setForeground(new Color(255,0,0));
        isPwdLabel.setForeground(new Color(255,0,0));

        //输入框及其位置
        accField.setFont(font);//输入字体
        nameField.setFont(font);
        pwdField.setFont(font);
        isPwdField.setFont(font);
        add(accField);
        add(nameField);
        add(pwdField);
        add(isPwdField);
        accField.setBounds(305,180,240,33);
        nameField.setBounds(305,220,240,33);
        pwdField.setBounds(305,260,240,33);
        isPwdField.setBounds(305,300,240,33);

        //按钮及其位置
        add(logonBtn);
        add(toLoginBtn);
        add(exitBtn);
        logonBtn.setBounds(225,430,120,50);
        toLoginBtn.setBounds(365,430,120,50);
        exitBtn.setBounds(505,430,120,50);

        //为按钮注册监听
        CliLogonActLis cliLogonActLis = new CliLogonActLis(con);
        logonBtn.addActionListener(cliLogonActLis);
        logonBtn.setActionCommand("logon");
        toLoginBtn.addActionListener(cliLogonActLis);
        toLoginBtn.setActionCommand("toLogin");
        exitBtn.addActionListener(cliLogonActLis);
        exitBtn.setActionCommand("exit");

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Data.LOGON_BG,0,0,800,600,null);
    }
}
