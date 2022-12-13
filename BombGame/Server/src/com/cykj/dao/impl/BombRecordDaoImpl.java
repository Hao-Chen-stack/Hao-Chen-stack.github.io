package com.cykj.dao.impl;

import com.cykj.bean.BombRecord;
import com.cykj.dao.BombRecordDao;
import com.cykj.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BombRecordDaoImpl implements BombRecordDao {
    //插入聊天记录到数据库
    @Override
    public void insertRec(String sendId, String recVid, int recType, String content, String state) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        //时间参数可以利用now()函数直接生成，省去传参的麻烦
        String sql = "insert into bomb_record(sendid,recvid,rectype,content,rectime,state) values(?,?,?,?,now(),?)";
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
    //群聊聊天记录插入到客户端的聊天记录中
    @Override
    public List<BombRecord> selectRec(String name,int pageNum) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from bomb_record  where rectype = 1 order by rectime desc limit ?,5";
        List<BombRecord> recordList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,pageNum);
            resultSet = preparedStatement.executeQuery();//执行查询操作
            while (resultSet.next()){
                String sendId = resultSet.getString("sendid");
                String content = resultSet.getString("content");
                String recTime = resultSet.getString("rectime");
                BombRecord bombRecord = new BombRecord();
                bombRecord.setSendid(sendId);
                bombRecord.setContent(content);
                bombRecord.setRectime(recTime);
                recordList.add(bombRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return recordList;
    }

    //查询群聊的总页数
    @Override
    public int queryCount(String name) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select count(*) from bomb_record where rectype = 1 ";
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

    //私聊聊天记录插入到客户端的聊天记录中
    @Override
    public List<BombRecord> selectSendOneRec(String sendId,String recId, int pageNum) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from bomb_record  where (rectype = 0 and sendid = ? and recvid = ?) order by rectime desc limit ?,5";
        List<BombRecord> recordList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sendId);
            preparedStatement.setString(2,recId);
            preparedStatement.setInt(3,pageNum);
            resultSet = preparedStatement.executeQuery();//执行查询操作
            while (resultSet.next()){
                String content = resultSet.getString("content");
                String recTime = resultSet.getString("rectime");
                BombRecord bombRecord = new BombRecord();
                bombRecord.setSendid(sendId);
                bombRecord.setRecvid(recId);
                bombRecord.setContent(content);
                bombRecord.setRectime(recTime);
                recordList.add(bombRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return recordList;
    }

    //查询私聊的总页数
    @Override
    public int querySendOneCount(String sendId,String recvId) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select count(*) from bomb_record where (rectype = 0 and sendid = ? and recvid = ?) ";
        int row = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sendId);
            preparedStatement.setString(2,recvId);
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

    //将不同用户的聊天记录保留
    @Override
    public List<BombRecord> selectNowRec(String recvId) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from bomb_record  where (rectype = 0 and recvid = ?)";
        List<BombRecord> recordList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,recvId);
            resultSet = preparedStatement.executeQuery();//执行查询操作
            while (resultSet.next()){
                String content = resultSet.getString("content");
                String recTime = resultSet.getString("rectime");
                BombRecord bombRecord = new BombRecord();
                bombRecord.setRecvid(recvId);
                bombRecord.setContent(content);
                bombRecord.setRectime(recTime);
                recordList.add(bombRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return recordList;
    }


}
