package com.cykj.mapper;

import com.cykj.bean.Tblregion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionMapper {
    //查
    public List<Tblregion> findRegionList(@Param("provinceId") long provinceId,
                                          @Param("cityId") long cityId,
                                          @Param("areaName") String areaName,
                                          @Param("regionStatus") long regionStatus,
                                          @Param("index") int index,
                                          @Param("size") int size);

    //查询总条数
    //查
    public int findRegionCount(@Param("provinceId") long provinceId,
                               @Param("cityId") long cityId,
                               @Param("areaName") String areaName,
                               @Param("regionStatus") long regionStatus
    );
//    查询省份
    public List<Tblregion> findRegionByParentId(@Param("parentId") long parentId);

    //增加区域
    public int addRegion(Tblregion tblregion);
    //修改区域
    public int updateRegion(Tblregion tblregion);
    //删除
    public int delRegion(@Param("regionId") int regionId);
}
