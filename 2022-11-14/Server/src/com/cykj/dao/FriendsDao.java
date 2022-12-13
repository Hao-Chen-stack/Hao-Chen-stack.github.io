package com.cykj.dao;

import com.cykj.bean.TFriend;
import com.cykj.bean.TGroup;

import java.util.List;

public interface FriendsDao {
    List<TGroup> selectGroupName();//查询分组表获取组名
    List<TFriend> relation(String qqId);//查询好友和分组的关系
}
