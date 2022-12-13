package com.cykj.view;

import com.cykj.bean.BombRoom;
import com.cykj.controller.CliController;
import com.cykj.controller.CliGameRoomActLis;
import com.cykj.util.ImageButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CliGameRoomLeftPanel extends JPanel {
    public CliController con;
    public ImageIcon startIcon;//初始图片
    public ImageIcon nearStartIcon;//鼠标靠近时变化的图片
    public ImageIcon hitStartIcon;//点击变化图片
    public ImageButton roomBtn;
    private int addNumber = 1;//加入房间的人数

    public CliGameRoomLeftPanel(CliController con){
        this.con = con;
//        setLayout(new GridLayout(10,2,10,8));
        setPreferredSize(new Dimension(500,600));
        setBackground(new Color(250,235,215));
    }

    //创建房间
    public void roomCreate(List<BombRoom> rooms){
        this.removeAll();
        for (BombRoom room : rooms) {
            startIcon = new ImageIcon("");
            nearStartIcon = new ImageIcon("");
            hitStartIcon = new ImageIcon("");
            roomBtn = new ImageButton(startIcon);
            roomBtn.setPressedIcon(hitStartIcon);
            roomBtn.setRolloverIcon(nearStartIcon);
//            roomBtn.setContentAreaFilled(false);//透明
//            roomBtn.setBorderPainted(false);//边框不可见
            startIcon.setImage(startIcon.getImage().getScaledInstance(300, 100, 0));
            hitStartIcon.setImage(hitStartIcon.getImage().getScaledInstance(300,100,0));
            nearStartIcon.setImage(nearStartIcon.getImage().getScaledInstance(300,100,0));
            add(roomBtn);
            //注册并且安装监听,每次new一个添加一个
            CliGameRoomActLis gameRoomActLis = new CliGameRoomActLis(con);
            roomBtn.addActionListener(gameRoomActLis);
            roomBtn.setActionCommand("newRoom");
            //设置按键文本
            roomBtn.setText(room.getCreateuserid()+"的房间\t"+room.getRoomstate());
            roomBtn.setFont(new Font("宋体",Font.BOLD,22));
            //设置按钮位置
            //由中间向两边展开
            roomBtn.setVerticalTextPosition(SwingConstants.CENTER);
            roomBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        }

    }
    public int getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(int addNumber) {
        this.addNumber = addNumber;
    }
}


