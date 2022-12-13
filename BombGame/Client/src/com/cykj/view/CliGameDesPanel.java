package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.model.Data;

import javax.swing.*;
import java.awt.*;

public class CliGameDesPanel extends JPanel {
    public CliController con;
    public CliGameDesPanel(CliController con){
        this.con = con;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(Data.GAME_REC,0,0,800,600,null);
    }
}
