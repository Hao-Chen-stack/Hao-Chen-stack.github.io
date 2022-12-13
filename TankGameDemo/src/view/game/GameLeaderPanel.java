package view.game;

import controller.Controller;
import controller.GameActLis;

import javax.swing.*;
import java.awt.*;

public class GameLeaderPanel extends JPanel {
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,20);
    public JLabel label1 = new JLabel("stage  1");
    public JLabel imgLabel2 = new JLabel(new ImageIcon("image/tankbai.jpg"));
    public JLabel label2 = new JLabel("14");
    public JLabel label2N = new JLabel("X   100 =");
    public JLabel label2Sum = new JLabel("1400");

    public JLabel imgLabel3 = new JLabel(new ImageIcon("image/tankhuangup.jpg"));
    public JLabel label3 = new JLabel("4");
    public JLabel label3N = new JLabel("X   200 =");
    public JLabel label3Sum = new JLabel("800");

    public JLabel imgLabel4 = new JLabel(new ImageIcon("image/tanklvup.jpg"));
    public JLabel label4 = new JLabel("1");
    public JLabel label4N = new JLabel("X   200 =");
    public JLabel label4Sum = new JLabel("300");

    public JLabel imgLabel5 = new JLabel(new ImageIcon("image/tankblueup.jpg"));
    public JLabel label5 = new JLabel("1");
    public JLabel label5N = new JLabel("X   300 =");
    public JLabel label5Sum = new JLabel("400");

    public JLabel imgLabel6 = new JLabel(new ImageIcon("image/tankhong.png"));
    public JLabel label6 = new JLabel("0");
    public JLabel label6N = new JLabel("X   500 =");
    public JLabel label6Sum = new JLabel("0");

    public JLabel label7 = new JLabel("--------------------------------------------------------------");
    public JLabel label8 = new JLabel("enemy：");
    public JLabel label8N = new JLabel("20");
    public JLabel label9 = new JLabel("total：");
    public JLabel label9N = new JLabel("2900");
    public JButton btn1 = new JButton("下一关");
    public JButton btn2 = new JButton("重新开始");
    public GameLeaderPanel(Controller con){
        this.con = con;
        setLayout(null);
        setBackground(new Color(0,0,0));
        setPreferredSize(new Dimension(256,256));
        //结算界面第一行
        add(label1);
        add(imgLabel2);
        add(label2);
        add(label2N);
        add(label2Sum);
        label1.setForeground(new Color(0,255,0));
        label2.setForeground(new Color(0,255,0));
        label2N.setForeground(new Color(0,255,0));
        label2Sum.setForeground(new Color(0,255,0));
        label1.setFont(font);
        label2.setFont(font);
        label2N.setFont(font);
        label2Sum.setFont(font);
        label1.setBounds(250,10,150,20);
        imgLabel2.setBounds(40,40,24,24);
        label2.setBounds(150,40,150,20);
        label2N.setBounds(200,40,150,25);
        label2Sum.setBounds(350,40,150,25);

        //结算界面第二行
        add(imgLabel3);
        add(label3);
        add(label3N);
        add(label3Sum);
        label3.setForeground(new Color(0,255,0));
        label3N.setForeground(new Color(0,255,0));
        label3Sum.setForeground(new Color(0,255,0));
        label3.setFont(font);
        label3N.setFont(font);
        label3Sum.setFont(font);
        imgLabel3.setBounds(40,80,24,24);
        label3.setBounds(150,80,150,20);
        label3N.setBounds(200,80,150,25);
        label3Sum.setBounds(350,80,150,25);

        //结算界面第三行
        add(imgLabel4);
        add(label4);
        add(label4N);
        add(label4Sum);
        label4.setForeground(new Color(0,255,0));
        label4N.setForeground(new Color(0,255,0));
        label4Sum.setForeground(new Color(0,255,0));
        label4.setFont(font);
        label4N.setFont(font);
        label4Sum.setFont(font);
        imgLabel4.setBounds(40,120,24,24);
        label4.setBounds(150,120,150,20);
        label4N.setBounds(200,120,150,25);
        label4Sum.setBounds(350,120,150,25);

        //结算界面第四行
        add(imgLabel5);
        add(label5);
        add(label5N);
        add(label5Sum);
        label5.setForeground(new Color(0,255,0));
        label5N.setForeground(new Color(0,255,0));
        label5Sum.setForeground(new Color(0,255,0));
        label5.setFont(font);
        label5N.setFont(font);
        label5Sum.setFont(font);
        imgLabel5.setBounds(40,160,24,24);
        label5.setBounds(150,160,150,20);
        label5N.setBounds(200,160,150,25);
        label5Sum.setBounds(350,160,150,25);

        //结算界面第五行
        add(imgLabel6);
        add(label6);
        add(label6N);
        add(label6Sum);
        label6.setForeground(new Color(0,255,0));
        label6N.setForeground(new Color(0,255,0));
        label6Sum.setForeground(new Color(0,255,0));
        label6.setFont(font);
        label6N.setFont(font);
        label6Sum.setFont(font);
        imgLabel6.setBounds(40,200,24,24);
        label6.setBounds(150,200,150,20);
        label6N.setBounds(200,200,150,25);
        label6Sum.setBounds(350,200,150,25);

        //结算界面第六行
        add(label7);
        label7.setForeground(new Color(0,255,0));
        label7.setFont(font);
        label7.setBounds(0,260,700,20);

        //结算界面第七行
        add(label8);
        add(label8N);
        add(label9);
        add(label9N);
        label8.setForeground(new Color(0,255,0));
        label8N.setForeground(new Color(0,255,0));
        label9.setForeground(new Color(0,255,0));
        label9N.setForeground(new Color(0,255,0));
        label8.setFont(font);
        label8N.setFont(font);
        label9.setFont(font);
        label9N.setFont(font);
        label8.setBounds(40,300,150,25);
        label8N.setBounds(150,300,150,25);
        label9.setBounds(350,300,150,25);
        label9N.setBounds(450,300,150,25);

        //结算界面按钮
        add(btn1);
        add(btn2);
        btn1.setFont(font);
        btn2.setFont(font);
        btn1.setBounds(50,400,150,50);
        btn2.setBounds(350,400,150,50);

        GameActLis gameActLis = new GameActLis(con);
        btn1.addActionListener(gameActLis);
        btn2.addActionListener(gameActLis);
        btn1.setActionCommand("nextLevel");
        btn2.setActionCommand("restart");
    }
}
