package com.cykj;

import com.cykj.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TblUserTest {
    //增
    @Test
    public void insert(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("用户账号");
        String userAcc = sc.next();
        System.out.println("用户密码");
        String userPwd = sc.next();
        System.out.println("用户性别");
        String userSex = sc.next();
        System.out.println("用户状态");
        String userStatus = sc.next();
        System.out.println("用户手机号");
        String userPhone = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tbluser(userAcc,userPwd,userSex,userStatus,userPhone,createTime) values(?,?,?,?,?,now())";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userAcc);
            preparedStatement.setString(2, userPwd);
            preparedStatement.setInt(3, Integer.parseInt(userSex));
            preparedStatement.setInt(4, Integer.parseInt(userStatus));
            preparedStatement.setString(5, userPhone);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(null,preparedStatement,connection);
        }
    }

    //删
    @Test
    public void delete(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要删除的用户id");
        String userId = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from tbluser where userId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(userId));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(null,preparedStatement,connection);
        }
    }

    //改
    @Test
    public void update(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要修改的用户id");
        String userId = sc.next();
        System.out.println("修改后的用户账号");
        String userAcc = sc.next();
        System.out.println("修改后的用户密码");
        String userPwd = sc.next();
        System.out.println("修改后的用户性别");
        String userSex = sc.next();
        System.out.println("修改后的用户状态");
        String userStatus = sc.next();
        System.out.println("修改后的用户手机号");
        String userPhone = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update tbluser set userAcc = ?,userPwd = ?,userSex = ?,userStatus = ?,userPhone = ? where userId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userAcc);
            preparedStatement.setString(2, userPwd);
            preparedStatement.setInt(3, Integer.parseInt(userSex));
            preparedStatement.setInt(4, Integer.parseInt(userStatus));
            preparedStatement.setInt(5, Integer.parseInt(userPhone));
            preparedStatement.setInt(6, Integer.parseInt(userId));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(null,preparedStatement,connection);
        }
    }

    //查
    @Test
    public void select(){
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from tbluser";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String userId = resultSet.getString("userId");
                String userAcc = resultSet.getString("userAcc");
                String userPwd = resultSet.getString("userPwd");
                String userSex = resultSet.getString("userSex");
                String userStatus = resultSet.getString("userStatus");
                String userPhone = resultSet.getString("userPhone");
                String createTime = resultSet.getString("createTime");
                System.out.println(userId+"\t"+userAcc+"\t"+userPwd+"\t"+userSex+"\t"+userStatus+"\t"+userPhone+"\t"+createTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
    }


}
