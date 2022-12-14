package com.sample;


public class Tblregion {

  private long regionId;
  private String regionName;
  private String parentId;
  private long regionStatus;


  public long getRegionId() {
    return regionId;
  }

  public void setRegionId(long regionId) {
    this.regionId = regionId;
  }


  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }


  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }


  public long getRegionStatus() {
    return regionStatus;
  }

  public void setRegionStatus(long regionStatus) {
    this.regionStatus = regionStatus;
  }

}
