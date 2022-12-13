package com.cykj.Thread;

import com.cykj.controller.CliController;
import com.cykj.view.UI;

import java.io.IOException;
import java.net.Socket;

public class ConnectThread extends Thread {
    public int num = 0;
    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = new Socket("localhost", 10086);
                //读取客户端发送过来消息的线程，将它放在连接线程内启动
                CliController.cliReadThread = new CliReadThread(socket);
                CliController.cliReadThread.start();
                //心脏线程随时启动
                HeartThread heartThread = new HeartThread();
                heartThread.start();
                break;//没报错退出该线程
            } catch (IOException e) {
                e.printStackTrace();
                if (num<100){
                    num++;
                    UI.loginUserFrame.loginPanel.heartLabel.setText("尝试重新连接"+num+"%");
                    UI.loginUserFrame.loginPanel.heartLabel.repaint();
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
