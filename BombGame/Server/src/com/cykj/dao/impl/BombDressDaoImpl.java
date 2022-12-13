package com.cykj.dao.impl;

import com.cykj.bean.BombDress;
import com.cykj.dao.BombDressDao;
import com.cykj.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BombDressDaoImpl implements BombDressDao {
    //拉取数据库内的图片路径
    @Override
    public List<BombDress> selectPath() {
        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select imagepath from bomb_dress";
        List<BombDress> bombDressList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String path = resultSet.getString("imagepath");
                BombDress bombDress = new BombDress();
                bombDress.setImagepath(path);
                bombDressList.add(bombDress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(resultSet,preparedStatement,connection);
        }
        return bombDressList;
    }
}
