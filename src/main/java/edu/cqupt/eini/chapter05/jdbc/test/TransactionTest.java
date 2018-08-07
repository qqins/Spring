package edu.cqupt.eini.chapter05.jdbc.test;

import edu.cqupt.eini.chapter05.jdbc.AccountDAO;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Hello World
 * @date: 2018/8/6 20:44
 */
class TransactionTest {

    @Test
    void xmlTest() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("transaction.xml");
        AccountDAO accountDAO = (AccountDAO) applicationContext.getBean("accountDao");
        accountDAO.transfer("Bob", "Jack", 500.0);
        System.out.println("转账成功");
    }

    @Test
    void annotationTest() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("transactionAnnotation.xml");
        AccountDAO accountDAO = (AccountDAO) applicationContext.getBean("accountDao");
        accountDAO.transfer("Bob", "Jack", 500.0);
        System.out.println("转账成功");
    }
}