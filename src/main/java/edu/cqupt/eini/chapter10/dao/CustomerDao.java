package edu.cqupt.eini.chapter10.dao;

import edu.cqupt.eini.chapter10.po.Customer;

/**
 * @author: Hello World
 * @date: 2018/8/18 9:35
 */
public interface CustomerDao {
    public Customer findCustomerById(Integer id);
}
