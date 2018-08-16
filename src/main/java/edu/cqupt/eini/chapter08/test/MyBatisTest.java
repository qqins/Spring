package edu.cqupt.eini.chapter08.test;

import edu.cqupt.eini.chapter08.po.Customer;
import edu.cqupt.eini.chapter08.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Hello World
 * @date: 2018/8/7 21:29
 */
public class MyBatisTest {
    @Test
    void findCustomerByNameAndJobs() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            Customer customer = new Customer();
            customer.setUsername("Jack");
            customer.setJobs("teacher");
            List<Customer> customers = sqlSession.selectList("edu.cqupt.eini.chapter08.CustomerMapper.findCustomerByNameAndJobs"
                    , customer);
            for (Customer customer1 : customers) {
                System.out.println(customer1);
            }
        }
    }

    @Test
    void findCustomerByNameOrJobs() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            Customer customer = new Customer();
//            customer.setUsername("Jack");
            customer.setJobs("teacher");
            List<Customer> customers = sqlSession.selectList("edu.cqupt.eini.chapter08.CustomerMapper" +
                    ".findCustomerByNameOrJobs", customer);
            for (Customer customer1 : customers) {
                System.out.println(customer1);
            }
        }
    }

    @Test
    void updateCustomer() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            Customer customer = new Customer();
            customer.setId(5);
            customer.setPhone("66666666666");
            int rows = sqlSession.update("edu.cqupt.eini.chapter08.CustomerMapper.updateCustomer",
                    customer);
            if (rows > 0) {
                System.out.println("成功修改了" + rows + "条数据");
            } else {
                System.out.println("执行修改操作失败");
            }
            sqlSession.commit();
        }
    }

    /**
     * 根据客户编号批量查询
     */
    @Test
    void findCustomerByIds() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            List<Customer> customers = sqlSession.selectList("edu.cqupt.eini.chapter08.CustomerMapper" +
                    ".findCustomerByIds", list);
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    /**
     * bind元素的使用：根据客户名模糊查询客户信息
     */
    @Test
    void findCustomerByName() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            Customer customer = new Customer();
            customer.setUsername("j");
            List<Customer> customers = sqlSession.selectList("edu.cqupt.eini.chapter08.CustomerMapper" +
                    ".findCustomerByName", customer);
            for (Customer customer1 : customers) {
                System.out.println(customer1);
            }
        }
    }
}
