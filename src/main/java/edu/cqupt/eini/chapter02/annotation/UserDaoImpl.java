package edu.cqupt.eini.chapter02.annotation;

import org.springframework.stereotype.Repository;

/**
 * @author: Hello World
 * @date: 2018/7/27 11:06
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("userDao...save...");
    }
}
