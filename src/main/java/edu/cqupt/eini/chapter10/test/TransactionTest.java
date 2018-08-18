package edu.cqupt.eini.chapter10.test;

import edu.cqupt.eini.chapter10.po.Customer;
import edu.cqupt.eini.chapter10.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hello World
 * @date: 2018/8/18 11:15
 */
public class TransactionTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        Customer customer = new Customer();
        customer.setUsername("zhangsan");
        customer.setJobs("manager");
        customer.setPhone("11111111111");
        customerService.addCustomer(customer);
    }
}
