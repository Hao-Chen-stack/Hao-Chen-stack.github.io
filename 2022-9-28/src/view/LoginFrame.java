package view;

import controller.Controller;
import controller.GameWinLis;
import controller.LoginActLis;

import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginPanel loginPanel;
    public Controller con;
    //一级菜单
    public JMenuBar loginBar = new JMenuBar();
    public JMenu menu1 = new JMenu("操作");//一级菜单标题
    //菜单项
    public JMenuItem item1 = new JMenuItem("登录");
    public JMenuItem item2 = new JMenuItem("注册");

    //二级菜单
    public JMenu menu2 = new JMenu("关于");//二级菜单标题
    //菜单项
    public JMenuItem secondItem1 = new JMenuItem("关于游戏");
    JMenuItem secondItem2 = new JMenuItem("关于作者");
    public LoginFrame(Controller con){
        this.con = con;

        setSize(800,600);
        setLocationRelativeTo(null);//居中
        setTitle("登录界面");//标题
        setResizable(false);//窗口大小锁死
//        setDefaultCloseOperation(EXIT_ON_CLOSE);//点×退出游戏进程

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//点×的时候什么都不干
        //窗口自己不管理关闭 交给监听管理

        //注册窗口监听器实例化和注册
        GameWinLis winLis = new GameWinLis();
        addWindowListener(winLis);

        //将中层部分加入
        loginPanel = new LoginPanel(con);//等价于this.loginPanel = new LoginPanel(con);
        add(loginPanel);


        //添加
        loginBar.add(menu1);
        loginBar.add(menu2);
        menu1.add(item1);
        menu1.add(item2);
        menu2.add(secondItem1);
        menu2.add(secondItem2);
        setJMenuBar(loginBar);

        //为了给菜单安装监听 JFrame里面也要实例化监听器
        LoginActLis loginForGame = new LoginActLis(con,loginPanel);
        secondItem1.addActionListener(loginForGame);
        secondItem1.setActionCommand("关于游戏");

        LoginActLis loginForAuthor = new LoginActLis(con,loginPanel);
        secondItem2.addActionListener(loginForAuthor);
        secondItem2.setActionCommand("关于作者");

        LoginActLis logonActLis = new LoginActLis(con,loginPanel);
        item2.addActionListener(logonActLis);
        item2.setActionCommand("注册");
        setVisible(true);

    }
}
