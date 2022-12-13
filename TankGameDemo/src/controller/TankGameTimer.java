package controller;

import model.Items;
import model.Tank_Enemy;
import view.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Random;

public class TankGameTimer {
    public Timer myTimer;
    public int delay = 30; //延迟33毫秒
    public int timeDelay = 0;//每隔多少秒随机一次位置
    public Controller con;
    public int itemBornTime =0;
    public int itemDeadTime =0;
    public int enemyLisRan;

    //随机敌方坦克的出生点
    public Point[] holePoints = {
            new Point(0, 0),
            new Point(150, 0),
            new Point(660, 0),
            new Point(0, 125),
            new Point(660, 340),
    };
    //此处使用actionListener 作为要做的事情的指代
    public ActionListener myAct = new ActionListener() {//坦克刷新界面的定时器执行方法
        @Override
        public void actionPerformed(ActionEvent e) {
//            System.out.println("定时器执行");
            //执行玩家1的坦克移动方法
            con.tankP1.tankMove();
            //执行玩家2的移动方法
            con.tankP2.tank2Move();
            //敌方坦克移动方法
            for (int i = 0; i < con.tank_enemies.size(); i++) {
                con.tank_enemies.get(i).tankMove();
            }

            UI.gameFrame.gameLeftPanel.repaint();
            timeDelay++;
            //敌方坦克的生成
            if (timeDelay >= 100) { //每3.3秒产生一次随机坐标
                enemyTanksRanPos();
            }
            for (int i = 0; i < con.bullets.size(); i++) { //子弹类里子弹移动的方法
                con.bullets.get(i).bulletMove();
            }
            con.tankP1.fileTime++;
            con.tankP2.fileTime++;

            //子弹移动的方法
            for (int i = 0; i < con.tank_enemies.size(); i++) {//遍历敌方坦克的集合
                con.tank_enemies.get(i).enemyFileTime++;//敌方坦克类这个对象里定义的整型值开始增加
                if (con.tank_enemies.get(i).enemyFileTime >= 50) { //当定义的整型值>=50
                    con.tank_enemies.get(i).shootBullet();//调用敌方坦克发射子弹的方法
                    con.tank_enemies.get(i).enemyFileTime = 0;  //定义的整型值清0
                }
            }
            rightPanelNum();//调用获取右侧上方top信息面板实时数据的方法

            //坦克爆炸
            for (int i = 0; i < con.booms.size(); i++) {
                con.booms.get(i).boomTime++;
            }

            //道具生成
            itemBornTime++;
            if (itemBornTime >= 100){
                Items items = new Items(con,new Random().nextInt(2)+1);
                if (items.itemRanPos()){
                    con.items.add(items);
                }
                itemBornTime = 0;
            }

            //道具消失
            if (con.items.size() > 0){
                itemDeadTime ++;
            }
            for (int i = 0; i < con.items.size(); i++) {
                if (itemDeadTime >=300){
                    con.items.remove(con.items.get(i));
                    itemDeadTime = 0;
                }
            }

        }
    };

    public TankGameTimer(Controller con) {
        myTimer = new Timer(delay, myAct);//定时器实例化
        this.con = con;
    }

