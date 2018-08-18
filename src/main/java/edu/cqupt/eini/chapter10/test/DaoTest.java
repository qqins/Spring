package edu.cqupt.eini.chapter10.test;

import edu.cqupt.eini.chapter10.dao.CustomerDao;
import edu.cqupt.eini.chapter10.mapper.CustomerMapper;
import edu.cqupt.eini.chapter10.po.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/8/18 9:45
 */
public class DaoTest {
    @Test
    void findCustomerByIdDao() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerDao customerDao= (CustomerDao) applicationContext.getBean("customerDao");
        CustomerDao customerDao = applicationContext.getBean(CustomerDao.class);
        Customer customer = customerDao.findCustomerById(1);
        System.out.println(customer);
    }

    @Test
    void findCustomerByIdMapper() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerMapper customerMapper= applicationContext.getBean(CustomerMapper.class);
        Customer customer=customerMapper.findCustomerById(1);
        System.out.println(customer);
    }
}
