package com.cykj.Thread;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.TFriend;
import com.cykj.bean.TGroup;
import com.cykj.bean.TRecord;
import com.cykj.dao.UserDao;
import com.cykj.dao.impl.FriendsDaoImpl;
import com.cykj.dao.impl.RecordsDaoImpl;
import com.cykj.dao.impl.UserDaoImpl;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class ServerRec extends Thread {
    private Socket socket;//本类的socket   未被使用
    private BufferedReader bufRed;
    private PrintWriter priWriter;
    private UserDao userDao;
    public String state;
    public int num;//当前页

    public ServerRec(Socket socket) {//使用的是外部传进来的socket
        this.socket = socket;//本类的socket   未被使用
        try {
            bufRed = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            priWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            userDao = new UserDaoImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //持续等待消息
    @Override
    public void run() {
        while (true) {
            rec();
//            recMass();
        }
    }

    //接受
    public void rec() {
        String line = null;
        try {
            FriendsDaoImpl friendsDao = new FriendsDaoImpl();//实体类方法
            RecordsDaoImpl recordsDao = new RecordsDaoImpl();
            line = bufRed.readLine();//阻塞接受客户端消息
            System.out.println("收到数据" + line);
//            String [] str=line.split("%");//下标切割
//            String action=str[0];//收到协议头（判断登录还是注册）
            JSONObject recJson = JSONObject.parseObject(line);//接受的JSONObject
            String action = recJson.getString("action");//拿到 recJson 的 "action"
//            String result="";//返回字符串
            switch (action) {
                case "login":
                    String uname = recJson.getString("acc");
                    String upwd = recJson.getString("psw");
                    boolean login = userDao.login(uname, upwd);
                    System.out.println("登陆" + login);
                    JSONObject js = new JSONObject(); //应答的JSONObject
                    js.put("flag", login);
                    if (login) {//登录成功 利用qqId来判断登入的用户
                        SeverThread.threadMap.put(uname, this);
                    }
                    //调用FriendDaoImpl实现类方法
                    List<TGroup> tGroups = friendsDao.selectGroupName();
                    List<TFriend> tFriends = friendsDao.relation(uname);
                    //将FriendDaoImpl的返回值    加入到应答的JSONObject里
                    js.put("组名", tGroups);
                    js.put("好友", tFriends);
                    //将应答消息：{"action":"login"}放入
                    js.put("action", "login");
                    //调用发送方法 将应答的JSONObject对象返回出的字符串表达 发送出去
                    System.out.println("发送："+js.toJSONString());
                    send(js.toJSONString());
                    break;
                case "logon"://注册
                    //先拿到需要的key
                    String userId = recJson.getString("qqid");
                    String name = recJson.getString("name");
                    String psw = recJson.getString("psw");
                    String age = recJson.getString("age");
                    String address = recJson.getString("address");
                    //布尔值
                    boolean logon = userDao.logon(userId, name, psw, Integer.parseInt(age), address);
                    System.out.println("注册" + logon);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("flagLogon", logon);
                    jsonObject.put("action", "logon");
                    send(jsonObject.toJSONString());
                    break;
                case "sendOut"://群发
                    String sendTxt = recJson.getString("sendTxt");
                    String sendId = recJson.getString("from");
                    System.out.println("发送" + sendTxt);
                    //每个线程都代表一个客户端加入
                    //          id     拿到每个客户端的消息
                    for (String key : SeverThread.threadMap.keySet()) {//群发
                        recJson.put("id", key);//将id放入方便显示在消息前
                        SeverThread.threadMap.get(key).send(recJson.toJSONString());
                    }
//                    send(recJson.toJSONString());//单个用户
                    //插入到数据库
                    recordsDao.insertRec(sendId,"1008",1,sendTxt,"已读");
                    break;
                case "oneSend"://单发
                    String oneSendId = recJson.getString("from");//谁发的
                    String oneSendTxt = recJson.getString("msg");//发什么的消息
                    String to = recJson.getString("to");//发给谁
                    state = null;
                    ServerRec serverRec = SeverThread.threadMap.get(to);
                    if (serverRec == null){
                        //没有上线
                        System.out.println("没有在线");
                        state = "未读";
                        //应答
                    }else {
                        System.out.println("转发"+line);
                        state = "已读";
                        serverRec.send(line);
                    }
                    recordsDao.insertRec(oneSendId,to,0,oneSendTxt,state);
                    break;
                case "heart":
                    //给客户端个应答，告诉它服务器自己还在
                    //这是在心脏内写计数器的写法
                    send(line);
                    //这是在CliReadThread写计数器的写法
//                    recJson.put("action","heart");
//                    send(recJson.toJSONString());
                    break;
                case "recShow":
                    num = 0;
                    String recName = recJson.getString("acc");
                    List<TRecord> tRecords = recordsDao.selectRec(recName,num);
                    int count = recordsDao.queryCount(recName);

                    System.out.println("查看聊天记录的动作，发送"+tRecords);
                    System.out.println("总页数，发送"+count);

                    recJson.put("recMsg",tRecords);
                    recJson.put("count",count);
                    send(recJson.toJSONString());
                    break;
                case "upPage":
                    if (num>=5){
                        num-=5;
                    }
                    System.out.println("当前的num等于："+num);
                    String upRecName = recJson.getString("acc");
                    List<TRecord> recordList = recordsDao.selectRec(upRecName,num);
                    System.out.println("上一页的动作，发送"+recordList);
                    recJson.put("upRec",recordList);
                    send(recJson.toJSONString());
                    break;
                case "downPage":
                    if (num<=30){
                        num+=5;
                    }
                    System.out.println("当前的num等于："+num);
                    String downRecName = recJson.getString("acc");
                    List<TRecord> downRecordList = recordsDao.selectRec(downRecName,num);
                    System.out.println("下一页的动作，发送"+downRecordList);
                    recJson.put("downRec",downRecordList);
                    send(recJson.toJSONString());
                    break;
                case "sendFile":
                    String fileName = recJson.getString("fileName");//获取
                    String fileSize = recJson.getString("fileSize");//获取
                    String filePath = recJson.getString("filePath");//获取
                    //实例化服务端的文件读取线程并开启
                    ServerReadFileThread serverReadFileThread = new ServerReadFileThread(fileName);//实例化文件读取线程
                    serverReadFileThread.start();//线程开启
                    //放入指令和对应的value
                    recJson.put("action","sendFile");
                    recJson.put("fileSize",fileSize);
                    recJson.put("filePath",filePath);
                    //调用发送方法
                    send(recJson.toJSONString());
                    break;
                case "downLoad":
                    String downFilePath = recJson.getString("downFilePath");
                    String downFileName = recJson.getString("downFileName");
                    String downFileSize = recJson.getString("downFileSize");
//                    String
                    //实例化服务端的文件发送线程并开启
                    ServerSendFileThread sendFileThread = new ServerSendFileThread(downFilePath);
                    sendFileThread.start();
                    recJson.put("action","downLoad");
                    recJson.put("filePath",downFilePath);
                    recJson.put("downFileName",downFileName);
                    recJson.put("downFileSize",downFileSize);
                    //指令
                    send(recJson.toJSONString());
                    break;

            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void send(String line) {
        priWriter.println(line);
        priWriter.flush();
    }
}
