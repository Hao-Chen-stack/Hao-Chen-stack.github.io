package com.cykj.bean;


public class Tblevaluate {

  private long evaId;
  private String evaluateContext;
  private String userAcc;
  private String managerAcc;
  private String evaluateTime;

  public Tblevaluate() {

  }

  public long getEvaId() {
    return evaId;
  }

  public void setEvaId(long evaId) {
    this.evaId = evaId;
  }


  public String getEvaluateContext() {
    return evaluateContext;
  }

  public void setEvaluateContext(String evaluateContext) {
    this.evaluateContext = evaluateContext;
  }


  public String getUserAcc() {
    return userAcc;
  }

  public void setUserAcc(String userAcc) {
    this.userAcc = userAcc;
  }

  public String getManagerAcc() {
    return managerAcc;
  }

  public void setManagerAcc(String managerAcc) {
    this.managerAcc = managerAcc;
  }

  public String getEvaluateTime() {
    return evaluateTime;
  }

  public void setEvaluateTime(String evaluateTime) {
    this.evaluateTime = evaluateTime;
  }

  @Override
  public String toString() {
    return "Tblevaluate{" +
            "evaId=" + evaId +
            ", evaluateContext='" + evaluateContext + '\'' +
            ", userAcc='" + userAcc + '\'' +
            ", managerAcc='" + managerAcc + '\'' +
            ", evaluateTime='" + evaluateTime + '\'' +
            '}';
  }
}
