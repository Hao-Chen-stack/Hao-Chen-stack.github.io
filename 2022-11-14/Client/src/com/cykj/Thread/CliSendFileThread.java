package com.cykj.Thread;

import com.alibaba.fastjson.JSONObject;
import com.cykj.view.CliSendFileProFrame;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CliSendFileThread  extends Thread{
    private int fileSize;
    private String filePath;
    //利用构造函数拿到所需要的  文件大小，文件绝对路径
    public CliSendFileThread(int fileSize,String filePath){
        this.fileSize = fileSize;
        this.filePath = filePath;
    }
    @Override
    public void run() {
        try {
            //实例化进度条界面
            CliSendFileProFrame proFrame = new CliSendFileProFrame(fileSize);
            //客户端接口
            Socket socket = new Socket("localhost",10088);
            //字节流，输出流-----用来发送字节
            OutputStream outputStream = socket.getOutputStream();

            //1、文件的基本信息：字符流
            File file = new File(filePath);
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("action","sendFile");
//            jsonObject.put("fileName",file.getName());
//            jsonObject.put("fileSize",file.length());
//            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
//            writer.println(jsonObject.toJSONString());
//            writer.flush();

            Thread.sleep(100);//发送的时候不要太快，间隔一下，防止丢包
            //2、文件内容：字节流
            FileInputStream fileInputStream = new FileInputStream(file);//直接读文件对象



            byte[] buffer = new byte[1024];
            int len = 0;
            int nowCount = 0;//定义一个传输总和
            System.out.println("发送开始");
            while ((len = fileInputStream.read(buffer)) !=-1){
                outputStream.write(buffer,0,len);
                outputStream.flush();//刷新一下
                System.out.println(len);
                nowCount+=len;//传输总和的赋值
                proFrame.getSendFilePro().setValue(nowCount);//将传输总和放入进度条组件
            }
            System.out.println("发送完毕...");
            fileInputStream.close();//关闭流
            Thread.sleep(100);//发送的时候不要太快，间隔一下，防止丢包
            outputStream.close();//关闭流
            socket.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e){
            e.getStackTrace();
        }
    }



//    public static void main(String[] args) {
//        try {
//            Socket socket = new Socket("localhost",10088);
//            OutputStream outputStream = socket.getOutputStream();
//
//            //1、文件的基本信息：字符流
//            File file = new File("server\\druid.properties");
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("action","sendFile");
//            jsonObject.put("fileName",file.getName());
//            jsonObject.put("fileSize",file.length());
//            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
//            writer.println(jsonObject.toJSONString());
//            writer.flush();
//
//            Thread.sleep(100);//发送的时候不要太快，间隔一下
//            //2、文件内容：字节流
//            FileInputStream fileInputStream = new FileInputStream("server\\druid.properties");
//
//
//
//            byte[] buffer = new byte[1024];
//            int len = 0;
//            System.out.println("发送开始");
//            while ((len = fileInputStream.read(buffer)) !=-1){
//                outputStream.write(buffer,0,len);
//                outputStream.flush();
//                System.out.println(len);
//            }
//            System.out.println("发送完毕...");
//            fileInputStream.close();
//            Thread.sleep(100);
//            outputStream.close();
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }catch (InterruptedException e){
//            e.getStackTrace();
//        }
//    }


//    public CliSendFileThread(){
//        try {
//            ServerSocket serverSocket = new ServerSocket(10088);
//            Socket socket = serverSocket.accept();
//
//            FileOutputStream fileOutputStream = new FileOutputStream("server\\druid.properties");
//
//            InputStream inputStream = socket.getInputStream();
//            byte[] buffer = new byte[1024];
//            int len = 0;
//            System.out.println("发送开始");
//            while ((len = inputStream.read(buffer)) !=-1){
//                fileOutputStream.write(buffer,0,len);
//                fileOutputStream.flush();
//                System.out.println(len);
//            }
//            System.out.println("发送完毕...");
//            fileOutputStream.close();
//            Thread.sleep(100);
//            inputStream.close();
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }catch (InterruptedException e){
//            e.getStackTrace();
//        }
//    }

}
