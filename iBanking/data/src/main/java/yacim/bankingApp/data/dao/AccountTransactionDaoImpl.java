package yacim.bankingApp.data.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yacim.bankingApp.data.dao.common.BaseDaoImpl;
import yacim.bankingApp.data.entity.AccountTransaction;

@Repository
@Transactional
public class AccountTransactionDaoImpl extends BaseDaoImpl<AccountTransaction> implements AccountTransactionDao {
    public AccountTransactionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
