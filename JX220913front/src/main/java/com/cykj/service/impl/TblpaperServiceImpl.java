package com.cykj.service.impl;

import com.cykj.bean.Tblpaper;
import com.cykj.mapper.TblpaperMapper;
import com.cykj.service.TblpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblpaperServiceImpl implements TblpaperService {
    @Autowired
    private TblpaperMapper tblpaperMapper;

    @Override
    public List<Tblpaper> findPaperByAreaName(String areaName) {
        return tblpaperMapper.findPaperByAreaName(areaName);
    }
}
