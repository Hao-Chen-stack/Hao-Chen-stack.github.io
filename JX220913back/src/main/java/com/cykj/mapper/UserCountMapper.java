package com.cykj.mapper;

import com.cykj.bean.Tbluser;
import com.cykj.utils.YearUtis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCountMapper {
    //本周统计
    List<Tbluser> findWeekNowList(Tbluser tbluser);

    //本月统计
    List<Tbluser> findMonthNowList(Tbluser tbluser);

    //近半年统计
    List<Tbluser> findHalfYearNowList(@Param("yearMonths") List<String> yearMonths);

}
