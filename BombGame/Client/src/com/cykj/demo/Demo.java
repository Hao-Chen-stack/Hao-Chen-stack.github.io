package com.cykj.demo;

public class Demo implements  Runnable {
  public   void run() {
      System.out.print("running");
 }
  public  static void main(String[]  args) {
      Thread t = new Thread(new Demo());
      t.run();
      t.run();
      t.start();
  }
 }
