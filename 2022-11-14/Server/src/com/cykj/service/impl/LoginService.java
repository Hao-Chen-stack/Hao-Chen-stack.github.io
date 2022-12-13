package com.cykj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cykj.Thread.ServerRec;
import com.cykj.Thread.SeverThread;
import com.cykj.annotation.Hat;
import com.cykj.bean.TFriend;
import com.cykj.bean.TGroup;
import com.cykj.dao.impl.FriendsDaoImpl;
import com.cykj.dao.impl.UserDaoImpl;
import com.cykj.service.BizService;

import java.util.List;

@Hat(value = "red",who = "xiaowang")
public class LoginService implements BizService {
    @Override
    public void doService(JSONObject recJson, ServerRec serverRec) {
        UserDaoImpl userDao = new UserDaoImpl();
        FriendsDaoImpl friendsDao = new FriendsDaoImpl();
        String uname = recJson.getString("acc");
        String upwd = recJson.getString("psw");
        boolean login = userDao.login(uname, upwd);
        System.out.println("登陆" + login);
        JSONObject js = new JSONObject(); //应答的JSONObject
        js.put("flag", login);
        if (login) {//登录成功 利用qqId来判断登入的用户
            SeverThread.threadMap.put(uname, serverRec);
        }
        //调用FriendDaoImpl实现类方法
        List<TGroup> tGroups = friendsDao.selectGroupName();
        List<TFriend> tFriends = friendsDao.relation(uname);
        //将FriendDaoImpl的返回值    加入到应答的JSONObject里
        js.put("组名", tGroups);
        js.put("好友", tFriends);
        //将应答消息：{"action":"login"}放入
        js.put("action", "login");
        //调用发送方法 将应答的JSONObject对象返回出的字符串表达 发送出去
        System.out.println("发送："+js.toJSONString());
        serverRec.send(js.toJSONString());
    }
}
