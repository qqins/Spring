package edu.cqupt.eini.chapter04.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/8/4 11:04
 */
public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("jdbc.xml");
        org.springframework.jdbc.core.JdbcTemplate jdbcTemplate = (org.springframework.jdbc.core.JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table account("+
                                   "id int primary key auto_increment,"+
                                   "username varchar(50),"+
                                   "balance double)");
        System.out.println("账户表创建成功");
    }
}
