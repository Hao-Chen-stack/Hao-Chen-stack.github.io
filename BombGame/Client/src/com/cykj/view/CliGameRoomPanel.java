package com.cykj.view;

import com.cykj.controller.CliController;

import javax.swing.*;
import java.awt.*;

public class CliGameRoomPanel extends JPanel {
    public CliController con;
    public CliGameRoomRightPanel roomRightPanel;
    public CliGameRoomLeftPanel roomLeftPanel;
    public CliGameRoomPanel(CliController con){
        this.con = con;
        setLayout(new BorderLayout(0,0));//边界布局

        //实例化roomRightPanel
        roomRightPanel = new CliGameRoomRightPanel(con);
        add(roomRightPanel,BorderLayout.EAST);

        //实例化roomLeftPanel
        roomLeftPanel = new CliGameRoomLeftPanel(con);
        add(roomLeftPanel,BorderLayout.WEST);


    }
}
