package com.cykj.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.view.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CliImgActLis extends MouseAdapter implements ActionListener {
    public CliController con;
    public CliImgActLis(CliController con){
        this.con = con;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String path="";//定义一个字符串变量来接表情包的路径
        for (int i = 1; i <=30; i++) {
            if (e.getActionCommand().equals(i+"")){
                path="Client/image/"+i+".gif";
//                System.out.println("+++++++++++++++++++++");
            }
        }
        JSONObject isImgJs = new JSONObject();
        isImgJs.put("action","sendImg");
        isImgJs.put("isSend", path);
        CliController.cliReadThread.send(isImgJs.toJSONString());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }
}
