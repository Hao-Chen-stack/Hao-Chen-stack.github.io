package com.cykj.service.impl;

import com.cykj.bean.Tbluser;
import com.cykj.mapper.UserCountMapper;
import com.cykj.service.UserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCountServiceImpl implements UserCountService {
    @Autowired
    private UserCountMapper userCountMapper;

    @Override
    public List<Tbluser> findWeekNowList(Tbluser tbluser) {
        return userCountMapper.findWeekNowList(tbluser);
    }

    @Override
    public List<Tbluser> findMonthNowList(Tbluser tbluser) {
        return userCountMapper.findMonthNowList(tbluser);
    }

    @Override
    public List<Tbluser> findHalfYearNowList(List<String> yearMonths) {
        return userCountMapper.findHalfYearNowList(yearMonths);
    }
}
