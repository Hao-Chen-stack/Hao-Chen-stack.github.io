package com.cykj.Thread;

//import com.cykj.view.CliSendFileProFrame;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;

public class CliDownLoadFileThread extends Thread {
    public Socket socket;
    private BufferedReader bufRed;
    private PrintWriter priWriter;
    private String saveFilePath;
    private int fileSize;
    //利用构造函数拿到所需要的  文件大小，文件绝对路径

    public CliDownLoadFileThread(String saveFilePath) {
        this.saveFilePath = saveFilePath;
        try {
            socket = new Socket("localhost",10090);
            bufRed = new BufferedReader(new InputStreamReader(socket.getInputStream()));//读
            priWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));//写
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            //实例化进度条界面
//            CliSendFileProFrame proFrame = new CliSendFileProFrame(fileSize);
            //客户端接口
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("action","downLoad");
            jsonObject.put("file",saveFilePath);
            send(jsonObject.toJSONString());

            //字节流，输入流---将端口用来接收，拿到字节
            InputStream inputStream = socket.getInputStream();
            //保存的目录
            String dir = "Client/image/player";
            File file = new File(dir);
            if (!file.exists()){
                file.mkdirs();
            }
            String[] strings = saveFilePath.split("/");
            String fileName = strings[strings.length-1];
            fileName = dir + "/"+fileName;
            System.out.println("-----"+fileName);

            //发送的文件名字
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
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
//                proFrame.getSendFilePro().setValue(nowCount);//将传输总和放入进度条组件
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

    public void send(String line) {
        priWriter.println(line);
        priWriter.flush();
    }


}
