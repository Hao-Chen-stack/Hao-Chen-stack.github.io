package com.cykj.service;

import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblevaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblevaluateService {

    //根据咨询师账号查询评价
    List<Tblevaluate> findEvaListByMAcc(String managerAcc);

    //插入用户评价
    int addUserEva(Tblevaluate tblevaluate);

    //评价完修改预约状态为已评价
    int updateAppointState(Tblappointment tblappointment);
}
