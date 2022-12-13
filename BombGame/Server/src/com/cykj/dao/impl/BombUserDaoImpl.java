package com.cykj.dao.impl;

import com.cykj.bean.BombUser;
import com.cykj.dao.BombUserDao;
import com.cykj.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BombUserDaoImpl implements BombUserDao {
    //注册方法
    @Override
    public boolean logon(String userId, String userName, String password) {
        DbUtils dbUtils = DbUtils.getInstance();//调用连接数据库的实例方法
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = dbUtils.getConnection();
        //先判断数据库内是否有数据跟注册的数据重复
        String sql1 =  "select userid from bomb_user where userid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, userId);//从1开始，第几个?
            resultSet = preparedStatement.executeQuery();
            //判断账号重复
            if (resultSet.next()){
                return false;
            }
            String sql = "insert into bomb_user(userid,username,userpwd,regtime) values(?,?,?,now())";
            //防止SQL语句的注入
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }

        return true;
    }
    //登录方法
    @Override
    public boolean login(String acc, String pwd) {
        //声明一个变量用来判断是否迭代到数据库中的数据
        boolean re = false; //变量的作用域，只在当前的花括号{}里有效
        DbUtils dbUtils = DbUtils.getInstance();    //直接调用实例方法
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from bomb_user where userid = ? and userpwd = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,acc);
            preparedStatement.setString(2,pwd);
            resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            //判断是否迭代到了数据库内存在的账号和密码
            if (resultSet.next()) {
                //  判断账号密码
                if (acc.equals(resultSet.getString("userid")) && pwd.equals(resultSet.getString("userpwd"))) {
                    System.out.println("登录成功");
                    re = true;
                } else {
                    re = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return re;
    }

    //将userId和用户名传进JList的方法
    @Override
    public List<BombUser> selectUser(String userId) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from bomb_user";
        List<BombUser> bombUsers = new ArrayList<>();//将数据库查询到的结果赋值给字符串数组
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();//执行查询操作
            while (resultSet.next()){
                String uId = resultSet.getString("userid");
                String name = resultSet.getString("username");
                BombUser bombUser = new BombUser();
                bombUser.setUserid(uId);
                bombUser.setUsername(name);
                bombUsers.add(bombUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return bombUsers;
    }
}
