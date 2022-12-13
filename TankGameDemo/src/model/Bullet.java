package model;

import controller.Controller;
import view.UI;

import java.awt.*;

public class Bullet {
    public Controller con;
    public int bulletDir;
    public int bulletX;
    public int bulletY;
    public int speed;
    public int bulletType;
    public Image bulletImg;

    //    public boolean Live = true;//子弹是否存活
    public Bullet(int bulletType, Controller con, int dir, int x, int y) {
        this.bulletDir = dir;
        this.con = con;
        this.bulletType = bulletType;
        bulletX = x;
        bulletY = y;
        switch (bulletType) {
            case 1:       //我方坦克子弹的类型
                speed = 15;
                break;
            case 2:       //敌方坦克的子弹
                speed = 8;
                break;

        }
    }

    //我方坦克子弹的移动方法
    public void bulletMove() {
        if (bulletDir == 0 && !bulletBoom(bulletX, bulletY)) {
            bulletImg = Data.BULLET;
            bulletY -= speed;
        } else if (bulletDir == 1 && !bulletBoom(bulletX, bulletY)) {
            bulletImg = Data.BULLET;
            bulletY += speed;
        } else if (bulletDir == 2 && !bulletBoom(bulletX, bulletY)) {
            bulletImg = Data.BULLET;
            bulletX -= speed;
        } else if (bulletDir == 3 && !bulletBoom(bulletX, bulletY)) {
            bulletImg = Data.BULLET;
            bulletX += speed;
        }
//            System.out.println("子弹的x坐标="+bulletX+"子弹的y坐标为"+bulletY);
    }


