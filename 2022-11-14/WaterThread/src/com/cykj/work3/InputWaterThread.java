package com.cykj.work3;

public class InputWaterThread extends Thread{
    @Override
    public void run() {
        while (OutputWaterThread.waterNow < 50){//当总水量小于50开始加水
            OutputWaterThread.waterNow++;
            System.out.println(Thread.currentThread().getName()+"当前加水1升\t"+"总水量还有"+ OutputWaterThread.waterNow);
            try {
                Thread.sleep(3000);//3秒加一次水
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
