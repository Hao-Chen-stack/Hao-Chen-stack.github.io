package com.cykj.service;

import com.cykj.bean.Tblreport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblreportService {
    //查询用户报告
    List<Tblreport> findReportListByUAcc(String userAcc, int page, int size);

    //查询总条数
    int findReportCount(String userAcc);

    //根据日期查询报告内容和报告结果
    List<Tblreport> findContextAndResByDate(long reportId);

    //在线评估完后自动生成报告插入数据库
    int addReportMsg(Tblreport tblreport);
}
