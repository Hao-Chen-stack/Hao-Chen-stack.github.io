package com.cykj.sync;

public class AddThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            //同步的     锁：唯一性\对象
//            synchronized(ThreadStart.o){
            //            }

//            //同步代码块         同步方法
            synchronized (AddThread.class) {//用类对象自身当锁，省略了一个对象
                ThreadStart.number++;
            }
//            add();
        }
        System.out.println(Thread.currentThread().getName() + "：" + ThreadStart.number);
    }
    //同步方法，以自身为锁，锁是当前对象
    public synchronized static void add() {
        ThreadStart.number++;
    }
}
