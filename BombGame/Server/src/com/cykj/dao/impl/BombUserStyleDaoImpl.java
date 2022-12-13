package com.cykj.dao.impl;

import com.cykj.bean.BombUserstyle;
import com.cykj.dao.BombUserStyleDao;
import com.cykj.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BombUserStyleDaoImpl implements BombUserStyleDao {
    //将选择好的样式保存
    @Override
    public void style(BombUserstyle userstyle) {
        DbUtils dbUtils = DbUtils.getInstance();//调用连接数据库的实例方法
        Connection connection = null;// 定义但是未赋值就会报错 可以给个初始值null(空)
        // 执行SQL对象
        PreparedStatement preparedStatement = null;// 变量的作用域、变量需要初始化、close需要try-catch
        ResultSet resultSet = null;
        //结果
        try {
            dbUtils = DbUtils.getInstance();
            connection = dbUtils.getConnection();
            String sql = "insert into bomb_userstyle(userid,num,hat,dress)values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userstyle.getUserid());
            preparedStatement.setInt(2, userstyle.getNum());
            preparedStatement.setInt(3, userstyle.getHat());
            preparedStatement.setInt(4, userstyle.getDress());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
    }

    //查询样式
    @Override
    public BombUserstyle queryStyle(String id) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BombUserstyle userstyle = new BombUserstyle();
        String sql =  "select * from bomb_userstyle where userid=" + id;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userstyle.setHat(resultSet.getInt("hat"));
                userstyle.setNum(resultSet.getInt("num"));
                userstyle.setDress(resultSet.getInt("dress"));
                userstyle.setUserid(resultSet.getString("userid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return userstyle;
    }

    //删除样式
    @Override
    public void deleteUserStyle(String id) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = null;// 定义但是未赋值就会报错 可以给个初始值null(空)
        // 执行SQL对象
        PreparedStatement preparedStatement = null;// 变量的作用域、变量需要初始化、close需要try-catch
        connection=dbUtils.getConnection();
        String sql="delete from bomb_userstyle where userid=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(null,preparedStatement,connection);
        }
    }
}
