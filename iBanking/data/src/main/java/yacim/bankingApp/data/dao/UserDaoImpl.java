package yacim.bankingApp.data.dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yacim.bankingApp.data.dao.common.BaseDaoImpl;
import yacim.bankingApp.data.entity.User;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

    private final SessionFactory sessionFactory;
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory, SessionFactory sessionFactory1) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory1;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM User WHERE username = :username";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

    @Override
    public User getUserById(String id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM User WHERE id = :id";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }
}
