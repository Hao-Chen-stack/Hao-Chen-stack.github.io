package com.cykj.bean;


public class Tbluser {

  private long userId;
  private String userAcc;
  private String userPwd;
  private String userName;
  private long userSex;
  private long userAge;
  private String userPhone;
  private java.sql.Timestamp createTime;
  private long userState;
  private String userAddress;
  private double balance;

  public Tbluser() {

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


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public long getUserSex() {
    return userSex;
  }

  public void setUserSex(long userSex) {
    this.userSex = userSex;
  }


  public long getUserAge() {
    return userAge;
  }

  public void setUserAge(long userAge) {
    this.userAge = userAge;
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


  public long getUserState() {
    return userState;
  }

  public void setUserState(long userState) {
    this.userState = userState;
  }


  public String getuserAddress() {
    return userAddress;
  }

  public void setuserAddress(String userAddress) {
    this.userAddress = userAddress;
  }


  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }


  @Override
  public String toString() {
    return "Tbluser{" +
            "userId=" + userId +
            ", userAcc='" + userAcc + '\'' +
            ", userPwd='" + userPwd + '\'' +
            ", userName='" + userName + '\'' +
            ", userSex=" + userSex +
            ", userAge=" + userAge +
            ", userPhone='" + userPhone + '\'' +
            ", createTime=" + createTime +
            ", userState=" + userState +
            ", userAddress='" + userAddress + '\'' +
            ", balance=" + balance +
            '}';
  }
}
