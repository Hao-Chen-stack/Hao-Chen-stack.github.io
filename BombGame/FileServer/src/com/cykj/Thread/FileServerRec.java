package com.cykj.Thread;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;

public class FileServerRec  extends Thread{
    private Socket socket;//本类的socket   未被使用
    private BufferedReader bufRed;
    private PrintWriter priWriter;

    public FileServerRec(Socket socket) {
        this.socket = socket;
        try {
            bufRed = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            priWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            rec();
        }
    }

    public void rec() {
        String line = null;
        try {
            //调用实体类方法
            line = bufRed.readLine();//阻塞接受客户端消息
            System.out.println("文件服务器收到数据" + line);
            JSONObject recJson = JSONObject.parseObject(line);//接受的JSONObject
            String action = recJson.getString("action");//拿到 recJson 的 "action"
            switch (action) {
                case "downLoad":
                    String file = recJson.getString("file");
                    ServerSendFileThread sendFileThread = new ServerSendFileThread(file,socket);
                    sendFileThread.start();
                    break;


            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

//    public void send(String line) {
//        priWriter.println(line);
//        priWriter.flush();
//    }
}
