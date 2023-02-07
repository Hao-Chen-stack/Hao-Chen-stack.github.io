package com.cykj.mapper;

import com.cykj.bean.Tblgoods;
import com.cykj.bean.Tblgoodtype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblgoodsMapper {
    //查询系统中的商品列表
    List<Tblgoods> findGoodsList();

}
