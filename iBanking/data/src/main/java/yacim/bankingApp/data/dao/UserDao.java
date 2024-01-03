package yacim.bankingApp.data.dao;

import yacim.bankingApp.data.entity.User;

public interface UserDao {

    void saveUser(User user);

    User getUserById(String id);

    void updateUser(User user);

    boolean deleteUser(User user);
}
