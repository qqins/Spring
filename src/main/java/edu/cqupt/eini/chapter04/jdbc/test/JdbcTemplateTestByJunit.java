package edu.cqupt.eini.chapter04.jdbc.test;

import edu.cqupt.eini.chapter04.jdbc.Account;
import edu.cqupt.eini.chapter04.jdbc.AccountDAO;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: Hello World
 * @date: 2018/8/4 13:26
 */
class JdbcTemplateTestByJunit {

    @Test
    void main() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");
        org.springframework.jdbc.core.JdbcTemplate jdbcTemplate = (org.springframework.jdbc.core.JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table account(" +
                "id int primary key auto_increment," +
                "username varchar(50)," +
                "balance double)");
        System.out.println("账户表创建成功");
    }

    @Test
    void addAccount() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");
        AccountDAO accountDAO = (AccountDAO) applicationContext.getBean("accountDao");
        Account account = (Account) applicationContext.getBean("addAccount");
        int num = accountDAO.addAccount(account);
        if (num > 0) {
            System.out.println("成功插入了" + num + "条数据!");
        } else {
            System.out.println("插入操作执行失败!");
        }
    }

    @Test
    void updateAccount() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");
        AccountDAO accountDAO = (AccountDAO) applicationContext.getBean("accountDao");
        Account account = (Account) applicationContext.getBean("updateAccount");
        int num = accountDAO.updateAccount(account);
        if (num > 0) {
            System.out.println("成功修改了" + num + "条数据!");
        } else {
            System.out.println("修改操作执行失败!");
        }
    }

    @Test
    void deleteAccount() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");
        AccountDAO accountDAO = (AccountDAO) applicationContext.getBean("accountDao");
        int num = accountDAO.deleteAccount(2);
        if (num > 0) {
            System.out.println("成功删除了" + num + "条数据!");
        } else {
            System.out.println("删除操作执行失败!");
        }
    }

    @Test
    void findAccountById() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");
        AccountDAO accountDAO = (AccountDAO) applicationContext.getBean("accountDao");
        Account account = accountDAO.findAccountById(3);
        System.out.println(account);
    }

    @Test
    void findAllAccount() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");
        AccountDAO accountDAO = (AccountDAO) applicationContext.getBean("accountDao");
        List<Account> accounts = accountDAO.findAllAccount();
        for (Account act : accounts) {
            System.out.println(act);
        }
    }
}