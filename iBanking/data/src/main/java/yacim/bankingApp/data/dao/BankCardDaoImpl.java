package yacim.bankingApp.data.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yacim.bankingApp.data.dao.common.BaseDaoImpl;
import yacim.bankingApp.data.entity.BankCard;

import java.util.List;

@Repository
@Transactional
public class BankCardDaoImpl extends BaseDaoImpl<BankCard> implements BankCardDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public BankCardDaoImpl(SessionFactory sessionFactory, SessionFactory sessionFactory1) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory1;
    }

    @Override
    public List<BankCard> getAllCards() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM BankCard", BankCard.class).getResultList();
    }

    @Override
    public List<BankCard> getBankCardsByBankAccountId(String bankAccountId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM BankCard WHERE bankAccount.id = :bankAccountId";
        Query<BankCard> query = session.createQuery(hql, BankCard.class);
        query.setParameter("bankAccountId", bankAccountId);
        return query.getResultList();
    }
}