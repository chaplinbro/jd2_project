package yacim.bankingApp.data.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import yacim.bankingApp.data.entity.Currency;

import java.util.List;

@Repository
@Transactional
public class CurrencyDaoImpl implements CurrencyDao{

    private  final SessionFactory sessionFactory;

    @Autowired
    public CurrencyDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Currency> getAllForPagination(int startPosition, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Currency", Currency.class)
                .setFirstResult(startPosition)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public int getTotalCurrencyCount() {
        Session session = sessionFactory.getCurrentSession();
        Long count = session.createQuery("SELECT COUNT(*) FROM Currency", Long.class)
                .uniqueResult();
        return count.intValue();
    }
}
