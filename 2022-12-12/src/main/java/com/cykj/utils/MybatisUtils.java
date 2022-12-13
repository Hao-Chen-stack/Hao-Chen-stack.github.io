package com.cykj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @description:MybatisUtils工具类
 * @author: chenhao
 * @date: 2022/12/8 9:47
 **/
public class MybatisUtils {
    /**
     * @description:获取连接的方法
     * @author: chenhao
     * @date: 2022/12/8 10:13
     * @param: []
     * @return: org.apache.ibatis.session.SqlSession
     **/
    public static SqlSession getSession(){
        try {
            //创建一个工厂构建器
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
            //拿到工厂实例,构建工厂实例
            String config = "mybatis-config.xml";
            SqlSessionFactory sqlSessionFactory = sfb.build(Resources.getResourceAsStream(config));
            //获取sqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);
            return sqlSession;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @description:关闭连接的方法
     * @author: chenhao
     * @date: 2022/12/8 10:57
     * @param: [sqlSession]
     * @return: void
     **/
    public static void closeSession(SqlSession sqlSession){
        try {
            if(null!=sqlSession){
                sqlSession.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getSession();
    }

}


