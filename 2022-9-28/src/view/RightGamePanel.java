package view;

import javax.swing.*;
import java.awt.*;

public class RightGamePanel extends JPanel {
    public Font font = new Font("宋体",Font.PLAIN,20);
    public JLabel label1 = new JLabel("欢迎玩家：1");
    public JLabel label2 = new JLabel("地鼠第1次出现");
    public JLabel timeLabel = new JLabel("游戏倒计时：");
    public JLabel label4 = new JLabel("30秒");
    public JLabel label5 = new JLabel("击中数：");
    public JLabel label6 = new JLabel("00次");
    public JLabel label7 = new JLabel("得分数：");
    public JLabel label8 = new JLabel("00分");
    public RightGamePanel(){
        setLayout(null);
        setBackground(new Color(0,0,0));


        label1.setFont(font);
        label2.setFont(font);
        timeLabel.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        label6.setFont(font);
        label7.setFont(font);
        label8.setFont(font);

        label1.setForeground(new Color(0,255,0));
        label2.setForeground(new Color(0,255,0));
        timeLabel.setForeground(new Color(0,255,0));
        label4.setForeground(new Color(0,255,0));
        label5.setForeground(new Color(0,255,0));
        label6.setForeground(new Color(0,255,0));
        label7.setForeground(new Color(0,255,0));
        label8.setForeground(new Color(0,255,0));

        add(label1);
        add(label2);
        add(timeLabel);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);

        label1.setBounds(10,50,150,20);
        label2.setBounds(10,90,150,20);
        timeLabel.setBounds(10,130,150,20);
        label4.setBounds(150,130,150,20);
        label5.setBounds(10,170,150,20);
        label6.setBounds(110,170,150,20);
        label7.setBounds(10,210,150,20);
        label8.setBounds(110,210,150,20);

        setPreferredSize(new Dimension(224,0));

    }
}
