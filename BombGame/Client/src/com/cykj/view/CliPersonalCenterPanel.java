package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.controller.CliPersonalCenterActLis;
import com.cykj.model.Data;

import javax.swing.*;
import java.awt.*;

public class CliPersonalCenterPanel extends JPanel {
    public CliController con;
    private Icon p1Icon;
    private Icon p2Icon;
    private Icon p3Icon;
    private Icon p4Icon;
    private Icon p5Icon;
    private Icon p6Icon;
    private Icon p7Icon;
    private Icon p8Icon;
//    private Icon playIcon;
    public JButton p1Btn;
    public JButton p2Btn;
    public JButton p3Btn;
    public JButton p4Btn;
    public JButton p5Btn;
    public JButton p6Btn;
    public JButton p7Btn;
    public JButton p8Btn;
    //不同人物的皮肤组件选择
    //帽子
    public JButton hat1_Btn;
    public JButton hat2_Btn;
    public JButton hat3_Btn;
    //衣服
    public JButton dress1_Btn;
    public JButton dress2_Btn;
    public JButton dress3_Btn;

    //开始游戏和返回大厅
    public JButton startGameBtn;
    public JButton returnCenterBtn;

//    public JButton playBtn;
    public int num = 1;//用来控制不同人物的跳转
    public int hitNum = 0;
//    public int hit2Num = 1;
//    public int hit3Num = 1;
    public int dressNum = 0;
//    public int dress2Num = 1;
//    public int dress3Num = 1;

