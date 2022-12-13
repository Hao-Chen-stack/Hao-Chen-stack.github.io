package com.cykj.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Tbladdress {
  @Value(value = "666")

  private long addressId;
  private long userId;
  private long regionId;
  private String houseAddr;


  public long getAddressId() {
    return addressId;
  }

  public void setAddressId(long addressId) {
    this.addressId = addressId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getRegionId() {
    return regionId;
  }

  public void setRegionId(long regionId) {
    this.regionId = regionId;
  }


  public String getHouseAddr() {
    return houseAddr;
  }

  public void setHouseAddr(String houseAddr) {
    this.houseAddr = houseAddr;
  }

  @Override
  public String toString() {
    return "Tbladdress{" +
            "addressId=" + addressId +
            ", userId=" + userId +
            ", regionId=" + regionId +
            ", houseAddr='" + houseAddr + '\'' +
            '}';
  }
}
