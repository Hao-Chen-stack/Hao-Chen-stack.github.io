package com.cykj.Thread;

import com.cykj.view.CliSendFileProFrame;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CliDownLoadFileThread extends Thread {
    private String filename;
    private String saveFilePath;
    private int fileSize;
    //利用构造函数拿到所需要的  文件大小，文件绝对路径


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSaveFilePath() {
        return saveFilePath;
    }

    public void setSaveFilePath(String saveFilePath) {
        this.saveFilePath = saveFilePath;
    }

    public CliDownLoadFileThread(String filename,int fileSize,String saveFilePath) {
        this.filename = filename;
        this.fileSize = fileSize;
        this.saveFilePath = saveFilePath;
    }

    @Override
    public void run() {
        try {
            //实例化进度条界面
            CliSendFileProFrame proFrame = new CliSendFileProFrame(fileSize);
            //客户端接口
            Socket socket = new Socket("localhost",10090);
            //字节流，输入流---将端口用来接收，拿到字节
            InputStream inputStream = socket.getInputStream();
            //发送的文件名字
            FileOutputStream fileOutputStream = new FileOutputStream(saveFilePath+"\\"+filename);
            //利用buffer传输,每次传输1024KB
            byte[] buffer = new byte[1024];
            //发送的长度
            int len = 0;
            int nowCount = 0;//传输总和
            System.out.println("下载开始");
            while ((len = inputStream.read(buffer)) !=-1){//长度不等于-1才开始发送
                fileOutputStream.write(buffer,0,len);//从0开始输出，到达发送的长度结束
                fileOutputStream.flush();//刷新一下
                System.out.println(len);
                nowCount+=len;
                proFrame.getSendFilePro().setValue(nowCount);//将传输总和放入进度条组件
            }
            System.out.println("下载完毕...");
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
}
