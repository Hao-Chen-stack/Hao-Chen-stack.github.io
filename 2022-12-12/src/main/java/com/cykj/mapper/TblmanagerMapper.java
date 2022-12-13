package com.cykj.mapper;

import com.cykj.bean.Tblmanager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblmanagerMapper {
    public List<Tblmanager> findManagerList();
    public List<Tblmanager> findManagerListByName(@Param("realName") String realName);
    public int addManager(Tblmanager tblmanager);
    public int delManager(@Param("managerId") int managerId);
    public int updateManager(Tblmanager tblmanager);
    public List<Tblmanager> findManager(@Param("roleId") int roleId);
    public List<Tblmanager> findManager2();
    public List<Tblmanager> findManager3();

    //多条件动态查询
    public List<Tblmanager> findManager4(@Param("roleId") int roleId,
                                         @Param("realName") String realName,
                                         @Param("managerStatus") int managerStatus);
    public int addManagerList(@Param("managerList") List<Tblmanager> managerList);
    //登录
    public Tblmanager login(@Param("managerAcc") String managerAcc);
    //注册
    public int logon(Tblmanager tblmanager);
    //判断数据库中是否已有有账号
    public int logonAcc(@Param("managerAcc") String managerAcc);
}
