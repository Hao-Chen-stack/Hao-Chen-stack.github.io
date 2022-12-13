package com.cykj.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtils {
    private String url = "jdbc:mysql://127.0.0.1:3306/qqUser_db?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private String username = "root";
    private String password = "12345678";
    //driver驱动
    private String driver = "";
    //数据来源---池
    private DataSource dataSource;

    private static DbUtils dbUtils = null ;  //new DbUtils(); //饿汉式

    private DbUtils(){//构造函数私有化
        //1.读取配置文件
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("Server\\druid.properties"));
            //2.通过迪卢伊来生成dataSource  数据工厂传递数据源
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取实例
    public static DbUtils getInstance(){
        if (dbUtils == null){       //第一次多个人，同时调用，并发问题------->锁，线程
            dbUtils = new DbUtils();//懒汉式
        }
        return dbUtils;
    }

    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    //连接方法
    public Connection getConnection(String url,String user,String password){
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,user,password);
            return  connection;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        //失败
        return null;
    }
    //release释放
    public void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }


}
