package com.cykj;

import com.cykj.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TblOrderDetailTest {

    //增
    @Test
    public void insert(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("订单id");
        String orderId = sc.next();
        System.out.println("商品id");
        String goodsId = sc.next();
        System.out.println("商品库存");
        String goodsNum = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tblorderdetail(orderId,goodsId,goodsNum) values(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(orderId));
            preparedStatement.setInt(2, Integer.parseInt(goodsId));
            preparedStatement.setInt(3, Integer.parseInt(goodsNum));
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
        System.out.println("需要删除的订单详情id");
        String orderDetailId = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from tblorderdetail where orderDetailId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(orderDetailId));
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
        System.out.println("需要修改的订单详情id");
        String orderDetailId = sc.next();
        System.out.println("修改后的订单id");
        String orderId = sc.next();
        System.out.println("修改后的商品id");
        String goodsId = sc.next();
        System.out.println("修改后的商品库存");
        String goodsNum = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update tblorderdetail set orderId = ?,goodsId = ?,goodsNum = ? where orderDetailId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(orderId));
            preparedStatement.setInt(2, Integer.parseInt(goodsId));
            preparedStatement.setInt(3, Integer.parseInt(goodsNum));
            preparedStatement.setInt(4, Integer.parseInt(orderDetailId));
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
        String sql = "select * from tblorderdetail";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String orderDetailId = resultSet.getString("orderDetailId");
                String orderId = resultSet.getString("orderId");
                String goodsId = resultSet.getString("goodsId");
                String goodsNum = resultSet.getString("goodsNum");
                System.out.println(orderDetailId+"\t"+orderId +"\t"+goodsId+"\t"+goodsNum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
    }

}
