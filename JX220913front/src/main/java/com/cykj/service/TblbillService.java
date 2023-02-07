package com.cykj.service;

import com.cykj.bean.Tblbill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblbillService {
    //根据用户账号查询对应的我的账户
    List<Tblbill> findBillListByUAcc(String userAcc,int page, int size);

    //根据用户账号查询对应的我的账户的总条数
    int findBillListByUAccCount(String userAcc);

    //根据用户账号查询对应的余额
    String findUserBalanceByUAcc(String userAcc);

    //插入消费记录
    int addBillMsg(Tblbill tblbill);

}
