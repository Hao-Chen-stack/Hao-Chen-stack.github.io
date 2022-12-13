package view.game;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class GameRightPanelBottom extends JPanel {
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,20);
    public JLabel nowNameLabel = new JLabel("NONAME");
    public JLabel label1 = new JLabel("该关击毁坦克：");
    public JLabel label2 = new JLabel("0");
    public JLabel label3 = new JLabel("该关得分：");
    public JLabel label4 = new JLabel("0");
    public JLabel label5 = new JLabel("总共击毁坦克：");
    public JLabel label6 = new JLabel("0");
    public JLabel label7 = new JLabel("总共得分：");
    public JLabel label8 = new JLabel("0");
//    public JLabel nowLevelLabel = new JLabel("当前关卡为：");
//    public JLabel label9 = new JLabel("0");
    public GameRightPanelBottom(Controller con){
        this.con = con;

        setLayout(null);
        setBackground(new Color(250,235,215));
        setPreferredSize(new Dimension(270,250));

        add(nowNameLabel);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);
//        add(label9);
//        add(nowLevelLabel);

        nowNameLabel.setFont(font);
        nowNameLabel.setForeground(new Color(178,34,34));
        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        label6.setFont(font);
        label7.setFont(font);
        label8.setFont(font);
//        label9.setFont(font);
//        nowLevelLabel.setFont(font);

        nowNameLabel.setBounds(20,20,150,20);
        label1.setBounds(20,60,150,20);
        label2.setBounds(170,60,150,20);
        label3.setBounds(20,100,150,20);
        label4.setBounds(170,100,150,20);
        label5.setBounds(20,140,150,20);
        label6.setBounds(170,140,150,20);
        label7.setBounds(20,180,150,20);
        label8.setBounds(170,180,150,20);
//        nowLevelLabel.setBounds(20,220,150,20);
//        label9.setBounds(170,220,150,20);
    }
}
