package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.Thread.CliReadThread;
import com.cykj.util.GameMusic;
import com.cykj.view.game.GameLeftPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameKeyLis implements KeyListener {
    public CliController con;
    public GameLeftPanel gameLeftPanel;
    public JSONObject moveJs=new JSONObject();
//    public Player player = CliReadThread.player;
//    public Player player = new Player();
    public GameKeyLis(CliController con,GameLeftPanel gameLeftPanel) {
        this.con = con;
        this.gameLeftPanel = gameLeftPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(CliReadThread.bombUserstyle.getUserid()+"房主的ID");
        System.out.println(CliController.cliReadThread.nowUserAcc+"当前玩家的ID");
        /**
         * @description:待修复，想办法拿到当前用户ID------------已修复，修复时间2022/11/28 0:50
         * @author: chenhao
         * @date: 2022/11/26 23:40
         * @param: [e]
         * @return: void
         **/
        if (CliReadThread.bombUserstyle.getUserid().equals(CliController.cliReadThread.nowUserAcc)){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    System.out.println("W");
                    CliReadThread.master.setUp(true);
                    moveJs.put("action","move");
                    moveJs.put("player",CliReadThread.player);
                    moveJs.put("master",CliReadThread.master);
                    CliController.cliReadThread.send(moveJs.toJSONString());
                    break;
                case KeyEvent.VK_S:
                    System.out.println("S");
                    CliReadThread.master.setDown(true);
                    moveJs.put("action","move");
                    moveJs.put("player",CliReadThread.player);
                    moveJs.put("master",CliReadThread.master);
                    CliController.cliReadThread.send(moveJs.toJSONString());
                    break;
                case KeyEvent.VK_A:
                    System.out.println("A");
                    CliReadThread.master.setLeft(true);
                    moveJs.put("action","move");
                    moveJs.put("player",CliReadThread.player);
                    moveJs.put("master",CliReadThread.master);
                    CliController.cliReadThread.send(moveJs.toJSONString());
                    break;
                case KeyEvent.VK_D:
                    System.out.println("D");
                    CliReadThread.master.setRight(true);
                    moveJs.put("action","move");
                    moveJs.put("player",CliReadThread.player);
                    moveJs.put("master",CliReadThread.master);
                    CliController.cliReadThread.send(moveJs.toJSONString());
                    break;
                case KeyEvent.VK_SPACE:
                    System.out.println("空格");
                    putBoom((CliReadThread.master.getPlayerX()+15)/30,(CliReadThread.master.getPlayerY()+15)/30);
                    break;
            }
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    System.out.println("W");
                    CliReadThread.player.setUp(true);
                    moveJs.put("action","move");
                    moveJs.put("player",CliReadThread.player);
                    moveJs.put("master",CliReadThread.master);
                    CliController.cliReadThread.send(moveJs.toJSONString());
                    break;
                case KeyEvent.VK_S:
                    System.out.println("S");
                    CliReadThread.player.setDown(true);
                    moveJs.put("action","move");
                    moveJs.put("player",CliReadThread.player);
                    moveJs.put("master",CliReadThread.master);
                    CliController.cliReadThread.send(moveJs.toJSONString());
                    break;
                case KeyEvent.VK_A:
                    System.out.println("A");
                    CliReadThread.player.setLeft(true);
                    moveJs.put("action","move");
                    moveJs.put("player",CliReadThread.player);
                    moveJs.put("master",CliReadThread.master);
                    CliController.cliReadThread.send(moveJs.toJSONString());
                    break;
                case KeyEvent.VK_D:
                    System.out.println("D");
                    CliReadThread.player.setRight(true);
                    moveJs.put("action","move");
                    moveJs.put("player",CliReadThread.player);
                    moveJs.put("master",CliReadThread.master);
                    CliController.cliReadThread.send(moveJs.toJSONString());
                    break;
                case KeyEvent.VK_SPACE:
                    System.out.println("空格");
                    GameMusic gameMusic = new GameMusic("Client/music/score.wav");
                    gameMusic.play();
                    putBoom((CliReadThread.player.getPlayerX()+15)/30,(CliReadThread.player.getPlayerY()+15)/30);
                    break;
            }
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (CliReadThread.bombUserstyle.getUserid().equals(CliController.cliReadThread.nowUserAcc)){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    System.out.println("W");
                    CliReadThread.master.setUp(false);
                    break;
                case KeyEvent.VK_S:
                    System.out.println("S");
                    CliReadThread.master.setDown(false);
                    break;
                case KeyEvent.VK_A:
                    System.out.println("A");
                    CliReadThread.master.setLeft(false);
                    break;
                case KeyEvent.VK_D:
                    System.out.println("D");
                    CliReadThread.master.setRight(false);
                    break;
            }
        } else {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    System.out.println("W");
                    CliReadThread.player.setUp(false);
                    break;
                case KeyEvent.VK_S:
                    System.out.println("S");
                    CliReadThread.player.setDown(false);
                    break;
                case KeyEvent.VK_A:
                    System.out.println("A");
                    CliReadThread.player.setLeft(false);
                    break;
                case KeyEvent.VK_D:
                    System.out.println("D");
                    CliReadThread.player.setRight(false);
                    break;
            }
        }
    }

    public void putBoom(int boomX,int boomY){
        //炸弹的生成位置
        JSONObject js = new JSONObject();
        js.put("action","setBoom");
        js.put("x",boomX);
        js.put("y",boomY);
        js.put("masterid",CliReadThread.bombUserstyle.getUserid());
        js.put("playerid",CliReadThread.playerUserStyle.getUserid());
        CliController.cliReadThread.send(js.toJSONString());
        Thread boom = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    js.put("action","boom");
                    CliController.cliReadThread.send(js.toJSONString());;//发送消息告炸弹已经爆炸
                    Thread.sleep(50);
                    js.put("action","clearBoom");
                    CliController.cliReadThread.send(js.toJSONString());;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        boom.start();
    }
}
