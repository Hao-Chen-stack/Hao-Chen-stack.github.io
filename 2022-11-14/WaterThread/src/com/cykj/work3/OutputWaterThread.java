package com.cykj.work3;

public class OutputWaterThread {
    public static int waterNow = 50;//当前水量为50
    public static void main(String[] args) {
        Thread inputTh = new InputWaterThread();
        inputTh.start();//放水线程开始执行
        while (waterNow > 0){//当前水量大于0时开始排水
            waterNow--;
            System.out.println(Thread.currentThread().getName()+"当前排水1升\t"+"总水量还有"+waterNow);
            try {
                Thread.sleep(1000);//每1秒排一次水
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
