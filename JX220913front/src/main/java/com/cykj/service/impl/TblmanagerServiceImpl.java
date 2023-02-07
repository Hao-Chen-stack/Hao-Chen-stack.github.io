package com.cykj.service.impl;

import com.cykj.bean.Tblmanager;
import com.cykj.mapper.TblmanagerMapper;
import com.cykj.service.TblmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblmanagerServiceImpl implements TblmanagerService {
    @Autowired
    private TblmanagerMapper tblmanagerMapper;

    @Override
    public List<Tblmanager> findRealNameByAcc(String managerAcc) {
        return tblmanagerMapper.findRealNameByAcc(managerAcc);
    }

}
