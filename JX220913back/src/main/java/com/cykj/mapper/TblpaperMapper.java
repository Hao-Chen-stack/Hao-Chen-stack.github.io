package com.cykj.mapper;

import com.cykj.bean.Tblpaper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblpaperMapper {
    //根据领域名称找题目
    List<Tblpaper> findPaperByAreaName(@Param("areaName") String areaName,
                                       @Param("page") int page,
                                       @Param("size") int size);

    //根据领域名称找题目总条数
    int findPaperByAreaNameCount(@Param("areaName") String areaName);

    //新增题目和相关选项信息
    int addPaperMsg(Tblpaper tblpaper);

    //修改题目和相关选项信息
    int updatePaperMsg(Tblpaper tblpaper);

    //根据题目id删除题目和相关选项信息
    int delPaperMsgByPId(@Param("paperId") long paperId);

    //根据题目id查询题目和相关选项信息
    List<Tblpaper> findPaperMsgById(@Param("paperId") long paperId);
}
