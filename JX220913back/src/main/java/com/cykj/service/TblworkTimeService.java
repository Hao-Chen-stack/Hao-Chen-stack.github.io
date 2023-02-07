package com.cykj.service;

import com.cykj.bean.Tblworktime;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface TblworkTimeService {
    //查询工作时间列表
    List<Tblworktime> findWorkTimeByMacc(String managerAcc);

    //插入咨询师所选择的时间和日期
    int addTimeAndDate(int managerId, List<String> workTime, String workDate);
}
