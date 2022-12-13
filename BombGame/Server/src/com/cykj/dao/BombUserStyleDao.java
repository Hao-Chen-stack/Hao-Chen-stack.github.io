package com.cykj.dao;

import com.cykj.bean.BombUserstyle;

public interface BombUserStyleDao {

    //将控制衣服帽子的变量插入到数据库
    void style(BombUserstyle userstyle);
    //从数据库查询出来
    BombUserstyle queryStyle(String id);
    //删除样式
    void deleteUserStyle(String id);
}
