package yacim.bankingApp.data.dao.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BaseDaoImpl<Entity> implements BaseDao<Entity> {

    private final SessionFactory sessionFactory;

    @Autowired
    public BaseDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Entity entity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
    }

    @Override
    public Entity getById(Class<Entity> entityClass,String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(entityClass, id);
    }

    @Override
    public void update(Entity entity) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(entity);
    }

    @Override
    public void delete(Class<Entity> entityClass, String id) {
        Session session = sessionFactory.getCurrentSession();
        Entity entity = session.get(entityClass, id);
        if (entity != null) {
            session.remove(entity);
        }
    }
}
