package com.cykj.dao;

import com.cykj.bean.BombUser;

import java.util.List;

public interface BombUserDao {
    //注册方法
    boolean logon(String userId,String userName,String password);

    //登录方法，查询数据库里是否有重复的数据，如果有重复即可登录上去
    boolean login(String acc,String pwd);

    //将userId和用户名传进JList的方法
    List<BombUser> selectUser(String userId);
}
