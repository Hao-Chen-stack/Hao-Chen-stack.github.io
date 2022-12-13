package controller;

import model.Mouse;
import view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseGameTimer {
    public Timer myTimer;
    public int delay = 1000;//  延迟 单位是毫秒
    public Controller con;

    //此处    声明int类型作为时间
    public int time = 30;
    //此处使用actionListener 作为要做的事情指代
    public ActionListener myAct = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("定时器执行");
            //这里又   需要controller
            con.mouse1.ranPos();//这个方法 只是改了坐标
            //修改被打状态
            con.mouse1.isHit = false;
            //还需要根据坐标 再次绘制
            UI.gameFrame.gamePanel.repaint();
            time--;
            UI.gameFrame.gamePanel.rightGamePanel.label4.setText(time + "秒");
            if (time <= 0) {
                System.out.println("时间到啦");
                myTimer.stop();
                int ans = JOptionPane.showConfirmDialog(null,
                        "请问是否重新开始", "       时间到||游戏失败", JOptionPane.YES_NO_OPTION);
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
        }
    };

    public MouseGameTimer(Controller con) {
        myTimer = new Timer(delay, myAct);//定时器的实例化
        this.con = con;
//        //启动定时器
//        myTimer.start();
    }
}
