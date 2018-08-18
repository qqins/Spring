package edu.cqupt.eini.chapter10.mapper;

import edu.cqupt.eini.chapter10.po.Customer;

/**
 * @author: Hello World
 * @date: 2018/8/18 10:06
 */
public interface CustomerMapper {
    public Customer findCustomerById(Integer id);
    public void addCustomer(Customer customer);
}
