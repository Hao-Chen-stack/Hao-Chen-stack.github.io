package controller;

import model.Tank_Enemy;
import view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameActLis implements ActionListener {
    public Controller con;
    public JComboBox levelComboBox;
    public String levelStr;
    public GameActLis(Controller con) {
        this.con = con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "start":
                con.tankGameTimer.myTimer.start();
                GameMusic music = new GameMusic("music/start.wav");
                music.play();
                break;
            case "stop":
                con.tankGameTimer.myTimer.stop();
                int ans = JOptionPane.showConfirmDialog(null,
                        "点击yes继续游戏,点击no回到初始界面", "游戏已暂停", JOptionPane.YES_NO_OPTION);
                System.out.println(ans);
                if (ans == 0) {
                    con.tankGameTimer.myTimer.start();
                } else if (ans == 1) {
                    UI.welcomeFrame.setVisible(true);
                    UI.gameFrame.setVisible(false);
                }
                break;
            case "restart":
                con.enemySum += 20;
                con.tankGameTimer.myTimer.start();    //定时器重新开始
                UI.gameOverFrame.setVisible(false);   //游戏结束界面关闭
                UI.gameLeaderFrame.setVisible(false);  //游戏结算界面关闭
                con.tank_enemies.clear();              //坦克列表清空
//                这个列表是已经被改变了，那么我们在执行下面那个方法的时候，我们应该将con.tank_enemies变成一开始的样子
                con.tank_m01_enemies  = new ArrayList<Tank_Enemy>();    //重新实例化项目
                con.tankTypeNum();                      //重新调用坦克类型方法
                con.map.drawMap();                      //重新调用绘制地图方法
                con.tankGameTimer.rightPanelNum();      //重新调用右方面板更新方法
                con.bullets.clear();                    //清除子弹集合
                con.items.clear();                      //清除道具集合

                UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label2.setText("0"); //击毁坦克数
                UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label4.setText("0");   //该关得分
//                UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label6.setText("0"); //总击毁坦克数
//                UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label8.setText("0");   //总分数
                con.hitTankNum = 0;                     //击毁坦克数
                con.scoreNow = 0;                       //当前分数
                con.scoreSum = 0;                       //总分数
                con.hitTankSum = 0;                     //击毁坦克总数
                con.tankP1.tank1RanPos();               //回归玩家1初始位置
                con.tankP2.tank2RanPos();               //回归玩家2初始位置
                UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.repaint();
                break;
            case "custom":
                UI.gameCustomFrame.setVisible(true);
                con.tankGameTimer.myTimer.stop();
                UI.gameCustomFrame.gameCustomPanel.label1.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.label2.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.label3.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.label4.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.jTextField.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.status1.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.status2.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.status3.setVisible(false);
                break;
            case "is":
                con.tank_enemies.clear();
                con.bullets.clear();
                con.items.clear();
            case "no":
                UI.gameCustomFrame.setVisible(false);
                con.tankGameTimer.myTimer.start();
                break;
            case "exit":
                System.exit(0);
                break;
            case "about":
                JOptionPane.showConfirmDialog(null,
                        "本软件为测试开发版，版权归制作者所有\n制作者：Jx220913陈浩", "关于游戏", JOptionPane.DEFAULT_OPTION);
                break;
            case "manual":
                JOptionPane.showConfirmDialog(null,
                        "W前进 S后退 A左移 D右移\nJ发射 P暂停 C继续", "操作说明", JOptionPane.DEFAULT_OPTION);
                break;
            case "rule":
                JOptionPane.showConfirmDialog(null,
                        "保护好自己的老家\n消灭所有敌方坦克即可过关", "规则说明", JOptionPane.DEFAULT_OPTION);
                break;
            case "nextLevel":
                con.tankGameTimer.myTimer.start();
                con.levels++;
                UI.gameLeaderFrame.setVisible(false);
                UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label2.setText("0"); //该关击毁坦克数
                UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label4.setText("0"); //该关得分
                con.hitTankNum = 0;
                con.scoreNow = 0;
                con.enemySum+=20;
                con.tankP1.tank1RanPos();
                con.tankP2.tank2RanPos();
                con.tank_enemies.clear();
                con.bullets.clear();
                con.items.clear();
                UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.repaint();
                if (con.levels >= 8) {
                    int ans2 = JOptionPane.showConfirmDialog(null,
                            "您成功通关，点击确认退出游戏", "恭喜胜利", JOptionPane.DEFAULT_OPTION);
                    if (ans2 == 0){
                        System.exit(0);
                    }
                }
                break;
//            case "nextLevel":
//                levelComboBox = UI.gameCustomFrame.gameCustomPanel.status1;
//                levelStr = levelComboBox.getSelectedItem().toString().trim();//获取值的字符串形式
//                con.levels = Integer.parseInt(levelStr);//将字符串转换成整型
//                break;
            case "rad1":
                con.oneA_two = false;
                break;
            case "rad2":
                con.oneA_two = true;
                break;
            case "rad3":
                UI.gameCustomFrame.gameCustomPanel.label1.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.label2.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.label3.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.label4.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.jTextField.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.status1.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.status2.setVisible(false);
                UI.gameCustomFrame.gameCustomPanel.status3.setVisible(false);
                break;
            case "rad4":
                UI.gameCustomFrame.gameCustomPanel.label1.setVisible(true);
                UI.gameCustomFrame.gameCustomPanel.label2.setVisible(true);
                UI.gameCustomFrame.gameCustomPanel.label3.setVisible(true);
                UI.gameCustomFrame.gameCustomPanel.label4.setVisible(true);
                UI.gameCustomFrame.gameCustomPanel.jTextField.setVisible(true);
                UI.gameCustomFrame.gameCustomPanel.status1.setVisible(true);
                UI.gameCustomFrame.gameCustomPanel.status2.setVisible(true);
                UI.gameCustomFrame.gameCustomPanel.status3.setVisible(true);
                break;

        }
    }
}
