package com.cykj.bean;

//@Component
public class Tblmanager {

  private long managerId;
  private long roleId;
  private String managerAcc;
  private String managerPwd;
  private String realName;
  private long managerStatus;

  private String roleName;

  //关联映射的属性
//  @Autowired
  private Tblrole tblrole;

  public Tblmanager() {
  }

  public Tblmanager(long roleId, String realName) {
    this.roleId = roleId;
    this.realName = realName;
  }

  public Tblmanager(String managerAcc, String managerPwd, String realName) {
    this.managerAcc = managerAcc;
    this.managerPwd = managerPwd;
    this.realName = realName;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Tblrole getTblrole() {
    return tblrole;
  }

  public void setTblrole(Tblrole tblrole) {
    this.tblrole = tblrole;
  }

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

  @Override
  public String toString() {
    return "Tblmanager{" +
            "managerId=" + managerId +
            ", roleId=" + roleId +
            ", managerAcc='" + managerAcc + '\'' +
            ", managerPwd='" + managerPwd + '\'' +
            ", realName='" + realName + '\'' +
            ", managerStatus=" + managerStatus +
            ", roleName='" + roleName + '\'' +
            ", tblrole=" + tblrole +
            '}';
  }
}
