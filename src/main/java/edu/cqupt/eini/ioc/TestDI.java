package edu.cqupt.eini.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/7/17 21:27
 */
public class TestDI {
    public static void main(String[] args) {
        String xmlPath= "ioc.xml";
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.say();
    }
}
