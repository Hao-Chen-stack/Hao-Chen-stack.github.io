package com.cykj.bean;


public class BombDress {

  private long dressid;
  private String dressname;
  private String image;
  private String imagepath;
  private String userid;
  private int dresstype;
  private int characterid;


  public long getDressid() {
    return dressid;
  }

  public void setDressid(long dressid) {
    this.dressid = dressid;
  }


  public String getDressname() {
    return dressname;
  }

  public void setDressname(String dressname) {
    this.dressname = dressname;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getImagepath() {
    return imagepath;
  }

  public void setImagepath(String imagepath) {
    this.imagepath = imagepath;
  }

  public int getDresstype() {
    return dresstype;
  }

  public void setDresstype(int dresstype) {
    this.dresstype = dresstype;
  }

  public int getCharacterid() {
    return characterid;
  }

  public void setCharacterid(int characterid) {
    this.characterid = characterid;
  }

  public BombDress() {

  }

  public BombDress(String dressname, String image, String imagepath, String userid, int dresstype, int characterid) {
    this.dressname = dressname;
    this.image = image;
    this.imagepath = imagepath;
    this.userid = userid;
    this.dresstype = dresstype;
    this.characterid = characterid;
  }

}
