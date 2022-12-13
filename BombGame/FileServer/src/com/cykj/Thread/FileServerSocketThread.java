package com.cykj.Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServerSocketThread extends Thread {
    public FileServerSocketThread() {
        try {
            ServerSocket serverSocket = new ServerSocket(10090);
            System.out.println("文件服务器启动");
            while (true){
                try {
                    Socket socket = serverSocket.accept();
                    FileServerRec fileServerRec = new FileServerRec(socket);       //一个客户端连接，开一个线程，实现对每个 客户端都持续等待信息 的功能
                    fileServerRec.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
