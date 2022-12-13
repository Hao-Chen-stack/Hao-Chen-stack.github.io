package controller;

import view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeActLis implements ActionListener {
    public Controller con;
    public GameMusic gameMusic;
    public WelcomeActLis(Controller con){
        this.con = con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "inGame":
                gameMusic = new GameMusic("music/login.wav");
                gameMusic.play();
                UI.welcomeFrame.setVisible(false);
                UI.loginFrame.setVisible(true);
                String inputValue = JOptionPane.showInputDialog(null,"请输入姓名：","欢迎来到坦克大战！", JOptionPane.INFORMATION_MESSAGE);
                if(con.login(inputValue)){
                    if (inputValue == null || inputValue.equals("")){
                        System.out.println("登录失败");
                        JOptionPane.showConfirmDialog(null,
                                "请重新点击开始游戏", "温馨提示", JOptionPane.DEFAULT_OPTION);
                        UI.loginFrame.setVisible(false);
                        UI.welcomeFrame.setVisible(true);
                    }else {
//                        con.nowLevel();
                        UI.gameFrame.setVisible(true);
                        UI.loginFrame.setVisible(false);
                        gameMusic = new GameMusic("music/login.wav");
                        gameMusic.over();
                    }
                }
                UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.nowNameLabel.setText(con.nowPlayer.playerName);
                break;
            case "outGame":
                System.exit(0);
                break;
        }
    }
}
