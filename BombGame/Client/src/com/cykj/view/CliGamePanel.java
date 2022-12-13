package com.cykj.view;

import com.cykj.bean.BombUser;
import com.cykj.controller.CliController;
import com.cykj.controller.CliGameActLis;
import com.cykj.model.Data;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class CliGamePanel extends JPanel implements ListCellRenderer {
    public CliController con;
    public Font font = new Font("宋体", Font.PLAIN, 25);
    public DefaultListModel mode;//好友列表的model
    public DefaultListModel msgMode;//群聊的model
    private JButton startBtn;//开始按钮
    private JButton gameMesBtn;//游戏说明按钮
    private JButton personalBtn;//个人中心按钮
    private JTextField msgTextField;//聊天室发送框
    private JButton imgBtn;//表情包
    private JButton sendBtn;//发送按钮
    private JButton sendAllBtn;//群聊按钮
    private JList<Object> friendJList;//好友列表
    private JScrollPane jScrollPane;//好友列表滚动条
    private JList<Object> msgJList;//群聊界面
    private JScrollPane msgJScrollPane;//群聊界面滚动条

    private JLabel nowUserLabel;//当前用户
    private JLabel userUpLabel;//有新的好友上线

    //音乐播放和暂停按钮
    public JButton startMusicBtn;
    public JButton stopMusicBtn;

    private JLabel newMsg;

    public CliGamePanel(CliController con) {
        this.con = con;
        setLayout(null);//自由布局

        //输入框及其位置
        msgTextField = new JTextField();
        msgTextField.setBounds(180, 690, 415, 30);
        msgTextField.setFont(font);
        msgTextField.setForeground(new Color(255, 0, 0));
//        msgTextField.setOpaque(false);//透明度
        add(msgTextField);

        //按钮及其位置还有颜色和字体
        startBtn = new JButton("开始游戏");
        startBtn.setBounds(550, 200, 180, 50);
        startBtn.setForeground(new Color(255, 0, 0));
        startBtn.setFont(font);
        add(startBtn);

        gameMesBtn = new JButton("游戏说明");
        gameMesBtn.setBounds(550, 270, 180, 50);
        gameMesBtn.setForeground(new Color(255, 0, 0));
        gameMesBtn.setFont(font);
        add(gameMesBtn);

        personalBtn = new JButton("个人中心");
        personalBtn.setBounds(550, 340, 180, 50);
        personalBtn.setForeground(new Color(255, 0, 0));
        personalBtn.setFont(font);
        add(personalBtn);

        imgBtn = new JButton("表情");
        imgBtn.setBounds(670, 650, 100, 30);
        imgBtn.setForeground(new Color(255, 0, 0));
        add(imgBtn);

        sendBtn = new JButton("发送");
        sendBtn.setBounds(610, 680, 180, 40);
        sendBtn.setForeground(new Color(255, 0, 0));
        sendBtn.setFont(font);
        add(sendBtn);

        //群聊记录按钮
        sendAllBtn = new JButton("群聊记录");
        sendAllBtn.setBounds(0, 680, 170, 40);
        sendAllBtn.setForeground(new Color(255, 0, 0));
        sendAllBtn.setFont(font);
        add(sendAllBtn);

        //音乐播放和暂停按钮
        startMusicBtn = new JButton();
        startMusicBtn.setBounds(410,0,50,50);
        startMusicBtn.setContentAreaFilled(false);//透明
        add(startMusicBtn);

        stopMusicBtn = new JButton();
        stopMusicBtn.setBounds(485,0,50,50);
        stopMusicBtn.setContentAreaFilled(false);//透明
        add(stopMusicBtn);

        //好友列表
        mode = new DefaultListModel();
        friendJList = new JList(mode);
        friendJList.setBounds(0, 40, 300, 400);
        friendJList.setFont(font);
        friendJList.addMouseListener(new CliGameActLis(con));//添加鼠标监听
        add(friendJList);

        //聊天室
        msgMode = new DefaultListModel();
        msgJList = new JList(msgMode);
        msgJList.setBounds(10, 490, 770, 200);
        msgJList.setForeground(new Color(255, 0, 0));
        msgJList.setFont(font);
        msgJList.setCellRenderer(this);//渲染器设置
        msgJList.setOpaque(false);//透明度
        add(msgJList);

        //界面滚动条
        jScrollPane = new JScrollPane(friendJList);
        jScrollPane.setBounds(0, 40, 300, 400);
        add(jScrollPane);

        msgJScrollPane = new JScrollPane(msgJList);
        msgJScrollPane.setBounds(10, 490, 770, 200);
        add(msgJScrollPane);

        //监听的注册和安装
        CliGameActLis gameActLis = new CliGameActLis(con);
        sendBtn.addActionListener(gameActLis);
        sendBtn.setActionCommand("sendOutAll");
        sendAllBtn.addActionListener(gameActLis);
        sendAllBtn.setActionCommand("allMsg");
        imgBtn.addActionListener(gameActLis);
        imgBtn.setActionCommand("img");
        startBtn.addActionListener(gameActLis);
        startBtn.setActionCommand("startGame");
        personalBtn.addActionListener(gameActLis);
        personalBtn.setActionCommand("playerCenter");
        gameMesBtn.addActionListener(gameActLis);
        gameMesBtn.setActionCommand("gameDes");
        startMusicBtn.addActionListener(gameActLis);
        startMusicBtn.setActionCommand("startMusic");
        stopMusicBtn.addActionListener(gameActLis);
        stopMusicBtn.setActionCommand("stopMusic");

        //当前账户
        nowUserLabel = new JLabel("当前用户为：    ");
        nowUserLabel.setFont(font);
        nowUserLabel.setForeground(new Color(0, 255, 0));
        nowUserLabel.setBounds(550, 10, 250, 80);
        add(nowUserLabel);

        //好友上线提醒
        userUpLabel = new JLabel("");
        userUpLabel.setFont(font);
        userUpLabel.setForeground(new Color(0, 255, 0));
        userUpLabel.setBounds(550, 50, 250, 80);
        add(userUpLabel);

        //消息提醒
        newMsg = new JLabel("");
        newMsg.setFont(font);
        newMsg.setForeground(new Color(0, 255, 0));
        newMsg.setBounds(550, 80, 250, 80);
        add(newMsg);

    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public void setStartBtn(JButton startBtn) {
        this.startBtn = startBtn;
    }

    public JButton getGameMesBtn() {
        return gameMesBtn;
    }

    public void setGameMesBtn(JButton gameMesBtn) {
        this.gameMesBtn = gameMesBtn;
    }

    public JButton getPersonalBtn() {
        return personalBtn;
    }

    public void setPersonalBtn(JButton personalBtn) {
        this.personalBtn = personalBtn;
    }

    public JTextField getMsgTextField() {
        return msgTextField;
    }

    public void setMsgTextField(JTextField msgTextField) {
        this.msgTextField = msgTextField;
    }

    public JButton getImgBtn() {
        return imgBtn;
    }

    public void setImgBtn(JButton imgBtn) {
        this.imgBtn = imgBtn;
    }

    public JButton getSendBtn() {
        return sendBtn;
    }

    public void setSendBtn(JButton sendBtn) {
        this.sendBtn = sendBtn;
    }

    public JButton getSendAllBtn() {
        return sendAllBtn;
    }

    public void setSendAllBtn(JButton sendAllBtn) {
        this.sendAllBtn = sendAllBtn;
    }

    public JList<Object> getFriendJList() {
        return friendJList;
    }

    public void setFriendJList(JList<Object> friendJList) {
        this.friendJList = friendJList;
    }

    public JList<Object> getMsgJList() {
        return msgJList;
    }

    public void setMsgJList(JList<Object> msgJList) {
        this.msgJList = msgJList;
    }

    public JScrollPane getMsgJScrollPane() {
        return msgJScrollPane;
    }

    public void setMsgJScrollPane(JScrollPane msgJScrollPane) {
        this.msgJScrollPane = msgJScrollPane;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public JLabel getNowUserLabel() {
        return nowUserLabel;
    }

    public void setNowUserLabel(JLabel nowUserLabel) {
        this.nowUserLabel = nowUserLabel;
    }

    public JLabel getUserUpLabel() {
        return userUpLabel;
    }

    public void setUserUpLabel(JLabel userUpLabel) {
        this.userUpLabel = userUpLabel;
    }

    public JLabel getNewMsg() {
        return newMsg;
    }

    public void setNewMsg(JLabel newMsg) {
        this.newMsg = newMsg;
    }

    public void initJList(List<BombUser> bombUserList) {
        mode = new DefaultListModel();
        for (BombUser b : bombUserList) {
//            //数组
//            String[] data = {b.getUserid(),
//                            b.getUsername()};
            //字符串拼接
            String data = b.getUsername() + "--" +
                    b.getUserid() + "--" + b.getLoginstate();
            //数组强转字符串
//            mode.addElement(Arrays.deepToString(data));
            mode.addElement(data);
        }

        friendJList.setModel(mode);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Data.GAME_PANEL_GB, 0, 0, 800, 445, null);
        g.drawImage(Data.ALL_MSG_BG, 0, 450, 800, 275, null);
        g.drawImage(Data.FRIEND_HAND, 0, 0, 300, 40, null);
    }

    //重写渲染器
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        //label中可以有文字加图标
//        JPanel panel = new JPanel();
//        System.out.println("-----------------------------------------------------");
//        System.out.println(value);
        if (value instanceof JLabel) {//图片
            JLabel la = (JLabel) value;
            return la;
        } else {
            JLabel la = new JLabel((String) value);
            la.setFont(font);
            la.setForeground(new Color(255, 0, 0));
            return la;
        }
//        JLabel label = new JLabel();
//        //设置大小
//        label.setSize(60,60);
//        //设置字体
//        label.setFont(new Font("微软雅黑",Font.PLAIN,20));
//        label.setBackground(new Color(0,0,0,0));//透明背景的label
//        label.setOpaque(true);//标签本身不透明
//        //设置用户昵称
//        JLabel label1= (JLabel) value;
////        label1= (JLabel) value;
//        label.setText(label1.getText());
//        label.setIcon(label1.getIcon());
////        label.setIcon(icon);
////        label.setBackground(new Color(0,0,0,0));
//        //设置用户头像
////        label.setIcon(new ImageIcon(userBean.getImgPath()));
//
////        if (isSelected){
//        label.setBackground(Color.PINK);
////        }else{
//        label.setBackground(new Color(0,0,0,0));
////        }
//        return label;
    }

    //圆形Button
    private static class RounderBorder implements Border {
        private int radius;

        RounderBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }

}
