package model;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Tank_Player2 extends Tank_Player1 {
    public Controller con;
    public boolean isUpP2;
    public boolean isDownP2;
    public boolean isLeftP2;
    public boolean isRightP2;
    public Tank_Player2(Controller con){
        super(con);
        this.con = con;
        speed = 6;
        blood = 3;
        isUpP2 = false;
        isDownP2 = false;
        isLeftP2 =false;
        isRightP2 = false;
    }

    public void tank2RanPos(){
        //玩家2 坦克的初始位置
        tankX = 525;
        tankY = 650;
    }

    //玩家1 坦克移动方法和边界碰撞以及碰撞元素方块检测
    public void tank2Move() {
        //玩家2
        if (isUpP2){
            dir = 0;
            image = Data.TANK2UP;
            if (!hitWall(tankX,tankY-speed) && tankY >= 3){//判断是否碰到墙体和是否超过边界
                tankY -= speed;//未碰到，可以移动
            }
        }else if (isDownP2){
            dir = 1;
            image = Data.TANK2DOWN;
            if (!hitWall(tankX,tankY+speed) && tankY <= 655){
                tankY += speed;
            }
        }else if (isLeftP2){
            dir = 2;
            image = Data.TANK2LEFT;
            if (!hitWall(tankX-speed,tankY) && tankX >= 3){
                tankX -= speed;
            }
        }else if (isRightP2){
            dir = 3;
            image = Data.TANK2RIGHT;
            if (!hitWall(tankX+speed,tankY) && tankX <= 710){
                tankX += speed;
            }
        }

    }
}
