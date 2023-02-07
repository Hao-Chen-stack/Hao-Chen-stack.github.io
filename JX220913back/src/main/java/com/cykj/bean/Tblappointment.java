package com.cykj.bean;


public class Tblappointment {

  private long appointmentId;
  private long userId;
  private long areaId;
  private String appointmentdate;
  private String appointmenttime;
  private String appointstate;
  private String problem;
  private String answer;
  private String replydate;
  private double appointCost;
  private String completeTime;
  private String evaluate;
  private String evaluateTime;
  private int managerStopAns;
  private int userStopAns;


  private String managerAcc;
  private String areaName;

  private String userName;

  private String startDate;
  private String endDate;

  private String userAcc;
  private String realName;

  private int appointCounts;

  public Tblappointment() {

  }

  public long getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(long appointmentId) {
    this.appointmentId = appointmentId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getAreaId() {
    return areaId;
  }

  public void setAreaId(long areaId) {
    this.areaId = areaId;
  }


  public String getAppointmentdate() {
    return appointmentdate;
  }

  public void setAppointmentdate(String appointmentdate) {
    this.appointmentdate = appointmentdate;
  }

  public String getAppointmenttime() {
    return appointmenttime;
  }

  public void setAppointmenttime(String appointmenttime) {
    this.appointmenttime = appointmenttime;
  }

  public String getAppointstate() {
    return appointstate;
  }

  public void setAppointstate(String appointstate) {
    this.appointstate = appointstate;
  }


  public String getProblem() {
    return problem;
  }

  public void setProblem(String problem) {
    this.problem = problem;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public String getReplydate() {
    return replydate;
  }

  public void setReplydate(String replydate) {
    this.replydate = replydate;
  }


  public double getAppointCost() {
    return appointCost;
  }

  public void setAppointCost(double appointCost) {
    this.appointCost = appointCost;
  }

  public String getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(String completeTime) {
    this.completeTime = completeTime;
  }

  public String getEvaluate() {
    return evaluate;
  }

  public void setEvaluate(String evaluate) {
    this.evaluate = evaluate;
  }


  public String getManagerAcc() {
    return managerAcc;
  }

  public void setManagerAcc(String managerAcc) {
    this.managerAcc = managerAcc;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public String getEvaluateTime() {
    return evaluateTime;
  }

  public void setEvaluateTime(String evaluateTime) {
    this.evaluateTime = evaluateTime;
  }

  public int getManagerStopAns() {
    return managerStopAns;
  }

  public void setManagerStopAns(int managerStopAns) {
    this.managerStopAns = managerStopAns;
  }

  public int getUserStopAns() {
    return userStopAns;
  }

  public void setUserStopAns(int userStopAns) {
    this.userStopAns = userStopAns;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getUserAcc() {
    return userAcc;
  }

  public void setUserAcc(String userAcc) {
    this.userAcc = userAcc;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public int getAppointCounts() {
    return appointCounts;
  }

  @Override
  public String toString() {
    return "Tblappointment{" +
            "appointmentId=" + appointmentId +
            ", userId=" + userId +
            ", areaId=" + areaId +
            ", appointmentdate='" + appointmentdate + '\'' +
            ", appointmenttime='" + appointmenttime + '\'' +
            ", appointstate='" + appointstate + '\'' +
            ", problem='" + problem + '\'' +
            ", answer='" + answer + '\'' +
            ", replydate='" + replydate + '\'' +
            ", appointCost=" + appointCost +
            ", completeTime='" + completeTime + '\'' +
            ", evaluate='" + evaluate + '\'' +
            ", evaluateTime='" + evaluateTime + '\'' +
            ", managerStopAns=" + managerStopAns +
            ", userStopAns=" + userStopAns +
            ", managerAcc='" + managerAcc + '\'' +
            ", areaName='" + areaName + '\'' +
            ", userName='" + userName + '\'' +
            ", startDate='" + startDate + '\'' +
            ", endDate='" + endDate + '\'' +
            ", userAcc='" + userAcc + '\'' +
            ", realName='" + realName + '\'' +
            ", appointCounts='" + appointCounts + '\'' +
            '}';
  }
}
