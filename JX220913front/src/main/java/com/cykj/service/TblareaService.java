package com.cykj.service;

import com.cykj.bean.Tblarea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblareaService {
    //通过医生账号查找擅长领域
    List<Tblarea> findAreaNameByMAcc(String managerAcc);
}
