package com.cykj.service;

import com.cykj.bean.Tblevaluate;

import java.util.List;

public interface TblevaluateService {

    //根据咨询师账号查询评价
    List<Tblevaluate> findEvaListByMAcc(String managerAcc,long userId);

}
