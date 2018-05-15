package by.bsuir.service.interfaces;

import by.bsuir.model.Account;

import java.util.List;

public interface AccountService {

    void addAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(int id);
    Account getAccountById(int id);
    List<Account> getAllAccounts();
    Account authorizeAccount(Account account);

}
