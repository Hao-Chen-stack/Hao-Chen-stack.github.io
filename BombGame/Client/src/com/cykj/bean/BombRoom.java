package com.cykj.bean;


public class BombRoom {

  private long roomid;
  private String roomname;
  private String createuserid;
  private String adduserid;
  private String roomstate;
  private long roomusernum;
  private java.sql.Timestamp createtime;


  public long getRoomid() {
    return roomid;
  }

  public void setRoomid(long roomid) {
    this.roomid = roomid;
  }


  public String getRoomname() {
    return roomname;
  }

  public void setRoomname(String roomname) {
    this.roomname = roomname;
  }


  public String getCreateuserid() {
    return createuserid;
  }

  public void setCreateuserid(String createuserid) {
    this.createuserid = createuserid;
  }


  public String getAdduserid() {
    return adduserid;
  }

  public void setAdduserid(String adduserid) {
    this.adduserid = adduserid;
  }


  public String getRoomstate() {
    return roomstate;
  }

  public void setRoomstate(String roomstate) {
    this.roomstate = roomstate;
  }


  public long getRoomusernum() {
    return roomusernum;
  }

  public void setRoomusernum(long roomusernum) {
    this.roomusernum = roomusernum;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

}
