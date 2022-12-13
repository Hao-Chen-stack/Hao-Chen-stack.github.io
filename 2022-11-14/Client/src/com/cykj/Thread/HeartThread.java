package com.cykj.Thread;

import com.alibaba.fastjson.JSONObject;
import com.cykj.controller.CliController;

public class HeartThread extends Thread{
    public static int heartCount = 0;
    @Override
    public void run() {
        while (true){
//            System.out.println("我还活着，I am alive!");
            //这是在心脏内写计数器的写法
            if (heartCount < 5){
                //最简单的消息
                JSONObject js = new JSONObject();
                js.put("action","heart");
                System.out.println("heart"+js.toJSONString());
                CliController.cliReadThread.send(js.toJSONString());
                heartCount++;
            }else {
                heartCount = 0;//清零

                CliController.cliReadThread.interrupt();//中断心脏线程
                //对方挂了,或网络断了
                ConnectThread connectThread = new ConnectThread();
                connectThread.start();
                break;
            }
            //这是在CliReadThread写计数器的写法
            //            //心跳数开始递增
//            int heartNum = CliController.cliReadThread.getHeartNum()+1;
//            CliController.cliReadThread.setHeartNum(heartNum);
//            if (heartNum>5){
//                ConnectThread connectThread = new ConnectThread();
//                connectThread.start();
//                break;
//            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
