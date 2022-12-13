package model;

import controller.Controller;

import java.awt.*;
import java.util.Random;

public class Items {
    public Controller con;
    public int type;
    public int itemsX;
    public int itemsY;
    public Image itemsImag;

    public Items(Controller con,int type){
        this.con = con;
        this.type = type;
        switch (type){
            case 1:             //血包
                itemsImag = Data.HP_BOX;
                break;
            case 2:             //加分道具
                itemsImag = Data.POINT_ADD;
                break;

        }
    }

    public boolean itemRanPos(){
        Random ran = new Random();
        itemsX = ran.nextInt(30);
        itemsY = ran.nextInt(30);
//        return con.map.allMapArray[con.levels][itemsX][itemsY] != 0;
        if (con.map.allMapArray[con.levels][itemsX][itemsY]==0){
            return true;
        }
        return false;
    }
}