    //我方坦克子弹与障碍物和敌方坦克的碰撞,以及敌方坦克子弹与我方坦克的碰撞，以及边界碰撞消失
    public boolean bulletBoom(int x, int y) {
        if ((bulletX < 0 || bulletY < 0 || bulletX > 720 || bulletY > 710)) {    //判断是否超过边界
            con.bullets.remove(this);                   //清除当前子弹
//            System.out.println("子弹运动到边界，子弹消失!");
            return true;
        }
        Rectangle bulletRec = new Rectangle(x, y, 10, 10);  //生成一个子弹的矩形
        for (int i = 0; i < UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels].length; i++) {   //遍历地图的二维数组
            for (int j = 0; j < UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels][i].length; j++) {
                Rectangle mapRec = new Rectangle(i * 30, j * 30, 30, 30);//生成二维数组内的元素方块矩形
                switch (UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels][j][i]) { //优化
                    case 1:                                                     //土墙
                        if (mapRec.intersects(bulletRec)) {
//                                System.out.println(mapRec.intersects(bulletRec) + "子弹撞到了土墙");
                            UI.gameFrame.gameLeftPanel.con.map.allMapArray[con.levels][j][i] = 0;  //子弹撞到障碍物然后二维数组内的该障碍物元素变为0，0代表空白无元素
//                                System.out.println("子弹打穿了障碍物");
                            con.bullets.remove(this);                       //清除打穿障碍物的这一颗子弹
//                                System.out.println("打到可打穿的障碍物，子弹消失！");
                            return true;
                        }
                        break;
                    case 2:                                                     //铁墙
                        if (mapRec.intersects(bulletRec)) {
//                                System.out.println("子弹撞到了铁墙");
                            con.bullets.remove(this);                      //清除打到铁墙的这一颗子弹
//                                System.out.println("打到铁墙，子弹消失！");
                            return true;
                        }
                        break;
                    case 4:                                                     //老家
                        if (mapRec.intersects(bulletRec)) {
                            UI.gameFrame.setVisible(false);
                            UI.gameOverFrame.setVisible(true);
                            con.tankGameTimer.myTimer.stop();
                            return true;
                        }
                        break;
                }

            }

        }
        if (bulletType == 1) {  //我方子弹碰撞敌方坦克
            for (int i = 0; i < con.tank_enemies.size(); i++) {
                Tank_Enemy tankEnemy = con.tank_enemies.get(i);
                Rectangle enemyRec = new Rectangle(con.tank_enemies.get(i).tankX, con.tank_enemies.get(i).tankY, 30, 30);
                if (bulletRec.intersects(enemyRec)) {
//                        System.out.println("我方子弹撞到了敌方坦克");
                    con.tank_enemies.get(i).blood--;
                    if (con.tank_enemies.get(i).blood <= 0) {
                        Boom boom = new Boom(con, con.tank_enemies.get(i).tankX, con.tank_enemies.get(i).tankY);
                        con.booms.add(boom);
                        System.out.println("坦克的血量为0");
//                        con.tankGameTimer.gameScore();//调用获取右侧下方top信息面板实时数据的方法
//                        敌方坦克总数
                        con.enemySum--;
                        //击毁坦克数
                        con.hitTankNum++;
                        //击毁坦克总数
                        con.hitTankSum++;
                        if (con.tank_enemies.get(i).type == 0) {
                            con.scoreNow += 500;
                            con.scoreSum += 500;
                            con.hitRedTankNum++;
                        }
                        if (con.tank_enemies.get(i).type == 1) {
                            con.scoreNow += 100;
                            con.scoreSum += 100;
                            con.hitWhiteTankNum++;
                        }
                        if (con.tank_enemies.get(i).type == 2) {
                            con.scoreNow += 200;
                            con.scoreSum += 200;
                            con.hitYellowTankNum++;
                        }
                        if (con.tank_enemies.get(i).type == 3) {
                            con.scoreNow += 300;
                            con.scoreSum += 300;
                            con.hitBlueTankNum++;
                        }
                        if (con.tank_enemies.get(i).type == 4) {
                            con.scoreNow += 200;
                            con.scoreSum += 200;
                            con.hitGreenTankNum++;
                        }
                        con.tank_enemies.remove(tankEnemy);//清除被打中的这只敌方坦克
//                        System.out.println("当前数为" + con.scoreNow);
                        if (con.enemySum <= 0) {
                            UI.gameLeaderFrame.setVisible(true);
                            con.tankGameTimer.myTimer.stop();
                        }
                        UI.gameLeaderFrame.gameLeaderPanel.label1.setText("stage   "+(con.levels+1));
                        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label2.setText(" " + con.hitTankNum); //击毁坦克数
                        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label4.setText(" " + con.scoreNow);   //该关得分
                        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label6.setText(" " + con.hitTankSum); //总击毁坦克数
                        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.label8.setText(" " + con.scoreSum);   //总分数
                        UI.gameFrame.gameLeftPanel.gameRightPanel.rightPanelBottom.repaint();
                        UI.gameLeaderFrame.gameLeaderPanel.label2.setText("  " + con.hitWhiteTankNum);
                        UI.gameLeaderFrame.gameLeaderPanel.label3.setText("  " + con.hitYellowTankNum);
                        UI.gameLeaderFrame.gameLeaderPanel.label4.setText("  " + con.hitGreenTankNum);
                        UI.gameLeaderFrame.gameLeaderPanel.label5.setText("  " + con.hitBlueTankNum);
                        UI.gameLeaderFrame.gameLeaderPanel.label6.setText("  " + con.hitRedTankNum);

                        UI.gameLeaderFrame.gameLeaderPanel.label2Sum.setText("    " + con.hitWhiteTankNum * 100);
                        UI.gameLeaderFrame.gameLeaderPanel.label3Sum.setText("    " + con.hitYellowTankNum * 200);
                        UI.gameLeaderFrame.gameLeaderPanel.label4Sum.setText("    " + con.hitGreenTankNum * 200);
                        UI.gameLeaderFrame.gameLeaderPanel.label5Sum.setText("    " + con.hitBlueTankNum * 300);
                        UI.gameLeaderFrame.gameLeaderPanel.label6Sum.setText("    " + con.hitRedTankNum * 500);
                        UI.gameLeaderFrame.gameLeaderPanel.label9N.setText("    " + con.scoreSum);
                    }
                    con.bullets.remove(this);               //清除打中敌方坦克的这一颗子弹
//                        System.out.println("打到敌方坦克，子弹消失！");
                    return true;
                }
            }
        } else if (bulletType == 2) { //敌方子弹撞击我方坦克
            Rectangle userTankRec = new Rectangle(con.tankP1.tankX, con.tankP1.tankY, 30, 30);
            if (bulletRec.intersects(userTankRec)) {
//                    System.out.println("敌方子弹打到我方");
                con.tankP1.blood--;
                if (con.tankP1.blood <= 0) {
                    Boom boom = new Boom(con, con.tankP1.tankX, con.tankP1.tankY);
                    con.booms.add(boom);
                    con.tankP1 = new Tank_Player1(con);
                    con.tankP1.tank1RanPos();
                }
                con.bullets.remove(this);                   //清除打中我方的这一颗敌方子弹
                return true;
            }
            for (int i = 0; i < con.bullets.size(); i++) {
                Bullet bullet = con.bullets.get(i);
                if (con.bullets.get(i).bulletType == 1) {
                    //生成对立当前类型的另一个类型的子弹矩形
                    Rectangle oppBulletRec = new Rectangle(con.bullets.get(i).bulletX, con.bullets.get(i).bulletY, 10, 10);
                    if (bulletRec.intersects(oppBulletRec)) {   //将两个不同类型的矩形进行碰撞
//                            System.out.println("相同类型子弹发生碰撞");
                        con.bullets.remove(this);           //清除当前这个类型的这一颗子弹
                        con.bullets.remove(bullet);//清除对立类型的这一颗子弹
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
