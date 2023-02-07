package com.cykj.service;


import com.cykj.bean.Tblmanager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblmanagerService {
    //登录
    int findManager(String managerAcc, String managerPwd);
    //根据管理员账号查询管理员昵称
    String findRealNameByAcc(String managerAcc);

    //查询后台用户列表
    List<Tblmanager> findManagerList(Tblmanager tblmanager, int page, int size);

    //查询后台用户总条数
    int findManagerCount(Tblmanager tblmanager);

    //逻辑删除用户,状态改为已删除
    int updateDelManager(long managerId);

    //重置密码
    int rePwd(long managerId);

    //启用和禁用用户
    int onAndOffManager(long managerId, long managerStatus);

    //添加后台用户
    int addManager(Tblmanager tblmanager,String[] areaName);

    //判断新增用户账号是否重复
    int findAcc(String managerAcc);

    //根据后台用户账号查询后台用户余额
    String findmanagerBalanceByAcc(String managerAcc);

    //通过后台用户账号查询managerId
    long findIdByAcc(String managerAcc);

    //根据后台用户账号查询咨询师的价格
    double findPriceByAcc(String managerAcc);

    //根据后台用户账号产生余额增加
    int updateMBalanceByMAcc(String managerAcc);

    //根据后台用户账号查询角色id
    int findRoleIdByMAcc (String managerAcc);
}
