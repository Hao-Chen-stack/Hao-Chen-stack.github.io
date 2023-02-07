package com.cykj.bean;


import java.util.List;

public class Tbluser {

  private long userId;
  private String userAcc;
  private String userPwd;
  private long userSex;
  private long userStatus;
  private String userPhone;
  private java.sql.Timestamp createTime;

  private List<Tbladdress> tbladdresses;

  private List<Tblcollection> tblcollections;


  public List<Tblcollection> getTblcollections() {
    return tblcollections;
  }

  public void setTblcollections(List<Tblcollection> tblcollections) {
    this.tblcollections = tblcollections;
  }

  public List<Tbladdress> getTbladdresses() {
    return tbladdresses;
  }

  public void setTbladdresses(List<Tbladdress> tbladdresses) {
    this.tbladdresses = tbladdresses;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserAcc() {
    return userAcc;
  }

  public void setUserAcc(String userAcc) {
    this.userAcc = userAcc;
  }


  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }


  public long getUserSex() {
    return userSex;
  }

  public void setUserSex(long userSex) {
    this.userSex = userSex;
  }


  public long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(long userStatus) {
    this.userStatus = userStatus;
  }


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

}
