package com.cykj.view;

import com.cykj.Thread.CliReadThread;
import com.cykj.bean.BombUserstyle;
import com.cykj.controller.CliController;
import com.cykj.controller.CliWaitRoomActLis;
import com.cykj.model.Data;
import com.cykj.util.GameMusic;
import com.cykj.view.game.ChooseMapPanel;

import javax.swing.*;
import java.awt.*;

public class CliWaitRoomPanel extends JPanel implements Runnable {
    public CliController con;
    public JButton reBtn;
    public JButton showMapBtn;
    public JButton startBtn;
    public JButton readyBtn;
    private JLabel createRoomLabel;
//    public int waitHitNum;
//    public int waitDressNum;
    private JLabel readyLabel;
    private JLabel decTimeLabel;
    public  int countDown = 6;//倒计时

    public JLabel getCreateRoomLabel() {
        return createRoomLabel;
    }

    public void setCreateRoomLabel(JLabel createRoomLabel) {
        this.createRoomLabel = createRoomLabel;
    }

    public JLabel getReadyLabel() {
        return readyLabel;
    }

    public void setReadyLabel(JLabel readyLabel) {
        this.readyLabel = readyLabel;
    }

    public JLabel getDecTimeLabel() {
        return decTimeLabel;
    }

    public void setDecTimeLabel(JLabel decTimeLabel) {
        this.decTimeLabel = decTimeLabel;
    }

    CliWaitRoomPanel(CliController con){
        this.con = con;
        setLayout(null);
        //返回大厅
        this.reBtn = new JButton();
        this.reBtn.setBounds(0,0,110,50);
        this.reBtn.setContentAreaFilled(false);//透明
        add(this.reBtn);

        //显示地图
        showMapBtn = new JButton();
        showMapBtn.setBounds(45,65,143,180);
        showMapBtn.setContentAreaFilled(false);//透明
        add(showMapBtn);

        //准备
        this.readyBtn = new JButton();
        this.readyBtn.setBounds(540,495,110,50);
        this.readyBtn.setContentAreaFilled(false);
        add(this.readyBtn);

        //开始
        this.startBtn = new JButton();
        this.startBtn.setBounds(670,495,130,50);
        this.startBtn.setContentAreaFilled(false);
        add(this.startBtn);

        //监听的注册和实例
        CliWaitRoomActLis waitRoomActLis = new CliWaitRoomActLis(con);
        reBtn.addActionListener(waitRoomActLis);
        reBtn.setActionCommand("reCen");
        showMapBtn.addActionListener(waitRoomActLis);
        showMapBtn.setActionCommand("showMap");
        readyBtn.addActionListener(waitRoomActLis);
        readyBtn.setActionCommand("ready");
        startBtn.addActionListener(waitRoomActLis);
        startBtn.setActionCommand("startGame");
        //房主的文本位置
        this.createRoomLabel = new JLabel("");
        this.createRoomLabel.setFont(new Font("宋体",Font.BOLD,22));
        this.createRoomLabel.setBounds(450,0,200,50);
        add(createRoomLabel);
        //准备字样的文本位置
        readyLabel = new JLabel("");
        readyLabel.setFont(new Font("宋体",Font.BOLD,22));
        readyLabel.setBounds(50,450,200,50);
        add(readyLabel);
        //倒计时文本位置
        decTimeLabel = new JLabel("");
        decTimeLabel.setFont(new Font("宋体",Font.BOLD,22));
        decTimeLabel.setBounds(650,0,200,50);
        add(decTimeLabel);

    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.countDown--;
            if (countDown<0){
                break;
            }
            decTimeLabel.setText("倒计时："+countDown);
        }
        UI.hitGameFrame.setVisible(true);
        GameMusic gameMusic = new GameMusic("Client/music/gameBg.wav");
        gameMusic.play();
        gameMusic.setLoop(true);
        UI.chooseMap.setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(Data.CHOOSE_MAP,0,0,850,565,null);
        if (ChooseMapPanel.mapNum == 1){
            g.drawImage(Data.MAP1,45,65,143,180,null);
        }else if (ChooseMapPanel.mapNum == 2){
            g.drawImage(Data.MAP2,45,65,143,180,null);
        }else if (ChooseMapPanel.mapNum == 3){
            g.drawImage(Data.MAP3,45,65,143,180,null);
        }

