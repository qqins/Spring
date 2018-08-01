package edu.cqupt.eini.chapter02.instance.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/7/23 11:08
 */
public class InstanceTest3 {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans3.xml");
        System.out.println(applicationContext.getBean("beans3"));

    }
}
