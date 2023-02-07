package com.cykj.mapper;

import com.cykj.bean.Tblmanager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblmanagerMapper {
    //根据医生账户查找名字
    List<Tblmanager> findRealNameByAcc(@Param("managerAcc") String managerAcc);


}
