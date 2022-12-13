package com.cykj.bean;

import java.awt.*;

import com.cykj.view.UI;

public class Player {
    private String userId;
    private int playerX;
    private int playerY;
    private int speed;//速度

    private int blood;//血量
    private int point;//积分
    private int hp;//生命值

    private boolean isUp = false;
    private boolean isDown = false;
    private boolean isLeft = false;
    private boolean isRight = false;
    private int image;

    //炸弹集合
//    private ArrayList<Bomb> booms = new ArrayList<>();
    public Player( int blood, int point, int hp) {
        this.blood = blood;
        this.point = point;
        this.hp = hp;
    }

    public Player() {

    }
    /**
     * @description: 玩家1的移动方法和边界碰撞以及碰撞元素方块检测
     * @author: chenhao
     * @date: 2022/11/26 13:40
     * @param: []
     * @return: void
     **/
    //玩家移动的方法
    public void playerMove(){
        if (isUp){
            if (!hitWall(playerX,playerY -speed) && playerY >=3){
                playerY -=speed;
            }
        }else if (isDown){
            if (!hitWall(playerX,playerY +speed) && playerY <= 655){
                playerY +=speed;
            }
        }else if (isLeft){
            if (!hitWall(playerX -speed,playerY) && playerX >=3){
                playerX -=speed;
            }
        }else if (isRight){
            if (!hitWall(playerX +speed,playerY) && playerX <=710){
                playerX +=speed;
            }
        }
    }

    //我方与障碍物的碰撞方法
    public boolean hitWall(int x, int y) {
        Rectangle Rec = new Rectangle(x, y, 30, 30);//下一步的运动矩形
        for (int i = 0; i < UI.hitGameFrame.gameLeftPanel.con.map.allMapArray[UI.hitGameFrame.gameLeftPanel.con.levels].length; i++) {//双重for遍历寻找地图的元素方块
            for (int j = 0; j < UI.hitGameFrame.gameLeftPanel.con.map.allMapArray[UI.hitGameFrame.gameLeftPanel.con.levels].length; j++) {
                switch (UI.hitGameFrame.gameLeftPanel.con.map.allMapArray[UI.hitGameFrame.gameLeftPanel.con.levels][j][i]) {  //之后重新优化
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        Rectangle mapRec = new Rectangle(i * 30, j * 30, 30, 30);//数组内元素的矩形
                        if (mapRec.intersects(Rec)) {
                            return true;
                        }
                        break;
                }
            }
        }
        return false;
    }


    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

//    public ArrayList<Bomb> getBooms() {
//        return booms;
//    }
//
//    public void setBooms(ArrayList<Bomb> booms) {
//        this.booms = booms;
//    }
}
