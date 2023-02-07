package com.cykj.mapper;

import com.cykj.bean.Tblmanager;

import com.cykj.bean.Tbluser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblmanagerMapper {
    //登录
    int findManager(@Param("managerAcc")String managerAcc,
                 @Param("managerPwd") String managerPwd);

    //根据管理员账号查询管理员昵称
    String findRealNameByAcc(@Param("managerAcc") String managerAcc);

    //查询后台用户列表
    List<Tblmanager> findManagerList(@Param("tblmanager") Tblmanager tblmanager,
                                     @Param("page") int page,
                                     @Param("size") int size);

    //查询后台用户总条数
    int findManagerCount(Tblmanager tblmanager);

    //逻辑删除用户,状态改为已删除
    int updateDelManager(@Param("managerId") long managerId);

    //重置密码
    int rePwd(@Param("managerId") long managerId);

    //启用和禁用用户
    int onAndOffManager(@Param("managerId") long managerId,
                     @Param("managerStatus") long managerStatus);

    //添加后台用户
    int addManager(Tblmanager tblmanager);

    //判断新增用户账号是否重复
    int findAcc(@Param("managerAcc")String managerAcc);

    //根据后台用户账号查询后台用户余额
    String findmanagerBalanceByAcc(@Param("managerAcc") String managerAcc);

    //通过后台用户账号查询managerId
    long findIdByAcc(@Param("managerAcc")String managerAcc);

    //根据后台用户账号查询咨询师的价格
    double findPriceByAcc(@Param("managerAcc") String managerAcc);

    //根据后台用户账号产生余额增加
    int updateMBalanceByMAcc(@Param("managerAcc") String managerAcc);

    //根据后台用户账号查询角色id
    int findRoleIdByMAcc (@Param("managerAcc") String managerAcc);

}
