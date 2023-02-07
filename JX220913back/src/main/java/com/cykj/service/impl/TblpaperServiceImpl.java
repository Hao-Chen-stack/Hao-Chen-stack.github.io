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
    public List<Tblpaper> findPaperByAreaName(String areaName,int page,int size) {
        return tblpaperMapper.findPaperByAreaName(areaName, page, size);
    }

    @Override
    public int findPaperByAreaNameCount(String areaName) {
        return tblpaperMapper.findPaperByAreaNameCount(areaName);
    }

    @Override
    public int addPaperMsg(Tblpaper tblpaper) {
        return tblpaperMapper.addPaperMsg(tblpaper);
    }

    @Override
    public int updatePaperMsg(Tblpaper tblpaper) {
        return tblpaperMapper.updatePaperMsg(tblpaper);
    }

    @Override
    public int delPaperMsgByPId(long paperId) {
        return tblpaperMapper.delPaperMsgByPId(paperId);
    }

    @Override
    public List<Tblpaper> findPaperMsgById(long paperId) {
        return tblpaperMapper.findPaperMsgById(paperId);
    }
}
