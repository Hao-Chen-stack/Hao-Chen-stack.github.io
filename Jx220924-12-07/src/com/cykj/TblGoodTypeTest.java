package com.cykj;

import com.cykj.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TblGoodTypeTest {
    //增
    @Test
    public void insert(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("管理员id");
        String managerId = sc.next();
        System.out.println("商品类型名称");
        String gtypeName = sc.next();
        System.out.println("父类id");
        String parentId = sc.next();
        System.out.println("状态");
        String gtypeStatus = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tblgoodtype(managerId,gtypeName,parentId,gtypeStatus,createTime) values(?,?,?,?,now())";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(managerId));
            preparedStatement.setString(2, gtypeName);
            preparedStatement.setInt(3, Integer.parseInt(parentId));
            preparedStatement.setInt(4, Integer.parseInt(gtypeStatus));
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
        System.out.println("需要删除的商品类型id");
        String gtypeId = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from tblgoodtype where gtypeId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(gtypeId));
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
        System.out.println("需要修改的商品类型id");
        String gtypeId = sc.next();
        System.out.println("修改后的管理员id");
        String managerId = sc.next();
        System.out.println("修改后的商品类型名称");
        String gtypeName = sc.next();
        System.out.println("修改后的父类id");
        String parentId = sc.next();
        System.out.println("修改后的状态");
        String gtypeStatus = sc.next();


        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update tblgoodtype set managerId = ?,gtypeName = ?,parentId = ?,gtypeStatus = ? ,updateTime = now() where gtypeId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(managerId ));
            preparedStatement.setString(2, gtypeName);
            preparedStatement.setInt(3, Integer.parseInt(parentId));
            preparedStatement.setInt(4, Integer.parseInt(gtypeStatus));
            preparedStatement.setInt(5, Integer.parseInt(gtypeId ));
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
        String sql = "select * from tblgoodtype";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String managerId = resultSet.getString("managerId");
                String gtypeName = resultSet.getString("gtypeName");
                String parentId = resultSet.getString("parentId");
                String gtypeStatus = resultSet.getString("gtypeStatus");
                String createTime = resultSet.getString("createTime");
                String updateTime = resultSet.getString("updateTime");
                System.out.println(managerId+"\t"+gtypeName +"\t"+parentId+"\t"+gtypeStatus+"\t"+createTime+"\t"+updateTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
    }
}
