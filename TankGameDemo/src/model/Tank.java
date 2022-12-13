package model;

import controller.Controller;
import view.UI;


import javax.crypto.spec.RC2ParameterSpec;
import java.awt.*;

public class Tank {
    public Controller con;
    public int tankX;
    public int tankY;
    public int speed;//速度
    public int blood;//血量
    public int point;//积分
    public int hp;//生命值
    public Image image;

    public boolean isUp;
    public boolean isDown;
    public boolean isLeft;
    public boolean isRight;

    public Tank(Controller con){
        this.con = con;
        isUp = false;
        isDown = false;
        isLeft = false;
        isRight = false;
    }

    //坦克移动的方法以及边界碰撞判断
    public void tankMove() {

    }


}
