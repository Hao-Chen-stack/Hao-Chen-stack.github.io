package com.cykj.mapper;

import com.cykj.bean.Tblgoods;
import com.cykj.bean.Tblgoodtype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblgoodsMapper {
//    //查询系统中的商品列表
//    List<Tblgoods> findGoodsList(@Param("index") int index,
//                                 @Param("size") int size);

    //查询系统中的商品列表
    List<Tblgoods> findGoodsList(@Param("tblgoods") Tblgoods tblgoods,
                                 @Param("page") int page,
                                 @Param("size") int size);

    //查询总条数
    //查
    public int findGoodsCount(Tblgoods tblgoods);

    //删除某一行
    public int delGoodsByGoodsId(@Param("goodsId") long goodsId);

    //添加商品
    public int addGoods(Tblgoods tblgoods);

    //商品修改
    public int updateGoods(Tblgoods tblgoods);

    //获取商品类型列表
    public List<Tblgoodtype> findGoodsTypeList();


}
