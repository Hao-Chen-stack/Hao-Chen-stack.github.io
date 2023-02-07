package com.cykj.service.impl;

import com.cykj.bean.Tblevaluate;
import com.cykj.mapper.TblevaluateMapper;
import com.cykj.service.TblevaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblevaluateServiceImpl implements TblevaluateService {
    @Autowired
    private TblevaluateMapper tblevaluateMapper;

    @Override
    public List<Tblevaluate> findEvaListByMAcc(String managerAcc,long userId) {
        return tblevaluateMapper.findEvaListByMAcc(managerAcc,userId);
    }

}
