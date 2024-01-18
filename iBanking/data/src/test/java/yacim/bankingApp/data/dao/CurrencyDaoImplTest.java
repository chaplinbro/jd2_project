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
import yacim.bankingApp.data.entity.Currency;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class CurrencyDaoImplTest {

    @Autowired
    CurrencyDao currencyDao;

    @Autowired
    DataSource dataSource;

    Connection connection;

    @Before
    public void setUp() throws Exception {

        connection = dataSource.getConnection();
        String sql1 = "delete from currency_exchange_rate";
        connection.createStatement().executeUpdate(sql1);
        String sql2 = "insert into currency_exchange_rate (id, digital_code, letter_code, name, quantity, exchange_rate, update_time) " +
                "values (101, 840, 'USD', 'Доллар США', 1, 3.19, '2024-01-22 00:00:01')," +
                "(102, 036, 'AUD', 'Австралийский доллар', 1, 2.18, '2024-01-22 00:00:01')," +
                "(103, 978, 'EUR', 'Евро', 1, 3.53, '2024-01-22 00:00:01')," +
                "(104, 643, 'RUB', 'Российский рубль', 100, 3.48, '2024-01-22 00:00:01')";
        connection.createStatement().executeUpdate(sql2);

    }

    @After
    public void tearDown() throws Exception {

        connection = dataSource.getConnection();
        String sql = "delete from currency_exchange_rate";
        connection.createStatement().executeUpdate(sql);
        connection.close();

    }

    @Test
    public void getAllCurrency() {

        List<Currency> currencies = currencyDao.getAllForPagination(1,3);

        assertNotNull(currencies);
        assertEquals("AUD", currencies.get(0).getLetterCode());
        assertEquals("EUR", currencies.get(1).getLetterCode());
        assertEquals("RUB", currencies.get(2).getLetterCode());
    }

    @Test
    public void getTotalCurrencyCount() {

        int currency = currencyDao.getTotalCurrencyCount();

        assertEquals(4, currency);
    }
}