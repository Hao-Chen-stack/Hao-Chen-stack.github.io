package com.cykj.bean;


public class Tblpower {

  private long powerid;
  private String powerName;
  private long parentId;
  private String powerUrl;


  public long getPowerid() {
    return powerid;
  }

  public void setPowerid(long powerid) {
    this.powerid = powerid;
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
