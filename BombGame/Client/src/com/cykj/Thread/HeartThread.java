package com.cykj.Thread;

import com.alibaba.fastjson.JSONObject;
import com.cykj.controller.CliController;

public class HeartThread extends Thread{
    public static int heartCount = 0;
    public CliController con;

    public HeartThread(CliController con){
        this.con = con;
    }
    @Override
    public void run() {
        while (true){
            //响应次数
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
                ConnectThread connectThread = new ConnectThread(con);
                connectThread.start();
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
