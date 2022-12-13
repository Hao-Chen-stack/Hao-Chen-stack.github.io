package model;

import java.util.Random;

public class MouseFather implements GamePos {
    public int mouseX;
    public int mouseY;


//    public MouseFather(String father){
//        System.out.println("父类的构造方法"+father);
//    }
    //random position 随机坐标
    public void ranPos(int mapX,int mapY){
        Random ran = new Random();
        mouseX = ran.nextInt(mapX);
        mouseY = ran.nextInt(mapY);

    }
//    public void showInfo(){
//        System.out.println("父类的信息提示");
//    }

}
