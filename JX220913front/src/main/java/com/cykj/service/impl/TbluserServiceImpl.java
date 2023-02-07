package com.cykj.service.impl;

import com.cykj.bean.Tbluser;
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
    public int findUser(String userAcc, String userPwd) {
        return tbluserMapper.findUser(userAcc,userPwd);
    }

    @Override
    public int findAcc(String userAcc) {
        return tbluserMapper.findAcc(userAcc);
    }

    @Override
    public int addUser(Tbluser tbluser) {
        if (tbluser.getUserName()==null || tbluser.getUserName().equals("")){
            tbluser.setUserName("未命名用户");
        }else if (tbluser.getUserPhone()==null || tbluser.getUserPhone().equals("")){
            tbluser.setUserPhone("用户未提供");
        }
        return tbluserMapper.addUser(tbluser);
    }

    @Override
    public List<Tbluser> findUserNameById(long userId) {
        return tbluserMapper.findUserNameById(userId);
    }

    @Override
    public int updateUserBalance(double code, String userAcc) {
        return tbluserMapper.updateUserBalance(code,userAcc);
    }

    @Override
    public int updateUserBalanceByUAccForPaper(String userAcc) {
        return tbluserMapper.updateUserBalanceByUAccForPaper(userAcc);
    }

    @Override
    public double findUserBalanceByUAcc(String userAcc) {
        return tbluserMapper.findUserBalanceByUAcc(userAcc);
    }
}
