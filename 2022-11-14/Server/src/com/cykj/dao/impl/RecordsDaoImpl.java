package com.cykj.dao.impl;

import com.cykj.bean.TRecord;
import com.cykj.dao.RecordsDao;
import com.cykj.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordsDaoImpl implements RecordsDao {
    //插入聊天记录到数据库
    @Override
    public void insertRec(String sendId, String recVid, int recType, String content,String state) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        //时间参数可以利用now()函数直接生成，省去传参的麻烦
        String sql = "insert into t_record(sendid,recvid,rectype,content,rectime,state) values(?,?,?,?,now(),?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sendId);
            preparedStatement.setString(2,recVid);
            preparedStatement.setInt(3,recType);
            preparedStatement.setString(4,content);
            preparedStatement.setString(5,state);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(null,preparedStatement,connection);
        }
    }

    //将聊天记录插入到客户端的聊天记录表格上
    @Override
    public List<TRecord> selectRec(String name,int pageNum) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from t_record order by rectime desc limit ?,5";
        List<TRecord> tRecords = new ArrayList<>();//将数据库查询到的结果赋值给字符串数组
        try {
            preparedStatement = connection.prepareStatement(sql);//预编译
            preparedStatement.setInt(1,pageNum);
            resultSet = preparedStatement.executeQuery();//执行查询操作
            while (resultSet.next()){
                String sendId = resultSet.getString("sendid");
                String recvId = resultSet.getString("recvid");
                int recType = resultSet.getInt("rectype");
                String content = resultSet.getString("content");
                String recTime = resultSet.getString("rectime");
                TRecord tRecord = new TRecord();
                tRecord.setSendid(sendId);
                tRecord.setRecvid(recvId);
                tRecord.setRectype(recType);
                tRecord.setContent(content);
                tRecord.setRectime(recTime);
                tRecords.add(tRecord);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }

        return tRecords;
    }

    //获取总页数的方法
    @Override
    public int queryCount(String name) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select count(*) from t_record";
        int row = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                row = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return row;
    }



//    //翻页方法
//    public List<TRecord> turnPages(){
//        DbUtils dbUtils = DbUtils.getInstance();
//        Connection connection = dbUtils.getConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        String sql = "select * from t_record order by rectime desc limit ?,5";
//        List<TRecord> tRecords = new ArrayList<>();//将数据库查询到的结果赋值给字符串数组
//        try {
//            preparedStatement = connection.prepareStatement(sql);//预编译
//            preparedStatement.setInt(1,num);
//            resultSet = preparedStatement.executeQuery();//执行查询操作
//            while (resultSet.next()){
//                String sendId = resultSet.getString("sendid");
//                String recvId = resultSet.getString("recvid");
//                int recType = resultSet.getInt("rectype");
//                String content = resultSet.getString("content");
//                String recTime = resultSet.getString("rectime");
//                TRecord tRecord = new TRecord();
//                tRecord.setSendid(sendId);
//                tRecord.setRecvid(recvId);
//                tRecord.setRectype(recType);
//                tRecord.setContent(content);
//                tRecord.setRectime(recTime);
//                tRecords.add(tRecord);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally { //资源永远被释放
//            dbUtils.close(resultSet, preparedStatement, connection);
//        }
//        return tRecords;
//
//    }
}
