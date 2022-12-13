package com.cykj.dao;

import com.cykj.bean.BombRoom;

import java.util.List;

public interface BombRoomDao {
    //房间创建
    boolean roomCreate(BombRoom room);

    //查询存在的房间
    List<BombRoom> isQuery();

    //房间的删除
    boolean deleteRoom(String createUserId);

    //查询账户是否进入到房间
    boolean queryUser(String id);

    //用户加入其他人创建的房间时
    int insetUser(String roomid, String playerid);

    //查询房间内的玩家id
    String queryRoomPlayer(String createUserId);

    //查询房主的id
    String roomMsId(String playerId);
}
