package com.cykj.bean;


public class Tblregion {

  private long regionId;
  private String regionName;
  private String parentId;
  private long regionStatus;

  private String province;
  private String city;
  private String area;

  public Tblregion() {
  }

  public Tblregion(long regionId, String regionName) {
    this.regionId = regionId;
    this.regionName = regionName;
  }

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

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  @Override
  public String toString() {
    return "Tblregion{" +
            "regionId=" + regionId +
            ", regionName='" + regionName + '\'' +
            ", parentId='" + parentId + '\'' +
            ", regionStatus=" + regionStatus +
            '}';
  }
}
