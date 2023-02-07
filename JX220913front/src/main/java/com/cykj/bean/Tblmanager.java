package com.cykj.bean;


public class Tblmanager {

  private long managerId;
  private long roleid;
  private String managerAcc;
  private String managerPwd;
  private String realName;
  private String title;
  private String school;
  private long managerStatus;
  private double price;
  private String background;
  private double managerBalance;

  public Tblmanager() {

  }

  public double getManagerBalance() {
    return managerBalance;
  }

  public void setManagerBalance(double managerBalance) {
    this.managerBalance = managerBalance;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public long getManagerId() {
    return managerId;
  }

  public void setManagerId(long managerId) {
    this.managerId = managerId;
  }


  public long getroleid() {
    return roleid;
  }

  public void setroleid(long roleid) {
    this.roleid = roleid;
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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getBackground() {
    return background;
  }

  public void setBackground(String background) {
    this.background = background;
  }


  @Override
  public String toString() {
    return "Tblmanager{" +
            "managerId=" + managerId +
            ", roleid=" + roleid +
            ", managerAcc='" + managerAcc + '\'' +
            ", managerPwd='" + managerPwd + '\'' +
            ", realName='" + realName + '\'' +
            ", title='" + title + '\'' +
            ", school='" + school + '\'' +
            ", managerStatus=" + managerStatus +
            ", price=" + price +
            ", background='" + background + '\'' +
            ", managerBalance=" + managerBalance +
            '}';
  }
}
