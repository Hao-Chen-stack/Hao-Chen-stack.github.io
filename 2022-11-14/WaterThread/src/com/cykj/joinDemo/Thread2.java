package com.cykj.joinDemo;

public class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread2 start.....");
        boolean flag = true;
        while (flag){
                System.out.println("thread runing...");
                try {
                    Thread.sleep(5000);
                    flag = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("T2结束");
    }
}
