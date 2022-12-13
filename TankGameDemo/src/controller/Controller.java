package controller;

import model.*;
import view.UI;

import java.util.ArrayList;
import java.util.Random;

public class Controller {
    //坦克
    public Tank_Player1 tankP1;//玩家1 坦克
    public Tank_Player2 tankP2;//玩家2 坦克
    //当前登录进来的玩家
    //玩家1
    public Player nowPlayer;
    //地图
    public Map map;
    //定时器
    public TankGameTimer tankGameTimer;
    //所有玩家的集合
    public ArrayList<Player> players;
    //所有敌方坦克的集合
    public ArrayList<Tank_Enemy> tank_enemies;
    //所有敌方坦克不同类型的集合
    public ArrayList<Tank_Enemy> tank_m01_enemies;
    public ArrayList<Tank_Enemy> tank_m02_enemies;
    public ArrayList<Tank_Enemy> tank_m03_enemies;
    public ArrayList<Tank_Enemy> tank_m04_enemies;
    public ArrayList<Tank_Enemy> tank_m05_enemies;
    public ArrayList<Tank_Enemy> tank_m06_enemies;
    public ArrayList<Tank_Enemy> tank_m07_enemies;
    public ArrayList<Tank_Enemy> tank_m08_enemies;
    //子弹的集合
    public ArrayList<Bullet> bullets;
    //爆炸效果
    public ArrayList<Boom> booms;
    //道具类的集合
    public ArrayList<Items> items;
    //关卡数的定义
    public int levels;
    //敌方总坦克数的定义
    public int enemySum;
    //击毁坦克数
    public int hitTankNum;
    //击毁坦克总数
    public int hitTankSum;
    //各种类的击毁坦克统计
    public int hitWhiteTankNum;
    public int hitYellowTankNum;
    public int hitGreenTankNum;
    public int hitBlueTankNum;
    public int hitRedTankNum;
    //当前分数
    public int scoreNow;
    //总的分数
    public int scoreSum;
    //单双人
    public boolean oneA_two;
    public Controller(){
        oneA_two = false;
        //玩家集合的实例化
        players = new ArrayList<Player>();
        //敌方坦克集合的实例化
        tank_enemies = new ArrayList<Tank_Enemy>();
        //子弹集合的实例化
        bullets = new ArrayList<Bullet>();
        //爆炸效果的实例化
        booms = new ArrayList<Boom>();
        //道具集合类的实例化
        items = new ArrayList<Items>();
        //关卡数的实例化
        levels = 0;
        // //敌方总坦克数的实例化
        enemySum = 20;
        //击毁坦克数的实例化
        hitTankNum = 0;
        //击毁坦克总数实例化
        hitTankSum = 0;
        //各种类的击毁坦克统计
        hitWhiteTankNum = 0;
        hitYellowTankNum = 0;
        hitGreenTankNum =0;
        hitBlueTankNum = 0;
        hitRedTankNum = 0;
        //当前分数和总得分数的实例化
        scoreNow = 0;
        scoreSum = 0;
        //地图类的实例化
        map = new Map(this);
        tankP1 = new Tank_Player1(this);
        tankP2 = new Tank_Player2(this);
        //玩家1 坦克
        tankP1.tankMove();
        tankP2.tank2Move();
        tankP1.tank1RanPos();
        //玩家2 坦克
        tankP2.tank2RanPos();

        tankGameTimer = new TankGameTimer(this);
        //敌方坦克类型集合的实例化
//        //m01
//        tank_m01_enemies  = new ArrayList<Tank_Enemy>();
//        for (int i = 0; i < 10; i++) {
//            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
//            tank_m01_enemies.add(whiteEnemyTank);
//        }
//        for (int i = 0; i < 7 ; i++) {
//            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
//            tank_m01_enemies.add(yellowEnemyTank);
//        }
//        for (int i = 0; i < 2 ; i++) {
//            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
//            tank_m01_enemies.add(greenEnemyTank);
//        }
//        Tank_Enemy blueEnemyTank = new Tank_Enemy(3,this);
//        tank_m01_enemies.add(blueEnemyTank);
//
//        //m02
//        tank_m02_enemies  = new ArrayList<Tank_Enemy>();
//        for (int i = 0; i < 8 ; i++) {
//            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
//            tank_m02_enemies.add(whiteEnemyTank);
//        }
//        for (int i = 0; i < 6 ; i++) {
//            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
//            tank_m02_enemies.add(yellowEnemyTank);
//        }
//        for (int i = 0; i < 4 ; i++) {
//            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
//            tank_m02_enemies.add(greenEnemyTank);
//        }
//        for (int i = 0; i < 2 ; i++) {
//            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
//            tank_m02_enemies.add(blueEnemyTank1);
//        }
//
//        //M03
//        tank_m03_enemies  = new ArrayList<Tank_Enemy>();
//        for (int i = 0; i < 6 ; i++) {
//            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
//            tank_m03_enemies.add(whiteEnemyTank);
//        }
//        for (int i = 0; i < 5 ; i++) {
//            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
//            tank_m03_enemies.add(yellowEnemyTank);
//        }
//        for (int i = 0; i < 6 ; i++) {
//            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
//            tank_m03_enemies.add(greenEnemyTank);
//        }for (int i = 0; i < 2 ; i++) {
//            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
//            tank_m03_enemies.add(blueEnemyTank1);
//        }
//        Tank_Enemy redEnemyTank= new Tank_Enemy(0,this);
//        tank_m03_enemies.add(redEnemyTank);
//
//
//        //M04
//        tank_m04_enemies  = new ArrayList<Tank_Enemy>();
//        for (int i = 0; i <4 ; i++) {
//            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
//            tank_m04_enemies.add(whiteEnemyTank);
//        }
//        for (int i = 0; i <4 ; i++) {
//            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
//            tank_m04_enemies.add(yellowEnemyTank);
//        }
//        for (int i = 0; i <6 ; i++) {
//            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
//            tank_m04_enemies.add(greenEnemyTank);
//        }
//        for (int i = 0; i <4 ; i++) {
//            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
//            tank_m03_enemies.add(blueEnemyTank1);
//        }
//        for (int i = 0; i <2 ; i++) {
//            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
//            tank_m04_enemies.add(redEnemyTank2);
//        }
//
//        //M05
//        tank_m05_enemies  = new ArrayList<Tank_Enemy>();
//        for (int i = 0; i <2; i++) {
//            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
//            tank_m05_enemies.add(whiteEnemyTank);
//        }
//        for (int i = 0; i <3 ; i++) {
//            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
//            tank_m05_enemies.add(yellowEnemyTank);
//        }
//        for (int i = 0; i <5 ; i++) {
//            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
//            tank_m05_enemies.add(greenEnemyTank);
//        }
//        for (int i = 0; i <6 ; i++) {
//            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
//            tank_m05_enemies.add(blueEnemyTank1);
//        }
//        for (int i = 0; i <4 ; i++) {
//            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
//            tank_m05_enemies.add(redEnemyTank2);
//        }
//
//        //M06
//        tank_m06_enemies  = new ArrayList<Tank_Enemy>();
//        Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
//        tank_m06_enemies.add(whiteEnemyTank);
//        for (int i = 0; i <2 ; i++) {
//            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
//            tank_m06_enemies.add(yellowEnemyTank);
//        }
//        for (int i = 0; i <4 ; i++) {
//            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
//            tank_m06_enemies.add(greenEnemyTank);
//        }
//        for (int i = 0; i <7 ; i++) {
//            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
//            tank_m06_enemies.add(blueEnemyTank1);
//        }
//        for (int i = 0; i <6 ; i++) {
//            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
//            tank_m06_enemies.add(redEnemyTank2);
//        }
//
//        //M07
//        tank_m07_enemies  = new ArrayList<Tank_Enemy>();
//        Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
//        tank_m07_enemies.add(yellowEnemyTank);
//        for (int i = 0; i <4 ; i++) {
//            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
//            tank_m07_enemies.add(greenEnemyTank);
//        }
//        for (int i = 0; i <8 ; i++) {
//            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
//            tank_m07_enemies.add(blueEnemyTank1);
//        }
//        for (int i = 0; i <7 ; i++) {
//            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
//            tank_m07_enemies.add(redEnemyTank2);
//        }
//
//        //M08
//        tank_m08_enemies  = new ArrayList<Tank_Enemy>();
//        for (int i = 0; i <4 ; i++) {
//            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
//            tank_m08_enemies.add(greenEnemyTank);
//        }
//        for (int i = 0; i <6 ; i++) {
//            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
//            tank_m08_enemies.add(blueEnemyTank1);
//        }
//        for (int i = 0; i <10 ; i++) {
//            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
//            tank_m08_enemies.add(redEnemyTank2);
//        }
        tankTypeNum();

    }

