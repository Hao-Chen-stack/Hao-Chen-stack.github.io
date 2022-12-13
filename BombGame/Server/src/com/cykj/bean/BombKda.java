package com.cykj.bean;


public class BombKda {

  private long id;
  private String aid;
  private String userid;
  private String rid;
  private long did;
  private long bombNum;
  private long hpNum;
  private long obstaclesNum;
  private java.sql.Timestamp timeEnd;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAid() {
    return aid;
  }

  public void setAid(String aid) {
    this.aid = aid;
  }


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }


  public String getRid() {
    return rid;
  }

  public void setRid(String rid) {
    this.rid = rid;
  }


  public long getDid() {
    return did;
  }

  public void setDid(long did) {
    this.did = did;
  }


  public long getBombNum() {
    return bombNum;
  }

  public void setBombNum(long bombNum) {
    this.bombNum = bombNum;
  }


  public long getHpNum() {
    return hpNum;
  }

  public void setHpNum(long hpNum) {
    this.hpNum = hpNum;
  }


  public long getObstaclesNum() {
    return obstaclesNum;
  }

  public void setObstaclesNum(long obstaclesNum) {
    this.obstaclesNum = obstaclesNum;
  }


  public java.sql.Timestamp getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(java.sql.Timestamp timeEnd) {
    this.timeEnd = timeEnd;
  }

}
