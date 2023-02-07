package com.cykj.mapper;

import com.cykj.bean.Tblpower;
import com.cykj.bean.Tblrole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblpowerMapper {
    //查询系统中的角色列表
    List<Tblrole> findRoleList();

    //根据角色id查询已分配的权限列表
    List<Tblpower> findDistributedPower(@Param("roleId") long roleId);

    //根据角色id查询未分配的权限列表
    List<Tblpower> findUnDistributedPower(long roleId);
    List<Tblpower> findUnDistributedPower_parent(@Param("childList") List<Tblpower> childList);

    //移除所有权限
    int delPowerByRoleId(@Param("roleId") long roleId);
}
