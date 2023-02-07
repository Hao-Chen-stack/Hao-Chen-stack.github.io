package com.cykj.mapper;

import com.cykj.bean.Tblbill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblbillMapper {
    //根据后台用户账号查询账户资金和业务收入情况
    List<Tblbill> findBillListByManagerAcc(@Param("managerAcc") String managerAcc);

    //插入消费记录
    int addBillMsg(Tblbill tblbill);

}
