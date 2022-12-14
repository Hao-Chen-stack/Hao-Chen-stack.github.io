package com.sample;


public class Tblgoodtype {

  private long gtypeId;
  private long managerId;
  private String gtypeName;
  private long parentId;
  private long gtypeStatus;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getGtypeId() {
    return gtypeId;
  }

  public void setGtypeId(long gtypeId) {
    this.gtypeId = gtypeId;
  }


  public long getManagerId() {
    return managerId;
  }

  public void setManagerId(long managerId) {
    this.managerId = managerId;
  }


  public String getGtypeName() {
    return gtypeName;
  }

  public void setGtypeName(String gtypeName) {
    this.gtypeName = gtypeName;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public long getGtypeStatus() {
    return gtypeStatus;
  }

  public void setGtypeStatus(long gtypeStatus) {
    this.gtypeStatus = gtypeStatus;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
