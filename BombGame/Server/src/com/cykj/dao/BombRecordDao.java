package com.cykj.dao;

import com.cykj.bean.BombRecord;

import java.util.List;

public interface BombRecordDao {
    //插入聊天记录到数据库
    void insertRec(String sendId,String recVid,int recType,String content,String state);
    //群聊聊天记录插入到客户端的聊天记录中
    List<BombRecord> selectRec(String name,int pageNum);

    //获取总页数的方法，查询群聊的总页数
    int queryCount(String name);

    //私聊聊天记录插入到客户端的聊天记录中
    List<BombRecord> selectSendOneRec(String sendId,String recId,int pageNum);

    //获取获取总页数的方法，查询私聊的总页数
    int querySendOneCount(String sendId,String recvId);

    //将不同用户的聊天记录保留
    List<BombRecord> selectNowRec(String recvId);


}
