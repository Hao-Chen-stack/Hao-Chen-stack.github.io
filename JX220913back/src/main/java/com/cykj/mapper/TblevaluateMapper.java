package com.cykj.mapper;

import com.cykj.bean.Tblevaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblevaluateMapper {
    //根据咨询师账号查询评价
    List<Tblevaluate> findEvaListByMAcc(@Param("managerAcc") String managerAcc,
                                        @Param("userId") long userId);

}
