package view.welcome;

import controller.Controller;
import controller.GameMusic;
import controller.GameWindowLis;

import javax.swing.*;

public class WelcomeFrame extends JFrame {
    public Controller con;
    public WelcomePanel welcomePanel;
    public WelcomeFrame(Controller con){
        this.con = con;

        setSize(800,600);
        setLocationRelativeTo(null);//居中
        setTitle("坦克大战---欢迎界面    姓名：陈浩     班级：JX2209班   学号：JX220913");
        setResizable(false);//窗口锁死无法拉动大小

//        setDefaultCloseOperation(EXIT_ON_CLOSE);//点×结束进程
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//点×无具体响应

        //注册窗口监听器实例化和注册
        GameWindowLis gameWindowLis = new GameWindowLis();
        addWindowListener(gameWindowLis);

        welcomePanel = new WelcomePanel(con);
        add(welcomePanel);


        setVisible(true);
    }
}
