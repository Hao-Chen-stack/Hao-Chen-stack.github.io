package com.cykj.mapper;

import com.cykj.bean.Tblarea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblareaMapper {
    //通过医生账号查找擅长领域
    List<Tblarea> findAreaNameByMAcc(@Param("managerAcc") String managerAcc);


}
