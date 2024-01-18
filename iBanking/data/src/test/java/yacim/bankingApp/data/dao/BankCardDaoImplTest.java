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
import yacim.bankingApp.data.entity.BankCard;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class BankCardDaoImplTest {

    @Autowired
    BankCardDao bankCardDao;

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
        String sql3 = "insert into bank_card (id, card_number, cardholder_name, card_balance, card_currency, cvv, bank_account_id)" +
                "values (111, 12345, 'test', 1000, 'USD', 911, 101)";

        connection.createStatement().executeUpdate(sql1);
        connection.createStatement().executeUpdate(sql2);
        connection.createStatement().executeUpdate(sql3);

    }

    @After
    public void tearDown() throws Exception {

        connection = dataSource.getConnection();
        String sql1 = "delete from bank_card";
        String sql2 = "delete from bank_account";
        String sql3 = "delete from t_user";

        connection.createStatement().executeUpdate(sql1);
        connection.createStatement().executeUpdate(sql2);
        connection.createStatement().executeUpdate(sql3);
        connection.close();

    }

    @Test
    public void getAllCards() {

        List<BankCard> bankCards = bankCardDao.getAllCards();

        assertNotNull(bankCards);
        assertEquals(1, bankCards.size());
        assertEquals("111", bankCards.get(0).getId());
        assertEquals("12345", bankCards.get(0).getCardNumber());
    }

    @Test
    public void getBankCardsByBankAccountId() {

        String id = "101";

        List<BankCard> bankCards = bankCardDao.getBankCardsByBankAccountId(id);

        assertNotNull(bankCards);
        assertEquals(1, bankCards.size());
        assertEquals("111", bankCards.get(0).getId());
        assertEquals("12345", bankCards.get(0).getCardNumber());
    }
}