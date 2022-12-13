package view.game;

import controller.Controller;
import controller.GameWindowLis;

import javax.swing.*;

public class GameLeaderFrame extends JFrame {
    public Controller con;
    public GameLeaderPanel gameLeaderPanel;
    public GameLeaderFrame(Controller con){
        this.con = con;
        setSize(600,500);
        setLocationRelativeTo(null);//居中
        setTitle("统计分数");
        setResizable(false);//窗口锁死无法拉动大小
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//点×的时候什么都不干
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//点×关闭当前窗口

        gameLeaderPanel = new GameLeaderPanel(con);
        add(gameLeaderPanel);

        //注册窗口监听器实例化和注册
        GameWindowLis winLis = new GameWindowLis();
        addWindowListener(winLis);

//        setVisible(true);
    }
}
