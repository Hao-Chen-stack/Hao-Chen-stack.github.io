package com.cykj.service.impl;

import com.cykj.bean.Tbluser;
import com.cykj.mapper.TblmanagerMapper;
import com.cykj.mapper.TbluserMapper;
import com.cykj.service.TbluserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbluserServiceImpl implements TbluserService {
    @Autowired
    private TbluserMapper tbluserMapper;

    @Override
    public List<Tbluser> findUserList(Tbluser tbluser, int page, int size) {
        return tbluserMapper.findUserList(tbluser,page,size);
    }

    @Override
    public int findUserCount(Tbluser tbluser) {
        return tbluserMapper.findUserCount(tbluser);
    }

    @Override
    public int updateDelUser(long userId) {
        return tbluserMapper.updateDelUser(userId);
    }

    @Override
    public int rePwd(long userId) {
        return tbluserMapper.rePwd(userId);
    }

    @Override
    public int onAndOffUser(long userId,long userState) {
        return tbluserMapper.onAndOffUser(userId,userState);
    }

    @Override
    public List<Tbluser> findUserNameById(long userId) {
        return tbluserMapper.findUserNameById(userId);
    }

    @Override
    public int updateUBalanceByUId(String managerAcc, long userId) {
        return tbluserMapper.updateUBalanceByUId(managerAcc,userId);
    }

    @Override
    public double findUserBalanceByUId(long userId) {
        return tbluserMapper.findUserBalanceByUId(userId);
    }


}
