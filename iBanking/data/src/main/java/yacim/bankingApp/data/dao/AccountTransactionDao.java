package yacim.bankingApp.data.dao;

import yacim.bankingApp.data.entity.AccountTransaction;
import yacim.bankingApp.data.entity.TransferTransaction;

public interface AccountTransactionDao {

    void saveTransaction (AccountTransaction accountTransaction);

    void saveTransaction (TransferTransaction transferTransaction);
}
