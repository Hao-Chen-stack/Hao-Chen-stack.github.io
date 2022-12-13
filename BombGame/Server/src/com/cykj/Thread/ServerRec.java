package com.cykj.Thread;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.*;
import com.cykj.dao.impl.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerRec extends Thread {
    public BombUserDaoImpl bombUserDao;
    public BombRecordDaoImpl bombRecordDao;
    public BombRoomDaoImpl bombRoomDao;
    public BombUserStyleDaoImpl bombUserStyleDao;
    public String line;
    public JSONObject recJson;
    public JSONObject js;
    public String userState;
    public String userName;
    public List<BombUser> bombUsers;
    public String state;
    public int num;//当前页
    public String createUid;//房间创建者id
    public String loginUserId;
    private Socket socket;//定义一个本类的接口属性，后续可能会用到
    private BufferedReader bufRed;
    private PrintWriter priWriter;
    private  String roomPlayerId;
    public String masterid;
    public String playerid;
    public ServerRec(Socket socket) {
        this.socket = socket;//本类的socket，后续可能使用，先声明放着
        try {
            //调用IO流内的封装流来实现应答消息的收发
            bufRed = new BufferedReader(new InputStreamReader(socket.getInputStream()));//读
            priWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));//写
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //持续等待消息
    @Override
    public void run() {
//        while (true){
        rec();
//        }
    }

    //接收消息的方法
    public void rec() {
        try {

            while (true) {
                //调用实体类方法
                bombUserDao = new BombUserDaoImpl();
                bombRecordDao = new BombRecordDaoImpl();
                BombDressDaoImpl bombDressDao = new BombDressDaoImpl();
                bombRoomDao = new BombRoomDaoImpl();
                bombUserStyleDao = new BombUserStyleDaoImpl();
                line = bufRed.readLine();//阻塞等待接收客户端消息
                System.out.println("收到来自客户端的消息" + line);
                recJson = JSONObject.parseObject(line);//接收用的JSON
                //拿到 recJson 的 "action"
                String action = recJson.getString("action");
                switch (action) {
                    case "login":
                        //获取用户名
                        BombUserstyle Userstyle = null;
                        userName = recJson.getString("acc");
                        //获取密码
                        String userPsw = recJson.getString("psw");
                        //声明一个布尔值来接受登录实体类方法的返回值
                        boolean login = bombUserDao.login(userName, userPsw);
                        System.out.println("登录状态：" + login);
                        //应答的JSONObject
                        js = new JSONObject();
                        js.put("flag", login);
                        js.put("action", "login");
                        userState = "离线";
                        if (login) {
                            ServerSocketThread.threadMap.put(userName, this);
                            Userstyle = bombUserStyleDao.queryStyle(userName);
                            js.put("queryStyle", Userstyle);
                        }
                        //调用BombUserDaoImpl实现类方法
                        bombUsers = bombUserDao.selectUser(userName);
                        //离线和在线状态的切换
                        //先遍历线程集合找到所有用户
                        for (String allUser : ServerSocketThread.threadMap.keySet()) {
                            //在遍历bean的集合找到当前用户
                            for (BombUser b : bombUsers) {
                                //如果线程集合内存在当前登陆上的id，就将状态改为在线
                                if (b.getUserid().equals(allUser)) {
                                    userState = "在线";
                                    b.setLoginstate(userState);
                                }
//                                else {
//                                    js.put("flag",!login);
//                                }
                            }
                        }
                        //将状态更新过的集合加入到json
                        js.put("id", userName);
                        js.put("好友", bombUsers);
                        //将状态更新过的集合发送出去
                        for (String sendState : ServerSocketThread.threadMap.keySet()) {
                            ServerSocketThread.threadMap.get(sendState).send(js.toJSONString());
                        }
                        /*注释时间为     2022-11-24 23:26:25
                          调用发送方法 将应答的JSONObject对象返回出的字符串表达 发送出去
                         System.out.println("发送：" + js.toJSONString());
                         send(js.toJSONString());
                         */
                        break;
                    case "logon"://注册
                        //先拿到需要的key
                        String userId = recJson.getString("userid");
                        String name = recJson.getString("username");
                        String psw = recJson.getString("userpwd");
                        //布尔值
                        boolean logon = bombUserDao.logon(userId, name, psw);
                        System.out.println("注册" + logon);
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("flagLogon", logon);
                        jsonObject.put("action", "logon");
                        send(jsonObject.toJSONString());
                        break;
                    case "sendOutAll"://群发
                        String sendTxt = recJson.getString("sendTxt");
                        String sendId = recJson.getString("from");
                        System.out.println("群发发送：" + sendTxt);
                        //每个线程都代表一个客户端加入
                        for (String key : ServerSocketThread.threadMap.keySet()) {//群发
                            recJson.put("id", key);//将id放入方便显示在消息前
                            ServerSocketThread.threadMap.get(key).send(recJson.toJSONString());
                        }
                        //插入到数据库
                        bombRecordDao.insertRec(sendId, "所有人", 1, sendTxt, "发送成功");
                        break;
                    case "sendOne":
                        String oneSendId = recJson.getString("from");//谁发的
                        String oneSendTxt = recJson.getString("msg");//发什么的消息
                        String to = recJson.getString("to");//发给谁
                        state = null;
                        ServerRec serverRec = ServerSocketThread.threadMap.get(to);
                        if (serverRec == null) {
                            System.out.println("未在线");
                            state = "未读";
                        } else {
                            System.out.println("转发" + line);
                            state = "已读";
                            serverRec.send(line);
                        }
                        bombRecordDao.insertRec(oneSendId, to, 0, oneSendTxt, state);
                        break;
                    //以下为群聊的聊天记录
                    case "recShow":
                        num = 0;
                        String recName = recJson.getString("acc");
                        List<BombRecord> bombRecords = bombRecordDao.selectRec(recName, num);
                        int count = bombRecordDao.queryCount(recName);

                        System.out.println("查看群聊聊天记录的动作，发送" + bombRecords);
                        System.out.println("群聊聊天记录总页数，发送" + count);

                        recJson.put("recMsg", bombRecords);
                        recJson.put("count", count);
                        send(recJson.toJSONString());
                        break;
                    case "upPage":
                        if (num >= 5) {
                            num -= 5;
                        }
                        System.out.println("当前的num等于：" + num);
                        String upRecName = recJson.getString("acc");
                        List<BombRecord> recordList = bombRecordDao.selectRec(upRecName, num);
                        System.out.println("上一页的动作，发送" + recordList);
                        recJson.put("upRec", recordList);
                        send(recJson.toJSONString());
                        break;
                    case "downPage":
                        if (num <= 30) {
                            num += 5;
                        }
                        System.out.println("当前的num等于：" + num);
                        String downRecName = recJson.getString("acc");
                        List<BombRecord> downRecordList = bombRecordDao.selectRec(downRecName, num);
                        System.out.println("下一页的动作，发送" + downRecordList);
                        recJson.put("downRec", downRecordList);
                        send(recJson.toJSONString());
                        break;
                    //以下为私聊的聊天记录
                    case "recSendOneShow":
                        num = 0;
                        String sendOneId = recJson.getString("sendId");
                        String recvId = recJson.getString("recvId");
                        List<BombRecord> recSendOneList = bombRecordDao.selectSendOneRec(sendOneId, recvId, num);
                        int sendOneCount = bombRecordDao.querySendOneCount(sendOneId, recvId);
                        System.out.println("查看私聊聊天记录的动作，发送" + recSendOneList);
                        System.out.println("私聊聊天记录总页数，发送" + sendOneCount);

                        recJson.put("recSendOneShow", recSendOneList);
                        recJson.put("sendOneCount", sendOneCount);
                        send(recJson.toJSONString());
                        break;
                    case "up":
                        if (num >= 5) {
                            num -= 5;
                        }
                        String sendUser = recJson.getString("upSendId");
                        String recvUser = recJson.getString("upRecvId");
                        List<BombRecord> records = bombRecordDao.selectSendOneRec(sendUser, recvUser, num);
                        recJson.put("SendOneUpRec", records);
                        send(recJson.toJSONString());
                        break;
                    case "down":
                        num += 5;
                        String sendUserD = recJson.getString("downSendId");
                        String recvUserD = recJson.getString("downRecvId");
                        List<BombRecord> downRecords = bombRecordDao.selectSendOneRec(sendUserD, recvUserD, num);
                        recJson.put("SendOneDownRec", downRecords);
                        send(recJson.toJSONString());
                        break;
                    //心脏线程
                    case "isClick":
                        String isRecId = recJson.getString("isRecvId");
                        List<BombRecord> list = bombRecordDao.selectNowRec(isRecId);
                        recJson.put("nowFriendRec", list);
                        send(recJson.toJSONString());
                        break;
                    case "sendImg":
                        String icon = recJson.getString("isSend");
                        recJson.put("action", "sendImg");
                        recJson.put("isSendImg", icon);
                        for (String key : ServerSocketThread.threadMap.keySet()) {//群发
                            ServerSocketThread.threadMap.get(key).send(recJson.toJSONString());
                        }
                        break;
                    case "downFile":
                        List<BombDress> dressList = bombDressDao.selectPath();
                        recJson.put("fileList", dressList);
                        send(recJson.toJSONString());
                        break;
                    case "roomCreate":
                        String cUserId = recJson.getString("Cid");
                        BombRoom room = new BombRoom();
                        room.setCreateuserid(cUserId);
                        if (bombRoomDao.queryUser(cUserId)) {
                            bombRoomDao.roomCreate(room);//将新建的房间存入
                        }
                        JSONObject create = new JSONObject();
                        create.put("action", "showrooms");
                        List<BombRoom> rooms = bombRoomDao.isQuery();
                        create.put("rooms", rooms);
                        send(create.toJSONString());
                        //将样式查询到并且传给客户端
                        BombUserstyle queryStyle = bombUserStyleDao.queryStyle(cUserId);
                        System.out.println("房主的样式为：" + queryStyle.toString());
                        create.put("action", "drawUser");
                        create.put("style", queryStyle);
                        send(create.toJSONString());
                        break;
                    case "deleteRoom":
                        createUid = recJson.getString("CreateUserId");
                        boolean deleteRoom = bombRoomDao.deleteRoom(createUid);
                        System.out.println("房间的消除情况" + deleteRoom);
                        js = new JSONObject();
                        js.put("flagDelete", deleteRoom);
                        js.put("action", "deleteRoom");
                        send(js.toJSONString());
                        break;
                    case "showrooms":
                        List<BombRoom> bombRooms = bombRoomDao.isQuery(); //查询库里面已经存在的房间
                        recJson.put("rooms", bombRooms);
                        recJson.put("action", "showrooms");
                        send(recJson.toJSONString());
                        break;
                    case "joinRoom":
                        String playerId = recJson.getString("playerId");
                        String roomId = recJson.getString("roomId");
                        String msg = "房间满了";
                        List<BombRoom> bombRooms2 = new ArrayList<>();
                        if (bombRoomDao.queryUser(playerId)) {
                            bombRoomDao.insetUser(roomId, playerId);
                            msg = "加入成功";
                            bombRooms2 = bombRoomDao.isQuery();//查询库里已经存在的房间
                            //查询加入房间的玩家的样式
                            JSONObject playJs = new JSONObject();
                            BombUserstyle playerStyle = bombUserStyleDao.queryStyle(playerId);
                            System.out.println("玩家的样式为：" + playerStyle.toString());
                            playJs.put("action", "drawPlayer");
                            playJs.put("playerStyle", playerStyle);
                            playJs.put("roomMasStyle", bombUserStyleDao.queryStyle(roomId));
                            //利用群发发一次房主的给其他加入房间的用户
                            ServerSocketThread.threadMap.get(roomId).send(playJs.toJSONString());
                            //发送给客户端的接收线程
                            send(playJs.toJSONString());
                        }
                        recJson.put("action", "joinRoom");
                        recJson.put("re", msg);
                        recJson.put("rooms", bombRooms2);
                        send(recJson.toJSONString());
                        break;
                    case "saveStyle":
                        bombUserStyleDao.deleteUserStyle(userName);
                        int num = recJson.getInteger("num");
                        int hitNum = recJson.getInteger("hitNum");
                        int dressNum = recJson.getInteger("dressNum");
                        BombUserstyle bombUserstyle = new BombUserstyle();
                        bombUserstyle.setNum(num);
                        bombUserstyle.setHat(hitNum);
                        bombUserstyle.setDress(dressNum);
                        bombUserstyle.setUserid(userName);
                        bombUserStyleDao.style(bombUserstyle);
                        break;
                    case "reCen":
                        /**
                         * @author: chenhao
                         * @date: 2022/11/25 15:24
                         * 如果点击返回按钮的是房主，执行删除房间操作
                         **/
                        loginUserId = recJson.getString("loginUserId");
                         roomPlayerId = bombRoomDao.queryRoomPlayer(loginUserId);
//                        System.out.println("-------------------" + loginUserId);
//                        System.out.println("==================" + roomPlayerId);
//                        System.out.println("-------------------" + createUid);
                        bombRoomDao.deleteRoom(createUid);
                        System.out.println("房主点击返回后房间删除，房主id为" + loginUserId);
                        String deMsg = "房间已解散";
                        recJson.put("action", "playerReCen");
                        recJson.put("deMsg", deMsg);
//                            send(recJson.toJSONString());
                        //发给另一个用户
                        /**
                         * @author: chenhao
                         * @date: 2022/11/25 23:06
                         * 已修复
                         * 如果为空，只发给房主
                         * 如果不为空，发给房主和其他玩家
                         **/
                        if (roomPlayerId == null) {
                            send(recJson.toJSONString());
                        } else {
                            send(recJson.toJSONString());
                            ServerSocketThread.threadMap.get(roomPlayerId).send(recJson.toJSONString());
                        }
                        break;
                    case "ready":
                        String readyId = recJson.getString("readerId");//登录上来的id，此时不知道是房主还是玩家
                        String roomMsId = bombRoomDao.roomMsId(readyId);//查询房主id
                        String readyMsg = "已准备";
                        recJson.put("action","playReady");
                        recJson.put("readyMsg",readyMsg);
                        /**
                         * @author: chenhao
                         * @date: 2022/11/26 0:06
                         * 当房主id不为空时才能发送给房主一次和自己一次
                         **/
                        if (roomMsId != null){//限制了只有玩家能点击
                            send(recJson.toJSONString());//给玩家自己发
                            ServerSocketThread.threadMap.get(roomMsId).send(recJson.toJSONString());//给房主发
                        }
                        break;
                    case "startGame":
                        /**
                         * @author: chenhao
                         * @date: 2022/11/26 0:16
                         * 发送倒计时指令
                         **/
                        roomPlayerId = bombRoomDao.queryRoomPlayer(userName);
                        recJson.put("action","startTime");
                        if (roomPlayerId != null){//限制了只有房主能点击
                            send(recJson.toJSONString());//给房主自己发
                            //然后给其他用户发
                            ServerSocketThread.threadMap.get(roomPlayerId).send(recJson.toJSONString());
                        }
                        break;
                    case "checkMap":
                        /**
                         * @author: chenhao
                         * @date: 2022/11/26 1:53
                         * 控制只有房主可以选择地图
                         **/
                        roomPlayerId = bombRoomDao.queryRoomPlayer(userName);
                        System.out.println(roomPlayerId);
                        recJson.put("action","otherMap");
                        if (roomPlayerId != null){//限制了只有房主能点击
                            send(recJson.toJSONString());//给房主自己发
//                            //然后给其他用户发
                            ServerSocketThread.threadMap.get(roomPlayerId).send(recJson.toJSONString());
                        }
                        break;
                    case "move":
                        Player player = recJson.getObject("player",Player.class);
                        Player master = recJson.getObject("master", Player.class);
//                        int playerX = recJson.getInteger("playerX");
//                        int playerY = recJson.getInteger("playerY");
//                        int masterX = recJson.getInteger("masterX");
//                        int masterY = recJson.getInteger("masterY");
                        /**
                         * @description:发送给房主和其他客户端
                         * @author: chenhao
                         * @date: 2022/11/29 16:19
                         **/
                        for (String key : ServerSocketThread.threadMap.keySet()) {
                            if (key.equals(player.getUserId()) || key.equals(master.getUserId())){
                                ServerSocketThread.threadMap.get(key).send(recJson.toJSONString());
                            }
                        }
//                        ServerSocketThread.threadMap.get(player.getUserId()).send(recJson.toJSONString());
//                        ServerSocketThread.threadMap.get(master.getUserId()).send(recJson.toJSONString());

                        break;
                    case "setBoom":
                        masterid = recJson.getString("masterid");
                        playerid = recJson.getString("playerid");
                        /**
                         * @description:反传给客户端
                         * @author: chenhao
                         * @date: 2022/11/29 9:24
                         * @param: []
                         * @return: void
                         **/
                        for (String key : ServerSocketThread.threadMap.keySet()) {
                            if (key.equals(playerid) || key.equals(masterid)){
                                ServerSocketThread.threadMap.get(key).send(recJson.toJSONString());
                            }
                        }
                        break;
                    case "boom":
                    case "clearBoom":
                        for (String key : ServerSocketThread.threadMap.keySet()) {
                            if (key.equals(playerid) || key.equals(masterid)){
                                ServerSocketThread.threadMap.get(key).send(recJson.toJSONString());
                            }
                        }
                        break;
                    case "heart":
                        //给客户端个应答，告诉它服务器自己还在
                        send(line);
                        break;

                }
            }
        } catch (IOException e) {
            //注释掉原来的抛出异常用新的字样来代替显示
//            e.printStackTrace();
            //删除房间
            bombRoomDao.deleteRoom(createUid);
            System.out.println("客户端断开连接时所获取到的创建者id为：" + createUid);
            System.out.println("--------------正在等待客户端的连接");

            //离线和在线状态的切换
            //当客户端下线时利用跟上面登录成功的状态改变方法，将状态改为离线，其他步骤同上
            for (String allUser : ServerSocketThread.threadMap.keySet()) {
                for (BombUser b : bombUsers) {
                    if (b.getUserid().equals(allUser)) {
                        userState = "离线";
                        b.setLoginstate(userState);
                    }
                }
            }
            js.put("好友", bombUsers);
            for (String sendState : ServerSocketThread.threadMap.keySet()) {
                ServerSocketThread.threadMap.get(sendState).send(js.toJSONString());
            }
//                        调用发送方法 将应答的JSONObject对象返回出的字符串表达 发送出去
            System.out.println("发送：" + js.toJSONString());
            send(js.toJSONString());


        }
    }

    public void send(String line) {
        priWriter.println(line);
        priWriter.flush();
    }
}
