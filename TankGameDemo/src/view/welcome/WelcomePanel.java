package view.welcome;

import controller.Controller;
import controller.WelcomeActLis;
import model.Data;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {
    public Controller con;
    public JButton inGameBtn = new JButton("开始游戏");
    public JButton outGameBtn = new JButton("退出游戏");
    public WelcomePanel(Controller con){
        this.con = con;

        setBackground(new Color(132,93,79));
        setLayout(null);
        add(inGameBtn);
        add(outGameBtn);
        inGameBtn.setBounds(320,320,150,50);
        outGameBtn.setBounds(320,380,150,50);

        //进入游戏按钮监听
        WelcomeActLis welcomeActLis = new WelcomeActLis(con);
        inGameBtn.addActionListener(welcomeActLis);
        inGameBtn.setActionCommand("inGame");

        //退出游戏按钮监听
        outGameBtn.addActionListener(welcomeActLis);
        outGameBtn.setActionCommand("outGame");

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Data.WELCOMEBG,0,0,800,600,null);
    }
}
