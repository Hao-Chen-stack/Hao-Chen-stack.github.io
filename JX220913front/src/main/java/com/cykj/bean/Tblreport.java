package com.cykj.bean;


public class Tblreport {

  private long reportId;
  private long userId;
  private String reportContent;
  private String reportResults;
  private String reportDate;

  private String userAcc;

  private String areaName;
  private int paperScore;



  public Tblreport() {
  }

  public long getReportId() {
    return reportId;
  }

  public void setReportId(long reportId) {
    this.reportId = reportId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getReportContent() {
    return reportContent;
  }

  public void setReportContent(String reportContent) {
    this.reportContent = reportContent;
  }


  public String getReportResults() {
    return reportResults;
  }

  public void setReportResults(String reportResults) {
    this.reportResults = reportResults;
  }

  public String getReportDate() {
    return reportDate;
  }

  public void setReportDate(String reportDate) {
    this.reportDate = reportDate;
  }

  public String getUserAcc() {
    return userAcc;
  }

  public void setUserAcc(String userAcc) {
    this.userAcc = userAcc;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public int getPaperScore() {
    return paperScore;
  }

  public void setPaperScore(int paperScore) {
    this.paperScore = paperScore;
  }

  @Override
  public String toString() {
    return "Tblreport{" +
            "reportId=" + reportId +
            ", userId=" + userId +
            ", reportContent='" + reportContent + '\'' +
            ", reportResults='" + reportResults + '\'' +
            ", reportDate='" + reportDate + '\'' +
            ", userAcc='" + userAcc + '\'' +
            ", areaName='" + areaName + '\'' +
            ", paperScore=" + paperScore +
            '}';
  }
}
