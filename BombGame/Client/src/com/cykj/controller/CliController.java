package com.cykj.controller;

import com.cykj.Thread.CliReadThread;
import com.cykj.Thread.ConnectThread;
import com.cykj.bean.Boom;
import com.cykj.model.Map;

import java.util.ArrayList;

public class CliController {
    //声明一个静态的连接线程
    public static CliReadThread cliReadThread;
    public static ConnectThread connectThread;
    //地图类
    public Map map;
    //地图的序号
    public int levels;
    //定时器
    public GameTimer gameTimer;
    //爆炸效果集合
    public ArrayList<Boom> booms;
    public CliController(){
        //若想要取消重连线程，下方的注释打开，再将重连线程的start注释掉
//        cliReadThread = new CliReadThread();//读取客户端发送过来消息的线程
//        cliReadThread.start();
        connectThread = new ConnectThread(this);
        connectThread.start();
        //地图类实例化
        map = new Map(this);
        //地图序号的实例化
        levels = 0;
        //定时器
        gameTimer = new GameTimer(this);
        //爆炸效果
        booms = new ArrayList<Boom>();
    }
}
