package com.cykj.bean;


import java.sql.Timestamp;

public class Tblgoodtype {

  private int gtypeId;
  private int managerId;
  private String gtypeName;
  private int parentId;
  private int gtypeStatus;
  private Timestamp createTime;
  private Timestamp updateTime;

  public int getGtypeId() {
    return gtypeId;
  }

  public void setGtypeId(int gtypeId) {
    this.gtypeId = gtypeId;
  }

  public int getManagerId() {
    return managerId;
  }

  public void setManagerId(int managerId) {
    this.managerId = managerId;
  }

  public String getGtypeName() {
    return gtypeName;
  }

  public void setGtypeName(String gtypeName) {
    this.gtypeName = gtypeName;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public int getGtypeStatus() {
    return gtypeStatus;
  }

  public void setGtypeStatus(int gtypeStatus) {
    this.gtypeStatus = gtypeStatus;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }
}
