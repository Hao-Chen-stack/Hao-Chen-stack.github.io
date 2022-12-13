package com.cykj.Thread;

import com.cykj.controller.CliController;
import com.cykj.view.UI;

import java.io.IOException;
import java.net.Socket;

public class ConnectThread extends Thread {
    public int num = 0;
    public CliController con;

    public ConnectThread(CliController con){
        this.con = con;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = new Socket("localhost", 10092);
//                Socket fileSocket = new Socket("localhost",10086);
                //读取客户端发送过来消息的线程，将它放在连接线程内启动
                CliController.cliReadThread = new CliReadThread(socket,con);
                CliController.cliReadThread.start();
//                CliController.cliFileReadThread = new CliFileReadThread(fileSocket);
//                CliController.cliFileReadThread.start();
                //心脏线程随时启动
                HeartThread heartThread = new HeartThread(con);
                heartThread.start();
                break;//没报错退出该线程
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("尝试重新连接"+num+"%");
                if (num<100){
                    num++;
                    //登录界面重新连接字样
                    UI.loginFrame.loginPanel.getReLinkLabel().setText("尝试重新连接"+num+"%");
                    UI.loginFrame.loginPanel.getReLinkLabel().repaint();
                    //注册界面重新连接字样
                    UI.logonFrame.logonPanel.getReLinkLabel().setText("尝试重新连接"+num+"%");
                    UI.logonFrame.logonPanel.getReLinkLabel().repaint();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}
