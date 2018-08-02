package edu.cqupt.eini.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/7/4 21:56
 */
public class TestIoc {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.say();
    }
}
