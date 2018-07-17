package edu.cqupt.eini.ioc;

/**
 * @author: Hello World
 * @date: 2018/7/17 21:23
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void say() {
        userDao.say();
        System.out.println("userService say hello World!");
    }
}