    public CliPersonalCenterPanel(CliController con){
        this.con = con;
        setLayout(null);

        //人物头像选择
        String p1HeadPath = "Client/image/P1.png";
        String p2HeadPath = "Client/image/P2.png";
        String p3HeadPath = "Client/image/P3.png";
        String p4HeadPath = "Client/image/P4.png";
        String p5HeadPath = "Client/image/P5.png";
        String p6HeadPath = "Client/image/P6.png";
        String p7HeadPath = "Client/image/P7.png";
        String p8HeadPath = "Client/image/P8.png";

        p1Icon = new ImageIcon(p1HeadPath);
        p2Icon = new ImageIcon(p2HeadPath);
        p3Icon = new ImageIcon(p3HeadPath);
        p4Icon = new ImageIcon(p4HeadPath);
        p5Icon = new ImageIcon(p5HeadPath);
        p6Icon = new ImageIcon(p6HeadPath);
        p7Icon = new ImageIcon(p7HeadPath);
        p8Icon = new ImageIcon(p8HeadPath);

        p1Btn = new JButton(p1Icon);
        p2Btn = new JButton(p2Icon);
        p3Btn = new JButton(p3Icon);
        p4Btn = new JButton(p4Icon);
        p5Btn = new JButton(p5Icon);
        p6Btn = new JButton(p6Icon);
        p7Btn = new JButton(p7Icon);
        p8Btn = new JButton(p8Icon);

        p1Btn.setBounds(80,60,70,70);
        p2Btn.setBounds(160,60,70,70);
        p3Btn.setBounds(240,60,70,70);
        p4Btn.setBounds(320,60,70,70);
        p5Btn.setBounds(400,60,70,70);
        p6Btn.setBounds(480,60,70,70);
        p7Btn.setBounds(560,60,70,70);
        p8Btn.setBounds(640,60,70,70);


        //按钮透明
        p1Btn.setContentAreaFilled(false);
        p2Btn.setContentAreaFilled(false);
        p3Btn.setContentAreaFilled(false);
        p4Btn.setContentAreaFilled(false);
        p5Btn.setContentAreaFilled(false);
        p6Btn.setContentAreaFilled(false);
        p7Btn.setContentAreaFilled(false);
        p8Btn.setContentAreaFilled(false);

        add(p1Btn);
        add(p2Btn);
        add(p3Btn);
        add(p4Btn);
        add(p5Btn);
        add(p6Btn);
        add(p7Btn);
        add(p8Btn);

        //不同人物的皮肤组件选择
        //帽子
        hat1_Btn = new JButton();
        hat2_Btn = new JButton();
        hat3_Btn = new JButton();
        hat1_Btn.setBounds(250,270,80,80);
        hat2_Btn.setBounds(365,270,80,80);
        hat3_Btn.setBounds(470,270,80,80);
        hat1_Btn.setContentAreaFilled(false);//按钮透明
        hat2_Btn.setContentAreaFilled(false);//按钮透明
        hat3_Btn.setContentAreaFilled(false);//按钮透明
        add(hat1_Btn);
        add(hat2_Btn);
        add(hat3_Btn);

        //衣服
        dress1_Btn = new JButton();
        dress2_Btn = new JButton();
        dress3_Btn = new JButton();
        dress1_Btn.setBounds(250,420,80,80);
        dress2_Btn.setBounds(365,420,80,80);
        dress3_Btn.setBounds(470,420,80,80);
        dress1_Btn.setContentAreaFilled(false);//按钮透明
        dress2_Btn.setContentAreaFilled(false);//按钮透明
        dress3_Btn.setContentAreaFilled(false);//按钮透明
        add(dress1_Btn);
        add(dress2_Btn);
        add(dress3_Btn);


        //开始游戏和返回大厅
        startGameBtn = new JButton();
        startGameBtn.setBounds(37,470,150,60);
        startGameBtn.setContentAreaFilled(false);//按钮透明
        add(startGameBtn);

        returnCenterBtn = new JButton();
        returnCenterBtn.setBounds(577,468,150,60);
        returnCenterBtn.setContentAreaFilled(false);//按钮透明
        add(returnCenterBtn);



        //人物选择
//        String playPath = "Client/image/PP"+num+".png";
//        playIcon = new ImageIcon(playPath);
//        playBtn = new JButton(playIcon);
//        playBtn.setBounds(40,200,175,230);
//        playBtn.setContentAreaFilled(false);
//        add(playBtn);

        //监听的注册和安装
        CliPersonalCenterActLis personalCenterActLis = new CliPersonalCenterActLis(con);
        p1Btn.addActionListener(personalCenterActLis);
        p2Btn.addActionListener(personalCenterActLis);
        p3Btn.addActionListener(personalCenterActLis);
        p4Btn.addActionListener(personalCenterActLis);
        p5Btn.addActionListener(personalCenterActLis);
        p6Btn.addActionListener(personalCenterActLis);
        p7Btn.addActionListener(personalCenterActLis);
        p8Btn.addActionListener(personalCenterActLis);
        p1Btn.setActionCommand("p1");
        p2Btn.setActionCommand("p2");
        p3Btn.setActionCommand("p3");
        p4Btn.setActionCommand("p4");
        p5Btn.setActionCommand("p5");
        p6Btn.setActionCommand("p6");
        p7Btn.setActionCommand("p7");
        p8Btn.setActionCommand("p8");

        hat1_Btn.addActionListener(personalCenterActLis);
        hat2_Btn.addActionListener(personalCenterActLis);
        hat3_Btn.addActionListener(personalCenterActLis);
        dress1_Btn.addActionListener(personalCenterActLis);
        dress2_Btn.addActionListener(personalCenterActLis);
        dress3_Btn.addActionListener(personalCenterActLis);
        hat1_Btn.setActionCommand("hat1");
        hat2_Btn.setActionCommand("hat2");
        hat3_Btn.setActionCommand("hat3");
        dress1_Btn.setActionCommand("dress1");
        dress2_Btn.setActionCommand("dress2");
        dress3_Btn.setActionCommand("dress3");

        //开始游戏和返回大厅的监听
        startGameBtn.addActionListener(personalCenterActLis);
        startGameBtn.setActionCommand("startGame");
        returnCenterBtn.addActionListener(personalCenterActLis);
        returnCenterBtn.setActionCommand("returnCenter");

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(Data.USER_ANS_BG,-85,-80,960,730,null);
        if (num ==1){
            g.drawImage(Data.PP1,-210,0,710,599,null);
            g.drawImage(Data.PP1_HAT_1,210,230,160,160,null);
            g.drawImage(Data.PP1_HAT_2,345,260,120,120,null);
            g.drawImage(Data.PP1_HAT_3,455,255,120,120,null);
            g.drawImage(Data.PP1_DRESS_1,210,395,170,130,null);
            g.drawImage(Data.PP1_DRESS_2,322,395,170,130,null);
            g.drawImage(Data.PP1_DRESS_3,430,400,170,130,null);
            if (hitNum ==1){
                g.drawImage(Data.PP1_HAT_1,30,150,200,160,null);
            }else if (hitNum ==2){
                g.drawImage(Data.PP1_HAT_2,20,180,230,130,null);
            }else if (hitNum ==3){
                g.drawImage(Data.PP1_HAT_3,20,180,230,130,null);
            }
            if (dressNum ==1){
                g.drawImage(Data.PP1_DRESS_1,42,285,170,130,null);
            }else if (dressNum ==2){
                g.drawImage(Data.PP1_DRESS_2,65,295,130,120,null);
            }else if (dressNum ==3){
                g.drawImage(Data.PP1_DRESS_3,65,315,130,100,null);
            }
        }else if (num ==2){
            g.drawImage(Data.PP2,-210,0,710,599,null);
            g.drawImage(Data.PP2_DRESS_2,210,395,170,130,null);
            g.drawImage(Data.PP2_DRESS_3,312,385,190,160,null);
            g.drawImage(Data.PP2_DRESS_4,430,400,170,130,null);
            if (dressNum ==1){
                g.drawImage(Data.PP2_DRESS_2,28,285,212,155,null);
            }else if (dressNum ==2){
                g.drawImage(Data.PP2_DRESS_3,-10,250,280,220,null);
            }else if (dressNum ==3){
                g.drawImage(Data.PP2_DRESS_4,-2,250,275,225,null);
            }
        }else if (num ==3){
            g.drawImage(Data.PP3,-160,30,630,560,null);
            g.drawImage(Data.PP3_HAT_1,210,230,160,160,null);
            g.drawImage(Data.PP3_HAT_2,345,260,120,120,null);
            g.drawImage(Data.PP3_HAT_3,445,245,120,120,null);
            g.drawImage(Data.PP3_DRESS_1,210,395,170,130,null);
            g.drawImage(Data.PP3_DRESS_2,322,395,170,130,null);
            g.drawImage(Data.PP3_DRESS_3,425,400,170,130,null);
            if (hitNum ==1){
                g.drawImage(Data.PP3_HAT_1,30,150,200,160,null);
            }else if (hitNum ==2){
                g.drawImage(Data.PP3_HAT_2,20,180,230,130,null);
            }else if (hitNum ==3){
                g.drawImage(Data.PP3_HAT_3,20,180,230,130,null);
            }
            if (dressNum ==1){
                g.drawImage(Data.PP3_DRESS_1,25,285,212,155,null);
            }else if (dressNum ==2){
                g.drawImage(Data.PP3_DRESS_2,40,320,180,100,null);
            }else if (dressNum ==3){
                g.drawImage(Data.PP3_DRESS_3,40,320,180,100,null);
            }
        }else if (num ==4){
            g.drawImage(Data.PP4,-210,0,710,599,null);
            g.drawImage(Data.PP4_HAT_1,230,250,120,120,null);
            g.drawImage(Data.PP4_HAT_2,345,240,120,120,null);
            g.drawImage(Data.PP4_DRESS_1,210,395,170,130,null);
            g.drawImage(Data.PP4_DRESS_2,322,395,170,130,null);
            g.drawImage(Data.PP4_DRESS_3,450,400,130,120,null);
            if (hitNum ==1){
                g.drawImage(Data.PP4_HAT_1,30,150,200,160,null);
            }else if (hitNum ==2){
                g.drawImage(Data.PP4_HAT_2,30,150,220,160,null);
            }
            if (dressNum ==1){
                g.drawImage(Data.PP4_DRESS_1,25,285,212,155,null);
            }else if (dressNum ==2){
                g.drawImage(Data.PP4_DRESS_2,40,320,180,100,null);
            }else if (dressNum ==3){
                g.drawImage(Data.PP4_DRESS_3,70,320,150,110,null);
            }
        }else if (num ==5){
            g.drawImage(Data.PP5,-210,0,690,599,null);
            g.drawImage(Data.PP5_HAT_1,210,230,160,160,null);
            g.drawImage(Data.PP5_HAT_2,345,260,120,120,null);
            g.drawImage(Data.PP5_HAT_3,455,255,120,120,null);
            g.drawImage(Data.PP5_DRESS_1,210,395,170,130,null);
            g.drawImage(Data.PP5_DRESS_2,322,395,170,130,null);
            g.drawImage(Data.PP5_DRESS_3,430,400,170,130,null);
            if (hitNum ==1){
                g.drawImage(Data.PP5_HAT_1,30,150,200,160,null);
            }else if (hitNum ==2){
                g.drawImage(Data.PP5_HAT_2,30,170,220,160,null);
            }else if (hitNum ==3){
                g.drawImage(Data.PP5_HAT_3,20,170,220,160,null);
            }
            if (dressNum ==1){
                g.drawImage(Data.PP5_DRESS_1,25,285,212,155,null);
            }else if (dressNum ==2){
                g.drawImage(Data.PP5_DRESS_2,40,300,180,100,null);
            }else if (dressNum ==3){
                g.drawImage(Data.PP5_DRESS_3,20,275,212,155,null);
            }
        }else if (num ==6){
            g.drawImage(Data.PP6,-210,0,710,599,null);
            g.drawImage(Data.PP6_HAT_1,225,250,140,140,null);
            g.drawImage(Data.PP6_HAT_2,345,260,120,120,null);
            g.drawImage(Data.PP6_HAT_3,455,255,120,120,null);
            g.drawImage(Data.PP6_DRESS_1,210,405,170,130,null);
            g.drawImage(Data.PP6_DRESS_2,322,395,170,130,null);
            g.drawImage(Data.PP6_DRESS_3,430,400,170,130,null);
            if (hitNum == 1){
                g.drawImage(Data.PP6_HAT_1,25,180,230,160,null);
            }else if (hitNum == 2){
                g.drawImage(Data.PP6_HAT_2,30,170,220,160,null);
            }else if (hitNum == 3){
                g.drawImage(Data.PP6_HAT_3,20,180,230,160,null);
            }
            if (dressNum == 1){
                g.drawImage(Data.PP6_DRESS_1,33,300,200,143,null);
            }else if (dressNum == 2){
                g.drawImage(Data.PP6_DRESS_2,50,310,180,100,null);
            }else if (dressNum ==3){
                g.drawImage(Data.PP6_DRESS_3,38,290,212,155,null);
            }
        }else if (num ==7){
            g.drawImage(Data.PP7,-210,0,680,599,null);
            g.drawImage(Data.PP7_HAT_1,225,250,140,140,null);
            g.drawImage(Data.PP7_DRESS_1,210,405,170,130,null);
            g.drawImage(Data.PP7_DRESS_2,322,395,170,130,null);
            g.drawImage(Data.PP7_DRESS_3,430,400,170,130,null);
            if (hitNum == 1){
                g.drawImage(Data.PP7_HAT_1,15,180,230,160,null);
            }
            if (dressNum == 1){
                g.drawImage(Data.PP7_DRESS_1,50,300,150,135,null);
            }else if (dressNum ==2){
                g.drawImage(Data.PP7_DRESS_2,35,280,180,135,null);
            }else if (dressNum ==3){
                g.drawImage(Data.PP7_DRESS_3,60,310,130,115,null);
            }
        }else if (num ==8){
            g.drawImage(Data.PP8,-230,20,710,599,null);
            g.drawImage(Data.PP8_HAT_2,345,260,120,120,null);
            g.drawImage(Data.PP8_HAT_3,445,255,120,120,null);
            g.drawImage(Data.PP8_DRESS_1,210,395,170,130,null);
            g.drawImage(Data.PP8_DRESS_2,322,395,170,130,null);
            g.drawImage(Data.PP8_DRESS_3,430,400,170,130,null);
            if (hitNum ==2){
                g.drawImage(Data.PP8_HAT_2,-30,190,300,200,null);
            }else if (hitNum ==3){
                g.drawImage(Data.PP8_HAT_3,-20,180,300,200,null);
            }
            if (dressNum ==1){
                g.drawImage(Data.PP8_DRESS_1,-25,220,300,300,null);
            }else if (dressNum ==2){
                g.drawImage(Data.PP8_DRESS_2,30,270,190,220,null);
            }else if (dressNum ==3){
                g.drawImage(Data.PP8_DRESS_3,30,300,180,135,null);
            }
        }
    }



