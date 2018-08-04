package edu.cqupt.eini.chapter04.jdbc;

import java.util.List;

/**
 * @author: Hello World
 * @date: 2018/8/4 15:15
 */
public interface AccountDAO {
    public int addAccount(Account account);

    public int updateAccount(Account account);

    public int deleteAccount(int id);

    public Account findAccountById(int id);

    public List<Account> findAllAccount();
}
