package view;

import controller.Controller;
import controller.LogonActLis;
import controller.ToLoginLis;

import javax.swing.*;
import java.awt.*;

public class LogonPanel extends JPanel {
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    public JLabel label1 = new JLabel("账号：");//文字
    public JLabel label2 = new JLabel("密码：");//文字
    public JLabel label3 = new JLabel("确认密码：");//文字
    public JTextField accField = new JTextField(20);
    public JTextField pwdField = new JTextField(20);
    public JTextField checkField = new JTextField(20);
    public JButton logonBtn = new JButton("注册");//注册按钮
    public JButton toLoginBtn = new JButton("去登录");//登录按钮
    public LogonPanel(Controller con){
        this.con = con;//将con传进来

        setBackground(new Color(132,93,79));//背景颜色
        setLayout(null);//自由布局

        //文字及其位置
        label1.setFont(font);//文字字体
        label2.setFont(font);
        label3.setFont(font);
        label1.setForeground(new Color(255,0,0));//文字颜色
        label2.setForeground(new Color(255,0,0));
        label3.setForeground(new Color(255,0,0));
        add(label1);
        add(label2);
        add(label3);
        label1.setBounds(420,155,120,80);
        label2.setBounds(420,195,120,80);
        label3.setBounds(390,238,125,80);

        //输入框及其位置

        accField.setFont(font);//输入字体
        pwdField.setFont(font);
        checkField.setFont(font);

        add(accField);
        add(pwdField);
        add(checkField);
        accField.setBounds(500,180,240,33);
        pwdField.setBounds(500,220,240,33);
        checkField.setBounds(500,260,240,33);

        //按钮及其位置

        add(logonBtn);//注册按钮
        add(toLoginBtn);//登录按钮
        logonBtn.setBounds(490,300,120,50);//注册按钮
        toLoginBtn.setBounds(650,300,120,50);//登录按钮

        //注册按钮 的监听器 实例化和注册
        //实例化  监听器
//        LogonLis logonLis = new LogonLis();
        LogonActLis logonActLis = new LogonActLis(con,this);
        //给事件源  注册监听器
//        logonBtn.addMouseListener(logonLis);
        logonBtn.addActionListener(logonActLis);
        logonBtn.setActionCommand("logon");


        //去登录按钮 的监听器 实例化和注册
        ToLoginLis loginLis = new ToLoginLis();
        toLoginBtn.addMouseListener(loginLis);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bgImg = new ImageIcon("images/bg.png").getImage();
        //         图片本身，起始x坐标,起始y坐标，宽，高，null
        g.drawImage(bgImg,0,0,800,600,null);
    }
}