    public Icon getP1Icon() {
        return p1Icon;
    }

    public void setP1Icon(Icon p1Icon) {
        this.p1Icon = p1Icon;
    }

    public Icon getP2Icon() {
        return p2Icon;
    }

    public void setP2Icon(Icon p2Icon) {
        this.p2Icon = p2Icon;
    }

    public Icon getP3Icon() {
        return p3Icon;
    }

    public void setP3Icon(Icon p3Icon) {
        this.p3Icon = p3Icon;
    }

    public Icon getP4Icon() {
        return p4Icon;
    }

    public void setP4Icon(Icon p4Icon) {
        this.p4Icon = p4Icon;
    }

    public Icon getP5Icon() {
        return p5Icon;
    }

    public void setP5Icon(Icon p5Icon) {
        this.p5Icon = p5Icon;
    }

    public Icon getP6Icon() {
        return p6Icon;
    }

    public void setP6Icon(Icon p6Icon) {
        this.p6Icon = p6Icon;
    }

    public Icon getP7Icon() {
        return p7Icon;
    }

    public void setP7Icon(Icon p7Icon) {
        this.p7Icon = p7Icon;
    }

    public Icon getP8Icon() {
        return p8Icon;
    }

    public void setP8Icon(Icon p8Icon) {
        this.p8Icon = p8Icon;
    }
}
