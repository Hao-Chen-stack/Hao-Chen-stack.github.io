package view.login;

import javax.swing.*;
import java.awt.*;

public class RightPanelBottom extends JPanel {
    public Font font = new Font("宋体",Font.PLAIN,20);
    public JLabel label1 = new JLabel("该关击毁坦克：");
    public JLabel label2 = new JLabel("0");
    public JLabel label3 = new JLabel("该关得分：");
    public JLabel label4 = new JLabel("0");
    public JLabel label5 = new JLabel("总共击毁坦克：");
    public JLabel label6 = new JLabel("0");
    public JLabel label7 = new JLabel("总共得分：");
    public JLabel label8 = new JLabel("0");
    public RightPanelBottom(){
        setLayout(null);
        setBackground(new Color(250,235,215));
        setPreferredSize(new Dimension(200,150));

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);

        label1.setBounds(20,40,150,20);
        label2.setBounds(120,40,150,20);
        label3.setBounds(20,60,150,20);
        label4.setBounds(120,60,150,20);
        label5.setBounds(20,80,150,20);
        label6.setBounds(120,80,150,20);
        label7.setBounds(20,100,150,20);
        label8.setBounds(120,100,150,20);

    }


}
