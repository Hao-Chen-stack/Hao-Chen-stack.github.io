package controller;

import view.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActLis implements ActionListener {
    public Controller con;
    public GameActLis(Controller con){
        this.con = con;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case "start":
                con.mouseGameTimer.myTimer.start();
                con.isStart = true;
                break;
            case "suspend":
                con.mouseGameTimer.myTimer.stop();
                break;
            case "restart":
                UI.gameFrame.gamePanel.rightGamePanel.label6.setText("00次");
                con.nowPlayer.playerCombo = 0;
                UI.gameFrame.gamePanel.rightGamePanel.label8.setText("00分");
                con.nowPlayer.playPoint = 0;
                con.mouseGameTimer.time = 30;
                UI.gameFrame.gamePanel.rightGamePanel.repaint();
                con.mouseGameTimer.myTimer.start();
                break;
        }
    }
}
