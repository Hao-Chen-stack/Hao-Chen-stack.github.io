package view.game;


import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class GameRightPanel extends JPanel {
    public Controller con;
    public Font font = new Font("宋体",Font.PLAIN,20);
    public GameRightPanelTop rightPanelTop;
    public GameRightPanelNormal rightPanelNormal;
    public GameRightPanelBottom rightPanelBottom;
    public GameRightPanel(Controller con){
        this.con = con;

        setLayout(new BorderLayout(0,0));
        rightPanelTop = new GameRightPanelTop();
        rightPanelNormal = new GameRightPanelNormal();
        rightPanelBottom = new GameRightPanelBottom(con);

        add(rightPanelTop,BorderLayout.NORTH);
        add(rightPanelNormal,BorderLayout.CENTER);
        add(rightPanelBottom,BorderLayout.SOUTH);
        setPreferredSize(new Dimension(265,600));

    }
}
