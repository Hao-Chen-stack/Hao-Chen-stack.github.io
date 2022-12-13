package com.cykj.Thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSendFileThread extends Thread {
    private String filePath;

    public ServerSendFileThread(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            //开启一个服务器发送端口
            ServerSocket serverSocket = new ServerSocket(10090);
            //在一个套接口接受一个连接
            Socket socket = serverSocket.accept();
            //字节流，输出流-----用来发送字节
            OutputStream outputStream = socket.getOutputStream();

            //1、文件的基本信息：字符流
            File file = new File(filePath);

            Thread.sleep(100);//发送的时候不要太快，间隔一下，防止丢包
            //2、文件内容：字节流
            FileInputStream fileInputStream = new FileInputStream(file);//直接读文件对象



            byte[] buffer = new byte[1024];
            int len = 0;
            System.out.println("发送开始");
            while ((len = fileInputStream.read(buffer)) !=-1){
                outputStream.write(buffer,0,len);
                outputStream.flush();//刷新一下
                System.out.println(len);
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
}
