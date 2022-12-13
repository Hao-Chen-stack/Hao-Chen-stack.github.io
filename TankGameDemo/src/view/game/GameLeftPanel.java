package view.game;

import controller.Controller;
import controller.GameKeyLis;
import model.Data;

//import model.Tank_Player2;


import javax.swing.*;
import java.awt.*;

public class GameLeftPanel extends JPanel {
    public Controller con;
    public Font font = new Font("宋体", Font.PLAIN, 20);
    public GameRightPanel gameRightPanel;
    public Rectangle wallRec;
    public GameLeftPanel(Controller con){
        this.con = con;
        setBackground(new Color(0,0,0));
        setLayout(new BorderLayout(0, 0));
        gameRightPanel = new GameRightPanel(con);
        add(gameRightPanel, BorderLayout.EAST);
        setPreferredSize(new Dimension(270, 750));

        //设置可以聚焦
        setFocusable(true);
        //键盘监听实例化
        GameKeyLis gameKeyLis = new GameKeyLis(con,this);
        addKeyListener(gameKeyLis);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //坦克 玩家1
        g.drawImage(Data.TANK1UP,con.tankP1.tankX,con.tankP1.tankY,30,30,null);
        g.drawImage(con.tankP1.image,con.tankP1.tankX,con.tankP1.tankY,30,30,null);

        //坦克 玩家2
        if (con.oneA_two){
            g.drawImage(Data.TANK2UP,con.tankP2.tankX,con.tankP2.tankY,30,30,null);
            g.drawImage(con.tankP2.image,con.tankP2.tankX,con.tankP2.tankY,30,30,null);
        }
        //敌方坦克的随机生成
        for (int i = 0; i <con.tank_enemies.size() ; i++) {
            g.drawImage(con.tank_enemies.get(i).image,con.tank_enemies.get(i).tankX,con.tank_enemies.get(i).tankY,30,30,null);
        }

        //子弹的绘画渲染
        for (int i = 0; i < con.bullets.size(); i++) {
            g.drawImage(Data.BULLET,con.bullets.get(i).bulletX,con.bullets.get(i).bulletY,10,10,null);
        }


        //地图元素的绘画
        for (int i = 0; i < con.map.allMapArray[con.levels].length; i++) {
            for (int j = 0; j < con.map.allMapArray[con.levels][i].length; j++) {
                switch (con.map.allMapArray[con.levels][j][i]){
                    case 1:
                        g.drawImage(Data.MAPQIANG,i*30,j*30,30,30,null);//土墙
                        break;
                    case 2:
                        g.drawImage(Data.MAPGANG,i*30,j*30,30,30,null);//铁墙
                        break;
                    case 3:
                        g.drawImage(Data.MAPSHUI,i*30,j*30,30,30,null);//水
                        break;
                    case 4:
                        g.drawImage(Data.MAPLAOJIA,i*30,j*30,30,30,null);//老家
                        break;
                    case 5:
                        g.drawImage(Data.MAPCAO,i*30,j*30,30,30,null);//草
                        break;
                }
            }
        }

        //敌方爆炸效果图的绘画
        for (int i = 0; i < con.booms.size(); i++) {   //分时间段来展示不一样的图片来达成爆炸效果
            if (con.booms.get(i).boomTime <=5){
                g.drawImage(con.booms.get(i).boomImg1,con.booms.get(i).boomX,con.booms.get(i).boomY,30,30,null);
            }else if (con.booms.get(i).boomTime >5 && con.booms.get(i).boomTime <= 10){
                g.drawImage(con.booms.get(i).boomImg2,con.booms.get(i).boomX,con.booms.get(i).boomY,30,30,null);
            }else if (con.booms.get(i).boomTime >10 && con.booms.get(i).boomTime <=20){
                g.drawImage(con.booms.get(i).boomImg3,con.booms.get(i).boomX,con.booms.get(i).boomY,30,30,null);
            }else {
                con.booms.remove(con.booms.get(i));  //用完就清掉防止占内存
            }

        }

        //绘制道具
        for (int i = 0; i < con.items.size(); i++) {
            switch (con.items.get(i).type){
                case 1:
                case 2:
                    g.drawImage(con.items.get(i).itemsImag,con.items.get(i).itemsY*30,con.items.get(i).itemsX*30,30,30,null);
                    break;
            }
        }


        //我方坦克 血条的绘画
        if (con.tankP1.blood == 3) {
            g.drawImage(Data.BLOOD_1, con.tankP1.tankX, con.tankP1.tankY, 30, 10, null);
        } else if (con.tankP1.blood ==2) {
            g.drawImage(Data.BLOOD_2, con.tankP1.tankX, con.tankP1.tankY, 30, 10, null);
        }else if (con.tankP1.blood ==1){
            g.drawImage(Data.BLOOD_3, con.tankP1.tankX, con.tankP1.tankY, 30, 10, null);
        }


        //敌方坦克 血条的绘画
        for (int i = 0; i < con.tank_enemies.size(); i++) {
            if (con.tank_enemies.get(i).blood ==3){
                g.drawImage(Data.BLOOD_1, con.tankP1.tankX, con.tankP1.tankY, 30, 10, null);
            }else if (con.tank_enemies.get(i).blood ==2){
                g.drawImage(Data.BLOOD_2, con.tank_enemies.get(i).tankX, con.tank_enemies.get(i).tankY, 30, 10, null);
            }else if (con.tank_enemies.get(i).blood ==1){
                g.drawImage(Data.BLOOD_3, con.tank_enemies.get(i).tankX, con.tank_enemies.get(i).tankY, 30, 10, null);
            }
        }


    }
}
