package controller;

import model.*;
import view.LoginPanel;
import view.LogonPanel;
import view.UI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    public Mouse mouse1;
    public SmallMouse sMouse;
    public NormalMouse nMouse;
    public BigMouse bMouse;
    public Bomb bomb;
    public BloodPack bloodPack;
    public Mine mine;
    public MouseGameTimer mouseGameTimer;
    //    public Player nowPlayer;
    public String mapAry[][];
    int mapX;
    int mapY;
    Scanner sc = new Scanner(System.in);

    //当前 登录进来玩游戏的玩家
    public Player nowPlayer;


    //所有玩家的集合
    public ArrayList<Player> players;

    //设置一个布尔值   用于管理    游戏是否开始
    public boolean isStart = false;


    public Controller() {    //构造函数,利用构造函数来传递参数
        nowPlayer = new Player();
        mouse1 = new Mouse();
        mouse1.ranPos();
        mouseGameTimer = new MouseGameTimer(this);

        sMouse = new SmallMouse();
        nMouse = new NormalMouse();
        bMouse = new BigMouse();
        bomb = new Bomb();
        bloodPack = new BloodPack();
        mine = new Mine();
        players = new ArrayList<Player>();

    }

    //注册方法
    public void logon(LogonPanel logonPanel) {
//        System.out.println("开始注册");
////        //账号
////        System.out.println("请输入账号");
////        Scanner sc = new Scanner(System.in);
////        String acc = sc.next();
////        //密码
////        System.out.println("请输入密码");
////        String pwd = sc.next();
////        //确认密码
////        System.out.println("请输入确认密码");
////        String checkPwd = sc.next();
        String acc = logonPanel.accField.getText();
        String pwd = logonPanel.pwdField.getText();
        System.out.println(acc+""+pwd);//看看是否有拿到
        String checkPwd = logonPanel.checkField.getText();
//        3.判断密码和确认密码是否相同
        if (pwd.equals(checkPwd)) {
            //4:判断账号是否重复  作为作业
            for (int i = 0; i < players.size(); i++) {
                if (acc.equals(players.get(i).playerAcc)) {
                    System.out.println("该用户已存在");
                    JOptionPane.showConfirmDialog(null,
                            "该用户已存在", "", JOptionPane.DEFAULT_OPTION);
                    return;
                }

            }
//            5:存储账号和密码 用一个new的玩家对象，来存储账号密码
            Player newPlayer = new Player(acc, pwd);
            players.add(newPlayer);
            System.out.println("注册成功");
            JOptionPane.showConfirmDialog(null,
                    "注册成功", "", JOptionPane.DEFAULT_OPTION);
            System.out.println("当前由用户" + players.size() + "位");
        } else {
            System.out.println("两次输入密码不相同");
            JOptionPane.showConfirmDialog(null,
                    "注册失败，两次输入密码不相同", "", JOptionPane.DEFAULT_OPTION);
        }
    }


    //登录方法
    public boolean login(LoginPanel loginPanel) {
//        System.out.println("开始登录");
//        //账号
//        System.out.println("请输入账号");
//        Scanner sc = new Scanner(System.in);
//        String acc = sc.next();
//        //密码
//        System.out.println("请输入密码");
//        String pwd = sc.next();
        String acc = loginPanel.accField.getText();//账号
        String pwd = loginPanel.pwdField.getText();//密码
        System.out.println("acc:"+acc+",pwd:"+pwd);

//        2：比较验证码
        String pcCode = showCode();
        System.out.println("请输入验证码:" + pcCode);
        String userCode = JOptionPane.showInputDialog("验证码为"+pcCode);
//        String userCode = sc.next();
        if (!pcCode.equalsIgnoreCase(userCode)) {
            System.out.println("验证码错误");
            JOptionPane.showConfirmDialog(null,
                "验证码错误", "失败", JOptionPane.DEFAULT_OPTION);
            return false;
        }

//        3：比较账号和密码（不要太具体的提示）
//        int check = 0;
        for (int i = 0; i < players.size(); i++) {
            if (acc.equals(players.get(i).playerAcc) && pwd.equals(players.get(i).playerPwd)) {
//                check = 1;
                System.out.println("登录成功");//优化后的写法:将下方的if else优化进来
                JOptionPane.showConfirmDialog(null,
                        "登录成功，游戏愉快", "", JOptionPane.DEFAULT_OPTION);

                //可以把页面跳转放置在这边
//                UI.gameFrame.setVisible(true);
//                UI.loginFrame.setVisible(false);
                nowPlayer = players.get(i);
                return true;
            }
        }
//        if (check == 1){
////            System.out.println("登录成功"); 优化前的写法
////            return true;
//        }else {
        System.out.println("登录失败");
        return false;
//        }

    }

    //生成验证码方法
    public String showCode() {
        String codeBox = "qwertyuipasdfghjkzxcvbnmQWERTYUPASDFGHJKLZXCVBNM" +
                "23456789";

        //要求四位验证码   并且  拿来比较
        String pcCode = "";
        for (int i = 0; i < 4; i++) {
            int ranNum = new Random().nextInt(codeBox.length());
//            System.out.print(codeBox.charAt(ranNum));
            pcCode += codeBox.charAt(ranNum);
        }
        return pcCode;
    }



    //设置地图大小
    public void initMapSize() {
        System.out.println("请输入地图大小的X坐标 Y坐标");
        Scanner sc = new Scanner(System.in);
        try {
            mapX = sc.nextInt();
            mapY = sc.nextInt();
        } catch (InputMismatchException e) {//输入异常抓取
            System.out.println("您输入的不是数字");
            initMapSize();                 //递归
            return;                         //截停
        } catch (Exception e) {
            System.out.println("程序出错，请联系管理员");
            initMapSize();
            return;
        }
        if ((mapX <= 2 && mapY <= 2) || (mapX > 10 && mapY > 10)) {//坐标限制
            System.out.println("您输入的数字太小了");
            initMapSize();
            return;
        }
        mapAry = new String[mapY][mapX];
        System.out.println("地图大小为" + mapX + "*" + mapY);
    }

    public void initMap() {
        for (int i = 0; i < mapAry.length; i++) {
            for (int j = 0; j < mapAry[i].length; j++) {
                mapAry[i][j] = "O";
            }
        }
    }

    public void putMouse() {
        bMouse.ranPos(mapX, mapY);
        mapAry[bMouse.mouseY][bMouse.mouseX] = bMouse.mouseName;

        nMouse.ranPos(mapX, mapY);
//        while (nMouse.mouseX == bMouse.mouseX&& nMouse.mouseY == bMouse.mouseY)
        while (!mapAry[nMouse.mouseY][nMouse.mouseX].equals("O")) {  //利用反向算法推理优化上方的循环条件
            nMouse.ranPos(mapX, mapY);
            System.out.println("坐标重叠   " + 53);
        }
        mapAry[nMouse.mouseY][nMouse.mouseX] = nMouse.mouseName;

        sMouse.ranPos(mapX, mapY);
//        while ((sMouse.mouseX == bMouse.mouseX&& sMouse.mouseY == bMouse.mouseY)||
//                (sMouse.mouseX == nMouse.mouseX&& sMouse.mouseY == nMouse.mouseY))
        while (!mapAry[sMouse.mouseY][sMouse.mouseX].equals("O")) {  //利用反向算法推理优化上方的循环条件
            sMouse.ranPos(mapX, mapY);
            System.out.println("坐标重叠   " + 61);
        }
        mapAry[sMouse.mouseY][sMouse.mouseX] = sMouse.mouseName;

//        sMouse.ranPos(mapX, mapY);
//        nMouse.ranPos(mapX, mapY);
//        bMouse.ranPos(mapX, mapY);
//        do {
//            sMouse.ranPos(mapX, mapY);
//            nMouse.ranPos(mapX, mapY);
//            bMouse.ranPos(mapX, mapY);
//            mapAry[sMouse.mouseY][sMouse.mouseX] = sMouse.mouseName;
//            mapAry[nMouse.mouseY][nMouse.mouseX] = nMouse.mouseName;
//            mapAry[bMouse.mouseY][bMouse.mouseX] = bMouse.mouseName;
//            System.out.println("坐标重叠   "+47);
//        } while (sMouse.mouseY == nMouse.mouseY && nMouse.mouseY == bMouse.mouseY && sMouse.mouseX == bMouse.mouseX||nMouse.mouseX==bMouse.mouseX);
        System.out.println("大老鼠的X坐标是" + bMouse.mouseX + ",大老鼠的Y坐标是" + bMouse.mouseY);
        System.out.println("中老鼠的X坐标是" + nMouse.mouseX + ",中老鼠的Y坐标是" + nMouse.mouseY);
        System.out.println("小老鼠的X坐标是" + sMouse.mouseX + ",小老鼠的Y坐标是" + sMouse.mouseY);
        //让老鼠自己去改坐标 自己去随机出现
    }

    //放置道具，其中道具目前有炸弹，血包，宝箱
    public void putProp() {
        //地雷的放置
        bomb.ranPos(mapX, mapY);
        while (!mapAry[bomb.propY][bomb.propX].equals("O")) {  //利用反向算法推理优化上方的循环条件
            bomb.ranPos(mapX, mapY);
            System.out.println("坐标重叠   " + 92);
        }
        mapAry[bomb.propY][bomb.propX] = bomb.bombName;
        System.out.println("地雷的X坐标是" + bomb.propX + "地雷的Y坐标为" + bomb.propY);

        //血包的放置
        bloodPack.ranPos(mapX, mapY);
        while (!mapAry[bloodPack.propY][bloodPack.propX].equals("O")) {  //利用反向算法推理优化上方的循环条件
            bloodPack.ranPos(mapX, mapY);
            System.out.println("坐标重叠   " + 104);
        }
        mapAry[bloodPack.propY][bloodPack.propX] = bloodPack.bloodName;
        System.out.println("血包的X坐标是" + bloodPack.propX + "血包的Y坐标为" + bloodPack.propY);

        //宝箱的放置
        mine.ranPos(mapX, mapY);
        while (!mapAry[mine.propY][mine.propX].equals("O")) {  //利用反向算法推理优化上方的循环条件
            mine.ranPos(mapX, mapY);
            System.out.println("坐标重叠   " + 115);
        }
        mapAry[mine.propY][mine.propX] = mine.mineName;
        System.out.println("宝藏的X坐标是" + bloodPack.propX + "宝藏的Y坐标为" + bloodPack.propY);

    }

    public void drawMap() {  //绘制地图
        for (int i = 0; i < mapAry.length; i++) {
            for (int j = 0; j < mapAry[i].length; j++) {
                System.out.print(mapAry[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void hitMouse() {
        nowPlayer.hitMouse(mapX, mapY);
        //让玩家自己去打老鼠
    }

    public void checkAns() {
        //        5:判断是否打中老鼠,或者打中地雷和宝藏
        //打小老鼠
        try {//异常捕获
            if (mapAry[nowPlayer.playerY][nowPlayer.playerX].equals("S")) {
                System.out.println("恭喜打中了小老鼠");
                nowPlayer.playerCombo++;
                if (nowPlayer.playerCombo <= 5) {
                    nowPlayer.playPoint = nowPlayer.playerCombo * sMouse.mousePoint;
                } else {
                    nowPlayer.playPoint = sMouse.mousePoint * 5;
                }
                if (nowPlayer.playerCombo == 3) {
                    System.out.println("恭喜三连击，血量+1");
                    nowPlayer.playerBlood++;
                }
            } else if (mapAry[nowPlayer.playerY][nowPlayer.playerX].equals("N")) {//中老鼠
                System.out.println("恭喜打中了中老鼠");
                nowPlayer.playerCombo++;
                if (nowPlayer.playerCombo <= 5) {
                    nowPlayer.playPoint = nMouse.mousePoint * nowPlayer.playerCombo;
                } else {
                    nowPlayer.playPoint = nMouse.mousePoint * 5;
                }
                if (nowPlayer.playerCombo == 3) {
                    System.out.println("恭喜三连击，血量+1");
                    nowPlayer.playerBlood++;
                }

            } else if (mapAry[nowPlayer.playerY][nowPlayer.playerX].equals("B")) {//大老鼠
                System.out.println("恭喜打中了大老鼠");
                nowPlayer.playerCombo++;
                if (nowPlayer.playerCombo <= 5) {
                    nowPlayer.playPoint = bMouse.MousePoint * nowPlayer.playerCombo;
                } else {
                    nowPlayer.playPoint = bMouse.MousePoint * 5;
                }
                if (nowPlayer.playerCombo == 3) {
                    System.out.println("恭喜三连击，血量+1");
                    nowPlayer.playerBlood++;
                }
            } else if (mapAry[nowPlayer.playerY][nowPlayer.playerX].equals(bomb.bombName)) {//地雷
                System.out.println("很遗憾打中了地雷");
                nowPlayer.playerBlood = 0;

            } else if (mapAry[nowPlayer.playerY][nowPlayer.playerX].equals(bloodPack.bloodName)) {//血包
                System.out.println("恭喜打中血包");
                nowPlayer.playerBlood += bloodPack.accHp;//加血

            } else if (mapAry[nowPlayer.playerY][nowPlayer.playerX].equals(mine.mineName)) {//宝藏
                System.out.println("恭喜打中宝藏");
                nowPlayer.playPoint += mine.accPoint;//加分

            } else {
                System.out.println("很遗憾没打中,血量-1");
                nowPlayer.playerBlood--;
                nowPlayer.playerCombo = 0;
                if (nowPlayer.playerBlood == 1) {
                    System.out.println("您现在还剩1滴血，是否充值来回复血量,输入y进行充值，输入n跳过");
                    String hpAcc = sc.next();
                    System.out.println(hpAcc);
                    if (hpAcc.equals("y")) {
                        System.out.println("充值成功，血量+1");
                        nowPlayer.playerBlood++;
                    } else {
                        System.out.println("祝你好运");
                    }
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("输入超出范围");
            hitMouse();
            checkAns();
            return;
        } catch (Exception e) {
            System.out.println("程序错误，请联系程序管理员");
            hitMouse();
            checkAns();
            return;
        }

        System.out.println("目前血量为" + nowPlayer.playerBlood + "目前积分为" + nowPlayer.playPoint);

        //            if(!mapAry[nowPlayer.playerY][nowPlayer.playerX].equals("O")){
//                nowPlayer.playerCombo++;
//                switch (mapAry[nowPlayer.playerY][nowPlayer.playerX]){
//                    case "B":
//                        System.out.println("恭喜打中了大老鼠");;
//                        break;
//                    case "S":
//                        nowPlayer.playerCombo--;
//                    default:
//                        System.out.println("123");
//                }
//
//            }
    }
}
