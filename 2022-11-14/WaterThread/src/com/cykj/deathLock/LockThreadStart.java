package com.cykj.deathLock;

import com.cykj.sync.AddThread;

public class LockThreadStart {
    public static int number = 0;
    public static  final Object o = new Object();//唯一性的

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Lock_1Thread lock_1Thread = new Lock_1Thread();
            lock_1Thread.start();
            Lock_2Thread lock_2Thread = new Lock_2Thread();
            lock_2Thread.start();
        }
    }
}
