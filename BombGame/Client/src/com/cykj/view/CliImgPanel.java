package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.controller.CliImgActLis;

import javax.swing.*;
import java.awt.*;

public class CliImgPanel extends JPanel {
    public CliController con;
    private Icon icon;
    private JButton allImgBtn;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public JButton getAllImgBtn() {
        return allImgBtn;
    }

    public void setAllImgBtn(JButton allImgBtn) {
        this.allImgBtn = allImgBtn;
    }

    public CliImgPanel(CliController con){
        this.con = con;
        setLayout(new GridLayout(5,15));
        CliImgActLis imgActLis = new CliImgActLis(con);
        for (int i = 1; i <=30; i++) {
            String allImg ="Client/image/"+i+".gif";
            icon=new ImageIcon(allImg);
            allImgBtn=new JButton(icon);
            add(allImgBtn);
            allImgBtn.addActionListener(imgActLis);
            allImgBtn.setActionCommand(i+"");
        }


//        for (int i = 1; i <=30; i++) {
//            String a ="1";
//            if (a.equals(i+""))
//            {
//                System.out.println(i+"");
//            }
//        }


//        ImageIcon icon = new ImageIcon("Client/image/1.gif");
//        ImageIcon icon2 = new ImageIcon("Client/image/2.gif");
//        ImageIcon icon3 = new ImageIcon("Client/image/3.gif");
//        ImageIcon icon4 = new ImageIcon("Client/image/4.gif");
//        ImageIcon icon5 = new ImageIcon("Client/image/5.gif");
//        ImageIcon icon6 = new ImageIcon("Client/image/6.gif");
//        ImageIcon icon7 = new ImageIcon("Client/image/7.gif");
//        ImageIcon icon8 = new ImageIcon("Client/image/8.gif");
//        ImageIcon icon9 = new ImageIcon("Client/image/9.gif");
//        ImageIcon icon10 = new ImageIcon("Client/image/10.gif");
//        ImageIcon icon11 = new ImageIcon("Client/image/11.gif");
//        ImageIcon icon12 = new ImageIcon("Client/image/12.gif");
//        ImageIcon icon13 = new ImageIcon("Client/image/13.gif");
//        ImageIcon icon14 = new ImageIcon("Client/image/14.gif");
//        ImageIcon icon15 = new ImageIcon("Client/image/15.gif");
//        ImageIcon icon16 = new ImageIcon("Client/image/16.gif");
//        ImageIcon icon17 = new ImageIcon("Client/image/17.gif");
//        ImageIcon icon18 = new ImageIcon("Client/image/18.gif");
//        ImageIcon icon19 = new ImageIcon("Client/image/19.gif");
//        ImageIcon icon20 = new ImageIcon("Client/image/20.gif");
//        ImageIcon icon21 = new ImageIcon("Client/image/21.gif");
//        ImageIcon icon22 = new ImageIcon("Client/image/22.gif");
//        ImageIcon icon23 = new ImageIcon("Client/image/23.gif");
//        ImageIcon icon24 = new ImageIcon("Client/image/24.gif");
//        ImageIcon icon25 = new ImageIcon("Client/image/25.gif");
//        ImageIcon icon26 = new ImageIcon("Client/image/26.gif");
//        ImageIcon icon27 = new ImageIcon("Client/image/27.gif");
//        ImageIcon icon28 = new ImageIcon("Client/image/28.gif");
//        ImageIcon icon29 = new ImageIcon("Client/image/29.gif");
//        ImageIcon icon30 = new ImageIcon("Client/image/30.gif");
//        JLabel label = new JLabel(icon);
//        JLabel label2 = new JLabel(icon2);
//        JLabel label3 = new JLabel(icon3);
//        JLabel label4 = new JLabel(icon4);
//        JLabel label5 = new JLabel(icon5);
//        JLabel label6 = new JLabel(icon6);
//        JLabel label7 = new JLabel(icon7);
//        JLabel label8 = new JLabel(icon8);
//        JLabel label9 = new JLabel(icon9);
//        JLabel label10 = new JLabel(icon10);
//        JLabel label11 = new JLabel(icon11);
//        JLabel label12 = new JLabel(icon12);
//        JLabel label13 = new JLabel(icon13);
//        JLabel label14 = new JLabel(icon14);
//        JLabel label15 = new JLabel(icon15);
//        JLabel label16 = new JLabel(icon16);
//        JLabel label17 = new JLabel(icon17);
//        JLabel label18 = new JLabel(icon18);
//        JLabel label19 = new JLabel(icon19);
//        JLabel label20 = new JLabel(icon20);
//        JLabel label21 = new JLabel(icon21);
//        JLabel label22 = new JLabel(icon22);
//        JLabel label23 = new JLabel(icon23);
//        JLabel label24 = new JLabel(icon24);
//        JLabel label25 = new JLabel(icon25);
//        JLabel label26 = new JLabel(icon26);
//        JLabel label27 = new JLabel(icon27);
//        JLabel label28 = new JLabel(icon28);
//        JLabel label29 = new JLabel(icon29);
//        JLabel label30 = new JLabel(icon30);
//        add(label);
//        add(label2);
//        add(label3);
//        add(label4);
//        add(label5);
//        add(label6);
//        add(label7);
//        add(label8);
//        add(label9);
//        add(label10);
//        add(label11);
//        add(label12);
//        add(label13);
//        add(label14);
//        add(label15);
//        add(label16);
//        add(label17);
//        add(label18);
//        add(label19);
//        add(label20);
//        add(label21);
//        add(label22);
//        add(label23);
//        add(label24);
//        add(label25);
//        add(label26);
//        add(label27);
//        add(label28);
//        add(label29);
//        add(label30);

//        label.addAncestorListener(imgActLis);
    }
}