        //房主进入房间的衣服判断
        if (CliReadThread.bombUserstyle !=null){
            int num =  CliReadThread.bombUserstyle.getNum();
            int hitNum = CliReadThread.bombUserstyle.getHat();
            int dressNum = CliReadThread.bombUserstyle.getDress();
            if (num == 1){
                g.drawImage(Data.PP1,280,0,710,599,null);
                if (hitNum == 1){
                    g.drawImage(Data.PP1_HAT_1,520,150,200,160,null);
                }else if (hitNum == 2){
                    g.drawImage(Data.PP1_HAT_2,520,180,230,130,null);
                }else if (hitNum == 3){
                    g.drawImage(Data.PP1_HAT_3,520,230,230,130,null);
                }
                if (dressNum ==1){
                    g.drawImage(Data.PP1_DRESS_1,532,285,170,130,null);
                }else if (dressNum ==2){
                    g.drawImage(Data.PP1_DRESS_2,565,295,130,120,null);
                }else if (dressNum ==3){
                    g.drawImage(Data.PP1_DRESS_3,565,315,130,100,null);
                }

            }else if (num == 2){
                g.drawImage(Data.PP2,280,0,710,599,null);
                if (dressNum ==1){
                    g.drawImage(Data.PP2_DRESS_2,518,285,212,155,null);
                }else if (dressNum ==2){
                    g.drawImage(Data.PP2_DRESS_3,480,250,280,220,null);
                }else if (dressNum ==3){
                    g.drawImage(Data.PP2_DRESS_4,488,250,275,225,null);
                }
            }else if (num == 3){
                g.drawImage(Data.PP3,280,0,710,599,null);
                if (hitNum ==1){
                    g.drawImage(Data.PP3_HAT_1,470,150,200,160,null);
                }else if (hitNum ==2){
                    g.drawImage(Data.PP3_HAT_2,460,180,230,130,null);
                }else if (hitNum ==3){
                    g.drawImage(Data.PP3_HAT_3,460,180,230,130,null);
                }
                if (dressNum ==1){
                    g.drawImage(Data.PP3_DRESS_1,465,285,212,155,null);
                }else if (dressNum ==2){
                    g.drawImage(Data.PP3_DRESS_2,480,320,180,100,null);
                }else if (dressNum ==3){
                    g.drawImage(Data.PP3_DRESS_3,480,320,180,100,null);
                }
            }else if (num == 4){
                g.drawImage(Data.PP4,280,0,710,599,null);
                if (hitNum ==1){
                    g.drawImage(Data.PP4_HAT_1,520,150,200,160,null);
                }else if (hitNum ==2){
                    g.drawImage(Data.PP4_HAT_2,520,150,220,160,null);
                }
                if (dressNum ==1){
                    g.drawImage(Data.PP4_DRESS_1,515,285,212,155,null);
                }else if (dressNum ==2){
                    g.drawImage(Data.PP4_DRESS_2,530,320,180,100,null);
                }else if (dressNum ==3){
                    g.drawImage(Data.PP4_DRESS_3,560,320,150,110,null);
                }
            }else if (num == 5){
                g.drawImage(Data.PP5,280,0,710,599,null);
                if (hitNum ==1){
                    g.drawImage(Data.PP5_HAT_1,520,150,200,160,null);
                }else if (hitNum ==2){
                    g.drawImage(Data.PP5_HAT_2,520,170,220,160,null);
                }else if (hitNum ==3){
                    g.drawImage(Data.PP5_HAT_3,510,170,220,160,null);
                }
                if (dressNum ==1){
                    g.drawImage(Data.PP5_DRESS_1,515,285,212,155,null);
                }else if (dressNum ==2){
                    g.drawImage(Data.PP5_DRESS_2,530,300,180,100,null);
                }else if (dressNum ==3){
                    g.drawImage(Data.PP5_DRESS_3,510,275,212,155,null);
                }
            }else if (num == 6){
                g.drawImage(Data.PP6,280,0,710,599,null);
                if (hitNum == 1){
                    g.drawImage(Data.PP6_HAT_1,515,180,230,160,null);
                }else if (hitNum == 2){
                    g.drawImage(Data.PP6_HAT_2,520,170,220,160,null);
                }else if (hitNum == 3){
                    g.drawImage(Data.PP6_HAT_3,520,180,230,160,null);
                }
                if (dressNum == 1){
                    g.drawImage(Data.PP6_DRESS_1,523,300,200,143,null);
                }else if (dressNum == 2){
                    g.drawImage(Data.PP6_DRESS_2,540,310,180,100,null);
                }else if (dressNum ==3){
                    g.drawImage(Data.PP6_DRESS_3,528,290,212,155,null);
                }
            }else if (num == 7){
                g.drawImage(Data.PP7,280,0,710,599,null);
                if (hitNum == 1){
                    g.drawImage(Data.PP7_HAT_1,505,180,230,160,null);
                }
                if (dressNum == 1){
                    g.drawImage(Data.PP7_DRESS_1,540,300,150,135,null);
                }else if (dressNum ==2){
                    g.drawImage(Data.PP7_DRESS_2,525,280,180,135,null);
                }else if (dressNum ==3){
                    g.drawImage(Data.PP7_DRESS_3,550,310,130,115,null);
                }
            }else if (num == 8){
                g.drawImage(Data.PP8,280,0,710,599,null);
                if (hitNum ==2){
                    g.drawImage(Data.PP8_HAT_2,480,190,300,200,null);
                }else if (hitNum ==3){
                    g.drawImage(Data.PP8_HAT_3,490,180,300,200,null);
                }
                if (dressNum ==1){
                    g.drawImage(Data.PP8_DRESS_1,485,220,300,300,null);
                }else if (dressNum ==2){
                    g.drawImage(Data.PP8_DRESS_2,540,270,190,220,null);
                }else if (dressNum ==3){
                    g.drawImage(Data.PP8_DRESS_3,540,300,180,135,null);
                }
            }
        }///////////////////////////////////
        //其他玩家加入房间的衣服类型绘制
        if (CliReadThread.playerUserStyle !=null){
            int playNum = CliReadThread.playerUserStyle.getNum();
            int playHitNum = CliReadThread.playerUserStyle.getHat();
            int playDressNum = CliReadThread.playerUserStyle.getDress();
            if (playNum == 1){
                g.drawImage(Data.PP1,-210,0,710,599,null);
                if (playHitNum ==1){
                    g.drawImage(Data.PP1_HAT_1,30,150,200,160,null);
                }else if (playHitNum ==2){
                    g.drawImage(Data.PP1_HAT_2,20,180,230,130,null);
                }else if (playHitNum ==3){
                    g.drawImage(Data.PP1_HAT_3,20,180,230,130,null);
                }
                if (playDressNum ==1){
                    g.drawImage(Data.PP1_DRESS_1,42,285,170,130,null);
                }else if (playDressNum ==2){
                    g.drawImage(Data.PP1_DRESS_2,65,295,130,120,null);
                }else if (playDressNum ==3){
                    g.drawImage(Data.PP1_DRESS_3,65,315,130,100,null);
                }
            }else if (playNum == 2){
                g.drawImage(Data.PP2,-210,0,710,599,null);
                if (playDressNum ==1){
                    g.drawImage(Data.PP2_DRESS_2,28,285,212,155,null);
                }else if (playDressNum ==2){
                    g.drawImage(Data.PP2_DRESS_3,-10,250,280,220,null);
                }else if (playDressNum ==3){
                    g.drawImage(Data.PP2_DRESS_4,-2,250,275,225,null);
                }
            }else if (playNum == 3){
                g.drawImage(Data.PP3,-160,30,630,560,null);
                if (playHitNum ==1){
                    g.drawImage(Data.PP3_HAT_1,30,150,200,160,null);
                }else if (playHitNum ==2){
                    g.drawImage(Data.PP3_HAT_2,20,180,230,130,null);
                }else if (playHitNum ==3){
                    g.drawImage(Data.PP3_HAT_3,20,180,230,130,null);
                }
                if (playDressNum ==1){
                    g.drawImage(Data.PP3_DRESS_1,25,285,212,155,null);
                }else if (playDressNum ==2){
                    g.drawImage(Data.PP3_DRESS_2,40,320,180,100,null);
                }else if (playDressNum ==3){
                    g.drawImage(Data.PP3_DRESS_3,40,320,180,100,null);
                }

            }else if (playNum == 4){
                g.drawImage(Data.PP4,-210,0,710,599,null);
                if (playHitNum ==1){
                    g.drawImage(Data.PP4_HAT_1,30,150,200,160,null);
                }else if (playHitNum ==2){
                    g.drawImage(Data.PP4_HAT_2,30,150,220,160,null);
                }
                if (playDressNum ==1){
                    g.drawImage(Data.PP4_DRESS_1,25,285,212,155,null);
                }else if (playDressNum ==2){
                    g.drawImage(Data.PP4_DRESS_2,40,320,180,100,null);
                }else if (playDressNum ==3){
                    g.drawImage(Data.PP4_DRESS_3,70,320,150,110,null);
                }

            }else if (playNum == 5){
                g.drawImage(Data.PP5,-210,0,690,599,null);
                if (playHitNum ==1){
                    g.drawImage(Data.PP5_HAT_1,30,150,200,160,null);
                }else if (playHitNum ==2){
                    g.drawImage(Data.PP5_HAT_2,30,170,220,160,null);
                }else if (playHitNum ==3){
                    g.drawImage(Data.PP5_HAT_3,20,170,220,160,null);
                }
                if (playDressNum ==1){
                    g.drawImage(Data.PP5_DRESS_1,25,285,212,155,null);
                }else if (playDressNum ==2){
                    g.drawImage(Data.PP5_DRESS_2,40,300,180,100,null);
                }else if (playDressNum ==3){
                    g.drawImage(Data.PP5_DRESS_3,20,275,212,155,null);
                }
            }else if (playNum == 6){
                g.drawImage(Data.PP6,-210,0,710,599,null);
                if (playHitNum == 1){
                    g.drawImage(Data.PP6_HAT_1,25,180,230,160,null);
                }else if (playHitNum == 2){
                    g.drawImage(Data.PP6_HAT_2,30,170,220,160,null);
                }else if (playHitNum == 3){
                    g.drawImage(Data.PP6_HAT_3,20,180,230,160,null);
                }
                if (playDressNum == 1){
                    g.drawImage(Data.PP6_DRESS_1,33,300,200,143,null);
                }else if (playDressNum == 2){
                    g.drawImage(Data.PP6_DRESS_2,50,310,180,100,null);
                }else if (playDressNum ==3){
                    g.drawImage(Data.PP6_DRESS_3,38,290,212,155,null);
                }
            }else if (playNum == 7){
                g.drawImage(Data.PP7,-210,0,680,599,null);
                if (playHitNum == 1){
                    g.drawImage(Data.PP7_HAT_1,15,180,230,160,null);
                }
                if (playDressNum == 1){
                    g.drawImage(Data.PP7_DRESS_1,50,300,150,135,null);
                }else if (playDressNum ==2){
                    g.drawImage(Data.PP7_DRESS_2,35,280,180,135,null);
                }else if (playDressNum ==3){
                    g.drawImage(Data.PP7_DRESS_3,60,310,130,115,null);
                }
            }else if (playNum == 8){
                g.drawImage(Data.PP8,-230,20,710,599,null);
                if (playHitNum ==2){
                    g.drawImage(Data.PP8_HAT_2,-30,190,300,200,null);
                }else if (playHitNum ==3){
                    g.drawImage(Data.PP8_HAT_3,-20,180,300,200,null);
                }
                if (playDressNum ==1){
                    g.drawImage(Data.PP8_DRESS_1,-25,220,300,300,null);
                }else if (playDressNum ==2){
                    g.drawImage(Data.PP8_DRESS_2,30,270,190,220,null);
                }else if (playDressNum ==3){
                    g.drawImage(Data.PP8_DRESS_3,30,300,180,135,null);
                }
            }
        }

    }


}