    //生成敌方坦克的方法
    public void enemyTanksRanPos() {
        boolean hitBron = true;
        Random ran = new Random();
        int enemyLisRan;
        int ranNum = ran.nextInt(holePoints.length);
        Rectangle tankBornRec = new Rectangle(holePoints[ranNum].x, holePoints[ranNum].y, 30, 30);
        for (int i = 0; i < con.tank_enemies.size(); i++) {
            Tank_Enemy t = con.tank_enemies.get(i);
            Rectangle tank = new Rectangle(t.tankX, t.tankY, 30, 30);
            Rectangle playerTankRec = new Rectangle(con.tankP1.tankX, con.tankP1.tankY, 30, 30);
            if (tankBornRec.intersects(tank) || playerTankRec.intersects(tankBornRec)) {
                hitBron = false;
                break;
            }
        }

        if (hitBron) {
            if (con.levels ==0){
                if (con.tank_enemies.size() < 10 && con.tank_m01_enemies.size() > 0) {
                    enemyLisRan = ran.nextInt(con.tank_m01_enemies.size());////存在一些异常的语句
                    con.tank_m01_enemies.get(enemyLisRan).tankX = holePoints[ranNum].x;
                    con.tank_m01_enemies.get(enemyLisRan).tankY = holePoints[ranNum].y;
                    con.tank_enemies.add(con.tank_m01_enemies.get(enemyLisRan));
                    con.tank_m01_enemies.remove(enemyLisRan);
                    System.out.println("出生坦克");
                    Collections.shuffle(con.tank_enemies);
                }
            }else if (con.levels ==1){
                if (con.tank_enemies.size() < 10 && con.tank_m02_enemies.size() > 0) {
                    enemyLisRan = ran.nextInt(con.tank_m02_enemies.size());////存在一些异常的语句
                    con.tank_m02_enemies.get(enemyLisRan).tankX = holePoints[ranNum].x;
                    con.tank_m02_enemies.get(enemyLisRan).tankY = holePoints[ranNum].y;
                    con.tank_enemies.add(con.tank_m02_enemies.get(enemyLisRan));
                    con.tank_m02_enemies.remove(enemyLisRan);
                    System.out.println("出生坦克");
                    Collections.shuffle(con.tank_enemies);
                }
            }else if (con.levels ==2){
                if (con.tank_enemies.size() < 10 && con.tank_m03_enemies.size() > 0) {
                    enemyLisRan = ran.nextInt(con.tank_m03_enemies.size());////存在一些异常的语句
                    con.tank_m03_enemies.get(enemyLisRan).tankX = holePoints[ranNum].x;
                    con.tank_m03_enemies.get(enemyLisRan).tankY = holePoints[ranNum].y;
                    con.tank_enemies.add(con.tank_m03_enemies.get(enemyLisRan));
                    con.tank_m03_enemies.remove(enemyLisRan);
                    System.out.println("出生坦克");
                    Collections.shuffle(con.tank_enemies);
                }
            }else if (con.levels ==3){
                if (con.tank_enemies.size() < 10 && con.tank_m04_enemies.size() > 0) {
                    enemyLisRan = ran.nextInt(con.tank_m04_enemies.size());////存在一些异常的语句
                    con.tank_m04_enemies.get(enemyLisRan).tankX = holePoints[ranNum].x;
                    con.tank_m04_enemies.get(enemyLisRan).tankY = holePoints[ranNum].y;
                    con.tank_enemies.add(con.tank_m04_enemies.get(enemyLisRan));
                    con.tank_m04_enemies.remove(enemyLisRan);
                    System.out.println("出生坦克");
                    Collections.shuffle(con.tank_enemies);
                }
            }else if (con.levels ==4){
                if (con.tank_enemies.size() < 10 && con.tank_m05_enemies.size() > 0) {
                    enemyLisRan = ran.nextInt(con.tank_m05_enemies.size());////存在一些异常的语句
                    con.tank_m05_enemies.get(enemyLisRan).tankX = holePoints[ranNum].x;
                    con.tank_m05_enemies.get(enemyLisRan).tankY = holePoints[ranNum].y;
                    con.tank_enemies.add(con.tank_m05_enemies.get(enemyLisRan));
                    con.tank_m05_enemies.remove(enemyLisRan);
                    System.out.println("出生坦克");
                    Collections.shuffle(con.tank_enemies);
                }
            }else if (con.levels ==5){
                if (con.tank_enemies.size() < 10 && con.tank_m06_enemies.size() > 0) {
                    enemyLisRan = ran.nextInt(con.tank_m06_enemies.size());////存在一些异常的语句
                    con.tank_m06_enemies.get(enemyLisRan).tankX = holePoints[ranNum].x;
                    con.tank_m06_enemies.get(enemyLisRan).tankY = holePoints[ranNum].y;
                    con.tank_enemies.add(con.tank_m06_enemies.get(enemyLisRan));
                    con.tank_m06_enemies.remove(enemyLisRan);
                    System.out.println("出生坦克");
                    Collections.shuffle(con.tank_enemies);
                }
            }else if (con.levels ==6){
                if (con.tank_enemies.size() < 10 && con.tank_m07_enemies.size() > 0) {
                    enemyLisRan = ran.nextInt(con.tank_m07_enemies.size());////存在一些异常的语句
                    con.tank_m07_enemies.get(enemyLisRan).tankX = holePoints[ranNum].x;
                    con.tank_m07_enemies.get(enemyLisRan).tankY = holePoints[ranNum].y;
                    con.tank_enemies.add(con.tank_m07_enemies.get(enemyLisRan));
                    con.tank_m07_enemies.remove(enemyLisRan);
                    System.out.println("出生坦克");
                    Collections.shuffle(con.tank_enemies);
                }
            }else if (con.levels ==7){
                if (con.tank_enemies.size() < 10 && con.tank_m08_enemies.size() > 0) {
                    enemyLisRan = ran.nextInt(con.tank_m08_enemies.size());////存在一些异常的语句
                    con.tank_m08_enemies.get(enemyLisRan).tankX = holePoints[ranNum].x;
                    con.tank_m08_enemies.get(enemyLisRan).tankY = holePoints[ranNum].y;
                    con.tank_enemies.add(con.tank_m08_enemies.get(enemyLisRan));
                    con.tank_m08_enemies.remove(enemyLisRan);
                    System.out.println("出生坦克");
                    Collections.shuffle(con.tank_enemies);
                }
            }
//            System.out.println(1);


        }
    }


