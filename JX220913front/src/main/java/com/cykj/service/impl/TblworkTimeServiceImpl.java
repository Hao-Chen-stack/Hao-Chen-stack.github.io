package com.cykj.service.impl;

import com.cykj.bean.Tblworktime;
import com.cykj.mapper.TblworkTimeMapper;
import com.cykj.service.TblworkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblworkTimeServiceImpl implements TblworkTimeService {
    @Autowired
    private TblworkTimeMapper tblworkTimeMapper;

    @Override
    public List<Tblworktime> findWorkTimeMsg(String managerAcc,String workDate) {
        return tblworkTimeMapper.findWorkTimeMsg(managerAcc,workDate);
    }

    @Override
    public int findWorkTimeMsgCount(String managerAcc, String workDate) {
        return tblworkTimeMapper.findWorkTimeMsgCount(managerAcc,workDate);
    }
}
