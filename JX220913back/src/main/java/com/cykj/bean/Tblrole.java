package com.cykj.bean;


public class Tblrole {

  private long roleid;
  private String roleName;

  public Tblrole() {

  }

  public long getroleid() {
    return roleid;
  }

  public void setroleid(long roleid) {
    this.roleid = roleid;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  @Override
  public String toString() {
    return "Tblrole{" +
            "roleid=" + roleid +
            ", roleName='" + roleName + '\'' +
            '}';
  }
}
