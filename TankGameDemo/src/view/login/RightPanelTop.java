package view.login;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;
import java.awt.*;

public class RightPanelTop extends JPanel {
    public Font font = new Font("宋体",Font.PLAIN,20);
    public JLabel label1 = new JLabel("敌方坦克还有");
    public JLabel imgLabel2 = new JLabel(new ImageIcon("image/tankhong.png"));
    public JLabel label2 = new JLabel("     X 0");

    public JLabel imgLabel3 = new JLabel(new ImageIcon("image/tankhuangup.jpg"));
    public JLabel label3 = new JLabel("     X 0");

    public JLabel imgLabel4 = new JLabel(new ImageIcon("image/tankbaiup.png"));
    public JLabel label4 = new JLabel("     X 0");

    public JLabel imgLabel5 = new JLabel(new ImageIcon("image/tanklvup.jpg"));
    public JLabel label5 = new JLabel("     X 0");

    public JLabel imgLabel6 = new JLabel(new ImageIcon("image/tankblueup.jpg"));
    public JLabel label6 = new JLabel("     X 0");
    public RightPanelTop(){
        setLayout(null);
        setBackground(new Color(0,0,0));
        setPreferredSize(new Dimension(200,250));

        add(label1);
        add(imgLabel2);
        add(label2);
        add(imgLabel3);
        add(label3);
        add(imgLabel4);
        add(label4);
        add(imgLabel5);
        add(label5);
        add(imgLabel6);
        add(label6);

        label1.setForeground(new Color(0,255,0));
        label2.setForeground(new Color(0,255,0));
        label3.setForeground(new Color(0,255,0));
        label4.setForeground(new Color(0,255,0));
        label5.setForeground(new Color(0,255,0));
        label6.setForeground(new Color(0,255,0));

        label1.setBounds(10,10,150,20);
        imgLabel2.setBounds(0,40,24,24);
        label2.setBounds(20,40,150,20);
        imgLabel3.setBounds(0,80,25,25);
        label3.setBounds(20,80,150,20);
        imgLabel4.setBounds(0,120,25,25);
        label4.setBounds(20,120,150,20);
        imgLabel5.setBounds(0,160,25,25);
        label5.setBounds(20,160,150,20);
        imgLabel6.setBounds(0,200,25,25);
        label6.setBounds(20,200,150,20);

    }

}
