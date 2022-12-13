package com.cykj.bean;


public class TQquser {

  private String qqid;
  private String nickname;
  private long age;
  private String password;
  private String sex;
  private java.sql.Date birthday;
  private String address;
  private String mylabel;


  public String getQqid() {
    return qqid;
  }

  public void setQqid(String qqid) {
    this.qqid = qqid;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public java.sql.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getMylabel() {
    return mylabel;
  }

  public void setMylabel(String mylabel) {
    this.mylabel = mylabel;
  }

}
