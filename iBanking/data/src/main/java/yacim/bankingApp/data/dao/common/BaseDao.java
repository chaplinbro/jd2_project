package yacim.bankingApp.data.dao.common;

public interface BaseDao<Entity> {

    void save(Entity entity);

    Entity getById(Class<Entity> entityClass, String id);

    void update(Entity entity);

    void delete(Class<Entity> entityClass, String id);

}
