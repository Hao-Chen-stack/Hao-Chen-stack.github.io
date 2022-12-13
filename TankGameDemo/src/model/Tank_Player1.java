package model;

import controller.Controller;
import controller.GameMusic;
import view.UI;

import java.awt.*;

public class Tank_Player1 extends Tank {
    public Controller con;
    public int dir = 0;
    public int fileTime = 10;
    public GameMusic gameMusic;

    public Tank_Player1(Controller con) {
        super(con);
        this.con = con;
        speed = 6;
        blood = 3;
        hp = 3;
    }

    public void tank1RanPos() {//玩家1 坦克的初始状态
        //玩家1 坦克的初始位置和速度
        tankX = 150;
        tankY = 650;
    }

    //玩家1 坦克移动方法和边界碰撞以及碰撞元素方块检测
    public void tankMove() {
        //玩家1
        if (isUp) {
            dir = 0;
            image = Data.TANK1UP;
            if (!hitWall(tankX, tankY - speed) && tankY >= 3) {//判断是否碰到墙体和是否超过边界
                tankY -= speed;//未碰到，可以移动
            }
        } else if (isDown) {
            dir = 1;
            image = Data.TANK1DOWN;
            if (!hitWall(tankX, tankY + speed) && tankY <= 655) {
                tankY += speed;
            }
        } else if (isLeft) {
            dir = 2;
            image = Data.TANK1LEFT;
            if (!hitWall(tankX - speed, tankY) && tankX >= 3) {
                tankX -= speed;
            }
        } else if (isRight) {
            dir = 3;
            image = Data.TANK1RIGHT;
            if (!hitWall(tankX + speed, tankY) && tankX <= 710) {
                tankX += speed;
            }
        }
    }

    //我方坦克与障碍物 敌方坦克 的碰撞方法
    public boolean hitWall(int x, int y) {
        Rectangle tankRec = new Rectangle(x, y, 30, 30);//坦克下一步的运动矩形
//        for (int k = 0; k < con.map.allMapArray.length; k++) {
        for (int i = 0; i < UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels].length; i++) {//双重for遍历寻找地图的元素方块
            for (int j = 0; j < UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels].length; j++) {
                switch (UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels][j][i]) {  //之后重新优化
                    case 1:
                    case 2:
                    case 3:
                        Rectangle mapRec = new Rectangle(i * 30, j * 30, 30, 30);//数组内元素的矩形
                        if (mapRec.intersects(tankRec)) {
//                            System.out.println(mapRec.intersects(tankRec)+"撞到了");
                            gameMusic = new GameMusic("music/wall.wav");
                            gameMusic.play();
                            return true;
                        }
                        break;
                }
            }
        }
        for (int i = 0; i < con.items.size(); i++) {        //判断我方坦克与道具的碰撞
            Rectangle itemsRec = new Rectangle(con.items.get(i).itemsY*30, con.items.get(i).itemsX*30, 30, 30);
//            System.out.println(tankRec.intersects(itemsRec)+"                       82");
            if (tankRec.intersects(itemsRec)) {
                switch (con.items.get(i).type) {
                    case 1:
                        if (con.tankP1.blood<=2){
                            con.tankP1.blood++;
                            con.items.remove(con.items.get(i));
                            gameMusic = new GameMusic("music/jiaxue.wav");
                            gameMusic.play();
                        }
                        break;
                    case 2:
                        con.scoreSum +=200;
                        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label8.setText(" "+con.scoreSum);
                        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.repaint();
                        gameMusic = new GameMusic("music/score.wav");
                        gameMusic.play();
                        con.items.remove(con.items.get(i));
                        break;
                }
                return true;
            }
        }
        for (int i = 0; i < con.tank_enemies.size(); i++) {
            Rectangle enemyRec = new Rectangle(con.tank_enemies.get(i).tankX, con.tank_enemies.get(i).tankY, 30, 30);
            if (enemyRec.intersects(tankRec)) {
                return true;
            }
        }
        return false;
    }

    //玩家坦克的射击方法
    public void playerShoot() {
        Bullet bullet = new Bullet(1, con, dir, tankX + (30 / 2 - 10 / 2), tankY + (30 / 2 - 10 / 2));
        con.bullets.add(bullet);
    }

}
