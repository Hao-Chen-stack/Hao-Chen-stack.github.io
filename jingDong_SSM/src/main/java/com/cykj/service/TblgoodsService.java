package com.cykj.service;

import com.cykj.bean.Tblgoods;
import com.cykj.bean.Tblgoodtype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblgoodsService {
//    //查询系统中的商品列表
//    List<Tblgoods> findGoodsList(int index, int size);

    //查询系统中的商品列表
    List<Tblgoods> findGoodsList(Tblgoods tblgoods, int page, int size);

    //查询总条数
    //查
    public int findGoodsCount(Tblgoods tblgoods);

    //删除某一行
    int delGoodsByGoodsId(long goodsId);

    //添加商品
    public int addGoods(Tblgoods tblgoods);

    //商品修改
    public int updateGoods(Tblgoods tblgoods);

    //获取商品类型列表
    public List<Tblgoodtype> findGoodsTypeList();


}
