package com.cykj.service;

import com.cykj.bean.Tblworktime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblworkTimeService {
    //通过咨询师账号查找工作时间的信息
    List<Tblworktime> findWorkTimeMsg(String managerAcc,String workDate);

    //获取通过咨询师账号查找工作时间的信息的总条数
    int findWorkTimeMsgCount(String managerAcc, String workDate);
}
