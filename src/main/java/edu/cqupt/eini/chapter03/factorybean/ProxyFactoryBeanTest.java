package edu.cqupt.eini.chapter03.factorybean;

import edu.cqupt.eini.chapter03.jdk.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/8/1 16:43
 */
public class ProxyFactoryBeanTest {
    public static void main(String[] args) {
        String xmlPath= "applicationContext.xml";
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");
        userDao.addUser();
        System.out.println("================");
        userDao.deleteUser();
    }
}
