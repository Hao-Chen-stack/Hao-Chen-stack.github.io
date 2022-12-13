package com.cykj.sync;

public class WaitThread extends Thread {
    String name;
    public WaitThread(String name){
        this.name = name;
    }
    @Override
    public void run() {
        synchronized (ThreadStart.waitLock){           //1970年到现在的毫秒数
            System.out.println(name+"WaitThread  登录..........."+","+System.currentTimeMillis());
            try {
                ThreadStart.waitLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"WaitThread  结束..........."+","+System.currentTimeMillis());
        }
    }
}
