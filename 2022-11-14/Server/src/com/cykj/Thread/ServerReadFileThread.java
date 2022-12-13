package com.cykj.Thread;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerReadFileThread  extends Thread{
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ServerReadFileThread(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            //开启一个服务器接收端口
            ServerSocket serverSocket = new ServerSocket(10088);
            //在一个套接口接受一个连接
            Socket socket = serverSocket.accept();
            //字节流，输入流---将端口用来接收，拿到字节
            InputStream inputStream = socket.getInputStream();

//            BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));

//            String line = bufReader.readLine();
//            System.out.println(line);
//            JSONObject jsonObject = JSONObject.parseObject(line);
//            String fileName = jsonObject.getString("fileName");
//            long fileSize = jsonObject.getLong("fileSize");


//            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\86182\\Desktop\\druid.properties");

            //发送的文件名字
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\86182\\Desktop\\"+fileName);
            //利用buffer传输,每次传输1024KB
            byte[] buffer = new byte[1024];
            //发送的长度
            int len = 0;
            System.out.println("接收开始");
            while ((len = inputStream.read(buffer)) !=-1){//长度不等于-1才开始发送
                fileOutputStream.write(buffer,0,len);//从0开始输出，到达发送的长度结束
                fileOutputStream.flush();//刷新一下
                System.out.println(len);
            }
            System.out.println("接收完毕...");
            fileOutputStream.close();//关闭流
            Thread.sleep(100);//给个延迟,防止出现异常
            inputStream.close();//关闭流
            socket.close();//关闭接口

        } catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e){
            e.getStackTrace();
        }
    }

    //    public static void main(String[] args) {
//        try {
//            ServerSocket serverSocket = new ServerSocket(10088);
//            Socket socket = serverSocket.accept();
//            InputStream inputStream = socket.getInputStream();
//            BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
//
//            String line = bufReader.readLine();
//            System.out.println(line);
//            JSONObject jsonObject = JSONObject.parseObject(line);
//            String fileName = jsonObject.getString("fileName");
//            long fileSize = jsonObject.getLong("fileSize");
//
//
////            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\86182\\Desktop\\druid.properties");
//            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\86182\\Desktop\\"+fileName);
//
//
//            byte[] buffer = new byte[1024];
//            int len = 0;
//            System.out.println("接收开始");
//            while ((len = inputStream.read(buffer)) !=-1){
//                fileOutputStream.write(buffer,0,len);
//                fileOutputStream.flush();
//                System.out.println(len);
//            }
//            System.out.println("接收完毕...");
//            fileOutputStream.close();
//            Thread.sleep(100);
//            inputStream.close();
//            socket.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }catch (InterruptedException e){
//            e.getStackTrace();
//        }
//    }
}
