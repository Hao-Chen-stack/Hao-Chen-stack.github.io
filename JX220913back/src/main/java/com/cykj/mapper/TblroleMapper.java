package com.cykj.mapper;

import org.apache.ibatis.annotations.Param;

public interface TblroleMapper {
    //根据管理员账号查找角色名字
    String findRoleNameByAcc(@Param("managerAcc") String managerAcc);
}
