package com.cykj.service;

import com.cykj.bean.Tblregion;

import java.util.List;

public interface TblregionService {
    //查询
    List<Tblregion> findRegionList(long provinceId, long cityId, String areaName, long regionStatus, int index, int size);

    List<Tblregion> findRegionByParentId(long parentId);

    //查询总条数
    int findRegionCount(long provinceId, long cityId, String areaName, long regionStatus);

    //删除区域
    int delRegion(int regionId);

    //增加区域
    public int addRegion(Tblregion tblregion);

    //修改区域
    public int updateRegion(Tblregion tblregion);
}
