package com.cykj.mapper;

import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblmanager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblappointmentMapper {

    //查询预约列表
    List<Tblappointment> findAppointList(@Param("tblappointment") Tblappointment tblappointment,
                                         @Param("page") int page,
                                         @Param("size") int size);

    //查询总条数
    int findAppointCount(Tblappointment tblappointment);

    //根据领域名称查询医生名称
    List<Tblmanager> findRealName(@Param("areaName") String areaName);

    //根据账号查找医生信息
    List<Tblmanager> doctorMsg(@Param("managerAcc") String managerAcc);

    //将用户所选和填入信息插入数据库
    int addUserCheckMsg(Tblappointment tblappointment);

    //在点击我要预约之后更改工作时间状态
    int updateWorkTimeState(@Param("timeState") int timeState);

    //查询未分页的预约列表
    List<Tblappointment> findAppointListByAppointId(@Param("appointmentId") long appointmentId);

    //点击评价后插入对应的完成时间
    int updateCompleteTimeByAppointmentId(@Param("appointmentId") long appointmentId);

    //提示弹窗告知用户已终止的预约单子
    List<Tblappointment> showWinByStopForUser(@Param("userAcc") String userAcc);

    //查询已终止的预约单子的条数
    int stopAppointCount(@Param("userAcc") String userAcc);

    //咨询师点击不再提醒后修改弹窗的状态
    int updateUserStopAns(@Param("userAcc") String userAcc);
}
