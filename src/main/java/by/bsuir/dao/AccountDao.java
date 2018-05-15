package by.bsuir.dao;

import by.bsuir.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao extends AbstractDao<Account> {

    @Override
    protected Class getEntityClass() {
        return Account.class;
    }

}
