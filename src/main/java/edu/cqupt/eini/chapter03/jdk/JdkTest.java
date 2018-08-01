package edu.cqupt.eini.chapter03.jdk;

/**
 * @author: Hello World
 * @date: 2018/7/31 17:16
 */
public class JdkTest {
    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserDao userDao = new UserDaoImpl();
        UserDao userDao1 = (UserDao) jdkProxy.creatProxy(userDao);
        userDao1.addUser();
        System.out.println("===========================");
        userDao1.deleteUser();
    }
}
