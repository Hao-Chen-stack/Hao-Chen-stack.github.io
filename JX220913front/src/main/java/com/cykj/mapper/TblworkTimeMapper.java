package com.cykj.mapper;

import com.cykj.bean.Tblworktime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblworkTimeMapper {
    //通过咨询师账号查找工作时间的信息
    List<Tblworktime> findWorkTimeMsg(@Param("managerAcc") String managerAcc,
                                      @Param("workDate") String workDate);

    //获取通过咨询师账号查找工作时间的信息的总条数
    int findWorkTimeMsgCount(@Param("managerAcc") String managerAcc,
                             @Param("workDate") String workDate);

}
