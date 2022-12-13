package com.cykj.bean;


public class TRecord {

  private long recid;
  private String sendid;
  private String recvid;
  private long rectype;
  private String content;
  private String rectime;
  private String state;


  public long getRecid() {
    return recid;
  }

  public void setRecid(long recid) {
    this.recid = recid;
  }


  public String getSendid() {
    return sendid;
  }

  public void setSendid(String sendid) {
    this.sendid = sendid;
  }


  public String getRecvid() {
    return recvid;
  }

  public void setRecvid(String recvid) {
    this.recvid = recvid;
  }


  public long getRectype() {
    return rectype;
  }

  public void setRectype(long rectype) {
    this.rectype = rectype;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getRectime() {
    return rectime;
  }

  public void setRectime(String rectime) {
    this.rectime = rectime;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}