       //登录方法
    public boolean login(String name1){
        nowPlayer = new Player(name1);
        players.add(nowPlayer);
        System.out.println("存入姓名成功,开始登录");
        return true;

    }

    public void tankTypeNum(){
        //m01
        tank_m01_enemies  = new ArrayList<Tank_Enemy>();
        for (int i = 0; i < 10; i++) {
            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
            tank_m01_enemies.add(whiteEnemyTank);
        }
        for (int i = 0; i < 7 ; i++) {
            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
            tank_m01_enemies.add(yellowEnemyTank);
        }
        for (int i = 0; i < 2 ; i++) {
            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
            tank_m01_enemies.add(greenEnemyTank);
        }
        Tank_Enemy blueEnemyTank = new Tank_Enemy(3,this);
        tank_m01_enemies.add(blueEnemyTank);

        //m02
        tank_m02_enemies  = new ArrayList<Tank_Enemy>();
        for (int i = 0; i < 8 ; i++) {
            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
            tank_m02_enemies.add(whiteEnemyTank);
        }
        for (int i = 0; i < 6 ; i++) {
            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
            tank_m02_enemies.add(yellowEnemyTank);
        }
        for (int i = 0; i < 4 ; i++) {
            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
            tank_m02_enemies.add(greenEnemyTank);
        }
        for (int i = 0; i < 2 ; i++) {
            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
            tank_m02_enemies.add(blueEnemyTank1);
        }

        //M03
        tank_m03_enemies  = new ArrayList<Tank_Enemy>();
        for (int i = 0; i < 6 ; i++) {
            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
            tank_m03_enemies.add(whiteEnemyTank);
        }
        for (int i = 0; i < 5 ; i++) {
            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
            tank_m03_enemies.add(yellowEnemyTank);
        }
        for (int i = 0; i < 6 ; i++) {
            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
            tank_m03_enemies.add(greenEnemyTank);
        }for (int i = 0; i < 2 ; i++) {
            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
            tank_m03_enemies.add(blueEnemyTank1);
        }
        Tank_Enemy redEnemyTank= new Tank_Enemy(0,this);
        tank_m03_enemies.add(redEnemyTank);


        //M04
        tank_m04_enemies  = new ArrayList<Tank_Enemy>();
        for (int i = 0; i <4 ; i++) {
            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
            tank_m04_enemies.add(whiteEnemyTank);
        }
        for (int i = 0; i <4 ; i++) {
            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
            tank_m04_enemies.add(yellowEnemyTank);
        }
        for (int i = 0; i <6 ; i++) {
            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
            tank_m04_enemies.add(greenEnemyTank);
        }
        for (int i = 0; i <4 ; i++) {
            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
            tank_m04_enemies.add(blueEnemyTank1);
        }
        for (int i = 0; i <2 ; i++) {
            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
            tank_m04_enemies.add(redEnemyTank2);
        }

        //M05
        tank_m05_enemies  = new ArrayList<Tank_Enemy>();
        for (int i = 0; i <2; i++) {
            Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
            tank_m05_enemies.add(whiteEnemyTank);
        }
        for (int i = 0; i <3 ; i++) {
            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
            tank_m05_enemies.add(yellowEnemyTank);
        }
        for (int i = 0; i <5 ; i++) {
            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
            tank_m05_enemies.add(greenEnemyTank);
        }
        for (int i = 0; i <6 ; i++) {
            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
            tank_m05_enemies.add(blueEnemyTank1);
        }
        for (int i = 0; i <4 ; i++) {
            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
            tank_m05_enemies.add(redEnemyTank2);
        }

        //M06
        tank_m06_enemies  = new ArrayList<Tank_Enemy>();
        Tank_Enemy whiteEnemyTank = new Tank_Enemy(1,this);
        tank_m06_enemies.add(whiteEnemyTank);
        for (int i = 0; i <2 ; i++) {
            Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
            tank_m06_enemies.add(yellowEnemyTank);
        }
        for (int i = 0; i <4 ; i++) {
            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
            tank_m06_enemies.add(greenEnemyTank);
        }
        for (int i = 0; i <7 ; i++) {
            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
            tank_m06_enemies.add(blueEnemyTank1);
        }
        for (int i = 0; i <6 ; i++) {
            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
            tank_m06_enemies.add(redEnemyTank2);
        }

        //M07
        tank_m07_enemies  = new ArrayList<Tank_Enemy>();
        Tank_Enemy yellowEnemyTank = new Tank_Enemy(2,this);
        tank_m07_enemies.add(yellowEnemyTank);
        for (int i = 0; i <4 ; i++) {
            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
            tank_m07_enemies.add(greenEnemyTank);
        }
        for (int i = 0; i <8 ; i++) {
            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
            tank_m07_enemies.add(blueEnemyTank1);
        }
        for (int i = 0; i <7 ; i++) {
            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
            tank_m07_enemies.add(redEnemyTank2);
        }

        //M08
        tank_m08_enemies  = new ArrayList<Tank_Enemy>();
        for (int i = 0; i <4 ; i++) {
            Tank_Enemy greenEnemyTank = new Tank_Enemy(4,this);
            tank_m08_enemies.add(greenEnemyTank);
        }
        for (int i = 0; i <6 ; i++) {
            Tank_Enemy blueEnemyTank1 = new Tank_Enemy(3,this);
            tank_m08_enemies.add(blueEnemyTank1);
        }
        for (int i = 0; i <10 ; i++) {
            Tank_Enemy redEnemyTank2 = new Tank_Enemy(0,this);
            tank_m08_enemies.add(redEnemyTank2);
        }
    }

}
