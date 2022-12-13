package view;

import controller.Controller;
import controller.GameActLis;
import controller.GameWinLis;

import javax.swing.*;

public class GameFrame extends JFrame {
    public Controller con;
    public GamePanel gamePanel;
    //一级菜单
    public JMenuBar loginBar = new JMenuBar();
    public JMenu menu1 = new JMenu("游戏选项");//一级菜单标题
    //菜单项
    public JMenuItem item1 = new JMenuItem("开始");
    public JMenuItem item2 = new JMenuItem("暂停");
    public JMenuItem item3 = new JMenuItem("重新开始");
    public GameFrame(Controller con){
        this.con = con;

        setSize(1024,760);
        setLocationRelativeTo(null);//居中
        setTitle("打地鼠游戏");//标题
        setResizable(false);//窗口大小锁死
//        setDefaultCloseOperation(EXIT_ON_CLOSE);//点×退出游戏进程

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//点×的时候什么都不干
        //窗口自己不管理关闭 交给监听管理

        //注册窗口监听器实例化和注册
        GameWinLis winLis = new GameWinLis();
        addWindowListener(winLis);

        //游戏选项菜单里的 开始监听实例化和注册 以及定时器
        GameActLis gameActLis = new GameActLis(con);
        JMenuItem startItem = new JMenuItem("开始");
        item1.addActionListener(gameActLis);
        item1.setActionCommand("start");

        JMenuItem  suspendItem = new JMenuItem("暂停");
        item2.addActionListener(gameActLis);
        item2.setActionCommand("suspend");


        JMenuItem restartItem = new JMenuItem("重新开始");
        item3.addActionListener(gameActLis);
        item3.setActionCommand("restart");


        //初始化GamePanel
        gamePanel = new GamePanel(con);
        add(gamePanel);


        //添加
        loginBar.add(menu1);
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        setJMenuBar(loginBar);

//        setVisible(true);
    }

}
