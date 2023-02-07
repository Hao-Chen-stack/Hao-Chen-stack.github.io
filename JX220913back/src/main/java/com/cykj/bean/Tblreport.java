package com.cykj.bean;


public class Tblreport {

  private long reportId;
  private long userId;
  private String reportContent;
  private String reportResults;
  private String reportDate;

  private String areaName;
  private int paperScore;

  private String startDate;
  private String endDate;
  private String minScore;
  private String maxScore;

  private String userName;

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

  public String getMinScore() {
    return minScore;
  }

  public void setMinScore(String minScore) {
    this.minScore = minScore;
  }

  public String getMaxScore() {
    return maxScore;
  }

  public void setMaxScore(String maxScore) {
    this.maxScore = maxScore;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public String toString() {
    return "Tblreport{" +
            "reportId=" + reportId +
            ", userId=" + userId +
            ", reportContent='" + reportContent + '\'' +
            ", reportResults='" + reportResults + '\'' +
            ", reportDate='" + reportDate + '\'' +
            ", areaName='" + areaName + '\'' +
            ", paperScore=" + paperScore +
            ", startDate='" + startDate + '\'' +
            ", endDate='" + endDate + '\'' +
            ", minScore=" + minScore +
            ", maxScore=" + maxScore +
            ", userName='" + userName + '\'' +
            '}';
  }
}
