package com.cykj.joinDemo;

public class ThreadTest {
    public static void main(String[] args) {
        Thread t2 = new Thread(new Thread2());
        Thread t1 = new Thread(new Thread1(t2));
        t1.start();
        t2.start();
    }
}
