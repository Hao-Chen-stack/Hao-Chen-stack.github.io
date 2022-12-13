package com.cykj.mapper;

import com.cykj.bean.Tblgoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    //查
    public List<Tblgoods> findGoodsList();
    //增
    public int addGoods(Tblgoods tblgoods);
    //改
    public int updateGoods(Tblgoods tblgoods);
    //删
    public int delGoods(@Param("goodsId") int goodsId);
    //嵌套查询----主表的返回类型改成：resultMap
    public List<Tblgoods> findGoods(@Param("gtypeId") int gtypeId,
                                    @Param("goodsName") String goodsName);
    //嵌套查询---嵌套结果
    public List<Tblgoods> findGoods2();
    //嵌套查询---在实体类中添加查询出的额外字段
    public List<Tblgoods> findGoods3();

    //多条件动态查询
    public List<Tblgoods> findGoods4(@Param("gtypeId") int gtypeId,
                                     @Param("goodsName") String goodsName,
                                     @Param("goodsPrice") double goodsPrice);
    //批量添加
    public int addGoodsList(@Param("goodsList") List<Tblgoods> goodsList);
}
