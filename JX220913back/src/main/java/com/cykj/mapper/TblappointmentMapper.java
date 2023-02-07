package com.cykj.mapper;

import com.cykj.bean.Tblappointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblappointmentMapper {

    //根据咨询师账号及其他条件查询所有预约列表
    List<Tblappointment> findAppointListByMAcc(@Param("startDate") String startDate,
                                               @Param("endDate") String endDate,
                                               @Param("tblappointment") Tblappointment tblappointment,
                                               @Param("page") int page,
                                               @Param("size") int size);

    //查询总条数---根据咨询师账号及其他条件查询所有预约列表
    int findAppointCount(@Param("startDate") String startDate,
                         @Param("endDate") String endDate,
                         @Param("tblappointment") Tblappointment tblappointment);

    //查询未分页的预约列表
    List<Tblappointment> findAppointListByAppointId(@Param("appointmentId") long appointmentId);

    //根据预约列表id加入答复
    int updateAnswerByAppointId(@Param("answer") String answer,
                                @Param("appointmentId") long appointmentId);

    //点击确认预约时根据预约列表id更改状态
    int updateAppointStateByAppointId(@Param("appointmentId") long appointmentId);

    //根据预约id修改预约状态为预约失败
    int updateAppointStateByUId(@Param("appointmentId") long appointmentId);

    //分条件查询管理员端的预约列表
    List<Tblappointment> findAppointListBySomeCondition(@Param("startDate") String startDate,
                                                        @Param("endDate") String endDate,
                                                        @Param("tblappointment") Tblappointment tblappointment,
                                                        @Param("page") int page,
                                                        @Param("size") int size);

    //分条件查询管理员端的预约列表的总条数
    int findAppointListCountBySomeCondition(@Param("startDate") String startDate,
                                            @Param("endDate") String endDate,
                                            @Param("tblappointment") Tblappointment tblappointment);
    //根据预约id修改预约状态为已终止
    int updateAppointStateToStopByUId(@Param("appointmentId") long appointmentId);

    //提示弹窗告知咨询师已终止的预约单子
    List<Tblappointment> showWinByStopForDoctor(@Param("managerAcc") String managerAcc);

    //查询已终止的预约单子的条数
    int stopAppointCount(@Param("managerAcc") String managerAcc);

    //咨询师点击不再提醒后修改弹窗的状态
    int updateManagerStopAns(@Param("managerAcc") String managerAcc);

    //咨询师预约统计
    List<Tblappointment> findDoctorAppointCount(@Param("startDate") String startDate,
                                                @Param("endDate") String endDate,
                                                @Param("tblappointment") Tblappointment tblappointment);
}
