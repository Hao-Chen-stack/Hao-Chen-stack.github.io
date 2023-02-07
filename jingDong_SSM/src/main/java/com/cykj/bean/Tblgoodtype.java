package com.cykj.bean;


import java.sql.Timestamp;

public class Tblgoodtype {

  private int gtypeId;
  private int managerId;
  private String gtypeName;
  private int parentId;
  private int gtypeStatus;
  private String createTime;
  private String updateTime;

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

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }
}
