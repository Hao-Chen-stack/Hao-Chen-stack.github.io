package view.game;

import controller.Controller;
import controller.GameActLis;
import controller.GameCustomActLis;

import javax.swing.*;
import java.awt.*;

public class GameCustomPanel extends JPanel {
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    public JRadioButton rad1 = new JRadioButton("单人游戏");
    public JRadioButton rad2 = new JRadioButton("双人游戏");
    public JRadioButton rad3 = new JRadioButton("正常游戏");
    public JRadioButton rad4 = new JRadioButton("自选游戏");
    public JLabel label1 = new JLabel("请选择关数：");
    public JComboBox status1 = new JComboBox(); //创建一个下拉框
    public JLabel label2 = new JLabel("坦克速度：");
    public JComboBox status2 = new JComboBox();
    public JLabel label3 = new JLabel("子弹速度：");
    public JComboBox status3 = new JComboBox();
    public ButtonGroup buttonGroup1 = new ButtonGroup();//创建一个单选按钮组，实现单选的功能，由于单选框要实现只能选择一个，所以要创建一个组（分组），一个组中只能选择一个
    public ButtonGroup buttonGroup2 = new ButtonGroup();//创建一个单选按钮组，实现单选的功能，由于单选框要实现只能选择一个，所以要创建一个组（分组），一个组中只能选择一个
    public JLabel label4 = new JLabel("坦克数量(10-50):");
    public JTextField jTextField = new JTextField("");
//    public JCheckBox c1 = new JCheckBox("继续游戏");
//    public JCheckBox c2 = new JCheckBox("出现关底");
    public JButton btn1 = new JButton("确定");
    public JButton btn2 = new JButton("取消");
    public GameCustomPanel(Controller con){
        this.con = con;
        setLayout(null);//自由布局
        setBackground(new Color(250,235,215));
        //顶部单选按钮
        add(rad1);
        add(rad2);
        add(rad3);
        add(rad4);
        buttonGroup1.add(rad1);
        buttonGroup1.add(rad2);
        buttonGroup2.add(rad3);
        buttonGroup2.add(rad4);
        rad1.setFont(font);
        rad2.setFont(font);
        rad3.setFont(font);
        rad4.setFont(font);
        rad1.setBounds(40,40,150,50);
        rad2.setBounds(200,40,150,50);
        rad3.setBounds(40,80,150,50);
        rad4.setBounds(200,80,150,50);

        rad1.setSelected(true);
        rad3.setSelected(true);

        GameActLis gameActLis = new GameActLis(con);
        rad1.addActionListener(gameActLis);
        rad2.addActionListener(gameActLis);
        rad3.addActionListener(gameActLis);
        rad4.addActionListener(gameActLis);
        btn1.addActionListener(gameActLis);
        btn2.addActionListener(gameActLis);
        btn1.setActionCommand("is");
        btn2.setActionCommand("no");
        rad1.setActionCommand("rad1");
        rad2.setActionCommand("rad2");
        rad3.setActionCommand("rad3");
        rad4.setActionCommand("rad4");


        //自选游戏按钮的下拉框和文本框
        add(label1);
        add(status1);
        GameCustomActLis gameCustomActLis = new GameCustomActLis(con);
        status1.addActionListener(gameCustomActLis);
        status1.setActionCommand("comboBoxNextLevel");
        status1.addItem("1");
        status1.addItem("2");
        status1.addItem("3");
        status1.addItem("4");
        status1.addItem("5");
        status1.addItem("6");
        status1.addItem("7");
        status1.addItem("8");

        add(label2);
        add(status2);
        status2.addItem("1");
        status2.addItem("2");
        status2.addItem("3");

        add(label3);
        add(status3);
        status3.addItem("1");
        status3.addItem("2");
        status3.addItem("3");

        add(label4);
        add(jTextField);
//        add(c1);
//        add(c2);

        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
//        c1.setFont(font);
//        c2.setFont(font);
//        label4.setFont(font);
//        jTextField.setFont(font);

        label1.setBounds(40,130,150,50);
        status1.setBounds(180,140,100,30);
        label2.setBounds(40,175,150,50);
        status2.setBounds(160,185,100,30);
        label3.setBounds(40,215,150,50);
        status3.setBounds(160,225,100,30);
        label4.setBounds(40,255,200,50);
        jTextField.setBounds(150,265,50,30);
//        c1.setBounds(40,320,150,50);
//        c2.setBounds(200,320,150,50);


        //底部按钮
        add(btn1);
        add(btn2);
        btn1.setFont(font);
        btn2.setFont(font);
        btn1.setBounds(40,400,100,50);
        btn2.setBounds(200,400,100,50);
    }
}
