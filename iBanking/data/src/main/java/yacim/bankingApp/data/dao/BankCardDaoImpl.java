package yacim.bankingApp.data.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yacim.bankingApp.data.entity.BankCard;

@Repository
@Transactional
public class BankCardDaoImpl implements BankCardDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public BankCardDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createBankCard(BankCard bankCard) {
        Session session = sessionFactory.getCurrentSession();
        session.save(bankCard);
    }

    public BankCard getBankCardById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(BankCard.class, id);
    }

    @Override
    public void updateBankCard(BankCard bankCard) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(bankCard);
    }

    @Override
    public boolean deleteBankCard(BankCard bankCard) {
        Session session = sessionFactory.getCurrentSession();
        if (bankCard == null) return false;
        session.delete(bankCard);
        return true;
    }

    @Override
    public BankCard getBankCardByCardNumber(String cardNumber) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM BankCard WHERE cardNumber = :searchedCardNumber";
        Query<BankCard> query = session.createQuery(hql, BankCard.class);
        query.setParameter("searchedCardNumber", cardNumber);
        return query.getSingleResult();
    }

}