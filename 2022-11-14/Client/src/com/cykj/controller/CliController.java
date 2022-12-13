package com.cykj.controller;

import com.cykj.Thread.CliReadThread;
import com.cykj.Thread.CliSendFileThread;
import com.cykj.Thread.ConnectThread;

public class CliController {
    public static CliReadThread cliReadThread;
    public static CliSendFileThread cliSendFileThread;
//    public CliReadThread cliReadThread;
    public static ConnectThread connectThread;//声明一个静态的连接线程
    public CliController() {
//        cliReadThread = new CliReadThread();//读取客户端发送过来消息的线程
//        cliReadThread.start();

        connectThread = new ConnectThread();
        connectThread.start();

//        cliSendFileThread = new CliSendFileThread();
//        cliSendFileThread.start();

    }
}
