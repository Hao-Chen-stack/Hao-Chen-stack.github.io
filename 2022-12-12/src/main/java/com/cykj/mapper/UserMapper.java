package com.cykj.mapper;

import com.cykj.bean.Tbluser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //查
    public List<Tbluser> findUserList();
    //增
    public int addUser(Tbluser tbluser);
    //改
    public int updateUser(Tbluser tbluser);
    //删
    public int delUser(@Param("userId") int userId);
    //查询所有用户的收货地址
    public List<Tbluser> findUserAddress(@Param("userId") int userId);
    //查询所有用户的收藏夹列表
    public List<Tbluser> findUserCollection(@Param("userId") int userId);
}
