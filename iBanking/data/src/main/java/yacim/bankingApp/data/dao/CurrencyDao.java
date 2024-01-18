package yacim.bankingApp.data.dao;

import yacim.bankingApp.data.entity.Currency;

import java.util.List;

public interface CurrencyDao {

    List<Currency> getAllForPagination(int startPosition, int pageSize);

    int getTotalCurrencyCount();
}
