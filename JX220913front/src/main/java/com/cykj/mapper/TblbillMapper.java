package com.cykj.mapper;

import com.cykj.bean.Tblbill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblbillMapper {
    //根据用户账号查询对应的我的账户
    List<Tblbill> findBillListByUAcc(@Param("userAcc") String userAcc,
                                     @Param("page") int page,
                                     @Param("size") int size);

    //根据用户账号查询对应的我的账户的总条数
    int findBillListByUAccCount(@Param("userAcc") String userAcc);

    //根据用户账号查询对应的余额
    String findUserBalanceByUAcc(@Param("userAcc") String userAcc);

    //插入消费记录
    int addBillMsg(Tblbill tblbill);
}
