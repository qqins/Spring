package edu.cqupt.eini.chapter07.test;

import edu.cqupt.eini.chapter07.po.Customer;
import edu.cqupt.eini.chapter07.po.User;
import edu.cqupt.eini.chapter07.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: Hello World
 * @date: 2018/8/7 21:29
 */
public class MyBatisTest {
    /**
     * 根据客户编号查询客户信息
     *
     * @throws IOException
     */
    @Test
    void findCustomerById() throws IOException {
       /* //1, 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2, 根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //3, 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();*/
        SqlSession sqlSession = MyBatisUtils.getSession();
        try {
            //4, SqlSession执行映射文件中定义的SQL, 并返回映射结果
            Customer customer = sqlSession.selectOne("edu.cqupt.eini.chapter07.CustomerMapper.findCustomerById", 1);
            System.out.println(customer.toString());
        } finally {
            //5, 关闭SqlSession
            sqlSession.close();
        }
    }

    /**
     * 根据用户名称来模糊查询用户信息列表
     */
    @Test
    void findCustomerByName() throws IOException {
        //1, 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2, 根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //3, 通过SqlSessionFactory创建SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            //4, SqlSession执行映射文件中定义的SQL, 并返回映射结果
            List<Customer> customers = sqlSession.selectList("edu.cqupt.eini.chapter07.CustomerMapper" +
                    ".findCustomerByName", "J");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    /**
     * 查找所有信息
     */
    @Test
    void findAll() {
        try (SqlSession sqlSession = MyBatisUtils.getSession()){
            List<Customer> customers = sqlSession.selectList("edu.cqupt.eini.chapter07.CustomerMapper" +
                    ".findAll");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    /**
     * 添加客户
     */
    @Test
    void addCustomer() throws IOException {
        //1, 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2, 根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //3, 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //4, SqlSession执行添加操作
            //4.1, 创建Customer对象, 并向对象中添加数据
            Customer customer = new Customer();
            customer.setUsername("Qqin");
            customer.setJobs("student");
            customer.setPhone("23333333333");
            //4.2, 执行SqlSession的插入方法, 返回的是SQL语句影响的行数
            int rows = sqlSession.insert("edu.cqupt.eini.chapter07.CustomerMapper.addCustomer", customer);
            //4.3, 通过返回结果判断插入操作是否执行成功
            if (rows > 0) {
                System.out.println("成功插入了" + rows + "条数据!");
            } else {
                System.out.println("执行插入操作失败!!!");
            }
            //4.4, 提交事务, 增改删都进行事务操作
            sqlSession.commit();
            //获取插入数据的主键id
            System.out.println(customer.getId());
        } finally {
            //5, 关闭sqlSession
            sqlSession.close();
        }
    }

    /**
     * 更新客户
     */
    @Test
    void updateCustomer() throws IOException {
        //1, 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2, 根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //3, 通过SqlSessionFactory创建SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            //4, SqlSession执行添加操作
            //4.1, 创建Customer对象, 并向对象中添加数据
            Customer customer = new Customer();
            customer.setId(4);
            customer.setUsername("QIN");
            customer.setJobs("Boss");
            customer.setPhone("23333333333");
            //4.2, 执行SqlSession的更新方法, 返回的是SQL语句影响的行数
            int rows = sqlSession.update("edu.cqupt.eini.chapter07.CustomerMapper.updateCustomer", customer);
            //4.3, 通过返回结果判断更新操作是否执行成功
            if (rows > 0) {
                System.out.println("成功修改了" + rows + "条数据!");
            } else {
                System.out.println("执行修改操作失败!!!");
            }
            //4.4, 提交事务, 增改删都进行事务操作
            sqlSession.commit();
        }
    }

    /**
     * 删除客户
     */
    @Test
    void deleteCustomer() throws IOException {
        //1, 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2, 根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //3, 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //4, SqlSession执行添加操作
            //4.1, 执行SqlSession的删除方法, 返回的是SQL语句影响的行数
            int rows = sqlSession.delete("edu.cqupt.eini.chapter07.CustomerMapper.deleteCustomer", 4);
            //4.2, 通过返回结果判断删除操作是否执行成功
            if (rows > 0) {
                System.out.println("成功删除了" + rows + "条数据!");
            } else {
                System.out.println("执行删除操作失败!!!");
            }
            //4.4, 提交事务, 增改删都进行事务操作
            sqlSession.commit();
        } finally {
            //5, 关闭sqlSession
            sqlSession.close();
        }
    }

    /**
     * 查询User中所有值
     */
    @Test
    void findAllUser() {
        try (SqlSession sqlSession=MyBatisUtils.getSession()){
            List<User> list = sqlSession.selectList("edu.cqupt.eini.chapter07.UserMapper" +
                    ".findAllUser");
            for (User user : list) {
                System.out.println(user);
            }
        }
    }
}
