package com.cykj.work2;

public class ThreadMain {
    public static int waterNow = 0;//当前水量
    public static void main(String[] args) {
        //2、有一水池最大容量50升，初始为空。实现5个加水线程，假设第1个线程每秒最多加1升水，
        // 第2个线程每秒最多加2升水；依此类推第3、4、5线程每秒最大可加3、4、5升水；
        // 当水池加满，各线程停止工作。
        for (int i = 0; i < 5; i++) {
            ThreadTest_2 w = new ThreadTest_2(i+1);
            w.start();
        }
//        Thread thread1 = new ThreadTest_2(1);//每秒至多加1
//        Thread thread2 = new ThreadTest_2(2);//每秒至多加2
//        Thread thread3 = new ThreadTest_2(3);//每秒至多加3
//        Thread thread4 = new ThreadTest_2(4);//每秒至多加4
//        Thread thread5 = new ThreadTest_2(5);//每秒至多加5
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
    }
}
