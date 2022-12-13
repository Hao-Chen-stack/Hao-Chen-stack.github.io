package com.cykj.dao;

import com.cykj.bean.BombDress;

import java.util.List;

public interface BombDressDao {
    //拉取数据库内的图片路径
    List<BombDress> selectPath();
}
