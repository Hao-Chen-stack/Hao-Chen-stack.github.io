package com.cykj.dao.impl;

import com.cykj.bean.BombRoom;
import com.cykj.dao.BombRoomDao;
import com.cykj.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BombRoomDaoImpl implements BombRoomDao {
    //创建房间
    @Override
    public boolean roomCreate(BombRoom room) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into bomb_room(roomid,createuserid,playerid,roomstate,roomusernum,createtime) values(?,?,?,?,?,now())";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,room.getCreateuserid());
            preparedStatement.setString(2,room.getCreateuserid());
            preparedStatement.setString(3,room.getCreateuserid());
            preparedStatement.setString(4,"等待加入");//初始状态为等待加入
            preparedStatement.setInt(5,1);
            int i = preparedStatement.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(null,preparedStatement,connection);
        }
        return false;
    }
    //查询已存在的房间
    @Override
    public List<BombRoom> isQuery() {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<BombRoom> list = new ArrayList<>();
        try {
            connection = dbUtils.getConnection();
            String sql = "select count(playerid) n,roomid from bomb_room group by roomid ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String createUserId = resultSet.getString("roomid");
                int roomState = resultSet.getInt("n");//加入人数的统计
                BombRoom room = new BombRoom();
                room.setCreateuserid(createUserId);
                room.setRoomstate("等待加入");
                if (roomState == 2){
                    room.setRoomstate("满员");//当加入人数等于2，状态变为满员
                }
                list.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }

        return list;
    }

    //房主退出的时候解散房间
    @Override
    public boolean deleteRoom(String createUserId) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "delete from bomb_room where createuserid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,createUserId);
            int i = preparedStatement.executeUpdate();
            if (i>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(null,preparedStatement,connection);
        }
        return false;
    }

    //查询账户是否进入到房间
    @Override
    public boolean queryUser(String id) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dbUtils.getConnection();
            String sql = "select * from bomb_room where playerid = ?";//通过匹配其他用户id来实现
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return false;//查询到账户已加入房间，则返回false
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return true;//查询到账户未加入房间，则返回true
    }


    //用户加入其他人创建的房间时
    @Override
    public int insetUser(String roomid, String playerid) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection=dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int enterroom = 0;
        try {
            String sql = "insert into bomb_room(roomid,createuserid,playerid,roomstate,roomusernum,createtime) values(?,?,?,?,?,now())";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,roomid);
            preparedStatement.setString(2,roomid);
            preparedStatement.setString(3,playerid);
            preparedStatement.setString(4,"满员");
            preparedStatement.setInt(5,2);
            enterroom = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            dbUtils.close(null,preparedStatement,connection);
        }
        return enterroom;
    }

    /**
     * @description:查询房间内玩家id
     * @author: chenhao
     * @date: 2022/11/25 22:50
     * @param: [createUserId]
     * @return: java.lang.String
     **/
    @Override
    public String queryRoomPlayer(String createUserId) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String playerId = null;
        try {
            connection = dbUtils.getConnection();
            String sql = "select playerid from bomb_room where roomstate = '满员' and roomid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,createUserId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                playerId = resultSet.getString(1);
                return playerId;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return playerId;
    }

    /**
     * @description:查询房主的id
     * @author: chenhao
     * @date: 2022/11/25 23:50
     * @param: [playerId]
     * @return: java.lang.String
     **/
    @Override
    public String roomMsId(String playerId) {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String roomMsId = null;
        try {
            connection = dbUtils.getConnection();
            String sql = "select createuserid from bomb_room where roomstate = '满员' and playerid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,playerId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roomMsId = resultSet.getString(1);
                return roomMsId;//查询到账户已加入房间，则返回false
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return roomMsId;
    }

}
