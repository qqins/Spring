package edu.cqupt.eini.chapter09.test;

import edu.cqupt.eini.chapter09.po.Orders;
import edu.cqupt.eini.chapter09.po.Person;
import edu.cqupt.eini.chapter09.po.User;
import edu.cqupt.eini.chapter09.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @author: Hello World
 * @date: 2018/8/17 9:39
 */
public class MyBatisAssociatedTest {
    /**
     * 嵌套查询
     */
    @Test
    void findPersonById() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            Person person = sqlSession.selectOne("edu.cqupt.eini.chapter09.PersonMapper.findPersonById", 1);
            System.out.println(person.getName());
        }
    }

    /**
     * 嵌套结果
     */
    @Test
    void findPersonById2() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            Person person = sqlSession.selectOne("edu.cqupt.eini.chapter09.PersonMapper.findPersonById2", 1);
            System.out.println(person);
        }
    }

    /**
     * 一对多
     */
    @Test
    void findUser() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            User user = sqlSession.selectOne("edu.cqupt.eini.chapter09.UserMapper.findUserWithOrders", 1);
            System.out.println(user);
        }
    }

    /**
     * 多对多
     */
    @Test
    void findOrders() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            Orders orders = sqlSession.selectOne("edu.cqupt.eini.chapter09.OrdersMapper.findOrdersWithProduct", 1);
            System.out.println(orders);
        }
    }
}
