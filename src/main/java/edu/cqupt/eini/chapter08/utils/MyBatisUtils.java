package edu.cqupt.eini.chapter08.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author: Hello World
 * @date: 2018/8/16 14:45
 */
public class MyBatisUtils {

    private MyBatisUtils() {

    }

    private static class SingletonSession {
        private static SqlSessionFactory sqlSessionFactory = null;

        private static SqlSession getSession() {
            try {
                Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sqlSessionFactory.openSession();
        }
    }

    public static SqlSession getSession() {
        return SingletonSession.getSession();
    }
}
