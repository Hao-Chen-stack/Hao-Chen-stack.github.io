package view.game;

import javax.swing.*;
import java.awt.*;

public class GameRightPanelNormal extends JPanel {
    public Font font = new Font("宋体",Font.PLAIN,20);
    public JLabel label1 = new JLabel("游戏玩法：");
    public JLabel label2 = new JLabel("向上：W");
    public JLabel label3 = new JLabel("向下：S");
    public JLabel label4 = new JLabel("向左：A");
    public JLabel label5 = new JLabel("向右：D");
    public JLabel label6 = new JLabel("发射：J");
    public JLabel label7 = new JLabel("暂停：P");
    public JLabel label8 = new JLabel("继续：C");
    public GameRightPanelNormal(){
        setLayout(null);
        setBackground(new Color(218,165,105));
        setPreferredSize(new Dimension(270,250));

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);

        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        label6.setFont(font);
        label7.setFont(font);
        label8.setFont(font);

        label1.setBounds(20,20,150,20);
        label2.setBounds(20,40,150,20);
        label3.setBounds(20,60,150,20);
        label4.setBounds(20,80,150,20);
        label5.setBounds(20,100,150,20);
        label6.setBounds(20,120,150,20);
        label7.setBounds(20,140,150,20);
        label8.setBounds(20,160,150,20);
    }
}
