package com.cykj.bean;


public class Tblworktime {

  private long workId;
  private long managerId;
  private String workTime;
  private int timeState;

  public Tblworktime() {

  }

  public long getWorkId() {
    return workId;
  }

  public void setWorkId(long workId) {
    this.workId = workId;
  }


  public long getManagerId() {
    return managerId;
  }

  public void setManagerId(long managerId) {
    this.managerId = managerId;
  }


  public String getWorkTime() {
    return workTime;
  }

  public void setWorkTime(String workTime) {
    this.workTime = workTime;
  }

  public int getTimeState() {
    return timeState;
  }

  public void setTimeState(int timeState) {
    this.timeState = timeState;
  }

  @Override
  public String toString() {
    return "Tblworktime{" +
            "workId=" + workId +
            ", managerId=" + managerId +
            ", workTime='" + workTime + '\'' +
            ", timeState=" + timeState +
            '}';
  }
}
