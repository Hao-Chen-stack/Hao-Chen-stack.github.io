package com.cykj.mapper;

import com.cykj.bean.Tblpaper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblpaperMapper {
    //根据领域名称找题目
    List<Tblpaper> findPaperByAreaName(@Param("areaName") String areaName);
}
