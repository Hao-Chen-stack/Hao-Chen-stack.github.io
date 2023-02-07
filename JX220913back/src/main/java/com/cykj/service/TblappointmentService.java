package com.cykj.service;

import com.cykj.bean.Tblappointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblappointmentService {
    //根据咨询师账号查询所有预约列表
    List<Tblappointment> findAppointListByMAcc(String startDate, String endDate, Tblappointment tblappointment,int page, int size);

    //查询总条数---根据咨询师账号查询所有预约列表
    int findAppointCount(String startDate, String endDate,Tblappointment tblappointment);

    //查询未分页的预约列表
    List<Tblappointment> findAppointListByAppointId(long appointmentId);

    //根据预约列表id加入答复
    int updateAnswerByAppointId(String answer, long appointmentId);

    //点击确认预约时根据预约列表id更改状态
    int updateAppointStateByAppointId(long appointmentId);

    //根据预约id修改预约状态为预约失败
    int updateAppointStateByUId(long appointmentId);

    //分条件查询管理员端的预约列表
    List<Tblappointment> findAppointListBySomeCondition(String startDate, String endDate, Tblappointment tblappointment, int page, int size);

    //分条件查询管理员端的预约列表的总条数
    int findAppointListCountBySomeCondition(String startDate, String endDate,Tblappointment tblappointment);

    //根据预约id修改预约状态为已终止
    int updateAppointStateToStopByUId(long appointmentId);

    //提示弹窗告知咨询师已终止的预约单子
    List<Tblappointment> showWinByStopForDoctor(String managerAcc);

    //查询已终止的预约单子的条数
    int stopAppointCount(String managerAcc);

    //咨询师点击不再提醒后修改弹窗的状态
    int updateManagerStopAns(String managerAcc);

    //咨询师预约统计
    List<Tblappointment> findDoctorAppointCount(String startDate, String endDate,Tblappointment tblappointment);
}
