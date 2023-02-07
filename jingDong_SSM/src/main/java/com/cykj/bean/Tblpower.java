package com.cykj.bean;


public class Tblpower {

  private long powerId;
  private String powerName;
  private long parentId;
  private String powerUrl;

  public Tblpower() {

  }

  public Tblpower(long powerId, String powerName, long parentId) {
    this.powerId = powerId;
    this.powerName = powerName;
    this.parentId = parentId;
  }

  public long getPowerId() {
    return powerId;
  }

  public void setPowerId(long powerId) {
    this.powerId = powerId;
  }


  public String getPowerName() {
    return powerName;
  }

  public void setPowerName(String powerName) {
    this.powerName = powerName;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getPowerUrl() {
    return powerUrl;
  }

  public void setPowerUrl(String powerUrl) {
    this.powerUrl = powerUrl;
  }

}
