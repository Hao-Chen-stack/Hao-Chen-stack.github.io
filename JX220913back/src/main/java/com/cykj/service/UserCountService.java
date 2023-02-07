package com.cykj.service;

import com.cykj.bean.Tbluser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCountService {
    //本周统计
    List<Tbluser> findWeekNowList(Tbluser tbluser);

    //本月统计
    List<Tbluser> findMonthNowList(Tbluser tbluser);

    //近半年统计
    List<Tbluser> findHalfYearNowList(List<String> yearMonths);

}
