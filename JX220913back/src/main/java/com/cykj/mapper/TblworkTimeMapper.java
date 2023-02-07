package com.cykj.mapper;

import com.cykj.bean.Tblworktime;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface TblworkTimeMapper {
    //查询工作时间列表
    List<Tblworktime> findWorkTimeByMacc(@Param("managerAcc") String managerAcc);

    //插入咨询师所选择的时间和日期
    int addTimeAndDate(@Param("managerId") int managerId,
                       @Param("workTime") List<String> workTime,
                       @Param("workDate") String workDate);
}
