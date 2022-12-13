package view;

import controller.Controller;
import controller.GameWinLis;
import controller.LogonActLis;

import javax.swing.*;

public class LogonFrame extends JFrame {
    public LogonPanel logonPanel;
    public Controller con;
    //一级菜单
    public JMenuBar loginBar = new JMenuBar();
    public JMenu menu1 = new JMenu("操作");//一级菜单标题
    //菜单项
    public JMenuItem loginItem = new JMenuItem("登录");
    public JMenuItem logonItem = new JMenuItem("注册");

    //二级菜单
    public JMenu menu2 = new JMenu("关于");//二级菜单标题
    //菜单项
    public JMenuItem secondItem1 = new JMenuItem("关于游戏");
    public JMenuItem secondItem2 = new JMenuItem("关于作者");
    public LogonFrame(Controller con){
        this.con = con;

        setSize(800,600);
        setLocationRelativeTo(null);//居中
        setTitle("注册界面");//标题
        setResizable(false);//窗口大小锁死

//        setDefaultCloseOperation(EXIT_ON_CLOSE);//点×退出游戏进程
//        setDefaultCloseOperation(HIDE_ON_CLOSE);//点×的时候隐藏窗口
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//点×的时候什么都不干
        //窗口自己不管理关闭 交给监听管理

        //注册窗口监听器实例化和注册
        GameWinLis winLis = new GameWinLis();
        addWindowListener(winLis);

        //将中层部分加入
        logonPanel = new LogonPanel(con);
        add(logonPanel);

        //添加
        loginBar.add(menu1);
        loginBar.add(menu2);
        menu1.add(loginItem);
        menu1.add(logonItem);
        menu2.add(secondItem1);
        menu2.add(secondItem2);
        setJMenuBar(loginBar);


        //为了给菜单安装监听 JFrame里面也要实例化监听器
        LogonActLis logonActLis = new LogonActLis(con,logonPanel);
        loginItem.addActionListener(logonActLis);
        loginItem.setActionCommand("登录");

        //菜单上的监听器
        LogonActLis logonForGame = new LogonActLis(con,logonPanel);
        secondItem1.addActionListener(logonForGame);
        secondItem1.setActionCommand("关于游戏");

        LogonActLis logonForAuthor = new LogonActLis(con,logonPanel);
        secondItem2.addActionListener(logonForAuthor);
        secondItem2.setActionCommand("关于作者");




//        setVisible(true);
    }
}
