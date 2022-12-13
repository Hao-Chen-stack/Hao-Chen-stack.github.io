package com.cykj.dao.impl;

import com.cykj.dao.UserDao;
import com.cykj.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    //注册方法
    @Override
    public boolean logon(String userid, String name, String password, int age, String address) {
        DbUtils dbUtils = DbUtils.getInstance();//调用连接数据库的实例方法
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dbUtils.getConnection();
            //先判断数据库内是否有数据跟注册的数据重复
            String sql1 =  "select qqid from t_qquser where qqid = ?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, userid);//从1开始，第几个?
            resultSet = preparedStatement.executeQuery();
            //判断账号重复
            if (resultSet.next()){
                return false;
            }
            String sql = "insert into t_qquser(qqid,nickname,password,age,address) values(?,?,?,?,?)";
            //防止SQL语句的注入
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userid);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, address);
            preparedStatement.executeUpdate();//   insert  update  delete同一个方法,刷新修改一下数据库表的显示
        } catch (SQLException e) {
            e.printStackTrace();
        }finally { //资源永远被释放
            //result语句
            //            有就传，没有就传空（null）
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return true;
    }

    //判断账号是否存在
    @Override
    public boolean idExist(String acc) {
        boolean re = false;
        DbUtils dbUtils = DbUtils.getInstance();    //直接调用实例方法
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select qqid from t_qquser where qqid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,acc);
            resultSet = preparedStatement.executeQuery();
            re = resultSet.next();//判断账号密码是否重复，如果迭代到了返回一个re = false
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return re;
    }

    //登陆方法-----判断账号或密码是否一致
    @Override
    public boolean login(String acc, String pwd) {
        //声明一个变量用来判断是否迭代到数据库中的数据
        boolean re = false; //变量的作用域，只在当前的花括号{}里有效
        DbUtils dbUtils = DbUtils.getInstance();    //直接调用实例方法
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from t_qquser where qqid = ? and password = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,acc);
            preparedStatement.setString(2,pwd);
            resultSet = preparedStatement.executeQuery();
//            re = resultSet.next();//判断账号密码是否重复，如果迭代到了返回一个re = false
            System.out.println(resultSet);


            if (resultSet.next()) {

                //  判断账号密码
                if (acc.equals(resultSet.getString("qqid")) && pwd.equals(resultSet.getString("password"))) {
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
}
