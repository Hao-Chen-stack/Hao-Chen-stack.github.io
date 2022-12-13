package com.cykj.bean;


public class Tblgoods {

  private long goodsId;
  private long gtypeId;
  private String goodsName;
  private double goodsPrice;
  private String goodsImage;
  private String goodsDetail;
  private double goodsInventory;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;

  private Tblgoodtype tblgoodtype;


  public Tblgoods() {

  }

  public Tblgoods(String goodsName, double goodsPrice) {
    this.goodsName = goodsName;
    this.goodsPrice = goodsPrice;
  }

  public Tblgoodtype getTblgoodtype() {
    return tblgoodtype;
  }

  public void setTblgoodtype(Tblgoodtype tblgoodtype) {
    this.tblgoodtype = tblgoodtype;
  }

  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public long getGtypeId() {
    return gtypeId;
  }

  public void setGtypeId(long gtypeId) {
    this.gtypeId = gtypeId;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public double getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(double goodsPrice) {
    this.goodsPrice = goodsPrice;
  }


  public String getGoodsImage() {
    return goodsImage;
  }

  public void setGoodsImage(String goodsImage) {
    this.goodsImage = goodsImage;
  }


  public String getGoodsDetail() {
    return goodsDetail;
  }

  public void setGoodsDetail(String goodsDetail) {
    this.goodsDetail = goodsDetail;
  }


  public double getGoodsInventory() {
    return goodsInventory;
  }

  public void setGoodsInventory(double goodsInventory) {
    this.goodsInventory = goodsInventory;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "Tblgoods{" +
            "goodsId=" + goodsId +
            ", gtypeId=" + gtypeId +
            ", goodsName='" + goodsName + '\'' +
            ", goodsPrice=" + goodsPrice +
            ", goodsImage='" + goodsImage + '\'' +
            ", goodsDetail='" + goodsDetail + '\'' +
            ", goodsInventory=" + goodsInventory +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", tblgoodtype=" + tblgoodtype +
            '}';
  }
}
