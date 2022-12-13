package view.game;

import controller.Controller;
import controller.GameActLis;
import controller.GameWindowLis;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,20);
    public GameLeftPanel gameLeftPanel;
    public JMenuBar loginBar = new JMenuBar();
    //一级菜单
    public JMenu gameMenu = new JMenu("游戏");
    public JMenuItem startItem = new JMenuItem("开始游戏");
    public JMenuItem stopItem = new JMenuItem("暂停");
    public JMenuItem restartItem = new JMenuItem("重新开始");
    public JMenuItem rankItem = new JMenuItem("排行榜");
    public JMenuItem customItem = new JMenuItem("自定义");
    public JMenuItem exitItem = new JMenuItem("退出");
    //二级菜单
    public JMenu helpMenu = new JMenu("帮助");
    public JMenuItem aboutItem = new JMenuItem("关于");
    //二级菜单子菜单
    public JMenu gameDesMenu = new JMenu("游戏说明");
    public JMenuItem manualItem = new JMenuItem("操作说明");
    public JMenuItem ruleItem = new JMenuItem("规则说明");
    public GameFrame(Controller con){
        this.con = con;

        setSize(1020,750);
        setLocationRelativeTo(null);//居中
        setTitle("坦克大战---游戏界面          姓名：陈浩     班级：JX2209班   学号：JX220913");
        setResizable(false);//窗口锁死无法拉动大小
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//点×的时候什么都不干

        //注册窗口监听器实例化和注册
        GameWindowLis winLis = new GameWindowLis();
        addWindowListener(winLis);


        loginBar.add(gameMenu);
        gameMenu.add(startItem);
        gameMenu.add(stopItem);
        gameMenu.add(restartItem);
        gameMenu.add(rankItem);
        gameMenu.add(customItem);
        gameMenu.add(exitItem);

        loginBar.add(helpMenu);
        helpMenu.add(aboutItem);
        helpMenu.add(gameDesMenu);
        gameDesMenu.add(manualItem);
        gameDesMenu.add(ruleItem);
//        gameMenu.setFont(font);
//        helpMenu.setFont(font);
        setJMenuBar(loginBar);
        setJMenuBar(loginBar);

        gameLeftPanel = new GameLeftPanel(con);
        add(gameLeftPanel);

        //GameActLis的实例化和安装
        GameActLis gameActLis = new GameActLis(con);
        //游戏菜单
        startItem.addActionListener(gameActLis);
        startItem.setActionCommand("start");
        stopItem.addActionListener(gameActLis);
        stopItem.setActionCommand("stop");
        restartItem.addActionListener(gameActLis);
        restartItem.setActionCommand("restart");
        customItem.addActionListener(gameActLis);
        customItem.setActionCommand("custom");
        exitItem.addActionListener(gameActLis);
        exitItem.setActionCommand("exit");


        //帮助菜单
        aboutItem.addActionListener(gameActLis);
        aboutItem.setActionCommand("about");
        manualItem.addActionListener(gameActLis);
        manualItem.setActionCommand("manual");
        ruleItem.addActionListener(gameActLis);
        ruleItem.setActionCommand("rule");


//        setVisible(true);
    }
}
