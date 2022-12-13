package com.cykj.joinDemo;

public class Thread1 extends Thread {
    private Thread t2;
    public Thread1(Thread cthread){
        t2 = cthread;
    }

    @Override
    public void run() {
        System.out.println("relate to other thread");
        //进入阻塞状态，直至t2线程结束
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread1 ended");
    }
}
