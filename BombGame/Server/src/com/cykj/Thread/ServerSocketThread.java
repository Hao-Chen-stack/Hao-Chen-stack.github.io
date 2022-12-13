package com.cykj.Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerSocketThread extends Thread{
    public static Map<String,ServerRec> threadMap = new HashMap<>();
    public ServerSocketThread(){
        try {
            ServerSocket serverSocket = new ServerSocket(10092);
            System.out.println("业务服务器启动");
            //端口一直处于打开状态，所以利用while(true)
            while (true){
                try {
                    Socket socket = serverSocket.accept();
                    //一个客户端连接，开一个线程，实现对每个 客户端都持续等待信息 的功能
                    ServerRec serverRec = new ServerRec(socket);
                    serverRec.start();
                }catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("等待客户端连接中");
        }
    }
}
