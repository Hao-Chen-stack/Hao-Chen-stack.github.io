package view.game;

import controller.Controller;
import controller.GameActLis;
import model.Data;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    public JButton btn1;
    public JButton btn2;
    public GameOverPanel(Controller con){
        this.con = con;
        setLayout(null);//自由布局
//        btn1 = new JButton("重新开始");
        btn2 = new JButton("结束游戏");
//        add(btn1);
        add(btn2);

//        btn1.setFont(font);
        btn2.setFont(font);
//        btn1.setBounds(150,400,150,50);
        btn2.setBounds(450,400,150,50);

        GameActLis gameActLis = new GameActLis(con);
//        btn1.addActionListener(gameActLis);
//        btn1.setActionCommand("restart");
        btn2.addActionListener(gameActLis);
        btn2.setActionCommand("exit");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Data.GAME_OVER,0,0,800,600,null);
    }
}
