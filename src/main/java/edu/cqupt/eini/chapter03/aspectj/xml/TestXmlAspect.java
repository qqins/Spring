package edu.cqupt.eini.chapter03.aspectj.xml;

import edu.cqupt.eini.chapter03.jdk.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/8/2 10:51
 */
public class TestXmlAspect {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("aspectjXml.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.addUser();
        System.out.println("==========================");
        userDao.deleteUser();
    }
}
