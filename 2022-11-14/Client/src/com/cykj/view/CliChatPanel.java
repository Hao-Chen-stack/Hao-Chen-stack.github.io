package com.cykj.view;

import com.cykj.bean.TFriend;
import com.cykj.bean.TGroup;
import com.cykj.controller.CliChatActLis;
import com.cykj.controller.CliController;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.util.List;

public class CliChatPanel extends JPanel {
    public CliController con;
    public Font font = new Font("宋体",Font.PLAIN,25);
    private JTextField newsField = new JTextField();//消息输入框
    private JButton sendOutBtn = new JButton("发送");
    private JButton fileBtn = new JButton("文件");
    private JButton oneSendBtn = new JButton("私聊");
    private JButton addFriendBtn = new JButton("好友添加");
    private JButton alterFriendBtn = new JButton("好友修改");
    private JButton deleteFriendBtn = new JButton("好友删除");
    private JButton groupAddBtn = new JButton("分组添加");
    private JButton groupAlterBtn = new JButton("分组修改");
    private JButton groupDeleteBtn = new JButton("分组删除");
    private JButton recordBtn = new JButton("聊天记录");
    private JButton downLoadBtn = new JButton("下载文件");
    private JTextArea jTextArea = new JTextArea();

    //树
    private JTree tree;
    private DefaultTreeModel modelTree;
    private DefaultMutableTreeNode treeNode;
    private JScrollPane treeSC;//滚动面板

    public JTextField getNewsField() {
        return newsField;
    }

    public void setNewsField(JTextField newsField) {
        this.newsField = newsField;
    }

    public JButton getSendOutBtn() {
        return sendOutBtn;
    }

    public void setSendOutBtn(JButton sendOutBtn) {
        this.sendOutBtn = sendOutBtn;
    }

    public JButton getFileBtn() {
        return fileBtn;
    }

    public void setFileBtn(JButton fileBtn) {
        this.fileBtn = fileBtn;
    }

    public JButton getOneSendBtn() {
        return oneSendBtn;
    }

    public void setOneSendBtn(JButton oneSendBtn) {
        this.oneSendBtn = oneSendBtn;
    }

    public JButton getAddFriendBtn() {
        return addFriendBtn;
    }

    public void setAddFriendBtn(JButton addFriendBtn) {
        this.addFriendBtn = addFriendBtn;
    }

    public JButton getAlterFriendBtn() {
        return alterFriendBtn;
    }

    public void setAlterFriendBtn(JButton alterFriendBtn) {
        this.alterFriendBtn = alterFriendBtn;
    }

    public JButton getDeleteFriendBtn() {
        return deleteFriendBtn;
    }

    public void setDeleteFriendBtn(JButton deleteFriendBtn) {
        this.deleteFriendBtn = deleteFriendBtn;
    }

    public JButton getGroupAddBtn() {
        return groupAddBtn;
    }

    public void setGroupAddBtn(JButton groupAddBtn) {
        this.groupAddBtn = groupAddBtn;
    }

    public JButton getGroupAlterBtn() {
        return groupAlterBtn;
    }

    public void setGroupAlterBtn(JButton groupAlterBtn) {
        this.groupAlterBtn = groupAlterBtn;
    }

    public JButton getGroupDeleteBtn() {
        return groupDeleteBtn;
    }

    public void setGroupDeleteBtn(JButton groupDeleteBtn) {
        this.groupDeleteBtn = groupDeleteBtn;
    }

    public JButton getRecordBtn() {
        return recordBtn;
    }

    public void setRecordBtn(JButton recordBtn) {
        this.recordBtn = recordBtn;
    }

    public JButton getDownLoadBtn() {
        return downLoadBtn;
    }

