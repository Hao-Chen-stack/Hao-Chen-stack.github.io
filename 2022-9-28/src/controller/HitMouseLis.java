package controller;

import view.GameFrame;
import view.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HitMouseLis extends MouseAdapter {
    public Controller con;
    public HitMouseLis(Controller con){
        this.con = con;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        System.out.println(e.getPoint());
        if (con.isStart){
            Rectangle mouseRec = new Rectangle(con.mouse1.mouseX,
                    con.mouse1.mouseY,110,102);
            if (mouseRec.contains(e.getPoint()) && con.mouse1.isHit == false){
                System.out.println("打中了");
                con.nowPlayer.playerCombo++;
                con.nowPlayer.playPoint++;
                con.mouse1.isHit = true;
                UI.gameFrame.gamePanel.rightGamePanel.label6.setText(con.nowPlayer.playerCombo+"次");
                UI.gameFrame.gamePanel.rightGamePanel.label8.setText(con.nowPlayer.playPoint+"分");
                //打中之后  也要重新绘制
                UI.gameFrame.gamePanel.repaint();
                if(con.nowPlayer.playPoint >= 10){
                    System.out.println("游戏胜利");
                    con.mouseGameTimer.myTimer.stop();
                    int ans = JOptionPane.showConfirmDialog(null,
                            "请问是否重新开始", "       恭喜获得胜利", JOptionPane.YES_NO_OPTION);
                    if (ans == 0){
                        UI.gameFrame.gamePanel.rightGamePanel.label6.setText("00次");
                        con.nowPlayer.playerCombo = 0;
                        UI.gameFrame.gamePanel.rightGamePanel.label8.setText("00分");
                        con.nowPlayer.playPoint = 0;
                        con.mouseGameTimer.time = 30;
                        UI.gameFrame.gamePanel.rightGamePanel.repaint();
                        con.mouseGameTimer.myTimer.start();
                    }else {
                        UI.gameFrame.setVisible(false);
                        UI.loginFrame.setVisible(true);
                    }
                }
            }else {
                System.out.println("没打中");

            }
        }
    }
}
