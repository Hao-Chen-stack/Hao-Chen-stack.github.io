package com.cykj.mapper;

import com.cykj.bean.Tblreport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblreportMapper {
    //根据条件查询评估报告列表
    List<Tblreport> findReportListBySomeCondition(@Param("tblreport") Tblreport tblreport,
                                                  @Param("page") int page,
                                                  @Param("size") int size);
    //根据条件查询评估报告列表的总条数
    int findReportCountBySomeCondition(@Param("tblreport") Tblreport tblreport);

    //根据管理员用户评估列表中的查看报告按钮来查询报告内容和报告结果
    List<Tblreport> findContextAndResByRId(@Param("reportId") long reportId);

}
