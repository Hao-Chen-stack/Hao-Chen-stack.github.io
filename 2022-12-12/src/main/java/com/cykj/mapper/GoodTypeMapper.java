package com.cykj.mapper;

import com.cykj.bean.Tblgoodtype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodTypeMapper {
    //查
    public List<Tblgoodtype> findGoodTypeList();
    //增
    public int addGoodType(Tblgoodtype tblgoodtype);
    //改
    public int updateGoodType(Tblgoodtype tblgoodtype);
    //删
    public int delGoodType(@Param("gtypeId") int gtypeId);

}
