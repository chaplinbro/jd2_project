package yacim.bankingApp.data.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yacim.bankingApp.data.dao.common.BaseDaoImpl;
import yacim.bankingApp.data.entity.BankAccount;

import java.util.List;

@Repository
@Transactional
public class BankAccountDaoImpl extends BaseDaoImpl<BankAccount> implements BankAccountDao {

    private final SessionFactory sessionFactory;

    public BankAccountDaoImpl(SessionFactory sessionFactory, SessionFactory sessionFactory1) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory1;
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM BankAccount", BankAccount.class).getResultList();
    }

    @Override
    public List<BankAccount> getBankAccountsByUserId(String userId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM BankAccount WHERE accountOwner.id = :userId";
        Query<BankAccount> query = session.createQuery(hql, BankAccount.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public BankAccount getBankAccountByAccountNumber(String accountNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM BankAccount WHERE accountNumber = :searchedAccountNumber";
        Query<BankAccount> query = session.createQuery(hql, BankAccount.class);
        query.setParameter("searchedAccountNumber", accountNumber);
        return query.uniqueResult();
    }
}
