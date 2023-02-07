package com.cykj.bean;


public class Tblrolepower {

  private long rpId;
  private long roleid;
  private long powerid;

  public Tblrolepower() {
  }

  public long getRpId() {
    return rpId;
  }

  public void setRpId(long rpId) {
    this.rpId = rpId;
  }

  public long getRoleid() {
    return roleid;
  }

  public void setRoleid(long roleid) {
    this.roleid = roleid;
  }

  public long getPowerid() {
    return powerid;
  }

  public void setPowerid(long powerid) {
    this.powerid = powerid;
  }

  @Override
  public String toString() {
    return "Tblrolepower{" +
            "rpId=" + rpId +
            ", roleid=" + roleid +
            ", powerid=" + powerid +
            '}';
  }
}
