package view.login;

import controller.Controller;
import model.Data;

import javax.swing.*;
import java.awt.*;


public class LoginLeftPanel extends JPanel {
    public Controller con;
    public Font font = new Font("宋体", Font.PLAIN, 20);
    public LoginRightPanel rightPanel;
    public LoginLeftPanel(Controller con) {
        this.con = con;

        setLayout(new BorderLayout(0, 0));
        rightPanel = new LoginRightPanel();
        add(rightPanel, BorderLayout.EAST);
        setPreferredSize(new Dimension(200, 600));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Data.LOGINBG,0,0,600,600,null);
    }
}
