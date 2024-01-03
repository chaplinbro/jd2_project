package yacim.bankingApp.data.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yacim.bankingApp.data.entity.AccountTransaction;
import yacim.bankingApp.data.entity.TransferTransaction;

@Repository
@Transactional
public class AccountTransactionDaoImpl implements AccountTransactionDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public AccountTransactionDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveTransaction(AccountTransaction accountTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.save(accountTransaction);
    }

    @Override
    public void saveTransaction(TransferTransaction transferTransaction) {
        Session session = sessionFactory.getCurrentSession();
        session.save(transferTransaction);
    }
}
