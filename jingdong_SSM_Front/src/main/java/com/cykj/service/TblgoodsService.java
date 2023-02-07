package com.cykj.service;

import com.cykj.bean.Tblgoods;

import java.util.List;

public interface TblgoodsService {
    //查询系统中的商品列表
    List<Tblgoods> findGoodsList();

}
