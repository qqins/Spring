package edu.cqupt.eini.chapter02.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Hello World
 * @date: 2018/7/27 11:08
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
//    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
        System.out.println("userService...save...");
    }

    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/
}
