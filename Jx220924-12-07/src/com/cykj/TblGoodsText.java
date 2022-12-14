package com.cykj;

import com.cykj.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TblGoodsText {
    //增
    @Test
    public void insert(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("商品类型id");
        String gtypeId = sc.next();
        System.out.println("商品名称");
        String goodsName = sc.next();
        System.out.println("商品价格");
        String goodsPrice = sc.next();
        System.out.println("商品图片");
        String goodsImage = sc.next();
        System.out.println("商品详情");
        String goodsDetail= sc.next();
        System.out.println("商品库存");
        String goodsInventory= sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into tblgoods(gtypeId,goodsName,goodsPrice,goodsImage,goodsDetail,goodsInventory,createTime) values(?,?,?,?,?,?,now())";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(gtypeId));
            preparedStatement.setString(2, goodsName);
            preparedStatement.setDouble(3, Double.parseDouble(goodsPrice));
            preparedStatement.setString(4, goodsImage);
            preparedStatement.setString(5, goodsDetail);
            preparedStatement.setDouble(6, Double.parseDouble(goodsInventory));
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
        System.out.println("需要删除的商品id");
        String goodsId = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from tblgoods where goodsId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(goodsId));
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
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要修改的商品id");
        String goodsId = sc.next();
        System.out.println("修改后的商品类型id");
        String gtypeId = sc.next();
        System.out.println("修改后的商品名称");
        String goodsName = sc.next();
        System.out.println("修改后的商品价格");
        String goodsPrice = sc.next();
        System.out.println("修改后的商品图片");
        String goodsImage = sc.next();
        System.out.println("修改后的商品详情");
        String goodsDetail= sc.next();
        System.out.println("修改后的商品库存");
        String goodsInventory= sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update tblgoods set gtypeId = ?,goodsName = ?,goodsPrice = ?,goodsImage =?,goodsDetail = ?, goodsInventory =?,updateTime = now() where goodsId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(gtypeId));
            preparedStatement.setString(2, goodsName);
            preparedStatement.setDouble(3, Double.parseDouble(goodsPrice));
            preparedStatement.setString(4, goodsImage);
            preparedStatement.setString(5, goodsDetail);
            preparedStatement.setDouble(6, Double.parseDouble(goodsInventory));
            preparedStatement.setInt(7, Integer.parseInt(goodsId));
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
        String sql = "select * from tblgoods";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String goodsId = resultSet.getString("goodsId");
                String gtypeId = resultSet.getString("gtypeId");
                String goodsName = resultSet.getString("goodsName");
                String goodsPrice = resultSet.getString("goodsPrice");
                String goodsImage = resultSet.getString("goodsImage");
                String goodsDetail = resultSet.getString("goodsDetail");
                String goodsInventory = resultSet.getString("goodsInventory");
                String createTime = resultSet.getString("createTime");
                String updateTime = resultSet.getString("updateTime");
                System.out.println(goodsId+"\t"+gtypeId+"\t"+goodsName+"\t"+goodsPrice+"\t"+goodsImage+"\t"+goodsDetail+"\t"+goodsInventory+"\t"+createTime+"\t"+updateTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
    }
}
