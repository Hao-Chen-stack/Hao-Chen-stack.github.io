package model;

import controller.Controller;
import view.UI;

import java.awt.*;
import java.util.Random;

public class Tank_Enemy extends Tank{
    public Controller con;
    public int type;
//    //敌方坦克速度
//    public int speed = 6;
    public int dir = 0;//方向随机数,0向上，1向下，2向左，3向右
    public int enemyFileTime = 0;
    public Image imageUp,imageDown,imageLeft,imageRight;//四个方向的图片属性

    public Tank_Enemy(int type,Controller con){
        super(con);
        this.con = con;
        this.type = type;
        switch (type){      //不同类型的敌方坦克
            case 0:         //红色
                speed = 2;
                blood = 3;
                point = 500;
                imageUp = Data.ENEMY_TANK1_UP;
                imageDown = Data.ENEMY_TANK1_DOWN;
                imageLeft = Data.ENEMY_TANK1_LEFT;
                imageRight = Data.ENEMY_TANK1_RIGHT;
                break;
            case 1:         //白色
                speed = 1;
                blood = 1;
                point = 100;
                imageUp = Data.ENEMY_TANK2_UP;
                imageDown = Data.ENEMY_TANK2_DOWN;
                imageLeft = Data.ENEMY_TANK2_LEFT;
                imageRight = Data.ENEMY_TANK2_RIGHT;
                break;
            case 2:         //黄色
                speed = 2;
                blood = 1;
                point = 200;
                imageUp = Data.ENEMY_TANK_YELLOW_UP;
                imageDown = Data.ENEMY_TANK_YELLOW_DOWN;
                imageLeft = Data.ENEMY_TANK_YELLOW_LEFT;
                imageRight = Data.ENEMY_TANK_YELLOW_RIGHT;
                break;
            case 3:         //蓝色
                speed = 2;
                blood = 2;
                point = 300;
                imageUp = Data.ENEMY_TANK_BLUE_UP;
                imageDown = Data.ENEMY_TANK_BLUE_DOWN;
                imageLeft = Data.ENEMY_TANK_BLUE_LEFT;
                imageRight = Data.ENEMY_TANK_BLUE_RIGHT;
                break;
            case 4:         //绿色
                speed = 1;
                blood = 2;
                point = 200;
                imageUp = Data.ENEMY_TANK_GREEN_UP;
                imageDown = Data.ENEMY_TANK_GREEN_DOWN;
                imageLeft = Data.ENEMY_TANK_GREEN_LEFT;
                imageRight = Data.ENEMY_TANK_GREEN_RIGHT;
                break;
        }
    }

    //敌方坦克的方向随机
    public void EnemyRanPos(){
        Random ran = new Random();
        dir = ran.nextInt(4);//方向随机数,0向上，1向下，2向左，3向右
//        System.out.println("方向改变");
    }

    //敌方坦克移动方法和边界碰撞以及碰撞元素方块检测
    public void tankMove(){
//        System.out.println("方向等于"+dir);
        if (dir == 0) {//向上
            image = imageUp;
            if ((!hitWall(tankX,tankY-speed)) && tankY-speed >= 3 && !tankHitTank(tankX,tankY-speed)){
                tankY -= speed;
            }else {
                EnemyRanPos();//发生碰撞的时候转向
            }
        } else if (dir == 1) {//向下
            image = imageDown;
            if ((!hitWall(tankX,tankY+speed)) && tankY <= 655 && !tankHitTank(tankX,tankY+speed)){
                tankY += speed;
            }else {
                EnemyRanPos();
            }
        } else if (dir == 2) {//向左
            image = imageLeft;
            if (!hitWall(tankX-speed,tankY) && tankX-speed >= 3 && !tankHitTank(tankX-speed,tankY)){
                tankX -= speed;
            }else {
                EnemyRanPos();
            }
        } else if (dir == 3) {//向右
            image = imageRight;
            if (!hitWall(tankX+speed,tankY) && tankX <= 710 && !tankHitTank(tankX+speed,tankY)){
                tankX += speed;
            }else {
                EnemyRanPos();
            }
        }
    }
    //敌方坦克与障碍物之间的碰撞
    public boolean hitWall(int x, int y) {
        Rectangle tankRec = new Rectangle(x, y, 30, 30);//坦克下一次移动的矩形
        for (int i = 0; i < UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels].length; i++) {
            for (int j = 0; j < UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels][i].length; j++) {
                switch (UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels][j][i]) {
                    case 1:
                    case 2:
                    case 3:
                        Rectangle mapRec = new Rectangle(i * 30, j * 30, 30, 30);
                        if (mapRec.intersects(tankRec)) {
                            return true;
                        }
                        break;
                }
            }
        }
        Rectangle playerTankRec = new Rectangle(con.tankP1.tankX,con.tankP1.tankY,30,30);
        if (playerTankRec.intersects(tankRec)){
            return true;
        }
        Rectangle player2TankRec = new Rectangle(con.tankP2.tankX,con.tankP2.tankY,30,30);
        return player2TankRec.intersects(tankRec);
    }

    //    敌方坦克之间的碰撞方法
    public boolean tankHitTank(int x, int y) {
        //获取敌方坦克集合里的所有坦克对象
        for (int i = 0; i < con.tank_enemies.size(); i++) {
            //获取坦克对象
            Tank_Enemy t = con.tank_enemies.get(i);
            if (this.equals(t)) {//排除掉自身，遍历到自身就截断，之后就继续遍历除自身以外的坦克
                continue;
            }
            Rectangle next = new Rectangle(t.tankX, t.tankY, 30, 30);//创建下一只坦克的矩形区域
            Rectangle thisEnemyRec = new Rectangle(x, y, 30, 30); //坦克自身对象
            if (next.intersects(thisEnemyRec)) {
//                System.out.println(next.intersects(thisEnemyRec)+"敌方坦克之间发生碰撞");
                return true;
            }
        }
        return false;
    }

    public void shootBullet(){
        Bullet bullet = new Bullet(2,con,dir,tankX+(30/2-10/2),tankY+(30/2-10/2));
        con.bullets.add(bullet);
    }


}
