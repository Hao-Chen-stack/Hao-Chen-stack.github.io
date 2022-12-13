package com.cykj.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("role")
public class Tblrole {

  @Value("11")
  private long roleId;
  @Value("远辉")
  private String roleName;

  public Tblrole() {
  }

  public Tblrole(long roleId, String roleName) {
    this.roleId = roleId;
    this.roleName = roleName;
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
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
            "roleId=" + roleId +
            ", roleName='" + roleName + '\'' +
            '}';
  }
}
