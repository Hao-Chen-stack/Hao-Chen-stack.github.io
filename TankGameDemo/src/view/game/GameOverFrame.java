package view.game;

import controller.Controller;
import controller.GameWindowLis;

import javax.swing.*;

public class GameOverFrame extends JFrame {
    public Controller con;
    public GameOverPanel gameOverPanel;
    public GameOverFrame(Controller con){
        this.con = con;
        setSize(800,600);
        setLocationRelativeTo(null);//居中
        setTitle("游戏设置");
        setResizable(false);//窗口锁死无法拉动大小
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//点×的时候关闭窗口不结束进程

        gameOverPanel = new GameOverPanel(con);
        add(gameOverPanel);

//        注册窗口监听器实例化和注册
        GameWindowLis winLis = new GameWindowLis();
        addWindowListener(winLis);

//        setVisible(true);
//
    }
}
