package com.cykj.mapper;

import com.cykj.bean.Tbluser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbluserMapper {
    //查询用户列表
    List<Tbluser> findUserList(@Param("tbluser") Tbluser tbluser,
                               @Param("page") int page,
                               @Param("size") int size);

    //查询用户总条数
    int findUserCount(Tbluser tbluser);

    //逻辑删除用户,状态改为已删除
    int updateDelUser(@Param("userId") long userId);

    //重置密码
    int rePwd(@Param("userId") long userId);

    //启用和禁用用户
    int onAndOffUser(@Param("userId") long userId,
                     @Param("userState") long userState);

    //通过用户id查找用户名
    List<Tbluser> findUserNameById(@Param("userId") long userId);


    //通过用户id在已确认预约时进行余额扣除
    int updateUBalanceByUId(@Param("managerAcc") String managerAcc,
                            @Param("userId") long userId);

    //根据用户id查询用户余额
    double findUserBalanceByUId(@Param("userId") long userId);
}
