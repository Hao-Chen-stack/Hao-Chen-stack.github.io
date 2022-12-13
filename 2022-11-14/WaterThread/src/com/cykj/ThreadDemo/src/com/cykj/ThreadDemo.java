package com.cykj.ThreadDemo.src.com.cykj;

public class ThreadDemo {
    public static  int n =0;
    public static void main(String[] args) {
        //主线程
        //查看是哪个线程在运行
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread();

        Thread thread1 = new FirstThread();
//        thread1.run();//直接运行线程对象的方法     并沒有创建线程
        thread1.start();//创建线程  等待着操作系统的运行（排队）
//        Thread thread2 = new FirstThread();
//        thread2.start();
//        sleep(long millis)  线程睡眠 millis 毫秒
//        sleep(long millis, int nanos)  线程睡眠 millis 毫秒 + nanos 纳秒
        for (int i = 0; i <1000000 ; i++) {
            n++;
//            System.out.println(Thread.currentThread().getName()+"****"+i);            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(Thread.currentThread().getName()+"********"+ThreadDemo.n);

    }
}
