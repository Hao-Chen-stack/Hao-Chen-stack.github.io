package com.cykj.bean;


public class Tblarea {

  private long areaId;
  private long managerId;
  private String areaName;

  public Tblarea() {

  }

  public long getAreaId() {
    return areaId;
  }

  public void setAreaId(long areaId) {
    this.areaId = areaId;
  }


  public long getManagerId() {
    return managerId;
  }

  public void setManagerId(long managerId) {
    this.managerId = managerId;
  }


  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  @Override
  public String toString() {
    return "Tblarea{" +
            "areaId=" + areaId +
            ", managerId=" + managerId +
            ", areaName='" + areaName + '\'' +
            '}';
  }
}
