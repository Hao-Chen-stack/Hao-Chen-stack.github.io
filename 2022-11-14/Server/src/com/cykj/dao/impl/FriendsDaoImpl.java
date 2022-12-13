package com.cykj.dao.impl;

import com.cykj.bean.TFriend;
import com.cykj.bean.TGroup;
import com.cykj.dao.FriendsDao;
import com.cykj.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendsDaoImpl implements FriendsDao {
    @Override
    public List<TGroup> selectGroupName() {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from t_group";
        List<TGroup> tGroups = new ArrayList<>();//将数据库查询到的结果赋值给字符串数组
        try {
            preparedStatement = connection.prepareStatement(sql);//预编译
            resultSet = preparedStatement.executeQuery();//执行查询操作
            while (resultSet.next()){
                String groupId = resultSet.getString("groupid");//分组id
                String groupName = resultSet.getString("groupname");//分组名字
                TGroup tGroup = new TGroup();
                tGroup.setGroupid(groupId);
                tGroup.setGroupname(groupName);
                tGroups.add(tGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return tGroups;
    }

    @Override
    public List<TFriend> relation(String qqId) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from t_friend where qqid = ?";
        List<TFriend> tFriends = new ArrayList<>();//将数据库查询到的结果赋值给字符串数组
        try {
            preparedStatement = connection.prepareStatement(sql);//预编译
            preparedStatement.setString(1,qqId);
            resultSet = preparedStatement.executeQuery();//执行查询操作
            while (resultSet.next()){
                String groupId = resultSet.getString("groupid");//分组id
                String friendname = resultSet.getString("friendname");//分组名字
                String friendId = resultSet.getString("friendid");//朋友id
                String qid = resultSet.getString("qqid");//QQid
                TFriend tFriend = new TFriend();
                tFriend.setGroupid(groupId);
                tFriend.setFriendid(friendId);
                tFriend.setQqid(qid);
                tFriend.setFriendname(friendname);
                tFriends.add(tFriend);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return tFriends;
    }
}
