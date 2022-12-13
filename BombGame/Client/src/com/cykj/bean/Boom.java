package com.cykj.bean;

import com.cykj.controller.CliController;
import com.cykj.model.Data;

import java.awt.*;

public class Boom {
    public CliController con;
    public int boomX;
    public int boomY;
    public Image boomImg1,boomImg2,boomImg3;
    public int boomTime;

    public Boom(CliController con, int x, int y){  //将炸弹对象的参数传进来
        this.con = con;
        boomImg1 = Data.BOOM_1;
        boomImg2 = Data.BOOM_2;
        boomImg3 = Data.BOOM_3;
        boomTime = 0;
        boomX = x;
        boomY = y;

    }

}
