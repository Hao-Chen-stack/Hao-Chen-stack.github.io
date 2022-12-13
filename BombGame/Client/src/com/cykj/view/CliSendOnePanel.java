package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.controller.CliSendOneActLis;

import javax.swing.*;
import java.awt.*;

public class CliSendOnePanel extends JPanel {
    public CliController con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    private JTextField msgTextField;//私聊发送框
    private JButton sendEmo;//发送表情
    private JButton sendBtn;//发送按钮
    private JButton sendOneMsgBtn;//私聊聊天记录按钮
    private JList<Object> msgList;//私聊界面
    public DefaultListModel msgMode;//私聊的model
    private JScrollPane msgJScrollPane;//私聊界面滚动条
    private JLabel friendLabel;//聊天界面标题

    public JTextField getMsgTextField() {
        return msgTextField;
    }

    public void setMsgTextField(JTextField msgTextField) {
        this.msgTextField = msgTextField;
    }

    public JButton getSendEmo() {
        return sendEmo;
    }

    public void setSendEmo(JButton sendEmo) {
        this.sendEmo = sendEmo;
    }

    public JButton getSendBtn() {
        return sendBtn;
    }

    public void setSendBtn(JButton sendBtn) {
        this.sendBtn = sendBtn;
    }

    public JButton getSendOneMsgBtn() {
        return sendOneMsgBtn;
    }

    public void setSendOneMsgBtn(JButton sendOneMsgBtn) {
        this.sendOneMsgBtn = sendOneMsgBtn;
    }

    public JList<Object> getMsgList() {
        return msgList;
    }

    public void setMsgList(JList<Object> msgList) {
        this.msgList = msgList;
    }

    public JScrollPane getMsgJScrollPane() {
        return msgJScrollPane;
    }

    public void setMsgJScrollPane(JScrollPane msgJScrollPane) {
        this.msgJScrollPane = msgJScrollPane;
    }

    public JLabel getFriendLabel() {
        return friendLabel;
    }

    public void setFriendLabel(JLabel friendLabel) {
        this.friendLabel = friendLabel;
    }

    public CliSendOnePanel(CliController con){
        this.con = con;
        setLayout(null);//自由布局

        //输入框及其位置
        msgTextField = new JTextField();
        msgTextField.setBounds(180,680,415,40);
        msgTextField.setFont(font);
        msgTextField.setForeground(new Color(255,0,0));
//        msgTextField.setOpaque(false);//透明度
        add(msgTextField);

        //按钮及其位置还有颜色和字体
        sendEmo = new JButton("表情");
        sendEmo.setBounds(610,650,180,40);
        sendEmo.setForeground(new Color(255,0,0));
        add(sendEmo);

        sendBtn = new JButton("发送");
        sendBtn.setBounds(610,680,180,40);
        sendBtn.setForeground(new Color(255,0,0));
        sendBtn.setFont(font);
        add(sendBtn);

        sendOneMsgBtn = new JButton("私聊记录");
        sendOneMsgBtn.setBounds(0,680,170,40);
        sendOneMsgBtn.setForeground(new Color(255,0,0));
        sendOneMsgBtn.setFont(font);
        add(sendOneMsgBtn);

        //监听的注册和安装
        CliSendOneActLis sendOneActLis = new CliSendOneActLis(con);
        sendBtn.addActionListener(sendOneActLis);
        sendBtn.setActionCommand("sendOne");
        sendOneMsgBtn.addActionListener(sendOneActLis);
        sendOneMsgBtn.setActionCommand("showMsg");

        //聊天界面
        msgMode = new DefaultListModel();
        msgList = new JList(msgMode);
        msgList.setBounds(10,50,770,600);
        msgList.setForeground(new Color(255,0,0));
        msgList.setFont(font);
//        msgList.setOpaque(false);//透明度
        add(msgList);

        //界面滚动条
        msgJScrollPane = new JScrollPane(msgList);
        msgJScrollPane.setBounds(10,50,770,600);
        add(msgJScrollPane);

        //聊天界面标题
        friendLabel = new JLabel("");
        friendLabel.setFont(font);
        friendLabel.setBounds(200,0,400,50);
        add(friendLabel);
    }
}
