package com.cykj.bean;

import com.cykj.model.Data;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private String userId;
    private int playerX;
    private int playerY;
    private int speed =6;//速度
    private int blood;//血量
    private int point;//积分
    private int hp;//生命值
//    private Image image;
    private int image;
    private boolean isUp = false;
    private boolean isDown = false;
    private boolean isLeft = false;
    private boolean isRight = false;


    //炸弹集合
//    private ArrayList<Bomb> booms = new ArrayList<>();


    public Player(String userId, int playerX, int playerY, int speed, int blood, int point, int hp, int image, boolean isUp, boolean isDown, boolean isLeft, boolean isRight) {
        this.userId = userId;
        this.playerX = playerX;
        this.playerY = playerY;
        this.speed = speed;
        this.blood = blood;
        this.point = point;
        this.hp = hp;
        this.image = image;
        this.isUp = isUp;
        this.isDown = isDown;
        this.isLeft = isLeft;
        this.isRight = isRight;
    }

    public Player() {
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
}
