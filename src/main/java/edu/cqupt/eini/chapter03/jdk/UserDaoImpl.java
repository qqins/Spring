package edu.cqupt.eini.chapter03.jdk;

/**
 * @author: Hello World
 * @date: 2018/7/31 17:09
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
