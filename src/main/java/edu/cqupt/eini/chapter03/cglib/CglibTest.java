package edu.cqupt.eini.chapter03.cglib;

/**
 * @author: Hello World
 * @date: 2018/8/1 16:04
 */
public class CglibTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = new UserDao();
        UserDao userDao1 = (UserDao) cglibProxy.createProxy(userDao);
        userDao1.addUser();
        System.out.println("=====================");
        userDao1.deleteUser();
    }
}
