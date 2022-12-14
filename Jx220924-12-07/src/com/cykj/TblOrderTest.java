package com.cykj;

import com.cykj.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TblOrderTest {
    //增
    @Test
    public void insert(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("订单编号");
        String orderNo = sc.next();
        System.out.println("用户id");
        String userId = sc.next();
        System.out.println("地址id");
        String addressId = sc.next();
        System.out.println("订单状态");
        String orderStatus = sc.next();
        System.out.println("订单价格");
        String price = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tblorder(orderNo,userId,addressId,orderStatus,createTime,payTime,finishTime,price) values(?,?,?,?,now(),now(),now(),?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderNo);
            preparedStatement.setString(2,userId );
            preparedStatement.setInt(3, Integer.parseInt(addressId));
            preparedStatement.setInt(4, Integer.parseInt(orderStatus));
            preparedStatement.setDouble(5, Double.parseDouble(price));
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
        System.out.println("需要删除的订单id");
        String orderId = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from tblorder where orderId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(orderId));
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
        System.out.println("需要修改的订单id");
        String orderId = sc.next();
        System.out.println("修改后的订单编号");
        String orderNo = sc.next();
        System.out.println("修改后的用户id");
        String userId = sc.next();
        System.out.println("修改后的地址id");
        String addressId = sc.next();
        System.out.println("修改后的订单状态");
        String orderStatus = sc.next();
        System.out.println("修改后的订单价格");
        String price = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update tblorder set orderNo = ?,userId = ?,addressId = ?,orderStatus = ? ,payTime = now(),finishTime = now(),price = ? where orderId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(orderNo));
            preparedStatement.setInt(2, Integer.parseInt(userId));
            preparedStatement.setInt(3, Integer.parseInt(addressId));
            preparedStatement.setInt(4, Integer.parseInt(orderStatus));
            preparedStatement.setDouble(5, Double.parseDouble(price));
            preparedStatement.setInt(6, Integer.parseInt(orderId ));
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
        String sql = "select * from tblorder";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String orderNo = resultSet.getString("orderNo");
                String userId = resultSet.getString("userId");
                String addressId = resultSet.getString("addressId");
                String orderStatus = resultSet.getString("orderStatus");
                String createTime = resultSet.getString("createTime");
                String payTime = resultSet.getString("payTime");
                System.out.println(orderNo+"\t"+userId +"\t"+addressId+"\t"+orderStatus+"\t"+createTime+"\t"+payTime );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
    }

}
