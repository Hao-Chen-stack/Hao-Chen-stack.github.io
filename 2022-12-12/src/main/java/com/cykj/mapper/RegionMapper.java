package com.cykj.mapper;

import com.cykj.bean.Tblregion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionMapper {
    //查
    public List<Tblregion> findRegionList();
    //增
    public int addRegion(Tblregion tblregion);
    //改
    public int updateRegion(Tblregion tblregion);
    //删
    public int delRegion(@Param("regionId") int regionId);
}
