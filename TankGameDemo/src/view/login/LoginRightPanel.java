package view.login;

import javax.swing.*;
import java.awt.*;

public class LoginRightPanel extends JPanel {
    public Font font = new Font("宋体",Font.PLAIN,20);
    public RightPanelTop rightPanelTop;
    public RightPanelNormal rightPanelNormal;
    public RightPanelBottom rightPanelBottom;
    public LoginRightPanel(){

        setLayout(new BorderLayout(0,0));
        rightPanelTop = new RightPanelTop();
        rightPanelNormal = new RightPanelNormal();
        rightPanelBottom = new RightPanelBottom();


        add(rightPanelTop,BorderLayout.NORTH);
        add(rightPanelNormal,BorderLayout.CENTER);
        add(rightPanelBottom,BorderLayout.SOUTH);
        setPreferredSize(new Dimension(200,600));


    }
}
