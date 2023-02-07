package com.cykj.service.impl;

import com.cykj.bean.Tblmanager;
import com.cykj.mapper.TblareaMapper;
import com.cykj.mapper.TblmanagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblmanagerServiceImpl implements com.cykj.service.TblmanagerService {
    @Autowired
    private TblmanagerMapper tblmanagerMapper;

    @Autowired
    private TblareaMapper tblareaMapper;

    @Override
    public int findManager(String managerAcc, String managerPwd) {
        return tblmanagerMapper.findManager(managerAcc,managerPwd);
    }

    @Override
    public String findRealNameByAcc(String managerAcc) {
        return tblmanagerMapper.findRealNameByAcc(managerAcc);
    }

    @Override
    public List<Tblmanager> findManagerList(Tblmanager tblmanager, int page, int size) {
        return tblmanagerMapper.findManagerList(tblmanager,page,size);
    }

    @Override
    public int findManagerCount(Tblmanager tblmanager) {
        return tblmanagerMapper.findManagerCount(tblmanager);
    }

    @Override
    public int updateDelManager(long managerId) {
        return tblmanagerMapper.updateDelManager(managerId);
    }

    @Override
    public int rePwd(long managerId) {
        return tblmanagerMapper.rePwd(managerId);
    }

    @Override
    public int onAndOffManager(long managerId, long managerStatus) {
        return tblmanagerMapper.onAndOffManager(managerId,managerStatus);
    }

    @Override
    public int addManager(Tblmanager tblmanager,String[] areaName) {
        int i = tblmanagerMapper.addManager(tblmanager);
        if(areaName!=null && areaName.length>0){
            i = tblareaMapper.addArea(tblmanager.getManagerId(),areaName);
        }
        if (i>0){
            i=1;
        }
        return i;

    }

    @Override
    public int findAcc(String managerAcc) {
        return tblmanagerMapper.findAcc(managerAcc);
    }

    @Override
    public String findmanagerBalanceByAcc(String managerAcc) {
        return tblmanagerMapper.findmanagerBalanceByAcc(managerAcc);
    }

    @Override
    public long findIdByAcc(String managerAcc) {
        return tblmanagerMapper.findIdByAcc(managerAcc);
    }

    @Override
    public double findPriceByAcc(String managerAcc) {
        return tblmanagerMapper.findPriceByAcc(managerAcc);
    }

    @Override
    public int updateMBalanceByMAcc(String managerAcc) {
        return tblmanagerMapper.updateMBalanceByMAcc(managerAcc);
    }

    @Override
    public int findRoleIdByMAcc(String managerAcc) {
        return tblmanagerMapper.findRoleIdByMAcc(managerAcc);
    }
}
