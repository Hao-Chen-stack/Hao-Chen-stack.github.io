package com.cykj.bean;


public class TFriend {

  private long fid;
  private String qqid;
  private String friendid;
  private String friendname;
  private String groupid;


  public long getFid() {
    return fid;
  }

  public void setFid(long fid) {
    this.fid = fid;
  }


  public String getQqid() {
    return qqid;
  }

  public void setQqid(String qqid) {
    this.qqid = qqid;
  }


  public String getFriendid() {
    return friendid;
  }

  public void setFriendid(String friendid) {
    this.friendid = friendid;
  }


  public String getFriendname() {
    return friendname;
  }

  public void setFriendname(String friendname) {
    this.friendname = friendname;
  }


  public String getGroupid() {
    return groupid;
  }

  public void setGroupid(String groupid) {
    this.groupid = groupid;
  }

  public TFriend() {
  }

  public TFriend(long fid, String qqid, String friendid, String friendname, String groupid) {
    this.fid = fid;
    this.qqid = qqid;
    this.friendid = friendid;
    this.friendname = friendname;
    this.groupid = groupid;
  }
}
