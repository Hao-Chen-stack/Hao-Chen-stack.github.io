package com.cykj.Thread;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.TFriend;
import com.cykj.bean.TGroup;
import com.cykj.bean.TRecord;
import com.cykj.controller.CliController;
import com.cykj.view.CliChatFrame;
import com.cykj.view.UI;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CliReadThread extends Thread {
    public CliController con;
    private Socket socket;
    private BufferedReader bufRed;
    private PrintWriter priWriter;
    private CliChatFrame chatFrame;
    private int heartNum;
    public int num = 0;

    public int getHeartNum() {
        return heartNum;
    }

    public void setHeartNum(int heartNum) {
        this.heartNum = heartNum;
    }

    public CliReadThread(Socket socket) {
        try {
            //建立连接
//            socket = new Socket("localhost", 10086);
            System.out.println("建立与" + socket + "服务器链接");
            //输出
            bufRed = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            priWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "服务器未开启",
                    "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void run() {
        while (true) {
            rec();
        }
    }

    // 关闭流
//    public void closeIO() {
//        try {
//            if (dis != null) {
//                dis.close();
//            }
//            if (dos != null) {
//                dos.close();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void rec() {
        try {

            //获取北京时间
            Locale locale = Locale.CHINA;
            String pattern = "yyyy-MM-dd kk:mm:ss zZ";
            SimpleDateFormat df = new SimpleDateFormat(pattern, locale);
            Date date = new Date();
            String bjTime = df.format(date);
            System.out.println(bjTime);//打印北京时间

            //接受服务器消息
            String line = bufRed.readLine();//阻塞等待接受服务器消息

//            chatFrame.cliChatPanel.getjTextArea().append(line+"\n");
            System.out.println("收到server 的信息" + line);
            JSONObject js = JSONObject.parseObject(line);
            String action = js.getString("action");
            switch (action) {
                case "login":
                    if (js.getBoolean("flag")) {
                        JOptionPane.showMessageDialog(null, "登录成功",
                                "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                        UI.loginUserFrame.setVisible(false);
                        UI.chatFrame.setVisible(true);
                        //将集合转化成JSON
                        List<TGroup> tGroups = JSONObject.parseArray(js.getString("组名")).toJavaList(TGroup.class);
                        List<TFriend> tFriends = JSONObject.parseArray(js.getString("好友")).toJavaList(TFriend.class);
                        //将集合传进树里
                        UI.chatFrame.cliChatPanel.setTree(tGroups, tFriends);

                    } else {
                        JOptionPane.showMessageDialog(null, "登录失败",
                                "温馨提示", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "logon":
                    if (js.getBoolean("flagLogon")) {
                        JOptionPane.showMessageDialog(null, "注册成功",
                                "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                        UI.logonFrame.setVisible(false);
                        UI.loginUserFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "注册失败",
                                "温馨提示", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "sendOut"://群发
                    String s = js.getString("sendTxt");//发送的消息
                    String userId = js.getString("id");//id
                    System.out.println("消息为" + s);
                    UI.chatFrame.cliChatPanel.getjTextArea().append("北京时间" + bjTime + "\n来自账户" + userId + "的消息：\n" + s + "\n");
                    break;
                case "oneSend"://单发
                    String from = js.getString("from");
                    String msg = js.getString("msg");
                    UI.chatFrame.cliChatPanel.getjTextArea().append("北京时间" + bjTime + "\n来自账户" + from + "的消息：\n" + msg + "\n");
                    break;
                case "heart":
                    //收到应答，计数器归零
                    HeartThread.heartCount = 0;//这是在心脏内写计数器的写法
//                    heartNum = 0;;//这是在CliReadThread写计数器的写法
                    break;
                case "recShow":
                    UI.cliRecordsFrame.cliRecordPanel.getRecTm().setRowCount(0);
                    List<TRecord> tRecords = JSONObject.parseArray(js.getString("recMsg")).toJavaList(TRecord.class);
                    for (TRecord tRecord : tRecords) {
                        String[] data={tRecord.getSendid(),
                                        tRecord.getRecvid(),
                                        String.valueOf(tRecord.getRectype()),
                                        tRecord.getContent(),
                                        String.valueOf(tRecord.getRectime())};
                        UI.cliRecordsFrame.cliRecordPanel.getRecTm().addRow(data);
                    }
                    int count = js.getInteger("count");
                    if (count%5 !=0){
                        UI.cliRecordsFrame.cliRecordPanel.pageTotal = (count/5)+1;
                    }else {
                        UI.cliRecordsFrame.cliRecordPanel.pageTotal = count/5;
                    }
                    UI.cliRecordsFrame.cliRecordPanel.getPageTotalLabel().setText("总页数："+UI.cliRecordsFrame.cliRecordPanel.pageTotal);
//                    UI.cliRecordsFrame.cliRecordPanel.getPageTotalLabel().repaint();
                    break;
                case "upPage":
                    if (UI.cliRecordsFrame.cliRecordPanel.nowPage > 1){
                        UI.cliRecordsFrame.cliRecordPanel.getRecTm().setRowCount(0);
                        List<TRecord> recordList = JSONObject.parseArray(js.getString("upRec")).toJavaList(TRecord.class);
//                        System.out.println("--------------------------------------集合长度"+recordList.size());
                        for (TRecord tRecord : recordList) {
                            String[] data={tRecord.getSendid(),
                                    tRecord.getRecvid(),
                                    String.valueOf(tRecord.getRectype()),
                                    tRecord.getContent(),
                                    String.valueOf(tRecord.getRectime())};
                            UI.cliRecordsFrame.cliRecordPanel.getRecTm().addRow(data);
                        }
                        UI.cliRecordsFrame.cliRecordPanel.nowPage--;//当前页数减1
                        UI.cliRecordsFrame.cliRecordPanel.getPageLabel().setText("当前页数："+UI.cliRecordsFrame.cliRecordPanel.nowPage);
                    }
                    break;
                case "downPage":
                    if (UI.cliRecordsFrame.cliRecordPanel.pageTotal != UI.cliRecordsFrame.cliRecordPanel.nowPage){
                        UI.cliRecordsFrame.cliRecordPanel.getRecTm().setRowCount(0);
                        List<TRecord> downRecordList = JSONObject.parseArray(js.getString("downRec")).toJavaList(TRecord.class);
                        for (TRecord tRecord : downRecordList) {
                            String[] data={tRecord.getSendid(),
                                    tRecord.getRecvid(),
                                    String.valueOf(tRecord.getRectype()),
                                    tRecord.getContent(),
                                    String.valueOf(tRecord.getRectime())};
                            UI.cliRecordsFrame.cliRecordPanel.getRecTm().addRow(data);
                        }
                        UI.cliRecordsFrame.cliRecordPanel.nowPage++;
                        UI.cliRecordsFrame.cliRecordPanel.getPageLabel().setText("当前页数："+UI.cliRecordsFrame.cliRecordPanel.nowPage);
                    }
                    break;
                case "sendFile":
                    int fileSize = js.getInteger("fileSize");//获取
                    String filePath = js.getString("filePath");//获取
                    //实例化客户端的文件发送线程并开启
                    CliSendFileThread cliSendFileThread = new CliSendFileThread(fileSize,filePath);//实例化文件发送线程
                    cliSendFileThread.start();//线程开启
                    break;
                case "downLoad":
                    JFileChooser jFileChooser = new JFileChooser();
                    jFileChooser.setDialogTitle("请选择保存位置");
                    jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//仅显示目录
                    int ans = jFileChooser.showSaveDialog(null);//保存弹窗
                    if (ans ==JFileChooser.APPROVE_OPTION){
                        String downFilePath = jFileChooser.getSelectedFile().getAbsolutePath();
                        System.out.println("文件的保存路径为"+downFilePath);
                        String downFileName = js.getString("downFileName");
                        int downFileSize = js.getInteger("downFileSize");
                        //实例化客户端的文下载线程并开启
                        CliDownLoadFileThread cliDownLoadFileThread = new CliDownLoadFileThread(downFileName,downFileSize,downFilePath);
                        cliDownLoadFileThread.start();
                    }
                    break;

            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("正在尝试重新连接");
            if (num<100){
                num++;
                UI.loginUserFrame.loginPanel.heartLabel.setText("尝试重新连接"+num+"%");
                UI.loginUserFrame.loginPanel.heartLabel.repaint();
            }

        }
    }

    public void send(String line) {
        System.out.println("客户端发送给服务器的信息" + line);
        priWriter.println(line);
        priWriter.flush();//刷新
    }
}
