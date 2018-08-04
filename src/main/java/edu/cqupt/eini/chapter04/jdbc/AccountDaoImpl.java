package edu.cqupt.eini.chapter04.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author: Hello World
 * @date: 2018/8/4 15:17
 */
public class AccountDaoImpl implements AccountDAO {
    /**
     * 申明JdbcTemplate属性及其setter方法, 将其注入
     */
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 数据库添加操作
     *
     * @param account 要添加的账户对象
     * @return 受SQL语句影响的记录条数
     */
    @Override
    public int addAccount(Account account) {
        String sql = "insert into account(username,balance) value(?,?)";
        //定义数组用来存放SQL语句中的参数
        Object[] obj = new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        //执行添加操作, 返回的是受SQL语句影响的记录条数
        int num = jdbcTemplate.update(sql, obj);
        return num;
    }

    /**
     * 数据库的更新操作
     *
     * @param account 要更新的对象
     * @return 受SQL语句影响的记录条数
     */
    @Override
    public int updateAccount(Account account) {
        String sql = "update account set username=?,balance=? where id=?";
        Object[] obj = new Object[]{
                account.getUsername(),
                account.getBalance(),
                account.getId()
        };
        int num = jdbcTemplate.update(sql, obj);
        return num;
    }

    /**
     * 数据库的删除操作
     *
     * @param id 要删除数据的id
     * @return 受SQL语句影响的记录条数
     */
    @Override
    public int deleteAccount(int id) {
        String sql = "delete from account where id = ?";
        int num = jdbcTemplate.update(sql, id);
        return num;
    }

    /**
     * 通过id查询账户数据信息
     *
     * @param id 要查询的id
     * @return 查询的记录
     */
    @Override
    public Account findAccountById(int id) {
        String sql = "select * from account where id = ?";
        //将数据库中的属性与Account类中的属性对应
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<>(Account.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    /**
     * @return 所有账户的信息
     */
    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<>(Account.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
}
