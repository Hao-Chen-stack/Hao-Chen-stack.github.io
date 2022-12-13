package com.cykj.sync;

public class ThreadStart {
    //公共的资源
    public static int number = 0;
    public static final Object o = new Object();//唯一性的
    public static final Object waitLock = new Object();

    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++) {
//            AddThread addThread = new AddThread();
//            addThread.start();
//        }

        for (int i = 0; i < 3; i++) {
            WaitThread waitThread = new WaitThread(i+"");
            waitThread.start();
        }

        NotifyThread notifyThread = new NotifyThread();
        notifyThread.start();
    }
}
