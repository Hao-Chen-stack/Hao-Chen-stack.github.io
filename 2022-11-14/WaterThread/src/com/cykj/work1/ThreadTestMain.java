package com.cykj.work1;

public class ThreadTestMain {
    public static int waterSum = 0;
    public static void main(String[] args) {
        //1、	有一水池最大容量50升，初始为空。实现5个加水线程，
        // 每个线程每秒往水池里加1升水，当水池加满，各线程停止工作。
        //主线程
        //查看是哪个线程在运行
        for (int i = 0; i < 5; i++) {
            ThreadTest_1 w = new ThreadTest_1();
            w.start();
        }
        System.out.println(Thread.currentThread().getName());
//        Thread thread = new Thread();
//
//        Thread thread1 = new ThreadTest_1();
//        Thread thread2 = new ThreadTest_1();
//        Thread thread3 = new ThreadTest_1();
//        Thread thread4 = new ThreadTest_1();
//        Thread thread5 = new ThreadTest_1();
//
//
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();



    }
}
