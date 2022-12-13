package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.bean.TFriend;
import com.cykj.view.UI;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CliChatActLis implements ActionListener, TreeSelectionListener {
    public CliController con;
    public CliChatActLis(CliController con){
        this.con = con;
    }
    //动作监听
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "sendOut"://群发
                String sendTxt = UI.chatFrame.cliChatPanel.getNewsField().getText();//获取聊天文本框的内容
                String qqId = UI.loginUserFrame.loginPanel.getUserTxt().getText();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("action","sendOut");
                jsonObject.put("sendTxt",sendTxt);
                jsonObject.put("from",qqId);
                String str = jsonObject.toJSONString();
                CliController.cliReadThread.send(str);

                break;
            case "oneSend":
                //先判断所选中的是否为空
                if (UI.chatFrame.cliChatPanel.getTree().getLastSelectedPathComponent()!=null){
                    //如果不为空,则将选中的强转为子叶
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) UI.chatFrame.cliChatPanel.getTree().getLastSelectedPathComponent();
                    //拿取User对象
                    Object object = node.getUserObject();
                    //判断左边的对象是否是右边的实例
                    if (object instanceof TFriend){
                        //将该对象转换为friend
                        TFriend friend = (TFriend) object;
                        //然后给个弹窗显示所选中的用户的qqId
                        JOptionPane.showMessageDialog(null,friend.getQqid());

                        //重新new一个JSON拿来接东西
                        JSONObject jsonObject1 = new JSONObject();
                        jsonObject1.put("action","oneSend");
                        jsonObject1.put("to",friend.getFriendid());
                        //拿到账户输入框
                        jsonObject1.put("from",friend.getQqid());
                        //拿到消息输入框
                        jsonObject1.put("msg",UI.chatFrame.cliChatPanel.getNewsField().getText());
                        System.out.println("发送"+jsonObject1.toJSONString());
                        CliController.cliReadThread.send(jsonObject1.toJSONString());
                    }else {
                        JOptionPane.showMessageDialog(null,"请选择要聊天的好友");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"请选择要聊天的好友");
                }
                break;
            case "recShow":
                UI.cliRecordsFrame.setVisible(true);
                JSONObject jsRec =  new JSONObject();
                jsRec.put("action","recShow");
                CliController.cliReadThread.send(jsRec.toJSONString());
                break;
            case "upPage":
                JSONObject upJs = new JSONObject();
                upJs.put("action","upPage");
                CliController.cliReadThread.send(upJs.toJSONString());
                break;
            case "downPage":
                JSONObject downJs = new JSONObject();
                downJs.put("action","downPage");
                CliController.cliReadThread.send(downJs.toJSONString());
                break;
            case "sendFile":
                JFileChooser jFileChooser = new JFileChooser();//实例化一个文件弹窗
                jFileChooser.setDialogTitle("文件选择窗口");
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//设置文件弹窗既可以查看文件夹也可以查看文件
                int openDialog = jFileChooser.showDialog(null,"选择并上传");//文件选择弹窗居中
                if (openDialog == JFileChooser.APPROVE_OPTION){//如果批准选择的话
                    File file = jFileChooser.getSelectedFile();//将选择到的赋值给文件对象声明的变量
                    String fileName = file.getName();//文件名字
                    long fileSize = file.length();//文件大小
                    String filePath = file.getAbsolutePath();//文件的绝对路径
                    JSONObject sendFileJs = new JSONObject();//实例化一个JSON
                    sendFileJs.put("action","sendFile");//放入{"action":"sendFile"}到json
                    sendFileJs.put("fileName",fileName);//放入
                    sendFileJs.put("fileSize",fileSize);//放入
                    sendFileJs.put("filePath",filePath);//放入
                    CliController.cliReadThread.send(sendFileJs.toJSONString());//调用线程对象内的发送方法，发送json.toJSONString()
                }
                break;
            case "downLoad":
                JFileChooser downLoadJFC = new JFileChooser("C:\\Users\\86182\\Desktop\\世界树枝");
                downLoadJFC.setDialogTitle("下载选择窗口");
                downLoadJFC.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int saveDialog = downLoadJFC.showDialog(null,"下载");
                if (saveDialog == JFileChooser.APPROVE_OPTION){
                    File saveFile = downLoadJFC.getSelectedFile();
                    String downFileName = saveFile.getName();
                    String filePath = saveFile.getAbsolutePath();//需要下载的文件路径
                    System.out.println("需要下载的文件路径为："+filePath);
                    long fileSize = saveFile.length();//需要下载的文件大小
                    JSONObject saveJs = new JSONObject();
                    saveJs.put("action","downLoad");
                    saveJs.put("downFileName",downFileName);
                    saveJs.put("downFilePath",filePath);
                    saveJs.put("downFileSize",fileSize);
                    CliController.cliReadThread.send(saveJs.toJSONString());
                }
                break;
        }
    }
    //树的节点监听
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        System.out.println("当前被选中的节点为:"+e.getPath());
        int count = e.getPath().getPathCount();
        System.out.println("节点等级为："+count);
    }
}
