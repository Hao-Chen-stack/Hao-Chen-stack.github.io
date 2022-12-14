package com.cykj;

import com.cykj.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TblRegionTest {
    //增
    @Test
    public void insert(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("区域名称");
        String regionName = sc.next();
        System.out.println("父级id");
        String parentId = sc.next();
        System.out.println("区域状态");
        String regionStatus = sc.next();


        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tblregion(regionName,parentId,regionStatus) values(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, regionName);
            preparedStatement.setString(2,parentId);
            preparedStatement.setInt(3, Integer.parseInt(regionStatus));
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
        System.out.println("需要删除的区域id");
        String regionId = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from tblregion where regionId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(regionId));
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
        System.out.println("需要修改的区域id");
        String regionId = sc.next();
        System.out.println("修改后的区域名称");
        String regionName = sc.next();
        System.out.println("修改后的父级id");
        String parentId = sc.next();
        System.out.println("修改后的区域状态");
        String regionStatus = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update tblregion set regionName = ?,parentId = ?,regionStatus = ? where regionId  = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, regionName);
            preparedStatement.setString(2, parentId);
            preparedStatement.setInt(3, Integer.parseInt(regionStatus));
            preparedStatement.setInt(4, Integer.parseInt(regionId));
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
        String sql = "select * from tblregion";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String regionName = resultSet.getString("regionName");
                String parentId = resultSet.getString("parentId");
                int regionStatus = resultSet.getInt("regionStatus");
                System.out.println(regionName+"\t"+parentId +"\t"+regionStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
    }


}
