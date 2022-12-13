package com.cykj.Thread;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.*;
import com.cykj.controller.CliController;
import com.cykj.controller.CliGameActLis;
import com.cykj.controller.GameTimer;
import com.cykj.model.Data;
import com.cykj.util.GameMusic;
import com.cykj.view.UI;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CliReadThread extends Thread {
    public static BombUserstyle bombUserstyle;
    public static BombUserstyle playerUserStyle;
    public CliController con;
    public int num = 0;//重新连接进度条
    public List<BombUser> bombUsers;
    private BufferedReader bufRed;
    private PrintWriter priWriter;
//    public static Player player;
    public static Player player =new Player();
    public static Player master = new Player();
    public String nowUserAcc;
    public int x;
    public int y;
//    public  GameMusic gameMusic;
    public CliReadThread(Socket socket,CliController con) {
        this.con = con;
        try {
            System.out.println("建立与" + socket + "业务服务器的连接");
            //输出
            bufRed = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            priWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        while (true){
//        synchronized (CliReadThread.class){//解决并发问题

//        }
        rec();

    }

    public void rec() {
        //接收服务器消息
        try {
            while (true) {
//                if (player!=null){
//                    player.playerMove();
//                }
                //获取北京时间
                Locale locale = Locale.CHINA;
                String pattern = "yyyy-MM-dd kk:mm:ss";
                SimpleDateFormat df = new SimpleDateFormat(pattern, locale);
                Date date = new Date();
                String bjTime = df.format(date);
                System.out.println("---------------------" + bjTime);//打印北京时间
                //接收服务器消息
                String line = bufRed.readLine();//阻塞等待接收服务器的消息
                System.out.println("收到来自server的消息：" + line);
                //利用JSON读取收到的来自server的消息
                JSONObject js = JSONObject.parseObject(line);
                //如果没有异常，则把重新连接字样隐藏
                Thread.sleep(100);
                UI.loginFrame.loginPanel.getReLinkLabel().setText("    ");//隐藏登录界面重新连接字样
                UI.logonFrame.logonPanel.getReLinkLabel().setText("    ");//隐藏注册界面重新连接字样
                String action = js.getString("action");
                switch (action) {
                    case "login":
                        if (js.getBoolean("flag")) {//判断服务器发过来的布尔值flag,为true登录成功，为false登录失败
//                            JOptionPane.showMessageDialog(null, "有新用户上线或下线");
                            //拿到上次退出后的服装样式
                            BombUserstyle Userstyle = js.getObject("queryStyle", BombUserstyle.class);
                            UI.personalCenterFrame.personalCenterPanel.num = Userstyle.getNum();
                            UI.personalCenterFrame.personalCenterPanel.hitNum = Userstyle.getHat();
                            UI.personalCenterFrame.personalCenterPanel.dressNum = Userstyle.getDress();
                            //登录成功登录界面隐藏，游戏大厅可见
                            UI.loginFrame.setVisible(false);
                            UI.gameFrame.setVisible(true);
//                            gameMusic = new GameMusic("Client/music/Yoohsic-Roomz-Eutopia.wav");
//                            gameMusic.play();
//                            String state = js.getString("state");
//                            //将集合转化成JSON
                            bombUsers = JSONObject.parseArray(js.getString("好友")).toJavaList(BombUser.class);
//                            List<BombUser> bombUsers = js.getJSONArray("好友").toJavaList(BombUser.class);
                            //通过输入框获取到当前登录进去的用户
                            nowUserAcc = UI.loginFrame.loginPanel.getUserTxt().getText();
                            //然后遍历bean集合找到当前的用户
                            for (BombUser user : bombUsers) {
                                //如果当前的用户是自己的话,就移除掉，这样自己本身就不会显示在列表中了
                                if (user.getUserid().equals(nowUserAcc)) {
                                    bombUsers.remove(user);
                                    break;
                                }
                            }
                            UI.gameFrame.gamePanel.initJList(bombUsers);
                            //当前用户
                            UI.gameFrame.gamePanel.getNowUserLabel().setText("当前用户为：" + nowUserAcc);
                            String acc = js.getString("id");
                            UI.gameFrame.gamePanel.getUserUpLabel().setText(acc + "状态发生改变");
                            Thread.sleep(1000);
                            UI.gameFrame.gamePanel.getUserUpLabel().setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "登录失败",
                                    "温馨提示", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "logon":
                        System.out.println(js.getBoolean("flagLogon"));
                        if (js.getBoolean("flagLogon") && js.getBoolean("flagLogon") != null) {
                            JOptionPane.showMessageDialog(null, "注册成功",
                                    "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "注册失败",
                                    "温馨提示", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case "sendOutAll":
                        String sendTxt = js.getString("sendTxt");//发送的消息
                        String userId = js.getString("from");//来自谁发的消息的id
                        System.out.println("群发的消息为" + sendTxt);
//                        UI.gameFrame.gamePanel.msgMode.addElement(bjTime + "来自账户" + userId + "的消息：");
//                        UI.gameFrame.gamePanel.msgMode.addElement(bjTime + "来自其他账户的消息：");
//                        UI.gameFrame.gamePanel.msgMode.addElement(sendTxt);
                        UI.gameFrame.gamePanel.msgMode.add(0, bjTime + "来自账户" + userId + "的消息：");
                        UI.gameFrame.gamePanel.msgMode.add(1, sendTxt);
                        break;
                    case "sendOne":
                        String from = js.getString("from");
                        String msg = js.getString("msg");
                        UI.sendOneFrame.sendOnePanel.msgMode.addElement(bjTime + "来自账户" + from + "的消息：");
                        UI.sendOneFrame.sendOnePanel.msgMode.addElement(msg);

                        //消息提醒
                        UI.gameFrame.gamePanel.getNewMsg().setText("来自" + from + "的新消息");
                        Thread.sleep(1000);
                        UI.gameFrame.gamePanel.getNewMsg().setText("");
                        break;
                    //以下为群聊的聊天记录
                    case "recShow":
                        UI.recordsFrame.cliRecordPanel.getRecTm().setRowCount(0);
                        List<BombRecord> bombRecords = JSONObject.parseArray(js.getString("recMsg")).toJavaList(BombRecord.class);
                        for (BombRecord bombRecord : bombRecords) {
                            String[] data = {bombRecord.getSendid(),
                                    bombRecord.getContent(),
                                    bombRecord.getRectime()
                            };
                            UI.recordsFrame.cliRecordPanel.getRecTm().addRow(data);
                        }
                        int count = js.getInteger("count");
                        if (count % 5 != 0) {
                            UI.recordsFrame.cliRecordPanel.pageTotal = (count / 5) + 1;
                        } else {
                            UI.recordsFrame.cliRecordPanel.pageTotal = count / 5;
                        }
                        UI.recordsFrame.cliRecordPanel.getPageTotalLabel().setText("总页数：" + UI.recordsFrame.cliRecordPanel.pageTotal);
                        break;
                    case "upPage":
                        if (UI.recordsFrame.cliRecordPanel.nowPage > 1) {
                            UI.recordsFrame.cliRecordPanel.getRecTm().setRowCount(0);
                            List<BombRecord> recordList = JSONObject.parseArray(js.getString("upRec")).toJavaList(BombRecord.class);
//                        System.out.println("--------------------------------------集合长度"+recordList.size());
                            for (BombRecord tRecord : recordList) {
                                String[] data = {tRecord.getSendid(),
                                        tRecord.getContent(),
                                        String.valueOf(tRecord.getRectime())};
                                UI.recordsFrame.cliRecordPanel.getRecTm().addRow(data);
                            }
                            UI.recordsFrame.cliRecordPanel.nowPage--;//当前页数减1
                            UI.recordsFrame.cliRecordPanel.getPageLabel().setText("当前页数：" + UI.recordsFrame.cliRecordPanel.nowPage);
                        }
                        break;
                    case "downPage":
                        if (UI.recordsFrame.cliRecordPanel.pageTotal != UI.recordsFrame.cliRecordPanel.nowPage) {
                            UI.recordsFrame.cliRecordPanel.getRecTm().setRowCount(0);
                            List<BombRecord> downRecordList = JSONObject.parseArray(js.getString("downRec")).toJavaList(BombRecord.class);
                            for (BombRecord tRecord : downRecordList) {
                                String[] data = {tRecord.getSendid(),
                                        tRecord.getContent(),
                                        String.valueOf(tRecord.getRectime())};
                                UI.recordsFrame.cliRecordPanel.getRecTm().addRow(data);
                            }
                            UI.recordsFrame.cliRecordPanel.nowPage++;
                            UI.recordsFrame.cliRecordPanel.getPageLabel().setText("当前页数：" + UI.recordsFrame.cliRecordPanel.nowPage);
                        }
                        break;
                    //以下为私聊的聊天记录
                    case "recSendOneShow":
                        UI.sendOneRecFrame.sendOneRecPanel.getRecTm().setRowCount(0);
                        List<BombRecord> sendOneList = JSONObject.parseArray(js.getString("recSendOneShow")).toJavaList(BombRecord.class);
                        for (BombRecord bombRecord : sendOneList) {
                            String[] data = {bombRecord.getSendid(),
                                    bombRecord.getRecvid(),
                                    bombRecord.getContent(),
                                    bombRecord.getRectime()
                            };
                            UI.sendOneRecFrame.sendOneRecPanel.getRecTm().addRow(data);
                        }
                        int sendOneCount = js.getInteger("sendOneCount");
                        if (sendOneCount % 5 != 0) {
                            UI.sendOneRecFrame.sendOneRecPanel.pageTotal = (sendOneCount / 5) + 1;
                        } else {
                            UI.sendOneRecFrame.sendOneRecPanel.pageTotal = sendOneCount / 5;
                        }
                        UI.sendOneRecFrame.sendOneRecPanel.getPageTotalLabel().setText("总页数：" + UI.sendOneRecFrame.sendOneRecPanel.pageTotal);
                        break;
                    case "up":
                        if (UI.sendOneRecFrame.sendOneRecPanel.nowPage > 1) {
                            UI.sendOneRecFrame.sendOneRecPanel.getRecTm().setRowCount(0);
                            List<BombRecord> records = JSONObject.parseArray(js.getString("SendOneUpRec")).toJavaList(BombRecord.class);
                            for (BombRecord r : records) {
                                String[] data = {r.getSendid(),
                                        r.getRecvid(),
                                        r.getContent(),
                                        String.valueOf(r.getRectime())};
                                UI.sendOneRecFrame.sendOneRecPanel.getRecTm().addRow(data);
                            }
                            UI.sendOneRecFrame.sendOneRecPanel.nowPage--;//当前页数减1
                            UI.sendOneRecFrame.sendOneRecPanel.getPageLabel().setText("当前页数：" + UI.sendOneRecFrame.sendOneRecPanel.nowPage);
                        }
                        break;
                    case "down":
                        if (UI.sendOneRecFrame.sendOneRecPanel.pageTotal != UI.sendOneRecFrame.sendOneRecPanel.nowPage) {
                            UI.sendOneRecFrame.sendOneRecPanel.getRecTm().setRowCount(0);
                            List<BombRecord> downRecord = JSONObject.parseArray(js.getString("SendOneDownRec")).toJavaList(BombRecord.class);
                            for (BombRecord record : downRecord) {
                                String[] data = {record.getSendid(),
                                        record.getRecvid(),
                                        record.getContent(),
                                        String.valueOf(record.getRectime())};
                                UI.sendOneRecFrame.sendOneRecPanel.getRecTm().addRow(data);
                            }
                            UI.sendOneRecFrame.sendOneRecPanel.nowPage++;
                            UI.sendOneRecFrame.sendOneRecPanel.getPageLabel().setText("当前页数：" + UI.sendOneRecFrame.sendOneRecPanel.nowPage);
                        }
                        break;
                    case "isClick":
                        List<BombRecord> list = JSONObject.parseArray(js.getString("nowFriendRec")).toJavaList(BombRecord.class);
                        for (BombRecord b : list) {
                            String data = b.getRecvid() + "==" + b.getContent() + "==" + b.getRectime();
                            String[] split = data.split("==");
                            String id = split[0];
                            String content = split[1];
                            String sendTime = split[2];
                            UI.sendOneFrame.sendOnePanel.msgMode.addElement(sendTime + "发送给" + id + "的消息记录：");
                            UI.sendOneFrame.sendOnePanel.msgMode.addElement(content);
                        }
                        break;
                    case "sendImg":
                        String icon = js.getString("isSendImg");
                        Icon a = new ImageIcon(icon);
                        System.out.println(a);
                        JLabel b = new JLabel();
                        b.setIcon(a);
                        b.setText("");
                        UI.gameFrame.gamePanel.msgMode.add(0, b);
                        UI.gameFrame.gamePanel.getMsgJList().setModel(UI.gameFrame.gamePanel.msgMode);//刷新
                        break;
                    case "downFile":
                        List<BombDress> bombDressList = JSONObject.parseArray(js.getString("fileList")).toJavaList(BombDress.class);
                        for (BombDress dress : bombDressList) {
                            CliDownLoadFileThread cliDownLoadFileThread = new CliDownLoadFileThread(dress.getImagepath());
                            cliDownLoadFileThread.start();
                            Thread.sleep(50);
                            cliDownLoadFileThread.join();
                        }
//                        UI.gameFrame.setVisible(false);
                        UI.progressBar.setVisible(false);
                        UI.personalCenterFrame.setVisible(true);
                        Data.initImage();
                        break;
                    case "roomCreate":
                        String cid = js.getString("Cid");
                        List<BombRoom> rooms = JSONObject.parseArray(js.getString("rooms")).toJavaList(BombRoom.class);
                        UI.gameRoomFrame.gameRoomPanel.roomLeftPanel.roomCreate(rooms);
////                        UI.gameRoomFrame.setVisible(false);
//                        UI.chooseMap.cliWaitRoomPanel.getCreateRoomLabel().setText(cid+"的房间");
//                        UI.chooseMap.setVisible(true);
                        break;
                    case "deleteRoom":
                        if (js.getBoolean("flagDelete")) {
                            JOptionPane.showMessageDialog(null, "房间已解散",
                                    "温馨提示", JOptionPane.ERROR_MESSAGE);
                        }
                        UI.chooseMap.cliWaitRoomPanel.repaint();
                        break;
                    case "showrooms":
                        List<BombRoom> bombRooms2 = js.getJSONArray("rooms").toJavaList(BombRoom.class);
                        UI.gameRoomFrame.gameRoomPanel.roomLeftPanel.roomCreate(bombRooms2);
                        System.out.println("显示创建的房间数量：" + bombRooms2.toString());
//                        UI.gameRoomFrame.setVisible(true);
                        break;
                    case "joinRoom":
                        String re = js.getString("re");
                        if (re.equals("加入成功")) {
                            List<BombRoom> bombRooms = js.getJSONArray("rooms").toJavaList(BombRoom.class);
                            UI.gameRoomFrame.gameRoomPanel.roomLeftPanel.roomCreate(bombRooms);
                            UI.gameRoomFrame.setVisible(false);
                            UI.chooseMap.setVisible(true);
                            UI.chooseMap.cliWaitRoomPanel.repaint();
                        }
                        JOptionPane.showMessageDialog(null, re, "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "drawUser":
                        BombUserstyle queryStyle = JSONObject.parseObject(js.getString("style"), BombUserstyle.class);//获取到服务端的bean对象
                        bombUserstyle = queryStyle;//将服务端的bean对象赋值给静态声明的的客户端bean对象
                        UI.chooseMap.cliWaitRoomPanel.repaint();
                        break;
                    case "drawPlayer":
                        BombUserstyle playerStyle = JSONObject.parseObject(js.getString("playerStyle"), BombUserstyle.class);
                        queryStyle = JSONObject.parseObject(js.getString("roomMasStyle"), BombUserstyle.class);
                        bombUserstyle = queryStyle;
                        playerUserStyle = playerStyle;
                        UI.chooseMap.cliWaitRoomPanel.repaint();
                        break;
                    case "playerReCen":
                        String deMsg = js.getString("deMsg");
                        JOptionPane.showMessageDialog(null, deMsg, "温馨提示", JOptionPane.INFORMATION_MESSAGE);
                        UI.chooseMap.setVisible(false);
                        UI.gameFrame.setVisible(true);
                        break;
                    case "playReady":
                        /**
                         * @author: chenhao
                         * @date: 2022/11/26 0:08
                         * 刷新cliWaitRoomPanel.getReadyLabel(),显示出"已准备"字样
                         **/
                        String readyMsg = js.getString("readyMsg");
                        UI.chooseMap.cliWaitRoomPanel.getReadyLabel().setText(readyMsg);
                        break;
                    case "startTime":
                        CliGameActLis.gameMusic.over();
                        UI.chooseMap.cliWaitRoomPanel.run();
                        master.setImage(bombUserstyle.getNum());
                        master.setUserId(bombUserstyle.getUserid());
                        master.setSpeed(6);
                        master.setBlood(3);
                        master.setPlayerX(150);
                        master.setPlayerY(650);

                        player.setImage(playerUserStyle.getNum());
                        player.setUserId(playerUserStyle.getUserid());
                        player.setSpeed(6);
                        player.setBlood(3);
                        player.setPlayerX(625);
                        player.setPlayerY(650);
                        GameTimer gameTimer = new GameTimer(con);
                        gameTimer.myTimer.start();
                        UI.hitGameFrame.repaint();
                        break;
                    case "otherMap":
                        UI.chooseMapFrame.setVisible(true);
                        break;
                    case "move":
                        player.setPlayerX(js.getObject("player",Player.class).getPlayerX());
                        player.setPlayerY(js.getObject("player",Player.class).getPlayerY());
                        master.setPlayerX(js.getObject("master",Player.class).getPlayerX());
                        master.setPlayerY(js.getObject("master",Player.class).getPlayerY());
                        UI.hitGameFrame.repaint();
                        break;
                    case "setBoom":
                        x = js.getInteger("x");
                        y = js.getInteger("y");
                        con.map.allMapArray[con.levels][y][x] = 22;
                        UI.hitGameFrame.repaint();
                        break;
                    case "boom":
                    case "clearBoom":
                        con.map.allMapArray[con.levels][y][x] = 0;
                        Boom boom = new Boom(con,x,y);
                        Boom boom2 = new Boom(con,x+1,y);
                        Boom boom3 = new Boom(con,x-1,y);
                        Boom boom4 = new Boom(con,x,y+1);
                        Boom boom5 = new Boom(con,x,y-1);
                        con.booms.add(boom);
                        bombBoom(x,y);
                        con.booms.add(boom2);
                        bombBoom(x+1,y);
                        con.booms.add(boom3);
                        bombBoom(x-1,y);
                        con.booms.add(boom4);
                        bombBoom(x,y+1);
                        con.booms.add(boom5);
                        bombBoom(x,y-1);
                        GameMusic bombMusic = new GameMusic("Client/music/Explode.wav");
                        bombMusic.play();
                        con.map.allMapArray[con.levels][y][x] = 0;
                        UI.hitGameFrame.repaint();
                        break;
                    //心脏线程
                    case "heart":
                        //收到应答，计数器归零
                        HeartThread.heartCount = 0;//这是在心脏内写计数器的写法
                        break;
                }
            }
        } catch (IOException e) {
            //注释掉原来的抛出异常用新的字样来代替显示
//            e.printStackTrace();
            System.out.println("--------------正在尝试重新连接");
            if (num < 100) {
                num++;
                //登录界面重新连接字样
                UI.loginFrame.loginPanel.getReLinkLabel().setText("尝试重新连接" + num + "%");
                //注册界面重新连接字样
                UI.logonFrame.logonPanel.getReLinkLabel().setText("尝试重新连接" + num + "%");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void send(String line) {
        System.out.println("客户端发送给服务器的信息" + line);
        priWriter.println(line);
        priWriter.flush();//刷新
    }

    public boolean bombBoom(int x,int y){
        Rectangle bombRec = new Rectangle(x*30, y*30, 30, 30);  //生成爆炸效果的矩形
        for (int i = 0; i < con.map.allMapArray[con.levels].length; i++) {   //遍历地图的二维数组
            for (int j = 0; j <con.map.allMapArray[con.levels][i].length; j++) {
                Rectangle mapRec = new Rectangle(i * 30, j * 30, 30, 30);//生成二维数组内的元素方块矩形
                switch (con.map.allMapArray[con.levels][j][i]) { //优化
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        if (mapRec.intersects(bombRec)) {
                           con.map.allMapArray[con.levels][j][i] = 0;
//                            System.out.println("-----------------------炸到了");
                            return true;
                        }
                        break;
                }
            }
        }
        Rectangle playerRec = new Rectangle(player.getPlayerX(),player.getPlayerY(),30,30);
        if (bombRec.intersects(playerRec)){
            System.out.println("+++++++++++++++++++++炸到玩家了");
            int i = player.getBlood()-1;
            player.setBlood(i);
            if (i <=0){
                int ans = JOptionPane.showConfirmDialog(null, "玩家血量为0，游戏结束",
                        "温馨提示", JOptionPane.YES_NO_OPTION);

                if (ans == 0){
                    System.exit(0);
                }
            }
            return true;
        }
        Rectangle masterRec = new Rectangle(master.getPlayerX(),master.getPlayerY(),30,30);
        if (bombRec.intersects(masterRec)){
            System.out.println("---------------------炸到房主了");
            int i = master.getBlood()-1;
            master.setBlood(i);
            if (i <=0){
                int ans = JOptionPane.showConfirmDialog(null, "房主血量为0，游戏结束",
                        "温馨提示", JOptionPane.YES_NO_OPTION);
                if (ans == 0){
                    System.exit(0);
                }
            }
            return true;
        }
        return false;
    }
}
