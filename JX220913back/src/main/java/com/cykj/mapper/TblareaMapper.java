package com.cykj.mapper;

import org.apache.ibatis.annotations.Param;

public interface TblareaMapper {
    //添加咨询师对应的领域
    int addArea(@Param("managerId") long managerId,
                @Param("areaName") String[] areaName);

}
