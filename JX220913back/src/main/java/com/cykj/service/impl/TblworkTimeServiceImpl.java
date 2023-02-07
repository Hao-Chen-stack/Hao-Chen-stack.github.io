package com.cykj.service.impl;

import com.cykj.bean.Tblworktime;
import com.cykj.mapper.TblworkTimeMapper;
import com.cykj.service.TblworkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TblworkTimeServiceImpl implements TblworkTimeService {

    @Autowired
    private TblworkTimeMapper tblworkTimeMapper;

    @Override
    public List<Tblworktime> findWorkTimeByMacc(String managerAcc) {
        return tblworkTimeMapper.findWorkTimeByMacc(managerAcc);
    }

    @Override
    public int addTimeAndDate(int managerId, List<String> workTime, String workDate) {
        return tblworkTimeMapper.addTimeAndDate(managerId,workTime,workDate);
    }
}
