package edu.cqupt.eini.chapter02.instance.static_factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/7/23 10:48
 */
public class InstanceTest2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans2.xml");
        System.out.println(applicationContext.getBean("beans2"));
    }
}