    //获取右侧top面板的数据
    public void rightPanelNum() {
        //定义四个不同的整型来接受不同的类型坦克数量
        int redNum = 0;
        int whiteNum = 0;
        int yellowNum = 0;
        int greenNum = 0;
        int blueNum = 0;
        for (int i = 0; i < con.tank_enemies.size(); i++) {
            switch (con.tank_enemies.get(i).type) {
                case 0:
                    redNum++;
                    break;
                case 1:
                    whiteNum++;
                    break;
                case 2:
                    yellowNum++;
                    break;
                case 3:
                    blueNum++;
                    break;
                case 4:
                    greenNum++;
                    break;
            }
        }
        if (con.levels ==0){
            for (int j = 0; j < con.tank_m01_enemies.size(); j++) {
                switch (con.tank_m01_enemies.get(j).type) {
                    case 1:
                        whiteNum++;
                        break;
                    case 2:
                        yellowNum++;
                        break;
                    case 3:
                        blueNum++;
                        break;
                    case 4:
                        greenNum++;
                        break;
                }
            }
        }
        if (con.levels ==1){
            for (int j = 0; j < con.tank_m02_enemies.size(); j++) {
                switch (con.tank_m02_enemies.get(j).type) {
                    case 1:
                        whiteNum++;
                        break;
                    case 2:
                        yellowNum++;
                        break;
                    case 3:
                        blueNum++;
                        break;
                    case 4:
                        greenNum++;
                        break;
                }
            }
        }
        if (con.levels ==2){
            for (int j = 0; j < con.tank_m03_enemies.size(); j++) {
                switch (con.tank_m03_enemies.get(j).type) {
                    case 0:
                        redNum++;
                        break;
                    case 1:
                        whiteNum++;
                        break;
                    case 2:
                        yellowNum++;
                        break;
                    case 3:
                        blueNum++;
                        break;
                    case 4:
                        greenNum++;
                        break;
                }
            }
        }
        if (con.levels ==3){
            for (int j = 0; j < con.tank_m04_enemies.size(); j++) {
                switch (con.tank_m04_enemies.get(j).type) {
                    case 0:
                        redNum++;
                        break;
                    case 1:
                        whiteNum++;
                        break;
                    case 2:
                        yellowNum++;
                        break;
                    case 3:
                        blueNum++;
                        break;
                    case 4:
                        greenNum++;
                        break;
                }
            }
        }
        if (con.levels ==4){
            for (int j = 0; j < con.tank_m05_enemies.size(); j++) {
                switch (con.tank_m05_enemies.get(j).type) {
                    case 0:
                        redNum++;
                        break;
                    case 1:
                        whiteNum++;
                        break;
                    case 2:
                        yellowNum++;
                        break;
                    case 3:
                        blueNum++;
                        break;
                    case 4:
                        greenNum++;
                        break;
                }
            }
        }
        if (con.levels == 5){
            for (int j = 0; j < con.tank_m06_enemies.size(); j++) {
                switch (con.tank_m06_enemies.get(j).type) {
                    case 0:
                        redNum++;
                        break;
                    case 1:
                        whiteNum++;
                        break;
                    case 2:
                        yellowNum++;
                        break;
                    case 3:
                        blueNum++;
                        break;
                    case 4:
                        greenNum++;
                        break;
                }
            }

        }
        if (con.levels == 6){
            for (int j = 0; j < con.tank_m07_enemies.size(); j++) {
                switch (con.tank_m07_enemies.get(j).type) {
                    case 0:
                        redNum++;
                        break;
                    case 2:
                        yellowNum++;
                        break;
                    case 3:
                        blueNum++;
                        break;
                    case 4:
                        greenNum++;
                        break;
                }
            }
        }
        if (con.levels ==7){
            for (int j = 0; j < con.tank_m08_enemies.size(); j++) {
                switch (con.tank_m08_enemies.get(j).type) {
                    case 0:
                        redNum++;
                        break;
                    case 3:
                        blueNum++;
                        break;
                    case 4:
                        greenNum++;
                        break;
                }
            }
        }
        //实时更新右侧的面板
        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelTop.label2.setText("     X   " + whiteNum);
        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelTop.label3.setText("     X   " + yellowNum);
        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelTop.label4.setText("     X   " + greenNum);
        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelTop.label5.setText("     X   " + blueNum);
        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelTop.label6.setText("     X   " + redNum);
        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelTop.repaint();
    }

}
