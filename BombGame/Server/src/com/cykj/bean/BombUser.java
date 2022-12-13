package com.cykj.bean;


import java.sql.Timestamp;

public class BombUser {

  private String userid;
  private String username;
  private String userpwd;
  private java.sql.Timestamp regtime;
  private String loginstate;


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getUserpwd() {
    return userpwd;
  }

  public void setUserpwd(String userpwd) {
    this.userpwd = userpwd;
  }


  public java.sql.Timestamp getRegtime() {
    return regtime;
  }

  public void setRegtime(java.sql.Timestamp regtime) {
    this.regtime = regtime;
  }

  public String getLoginstate() {
    return loginstate;
  }

  public void setLoginstate(String loginstate) {
    this.loginstate = loginstate;
  }

  public BombUser() {
    //默认为离线状态
    loginstate = "离线";
  }

  public BombUser(String userid, String username, String userpwd, Timestamp regtime, String loginstate) {
    this.userid = userid;
    this.username = username;
    this.userpwd = userpwd;
    this.regtime = regtime;
    this.loginstate = loginstate;
  }
}
