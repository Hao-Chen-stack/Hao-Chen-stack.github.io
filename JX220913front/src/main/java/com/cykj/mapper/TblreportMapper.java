package com.cykj.mapper;

import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblreport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblreportMapper {
    //查询用户报告
    List<Tblreport> findReportListByUAcc(@Param("userAcc") String userAcc,
                                         @Param("page") int page,
                                         @Param("size") int size);

    //查询总条数
    int findReportCount(@Param("userAcc") String userAcc);

    //根据点击的日期方块来查询报告内容和报告结果
    List<Tblreport> findContextAndResByDate(@Param("reportId") long reportId);

    //在线评估完后自动生成报告插入数据库
    int addReportMsg(Tblreport tblreport);
}
