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
import yacim.bankingApp.data.entity.BankAccount;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class BankAccountDaoImplTest {

    @Autowired
    BankAccountDao bankAccountDao;

    @Autowired
    DataSource dataSource;

    Connection connection;

    @Before
    public void setUp() throws Exception {

        connection = dataSource.getConnection();
        String sql1 = "insert into t_user (id, username, name, surname, password, role)" +
                "values ('abc1000', 'user', 'user', 'user', 'user', 'ROLE_USER')";
        String sql2 = "insert into bank_account (id, account_number, account_balance, account_currency, user_id)" +
                "values (101, 12345, 1000, 'USD', 'abc1000')";

        connection.createStatement().executeUpdate(sql1);
        connection.createStatement().executeUpdate(sql2);

    }

    @After
    public void tearDown() throws Exception {

        connection = dataSource.getConnection();
        String sql1 = "delete from bank_account";
        String sql2 = "delete from t_user";

        connection.createStatement().executeUpdate(sql1);
        connection.createStatement().executeUpdate(sql2);
        connection.close();

    }

    @Test
    public void getAllBankAccounts() {

        double DELTA = 1e-15;

        List<BankAccount> bankAccounts = bankAccountDao.getAllBankAccounts();

        assertNotNull(bankAccounts);
        assertEquals(1, bankAccounts.size());
        assertEquals("101", bankAccounts.get(0).getId());
        assertEquals("12345", bankAccounts.get(0).getAccountNumber());
        assertEquals(1000, bankAccounts.get(0).getAccountBalance(), DELTA);
        assertEquals("USD", bankAccounts.get(0).getAccountCurrency());
    }

    @Test
    public void getBankAccountsByUserId() {

        String id = "abc1000";

        List<BankAccount> bankAccounts = bankAccountDao.getBankAccountsByUserId(id);

        assertNotNull(bankAccounts);
        assertEquals(1, bankAccounts.size());
        assertEquals("USD", bankAccounts.get(0).getAccountCurrency());
    }

    @Test
    public void getBankAccountByAccountNumber() {

        double DELTA = 1e-15;

        String accNumber = "12345";

        BankAccount bankAccount = bankAccountDao.getBankAccountByAccountNumber(accNumber);

        assertNotNull(bankAccount);
        assertEquals("101", bankAccount.getId());
        assertEquals(1000, bankAccount.getAccountBalance(), DELTA);
    }
}