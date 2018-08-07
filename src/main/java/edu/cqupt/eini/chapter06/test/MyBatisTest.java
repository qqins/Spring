package edu.cqupt.eini.chapter06.test;

import edu.cqupt.eini.chapter06.po.Customer;
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
        //1, 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2, 根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //3, 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4, SqlSession执行映射文件中定义的SQL, 并返回映射结果
        Customer customer = sqlSession.selectOne("edu.cqupt.eini.chapter06.CustomerMapper.findCustomerById", 1);
        System.out.println(customer.toString());
        //5, 关闭SqlSession
        sqlSession.close();
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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4, SqlSession执行映射文件中定义的SQL, 并返回映射结果
        List<Customer> customers = sqlSession.selectList("edu.cqupt.eini.chapter06.CustomerMapper.findCustomerByName", "J");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        sqlSession.close();
    }
}
