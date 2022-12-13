package com.cykj.view.game;

import com.cykj.Thread.CliReadThread;
import com.cykj.controller.CliController;
import com.cykj.model.Data;

import javax.swing.*;
import java.awt.*;

public class GameRightPanel extends JPanel {
    public CliController con;
    public JLabel masterLabel;
    public JLabel playerLabel;
    public GameRightPanel(CliController con) {
        this.con = con;
        setPreferredSize(new Dimension(265,600));
        setLayout(null);
        masterLabel = new JLabel("房主当前血量为"+CliReadThread.master.getBlood());
        masterLabel.setBounds(110,60,200,80);
        add(masterLabel);

        playerLabel = new JLabel("当前血量为"+CliReadThread.player.getBlood());
        playerLabel.setBounds(110,160,200,80);
        add(playerLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Data.GAME_RIGHT_BG,0,0,265,750,null);
    }
}
