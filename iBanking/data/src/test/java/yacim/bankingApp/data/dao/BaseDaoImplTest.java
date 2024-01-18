package yacim.bankingApp.data.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yacim.bankingApp.data.dao.common.BaseDao;
import yacim.bankingApp.data.dao.testConfig.TestConfiguration;
import yacim.bankingApp.data.entity.User;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class BaseDaoImplTest {

    @Autowired
    BaseDao<User> baseDao;

    @Autowired
    DataSource dataSource;

    Connection connection;

    @Before
    public void setUp() throws Exception {

        connection = dataSource.getConnection();
        String sql = "insert into t_user (id, username, name, surname, password, role)" +
                "values ('101', 'testUsername', 'testName', 'testSurname', 'testPassword', 'ROLE_USER')";
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
    public void save() {

        User user = new User("Username", "Name", "Surname", "password", "ROLE_USER");

        baseDao.save(user);

        assertNotNull(user);
        assertEquals("Username", user.getUsername());
        assertEquals("Name", user.getName());
        assertEquals("Surname", user.getSurname());
        assertEquals("password", user.getPassword());
        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    public void getById() {

        String id = "101";

        User user = baseDao.getById(User.class, id);

        assertNotNull(user);
        assertEquals("101", user.getId());
        assertEquals("testUsername", user.getUsername());
        assertEquals("testName", user.getName());
        assertEquals("testSurname", user.getSurname());
        assertEquals("testPassword", user.getPassword());
        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    public void update() {

        User user = new User("Username", "Name", "Surname", "password", "ROLE_USER");

        user.setUsername("newUsername");
        user.setName("newName");
        user.setSurname("newSurname");
        user.setPassword("newPassword");
        user.setRole("ROLE_ADMIN");

        baseDao.update(user);

        assertNotNull(user);
        assertEquals("newUsername", user.getUsername());
        assertEquals("newName", user.getName());
        assertEquals("newSurname", user.getSurname());
        assertEquals("newPassword", user.getPassword());
        assertEquals("ROLE_ADMIN", user.getRole());

    }

    @Test
    public void delete() throws SQLException {

        String id = "101";

        baseDao.delete(User.class, id);

        connection = dataSource.getConnection();
        ResultSet rs =  connection.createStatement().executeQuery("select count(*) from t_user where id ='" + id + "';");
        rs.next();

        int actualCount = rs.getInt(1);
        assertEquals(0, actualCount);
        connection.close();

    }
}