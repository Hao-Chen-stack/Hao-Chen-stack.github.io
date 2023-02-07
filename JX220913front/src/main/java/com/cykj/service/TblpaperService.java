package com.cykj.service;

import com.cykj.bean.Tblpaper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblpaperService {
    //根据领域名称找题目
    List<Tblpaper> findPaperByAreaName(String areaName);
}
