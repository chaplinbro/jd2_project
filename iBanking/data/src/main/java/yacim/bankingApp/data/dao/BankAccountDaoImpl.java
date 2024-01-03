package yacim.bankingApp.data.dao;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yacim.bankingApp.data.entity.BankAccount;
import yacim.bankingApp.data.entity.BankCard;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class BankAccountDaoImpl implements BankAccountDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public BankAccountDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createBankAccount(BankAccount bankAccount) {
        Session session = sessionFactory.getCurrentSession();
        session.save(bankAccount);
    }

    @Override
    public BankAccount getBankCardById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(BankAccount.class, id);
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(bankAccount);
    }

    @Override
    public boolean deleteBankAccount(BankAccount bankAccount) {
        Session session = sessionFactory.getCurrentSession();
        if (bankAccount == null) return false;
        session.delete(bankAccount);
        return true;
    }

    @Override
    public BankAccount getBankAccountByAccountNumber(String accountNumber) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM BankAccount WHERE accountNumber = :accountNumber";
        Query<BankAccount> query = session.createQuery(hql, BankAccount.class);
        query.setParameter("accountNumber", accountNumber);
        return query.getSingleResult();
    }
}
