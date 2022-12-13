package com.cykj.deathLock;

import com.cykj.sync.AddThread;
import com.cykj.sync.ThreadStart;

public class Lock_1Thread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000000 ; i++) {
            //同步的     锁：唯一性\对象
//            synchronized(ThreadStart.o){
            //            }

//            //同步代码块         同步方法
            synchronized (Lock_2Thread.class){
                synchronized (Lock_1Thread.class){//用类对象自身当锁，省略了一个对象
                    LockThreadStart.number++;
                }
            }
//            add();
        }
        System.out.println(Thread.currentThread().getName()+"："+LockThreadStart.number);
    }
}
