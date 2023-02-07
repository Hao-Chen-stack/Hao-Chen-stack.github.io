package com.cykj.service.impl;

import com.cykj.bean.Tblappointment;
import com.cykj.bean.Tblmanager;
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
    public List<Tblappointment> findAppointList(Tblappointment tblappointment, int page, int size) {
        return tblappointmentMapper.findAppointList(tblappointment,page,size);
    }

    @Override
    public int findAppointCount(Tblappointment tblappointment) {
        return tblappointmentMapper.findAppointCount(tblappointment);
    }

    @Override
    public List<Tblmanager> findRealName(String areaName) {
        return tblappointmentMapper.findRealName(areaName);
    }

    @Override
    public List<Tblmanager> doctorMsg(String managerAcc) {
        return tblappointmentMapper.doctorMsg(managerAcc);
    }

    @Override
    public int addUserCheckMsg(Tblappointment tblappointment) {
        return tblappointmentMapper.addUserCheckMsg(tblappointment);
    }

    @Override
    public int updateWorkTimeState(int timeState) {
        return tblappointmentMapper.updateWorkTimeState(timeState);
    }

    @Override
    public List<Tblappointment> findAppointListByAppointId(long appointmentId) {
        return tblappointmentMapper.findAppointListByAppointId(appointmentId);
    }

    @Override
    public int updateCompleteTimeByAppointmentId(long appointmentId) {
        return tblappointmentMapper.updateCompleteTimeByAppointmentId(appointmentId);
    }

    @Override
    public List<Tblappointment> showWinByStopForUser(String userAcc) {
        return tblappointmentMapper.showWinByStopForUser(userAcc);
    }

    @Override
    public int stopAppointCount(String userAcc) {
        return tblappointmentMapper.stopAppointCount(userAcc);
    }

    @Override
    public int updateUserStopAns(String userAcc) {
        return tblappointmentMapper.updateUserStopAns(userAcc);
    }
}
