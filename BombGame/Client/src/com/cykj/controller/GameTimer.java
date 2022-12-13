package com.cykj.controller;

import com.cykj.Thread.CliReadThread;
import com.cykj.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {
    public CliController con;
    public Timer myTimer;
    public int delay = 20; //延迟33毫秒

    //此处使用actionListener 作为要做的事情的指代
    public ActionListener myAct = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (CliReadThread.player!=null ){
                CliReadThread.player.playerMove();
            }
            if (CliReadThread.master !=null){
                CliReadThread.master.playerMove();
            }
            UI.hitGameFrame.repaint();
            //爆炸
            for (int i = 0; i < con.booms.size(); i++) {
                con.booms.get(i).boomTime++;
            }
        }
    };

    public GameTimer(CliController con) {
        myTimer = new Timer(delay, myAct);//定时器实例化
        this.con = con;
    }
}
