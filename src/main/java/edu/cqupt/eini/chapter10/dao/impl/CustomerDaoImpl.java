package edu.cqupt.eini.chapter10.dao.impl;

import edu.cqupt.eini.chapter10.dao.CustomerDao;
import edu.cqupt.eini.chapter10.po.Customer;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author: Hello World
 * @date: 2018/8/18 9:36
 */
public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao {
    @Override
    public Customer findCustomerById(Integer id) {
        return getSqlSession().selectOne("edu.cqupt.eini.chapter10.dao.CustomerDao.findCustomerById",1);
    }
}
