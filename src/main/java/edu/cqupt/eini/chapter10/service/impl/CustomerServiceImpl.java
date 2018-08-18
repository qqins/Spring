package edu.cqupt.eini.chapter10.service.impl;

import edu.cqupt.eini.chapter10.mapper.CustomerMapper;
import edu.cqupt.eini.chapter10.po.Customer;
import edu.cqupt.eini.chapter10.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Hello World
 * @date: 2018/8/18 11:04
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
        int i=1/0;
    }
}
