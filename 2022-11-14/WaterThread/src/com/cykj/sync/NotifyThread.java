package com.cykj.sync;

public class NotifyThread extends Thread {
    @Override
    public void run() {
        synchronized (ThreadStart.waitLock){
            try {
                Thread.sleep(3000);
//                ThreadStart.waitLock.notify();//唤醒一个
                ThreadStart.waitLock.notifyAll();//唤醒所有
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
