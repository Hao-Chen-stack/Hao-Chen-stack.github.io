package com.cykj.service.impl;

import com.cykj.bean.Tblappointment;
import com.cykj.mapper.TblappointmentMapper;
import com.cykj.service.TblappointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblappointmentServiceImpl implements TblappointmentService {
    @Autowired
    private TblappointmentMapper tblappointmentMapper;


    @Override
    public List<Tblappointment> findAppointListByMAcc(String startDate, String endDate, Tblappointment tblappointment,int page, int size) {
        return tblappointmentMapper.findAppointListByMAcc(startDate,endDate,tblappointment,page,size);
    }

    @Override
    public int findAppointCount(String startDate, String endDate, Tblappointment tblappointment) {
        return tblappointmentMapper.findAppointCount(startDate,endDate,tblappointment);
    }

    @Override
    public List<Tblappointment> findAppointListByAppointId(long appointmentId) {
        return tblappointmentMapper.findAppointListByAppointId(appointmentId);
    }

    @Override
    public int updateAnswerByAppointId(String answer, long appointmentId) {
        return tblappointmentMapper.updateAnswerByAppointId(answer,appointmentId);
    }

    @Override
    public int updateAppointStateByAppointId(long appointmentId) {
        return tblappointmentMapper.updateAppointStateByAppointId(appointmentId);
    }

    @Override
    public int updateAppointStateByUId(long appointmentId) {
        return tblappointmentMapper.updateAppointStateByUId(appointmentId);
    }

    @Override
    public List<Tblappointment> findAppointListBySomeCondition(String startDate, String endDate, Tblappointment tblappointment, int page, int size) {
        return tblappointmentMapper.findAppointListBySomeCondition(startDate, endDate, tblappointment, page, size);
    }

    @Override
    public int findAppointListCountBySomeCondition(String startDate, String endDate, Tblappointment tblappointment) {
        return tblappointmentMapper.findAppointListCountBySomeCondition(startDate, endDate, tblappointment);
    }

    @Override
    public int updateAppointStateToStopByUId(long appointmentId) {
        return tblappointmentMapper.updateAppointStateToStopByUId(appointmentId);
    }

    @Override
    public List<Tblappointment> showWinByStopForDoctor(String managerAcc) {
        return tblappointmentMapper.showWinByStopForDoctor(managerAcc);
    }

    @Override
    public int stopAppointCount(String managerAcc) {
        return tblappointmentMapper.stopAppointCount(managerAcc);
    }

    @Override
    public int updateManagerStopAns(String managerAcc) {
        return tblappointmentMapper.updateManagerStopAns(managerAcc);
    }

    @Override
    public List<Tblappointment> findDoctorAppointCount(String startDate, String endDate,Tblappointment tblappointment) {
        return tblappointmentMapper.findDoctorAppointCount(startDate,endDate,tblappointment);
    }


}
