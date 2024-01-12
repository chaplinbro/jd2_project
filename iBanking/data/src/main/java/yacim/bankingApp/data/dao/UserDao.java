package yacim.bankingApp.data.dao;

import yacim.bankingApp.data.dao.common.BaseDao;
import yacim.bankingApp.data.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    List<User> getAllUsers();

    User getByUsername(String username);

    User getUserById(String id);
}
