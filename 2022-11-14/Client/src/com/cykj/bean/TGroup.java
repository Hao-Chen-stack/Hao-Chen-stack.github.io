package com.cykj.bean;


public class TGroup {

  private String groupid;
  private String groupname;
  private String qqid;
  private String grouptype;


  public String getGroupid() {
    return groupid;
  }

  public void setGroupid(String groupid) {
    this.groupid = groupid;
  }


  public String getGroupname() {
    return groupname;
  }

  public void setGroupname(String groupname) {
    this.groupname = groupname;
  }


  public String getQqid() {
    return qqid;
  }

  public void setQqid(String qqid) {
    this.qqid = qqid;
  }


  public String getGrouptype() {
    return grouptype;
  }

  public void setGrouptype(String grouptype) {
    this.grouptype = grouptype;
  }

  public TGroup(String groupid, String groupname, String qqid, String grouptype) {
    this.groupid = groupid;
    this.groupname = groupname;
    this.qqid = qqid;
    this.grouptype = grouptype;
  }

  public TGroup() {

  }

  @Override
  public String toString() {
    return groupname ;
  }
}
