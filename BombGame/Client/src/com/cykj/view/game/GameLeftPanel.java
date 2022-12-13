package com.cykj.view.game;

import com.cykj.Thread.CliReadThread;
import com.cykj.bean.Boom;
import com.cykj.bean.Player;
import com.cykj.controller.CliController;
import com.cykj.controller.GameKeyLis;
import com.cykj.model.Data;

import javax.swing.*;
import java.awt.*;

public class GameLeftPanel extends JPanel {
    public CliController con;
    public Font font = new Font("宋体", Font.PLAIN, 20);
    public GameRightPanel gameRightPanel;
    public Player player;
    public Player master;
    public GameLeftPanel(CliController con){
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
        //玩家1
        player = CliReadThread.player;
        g.drawImage(Data.PPS[player.getImage()],player.getPlayerX(),player.getPlayerY(),30,30,null);
        //玩家2
        master = CliReadThread.master;
        g.drawImage(Data.PPS[master.getImage()],master.getPlayerX(),master.getPlayerY(),30,30,null);

        //炸弹爆炸
        for (int i = 0; i < con.booms.size(); i++) {   //分时间段来展示不一样的图片来达成爆炸效果
            if (con.booms.get(i).boomTime <=5){
                g.drawImage(con.booms.get(i).boomImg1,con.booms.get(i).boomX*30,con.booms.get(i).boomY*30,30,30,null);
            }else if (con.booms.get(i).boomTime >5 && con.booms.get(i).boomTime <= 10){
                g.drawImage(con.booms.get(i).boomImg2,con.booms.get(i).boomX*30,con.booms.get(i).boomY*30,30,30,null);
            }else if (con.booms.get(i).boomTime >10 && con.booms.get(i).boomTime <=20){
                g.drawImage(con.booms.get(i).boomImg3,con.booms.get(i).boomX*30,con.booms.get(i).boomY*30,30,30,null);
            }else {
                con.booms.remove(con.booms.get(i));  //用完就清掉防止占内存
            }

        }


        //地图元素的绘画
        for (int i = 0; i < con.map.allMapArray[con.levels].length; i++) {
            for (int j = 0; j < con.map.allMapArray[con.levels][i].length; j++) {
                switch (con.map.allMapArray[con.levels][j][i]){
                    case 22:
                        g.drawImage(Data.BOMB,i*30,j*30,30,30,null);
                        break;
                    case 1:
                        g.drawImage(Data.WALL,i*30,j*30,30,30,null);//土墙
                        break;
                    case 2:
                        g.drawImage(Data.CHECK_1,i*30,j*30,30,30,null);//铁墙1
                        break;
                    case 3:
                        g.drawImage(Data.ICE,i*30,j*30,30,30,null);//冰砖
                        break;
                    case 4:
                        g.drawImage(Data.BAG,i*30,j*30,60,60,null);//老家
                        break;
                    case 5:
                        g.drawImage(Data.CHECK_2,i*30,j*30,30,30,null);//铁墙2
                        break;
                    case 6:
                        g.drawImage(Data.DRAGON,i*30,j*30,60,60,null);//龙老家
                        break;
                    case 7:
                        g.drawImage(Data.GRASS,i*30,j*30,30,30,null);//草
                        break;
                    case 8:
                        g.drawImage(Data.GRASS_2,i*30,j*30,30,30,null);//草2
                        break;
                    case 9:
                        g.drawImage(Data.GRASS_3,i*30,j*30,30,30,null);//草3
                        break;
                    case 10:
                        g.drawImage(Data.GRASS_4,i*30,j*30,30,30,null);//草4
                        break;
                    case 11:
                        g.drawImage(Data.ICE_2,i*30,j*30,30,30,null);//冰2
                        break;
                    case 12:
                        g.drawImage(Data.ICE_3,i*30,j*30,30,30,null);//冰3
                        break;
                    case 13:
                        g.drawImage(Data.ICE_4,i*30,j*30,30,30,null);//冰4
                        break;
                    case 14:
                        g.drawImage(Data.ICE_MAN,i*30,j*30,30,30,null);//雪人
                        break;
                    case 15:
                        g.drawImage(Data.ICE_TREE,i*30,j*30,30,30,null);//圣诞树
                        break;
                    case 16:
                        g.drawImage(Data.PIG,i*30,j*30,30,30,null);//猪
                        break;
                    case 17:
                        g.drawImage(Data.PIG_HOME_LEFT,i*30,j*30,30,30,null);//猪的家左
                        break;
                    case 18:
                        g.drawImage(Data.PIG_HOME_RIGHT,i*30,j*30,30,30,null);//冰2
                        break;
                    case 19:
                        g.drawImage(Data.STAR,i*30,j*30,30,30,null);//魔法阵
                        break;
                    case 20:
                        g.drawImage(Data.TREE_1,i*30,j*30,30,30,null);//树1
                        break;
                    case 21:
                        g.drawImage(Data.TREE_2,i*30,j*30,30,30,null);//树2
                        break;
                }
            }
        }
    }
}
