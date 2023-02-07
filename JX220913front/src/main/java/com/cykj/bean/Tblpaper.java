package com.cykj.bean;


public class Tblpaper {

  private long paperId;
  private String paperContent;
  private double paperscore;
  private String areaName;
  private String optionA;
  private String optionB;
  private String optionC;
  private String optionD;
  private int optionAscore;
  private int optionBscore;
  private int optionCscore;
  private int optionDscore;

  public Tblpaper() {
  }

  public long getPaperId() {
    return paperId;
  }

  public void setPaperId(long paperId) {
    this.paperId = paperId;
  }

  public String getPaperContent() {
    return paperContent;
  }

  public void setPaperContent(String paperContent) {
    this.paperContent = paperContent;
  }

  public double getPaperscore() {
    return paperscore;
  }

  public void setPaperscore(double paperscore) {
    this.paperscore = paperscore;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public String getOptionA() {
    return optionA;
  }

  public void setOptionA(String optionA) {
    this.optionA = optionA;
  }

  public String getOptionB() {
    return optionB;
  }

  public void setOptionB(String optionB) {
    this.optionB = optionB;
  }

  public String getOptionC() {
    return optionC;
  }

  public void setOptionC(String optionC) {
    this.optionC = optionC;
  }

  public String getOptionD() {
    return optionD;
  }

  public void setOptionD(String optionD) {
    this.optionD = optionD;
  }

  public int getOptionAscore() {
    return optionAscore;
  }

  public void setOptionAscore(int optionAscore) {
    this.optionAscore = optionAscore;
  }

  public int getOptionBscore() {
    return optionBscore;
  }

  public void setOptionBscore(int optionBscore) {
    this.optionBscore = optionBscore;
  }

  public int getOptionCscore() {
    return optionCscore;
  }

  public void setOptionCscore(int optionCscore) {
    this.optionCscore = optionCscore;
  }

  public int getOptionDscore() {
    return optionDscore;
  }

  public void setOptionDscore(int optionDscore) {
    this.optionDscore = optionDscore;
  }

  @Override
  public String toString() {
    return "Tblpaper{" +
            "paperId=" + paperId +
            ", paperContent='" + paperContent + '\'' +
            ", paperscore=" + paperscore +
            ", areaName='" + areaName + '\'' +
            ", optionA='" + optionA + '\'' +
            ", optionB='" + optionB + '\'' +
            ", optionC='" + optionC + '\'' +
            ", optionD='" + optionD + '\'' +
            ", optionAscore=" + optionAscore +
            ", optionBscore=" + optionBscore +
            ", optionCscore=" + optionCscore +
            ", optionDscore=" + optionDscore +
            '}';
  }
}
