package com.cykj.dao;

import com.cykj.bean.TRecord;

import java.util.List;

public interface RecordsDao {
    //插入聊天记录到数据库
    void insertRec(String sendId,String recVid,int recType,String content,String state);

    //将聊天记录放到客户端的聊天记录表格上
    List<TRecord> selectRec(String name,int pageNum);

//    //翻页方法
//    List<TRecord> turnPages();

    //获取总页数的方法
    public int queryCount(String name);
}
