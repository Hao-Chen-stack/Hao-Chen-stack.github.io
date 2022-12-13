package com.cykj.ThreadDemo.src.com.cykj;

public class FirstThread extends Thread{
    //另一个线程：子线程
    @Override
    public void run() {
        //线程要做的事
//        System.out.println(Thread.currentThread().getName());
        for (int i=0;i<1000000;i++){
            ThreadDemo.n++;
//            System.out.println(Thread.currentThread().getName()+"----"+i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(Thread.currentThread().getName()+"--------"+ThreadDemo.n);
    }
}
