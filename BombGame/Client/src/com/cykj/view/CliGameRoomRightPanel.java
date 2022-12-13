package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.controller.CliGameRoomActLis;
import com.cykj.model.Data;

import javax.swing.*;
import java.awt.*;

public class CliGameRoomRightPanel extends JPanel {
    public CliController con;
    public JButton createRoomBtn;
    public JButton returnCenBtn;
    public CliGameRoomRightPanel(CliController con){
        this.con = con;
        setLayout(null);
//        setBackground(new Color(255,0,0));
        setPreferredSize(new Dimension(280,600));

        createRoomBtn = new JButton();
        createRoomBtn.setBounds(60,330,150,50);
        createRoomBtn.setContentAreaFilled(false);
        add(createRoomBtn);
        returnCenBtn = new JButton();
        returnCenBtn.setBounds(115,455,125,60);
        returnCenBtn.setContentAreaFilled(false);
        add(returnCenBtn);

        //监听的注册和安装
        CliGameRoomActLis gameRoomActLis = new CliGameRoomActLis(con);
        createRoomBtn.addActionListener(gameRoomActLis);
        createRoomBtn.setActionCommand("createRoom");
        returnCenBtn.addActionListener(gameRoomActLis);
        returnCenBtn.setActionCommand("returnCen");

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(Data.PLAYER_SELECT,0,0,280,550,null);
    }
}
