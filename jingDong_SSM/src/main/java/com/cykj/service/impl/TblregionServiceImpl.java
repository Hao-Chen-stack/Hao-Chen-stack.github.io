package com.cykj.service.impl;

import com.cykj.bean.Tblregion;
import com.cykj.mapper.RegionMapper;
import com.cykj.service.TblregionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblregionServiceImpl implements TblregionService {
    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Tblregion> findRegionList(long provinceId, long cityId, String areaName, long regionStatus, int index, int size) {
        return regionMapper.findRegionList(provinceId,cityId,areaName,regionStatus,index,size);
    }

    @Override
    public List<Tblregion> findRegionByParentId(long parentId) {
        return regionMapper.findRegionByParentId(parentId);
    }

    @Override
    public int findRegionCount(long provinceId, long cityId, String areaName, long regionStatus) {
        return regionMapper.findRegionCount(provinceId,cityId,areaName,regionStatus);
    }

    @Override
    public int delRegion(int regionId) {
        int delRegion = regionMapper.delRegion(regionId);
        if (0 !=delRegion){
            return delRegion;
        }
        return 0;
    }

    @Override
    public int addRegion(Tblregion tblregion) {
        return regionMapper.addRegion(tblregion);
    }

    @Override
    public int updateRegion(Tblregion tblregion) {
        return regionMapper.updateRegion(tblregion);
    }
}
