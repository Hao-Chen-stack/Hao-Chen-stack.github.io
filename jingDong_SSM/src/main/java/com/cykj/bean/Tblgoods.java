package com.cykj.bean;


public class Tblgoods {

  private long goodsId;
  private long gtypeId;
  private String goodsName;
  private double goodsPrice;
  //价格区间
  private Double minPrice;
  private Double maxPrice;

  private String goodsImage;
  private String goodsDetail;
  private double goodsInventory;
  private String createTime;
  private String updateTime;

//  private Tblgoodtype tblgoodtype;

  //查询的字段
  //类型名称
  private String gtypeName;


  public Tblgoods() {

  }

  public Tblgoods(String goodsName, double goodsPrice) {
    this.goodsName = goodsName;
    this.goodsPrice = goodsPrice;
  }

  public Tblgoods(long gtypeId, String goodsName, double goodsPrice) {
    this.gtypeId = gtypeId;
    this.goodsName = goodsName;
    this.goodsPrice = goodsPrice;
  }

  public Tblgoods(long goodsId, long gtypeId, String goodsName, double goodsPrice) {
    this.goodsId = goodsId;
    this.gtypeId = gtypeId;
    this.goodsName = goodsName;
    this.goodsPrice = goodsPrice;
  }

//  public Tblgoodtype getTblgoodtype() {
//    return tblgoodtype;
//  }
//
//  public void setTblgoodtype(Tblgoodtype tblgoodtype) {
//    this.tblgoodtype = tblgoodtype;
//  }

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


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }


  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public Double getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(Double minPrice) {
    this.minPrice = minPrice;
  }

  public Double getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(Double maxPrice) {
    this.maxPrice = maxPrice;
  }

  public String getGtypeName() {
    return gtypeName;
  }

  public void setGtypeName(String gtypeName) {
    this.gtypeName = gtypeName;
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
//            ", tblgoodtype=" + tblgoodtype +
            '}';
  }

//  @Override
//  public String toString() {
//    return
//            goodsId +
//            ", " + gtypeId +
//            ", " + goodsName +
//            ", " + goodsPrice +
//            ", '" + goodsImage +
//            ", '" + goodsDetail +
//            ", " + goodsInventory +
//            ", " + createTime +
//            ", " + updateTime;
//  }

}
