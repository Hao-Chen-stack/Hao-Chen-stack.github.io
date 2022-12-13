package com.cykj.work1;

public class ThreadTest_1 extends Thread {
    //另一个线程：子线程
    public static int pool = 0;
    @Override
    public void run() {
        while (pool < 50){
            pool++;
            System.out.println(Thread.currentThread().getName()+","+pool);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"结束了");
//        for (int i = 1; i <= 50; i++) {
//            System.out.println(Thread.currentThread().getName()+"已加水1L\t"+"当前水量为"+i+"L");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
