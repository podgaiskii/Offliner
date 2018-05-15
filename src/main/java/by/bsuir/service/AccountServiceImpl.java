package by.bsuir.service;

import by.bsuir.dao.AccountDao;
import by.bsuir.model.Account;
import by.bsuir.service.interfaces.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional
    public void addAccount(Account account) {
        account.setRole("user");
        accountDao.add(account);
    }

    @Override
    @Transactional
    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    @Override
    @Transactional
    public void deleteAccount(int id) {
        accountDao.delete(id);
    }

    @Override
    @Transactional
    public Account getAccountById(int id) {
        return accountDao.getById(id);
    }

    @Override
    @Transactional
    public List<Account> getAllAccounts() {
        return accountDao.getAll();
    }

    @Override
    @Transactional
    public Account authorizeAccount(Account account) {
        List<Account> accountList = accountDao.getAll();
        for (Account a : accountList) {
            if (a.getLogin().equals(account.getLogin()) && a.getPassword().equals(account.getPassword())) {
                return a;
            }
        }
        return null;
    }

}
