package com.cykj;

import com.cykj.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TblAddressTest {
    //增
    @Test
    public void insert(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("用户id");
        String userId = sc.next();
        System.out.println("区域id");
        String regionId = sc.next();
        System.out.println("门牌地址");
        String houseAddr = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tbladdress(userId,regionId,houseAddr) values(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(userId));
            preparedStatement.setInt(2, Integer.parseInt(regionId));
            preparedStatement.setString(3, houseAddr);
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
        String sql = "delete from tbladdress where userId = ?";
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
        System.out.println("修改后的区域id");
        String regionId = sc.next();
        System.out.println("修改后的门牌地址");
        String houseAddr = sc.next();
        System.out.println("需要修改的用户id");
        String userId = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update tbladdress set regionId = ?,houseAddr = ? where userId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(regionId));
            preparedStatement.setString(2, houseAddr);
            preparedStatement.setInt(3, Integer.parseInt(userId));
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
        String sql = "select * from tbladdress";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String userId = resultSet.getString("userId");
                String regionId = resultSet.getString("regionId");
                String houseAddr = resultSet.getString("houseAddr");
                System.out.println(userId+"\t"+regionId+"\t"+houseAddr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
    }


}
