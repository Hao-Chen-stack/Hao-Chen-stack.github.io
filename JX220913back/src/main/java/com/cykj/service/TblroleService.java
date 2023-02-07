package com.cykj.service;

import org.apache.ibatis.annotations.Param;

public interface TblroleService {
    //根据管理员账号查找角色名字
    String findRoleNameByAcc(String managerAcc);
}
