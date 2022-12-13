package view.login;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,20);
    public LoginLeftPanel leftPanel;
    public JMenuBar loginBar = new JMenuBar();
    public JMenu gameMenu = new JMenu("游戏");
    public JMenu helpMenu = new JMenu("帮助");
    public LoginFrame(Controller con){
        this.con = con;

        setSize(800,600);
        setLocationRelativeTo(null);//居中
        setTitle("坦克大战---登录界面    姓名：陈浩     班级：JX2209班   学号：JX220913");
        setResizable(false);//窗口锁死无法拉动大小
        setDefaultCloseOperation(EXIT_ON_CLOSE);//点×结束进程

        loginBar.add(gameMenu);
        loginBar.add(helpMenu);
//        gameMenu.setFont(font);
//        helpMenu.setFont(font);
        setJMenuBar(loginBar);
        setJMenuBar(loginBar);

        leftPanel = new LoginLeftPanel(con);
        add(leftPanel);



//        setVisible(true);

    }

}
