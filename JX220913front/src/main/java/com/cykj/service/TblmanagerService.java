package com.cykj.service;

import com.cykj.bean.Tblmanager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblmanagerService {
    //根据医生账户查找名字
    List<Tblmanager> findRealNameByAcc(String managerAcc);

}
