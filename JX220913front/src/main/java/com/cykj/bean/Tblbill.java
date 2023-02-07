package com.cykj.bean;


public class Tblbill {

  private long billId;
  private long userId;
  private String billdate;
  private String billtype;
  private String state;
  private double amount;
  private long managerId;

  private String realName;
  private String userAcc;

  public Tblbill() {
  }

  public long getBillId() {
    return billId;
  }

  public void setBillId(long billId) {
    this.billId = billId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getBilldate() {
    return billdate;
  }

  public void setBilldate(String billdate) {
    this.billdate = billdate;
  }

  public String getBilltype() {
    return billtype;
  }

  public void setBilltype(String billtype) {
    this.billtype = billtype;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public long getManagerId() {
    return managerId;
  }

  public void setManagerId(long managerId) {
    this.managerId = managerId;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getUserAcc() {
    return userAcc;
  }

  public void setUserAcc(String userAcc) {
    this.userAcc = userAcc;
  }


  @Override
  public String toString() {
    return "Tblbill{" +
            "billId=" + billId +
            ", userId=" + userId +
            ", billdate='" + billdate + '\'' +
            ", billtype='" + billtype + '\'' +
            ", state='" + state + '\'' +
            ", amount=" + amount +
            ", managerId=" + managerId +
            ", realName='" + realName + '\'' +
            ", userAcc='" + userAcc + '\'' +
            '}';
  }
}
