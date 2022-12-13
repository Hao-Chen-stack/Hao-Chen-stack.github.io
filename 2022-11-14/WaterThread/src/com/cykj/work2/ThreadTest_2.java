package com.cykj.work2;

import java.util.Random;

public class ThreadTest_2 extends Thread {
    //子线程
    private int addWater;//每秒的加水量

    public ThreadTest_2(int addWater) {
        this.addWater = addWater;
    }

    @Override
    public void run() {
        while (ThreadMain.waterNow < 50){//循环判断当前水量是否小于50
            Random ran = new Random();
            int addNum = ran.nextInt(addWater+1);
            if (addWater+ThreadMain.waterNow >= 50){
                ThreadMain.waterNow+=addNum;//随机加水
                System.out.println(Thread.currentThread().getName()+"已经加水"+addNum+"升,"+ThreadMain.waterNow);
            }
            try {
                Thread.sleep(1000);//加水间隔为1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"总共加水量为"+ ThreadMain.waterNow);
    }
}
