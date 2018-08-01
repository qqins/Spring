package edu.cqupt.eini.chapter02.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/7/27 11:13
 */
public class AnnotationAssembleTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans6.xml");
        UserController userController =
                (UserController) applicationContext.getBean("userController");
        userController.save();
    }
}
