package view;

import controller.Controller;
import controller.LoginActLis;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel{
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    public JLabel label1 = new JLabel("账号：");//文字
    public JLabel label2 = new JLabel("密码：");//文字
    public JTextField accField = new JTextField(20);//账号输入框
    public JTextField pwdField = new JTextField(20);//密码输入框
    public JButton loginBtn = new JButton("登录");
    public JButton toLogonBtn = new JButton("去注册");
    public LoginPanel(Controller con){
        this.con = con;

        setBackground(new Color(132,93,79));//背景颜色
        setLayout(null);//自由布局

        //文字及其位置

        label1.setFont(font);//文字字体
        label2.setFont(font);
        label1.setForeground(new Color(255,0,0));//文字颜色
        label2.setForeground(new Color(255,0,0));
        add(label1);
        add(label2);
        label1.setBounds(420,155,120,80);
        label2.setBounds(420,195,120,80);

        //输入框及其位置

        accField.setFont(font);//输入字体
        pwdField.setFont(font);

        add(accField);
        add(pwdField);
        accField.setBounds(500,180,240,33);
        pwdField.setBounds(500,220,240,33);

        //按钮及其位置
        add(loginBtn);
        add(toLogonBtn);
        loginBtn.setBounds(490,300,120,50);
        toLogonBtn.setBounds(650,300,120,50);

        LoginActLis loginActLis = new LoginActLis(con,this);
        //登录按钮监听
        loginBtn.addActionListener(loginActLis);
        //如果是动作监听   那么最好带上actionCommand
        loginBtn.setActionCommand("login");

        //去注册按钮监听
        toLogonBtn.addActionListener(loginActLis);
        toLogonBtn.setActionCommand("toLogon");


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bgImg = new ImageIcon("images/bg.png").getImage();
        //         图片本身，起始x坐标,起始y坐标，宽，高，null
        g.drawImage(bgImg,0,0,800,600,null);
    }
}
