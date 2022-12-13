package com.cykj.dao;

public interface UserDao {
    //注册方法
    boolean logon(String userid, String name, String password, int age, String address);
    //判断账号是否存在
    boolean idExist(String acc);
    //登录方法,查询数据库里是否有重复的数据，如果有重复即可登录上去
    boolean login(String acc, String pwd);
}