    public void setDownLoadBtn(JButton downLoadBtn) {
        this.downLoadBtn = downLoadBtn;
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public JTree getTree() {
        return tree;
    }

    public void setTree(JTree tree) {
        this.tree = tree;
    }

    public DefaultTreeModel getModelTree() {
        return modelTree;
    }

    public void setModelTree(DefaultTreeModel modelTree) {
        this.modelTree = modelTree;
    }

    public JScrollPane getTreeSC() {
        return treeSC;
    }

    public void setTreeSC(JScrollPane treeSC) {
        this.treeSC = treeSC;
    }

    public DefaultMutableTreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(DefaultMutableTreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public CliChatPanel(CliController con){
        this .con = con;
        setBackground(new Color(0,0,0));//背景颜色
        setLayout(null);//自由布局

        //进度条JPro
        //  Max：filesize    value：len


        //输入框及其位置
        newsField.setFont(font);//输入字体
        add(newsField);
        newsField.setBounds(190,10,300,40);

        //按钮及其位置
        sendOutBtn.setFont(font);
        add(sendOutBtn);
        sendOutBtn.setBounds(600,10,90,40);

        fileBtn.setFont(font);
        add(fileBtn);
        fileBtn.setBounds(500,10,90,40);

        oneSendBtn.setFont(font);
        add(oneSendBtn);
        oneSendBtn.setBounds(700,10,90,40);

        addFriendBtn.setFont(font);
        add(addFriendBtn);
        addFriendBtn.setBounds(10,480,150,40);

        alterFriendBtn.setFont(font);
        add(alterFriendBtn);
        alterFriendBtn.setBounds(170,480,150,40);

        deleteFriendBtn.setFont(font);
        add(deleteFriendBtn);
        deleteFriendBtn.setBounds(330,480,150,40);

        groupAddBtn.setFont(font);
        add(groupAddBtn);
        groupAddBtn.setBounds(490,480,150,40);

        groupAlterBtn.setFont(font);
        add(groupAlterBtn);
        groupAlterBtn.setBounds(650,480,150,40);

        groupDeleteBtn.setFont(font);
        add(groupDeleteBtn);
        groupDeleteBtn.setBounds(10,520,150,40);

        recordBtn.setFont(font);
        add(recordBtn);
        recordBtn.setBounds(170,520,150,40);

        downLoadBtn.setFont(font);
        add(downLoadBtn);
        downLoadBtn.setBounds(330,520,150,40);

        //监听的注册和安装
        CliChatActLis chatActLis = new CliChatActLis(con);
        sendOutBtn.addActionListener(chatActLis);
        sendOutBtn.setActionCommand("sendOut");
        oneSendBtn.addActionListener(chatActLis);
        oneSendBtn.setActionCommand("oneSend"); //暂时为私聊功能
        fileBtn.addActionListener(chatActLis);
        fileBtn.setActionCommand("sendFile");
        downLoadBtn.addActionListener(chatActLis);
        downLoadBtn.setActionCommand("downLoad");

        recordBtn.addActionListener(chatActLis);
        recordBtn.setActionCommand("recShow");


        //聊天记录显示框
        jTextArea.setFont(font);
        add(jTextArea);
        jTextArea.setBounds(190,70,580,400);

        //使用根节点创建树组件
        treeNode = new DefaultMutableTreeNode("QQ分组");
        tree = new JTree(treeNode);//创建滚动面板，包裹树（因为树节点展开后可能需要很大的空间来显示，所以需要用一个滚动面板来包裹）
        treeSC = new JScrollPane(tree);//滚动面板
        treeSC.setBounds(10,10,160,460);//放置，树状图的大小和位置
        add(treeSC);

        // 设置树显示根节点句柄
        tree.setShowsRootHandles(true);

        // 设置树节点可编辑
        tree.setEditable(true);

        //为树添加监听
        tree.addTreeSelectionListener(chatActLis);

    }

    public void setTree(List<TGroup> tGroupList, List<TFriend> tFriendList){
        for (TGroup tGroup : tGroupList) {//先遍历组的集合
            //将组名加入父节点                                              传递对象内的组名
//            DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(tGroup.getGroupname());
            //将组名加入父节点                                             直接传递tGroup对象，然后在tGroup bean内重写toString方法
            DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(tGroup);
            treeNode.add(rootNode);//然后父节点加入根节点
            for (TFriend tFriend : tFriendList) {//再遍历好友的集合
                //将好友名放入到子节点                                       传递对象内的好友名
//                DefaultMutableTreeNode node = new DefaultMutableTreeNode(tFriend.getFriendname());
                //将好友名放入到子节点                                    直接传递tFriend对象，然后在tFriend bean内重写toString方法
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(tFriend);
                if (tGroup.getGroupid().equals(tFriend.getGroupid())){//如果外键相等
                    rootNode.add(node);//将子节点加入父节点
                }
            }
        }

    }
}
