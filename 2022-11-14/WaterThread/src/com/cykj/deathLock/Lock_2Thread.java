package com.cykj.deathLock;
import com.cykj.sync.ThreadStart;

public class Lock_2Thread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000000 ; i++) {
            synchronized (Lock_1Thread.class){
                synchronized (Lock_2Thread.class){
                    ThreadStart.number++;
                }
            }

        }
        System.out.println(Thread.currentThread().getName()+"："+ThreadStart.number);
    }
}
