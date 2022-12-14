package com.sample;


public class Tblmanager {

  private long managerId;
  private long roleId;
  private String managerAcc;
  private String managerPwd;
  private String realName;
  private long managerStatus;


  public long getManagerId() {
    return managerId;
  }

  public void setManagerId(long managerId) {
    this.managerId = managerId;
  }


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getManagerAcc() {
    return managerAcc;
  }

  public void setManagerAcc(String managerAcc) {
    this.managerAcc = managerAcc;
  }


  public String getManagerPwd() {
    return managerPwd;
  }

  public void setManagerPwd(String managerPwd) {
    this.managerPwd = managerPwd;
  }


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public long getManagerStatus() {
    return managerStatus;
  }

  public void setManagerStatus(long managerStatus) {
    this.managerStatus = managerStatus;
  }

}
