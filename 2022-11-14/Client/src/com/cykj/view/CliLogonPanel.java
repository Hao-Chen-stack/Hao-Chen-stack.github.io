package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.controller.CliLogonActLis;

import javax.swing.*;
import java.awt.*;

public class CliLogonPanel extends JPanel {
    public CliController con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    public JLabel label1 = new JLabel("账号：");//文字
    public JLabel label2 = new JLabel("姓名：");//文字
    public JLabel labelName = new JLabel("密码：");//文字
    public JLabel label3 = new JLabel("确认密码：");//文字
    public JLabel label4 = new JLabel("年龄：");//文字
    public JLabel label5 = new JLabel("地址：");//文字
    private JTextField accField = new JTextField(20);//账号输入框
    private JTextField nameField = new JTextField(20);//姓名输入框
    private JPasswordField pwdField = new JPasswordField(20);//密码输入框
    private JPasswordField isPwdField = new JPasswordField(20);//确认密码输入框
    private JTextField ageField = new JTextField(20);//年龄输入框
    private JTextField addressField = new JTextField(20);//地址输入框
    private JButton loginBtn = new JButton("注册");
    private JButton exitBtn = new JButton("退出");

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

    public JTextField getAgeField() {
        return ageField;
    }

    public void setAgeField(JTextField ageField) {
        this.ageField = ageField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public void setAddressField(JTextField addressField) {
        this.addressField = addressField;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(JButton loginBtn) {
        this.loginBtn = loginBtn;
    }

    public JButton getExitBtn() {
        return exitBtn;
    }

    public void setExitBtn(JButton exitBtn) {
        this.exitBtn = exitBtn;
    }

    public CliLogonPanel(CliController con){
        this.con = con;
        setBackground(new Color(0,0,0));//背景颜色
        setLayout(null);//自由布局

        //文字及其位置

        label1.setFont(font);//文字字体
        label2.setFont(font);
        labelName.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        label1.setForeground(new Color(0,255,0));//文字颜色
        label2.setForeground(new Color(0,255,0));
        labelName.setForeground(new Color(0,255,0));
        label3.setForeground(new Color(0,255,0));
        label4.setForeground(new Color(0,255,0));
        label5.setForeground(new Color(0,255,0));
        add(label1);
        add(label2);
        add(labelName);
        add(label3);
        add(label4);
        add(label5);
        label1.setBounds(225,155,120,80);
        label2.setBounds(225,195,120,80);
        labelName.setBounds(225,235,120,80);
        label3.setBounds(190,275,150,80);
        label4.setBounds(225,315,120,80);
        label5.setBounds(225,355,120,80);

        //输入框及其位置

        accField.setFont(font);//输入字体
        nameField.setFont(font);//输入字体
        pwdField.setFont(font);
        isPwdField.setFont(font);
        ageField.setFont(font);
        addressField.setFont(font);

        add(accField);
        add(nameField);
        add(pwdField);
        add(isPwdField);
        add(ageField);
        add(addressField);
        accField.setBounds(305,180,240,33);
        nameField.setBounds(305,220,240,33);
        pwdField.setBounds(305,260,240,33);
        isPwdField.setBounds(305,300,240,33);
        ageField.setBounds(305,340,240,33);
        addressField.setBounds(305,380,240,33);

        //按钮及其位置
        add(loginBtn);
        add(exitBtn);
        loginBtn.setBounds(225,430,120,50);
        exitBtn.setBounds(505,430,120,50);

        //为按钮注册监听
        CliLogonActLis cliLogonActLis = new CliLogonActLis(con);
        loginBtn.addActionListener(cliLogonActLis);
        loginBtn.setActionCommand("logon");
        exitBtn.addActionListener(cliLogonActLis);
        exitBtn.setActionCommand("exit");
    }
}
