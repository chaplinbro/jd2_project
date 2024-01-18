package yacim.bankingApp.data.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yacim.bankingApp.data.dao.testConfig.TestConfiguration;
import yacim.bankingApp.data.entity.User;

import javax.sql.DataSource;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Autowired
    DataSource dataSource;

    Connection connection;

    @Before
    public void setUp() throws Exception {

        connection = dataSource.getConnection();
        String sql = "insert into t_user (id, username, name, surname, password, role)" +
                " values ('abc1000', 'user', 'user', 'user', 'user', 'ROLE_USER')";
        connection.createStatement().executeUpdate(sql);

    }

    @After
    public void tearDown() throws Exception {

        connection = dataSource.getConnection();
        String sql = "delete from t_user";
        connection.createStatement().executeUpdate(sql);
        connection.close();

    }

    @Test
    public void getAllUsers() {

        List<User> users = userDao.getAllUsers();

        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    public void getByUsername() {

        String username = "user";

        User user = userDao.getByUsername(username);

        assertNotNull(user);
        assertEquals("user", user.getUsername());
    }

    @Test
    public void getUserById() {

        String id = "abc1000";

        User user = userDao.getUserById(id);

        assertNotNull(user);
        assertEquals("abc1000", user.getId());
    }
}