package com.cykj.Thread;

import com.cykj.service.BizService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class SeverThread extends Thread {
    //                 action
    public static Map<String, BizService> allService = new HashMap<>();
    public static Map<String,ServerRec> threadMap = new HashMap<>();
    public SeverThread() {
        try {
            ServerSocket serverSocket = new ServerSocket(10086);
            System.out.println("服务器启动");
            while (true){
            try {
                Socket socket = serverSocket.accept();
                ServerRec serverRec = new ServerRec(socket);       //一个客户端连接，开一个线程，实现对每个 客户端都持续等待信息 的功能
                serverRec.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readService(){
        //反射

        try {
            InputStream inputStream = new FileInputStream("service.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            Set<String> keys = properties.stringPropertyNames();
            for (String k : keys) {
                System.out.println(k+"，"+properties.getProperty(k));
                Class clazz = Class.forName(properties.getProperty(k));
                Object object = clazz.newInstance();
                allService.put(k, (BizService) object);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
//    //等待接收
//    @Override
//    public void run() {
//        try {
//            while (true) {
//                Socket socket = serverSocket.accept();
//                System.out.println(socket);
//                if (socket != null) {
//                    System.out.println("客户端连接");
//                    ServerRec clientRec =new ServerRec(socket);
//                    clientRec.start();
//
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
