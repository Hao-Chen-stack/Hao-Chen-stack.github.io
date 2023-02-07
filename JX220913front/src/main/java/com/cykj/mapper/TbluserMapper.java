package com.cykj.mapper;

import com.cykj.bean.Tbluser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbluserMapper {
    //登录
    int findUser(@Param("userAcc")String userAcc,
                 @Param("userPwd") String userPwd);

    //注册
    //判断账号是否重复
    int findAcc(@Param("userAcc")String userAcc);

    //插入用户
    int addUser(Tbluser tbluser);

    //通过用户id查找用户名
    List<Tbluser> findUserNameById(@Param("userId") long userId);

    //根据用户账户和输入数字来充值余额
    int updateUserBalance(@Param("code") double code ,
                          @Param("userAcc") String userAcc);

    //根据用户账户来扣除在线评估后的余额
    int updateUserBalanceByUAccForPaper(@Param("userAcc") String userAcc);

    //根据用户账户来查询余额
    double findUserBalanceByUAcc(@Param("userAcc") String userAcc);



}
