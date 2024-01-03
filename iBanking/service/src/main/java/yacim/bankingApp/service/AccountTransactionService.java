package yacim.bankingApp.service;

import yacim.bankingApp.data.model.AccountTransactionDto;
import yacim.bankingApp.data.model.TransferTransactionDto;

public interface AccountTransactionService {

    void doTransactionForReplenish(AccountTransactionDto accountTransactionDto) ;

    void doTransactionForCredit(AccountTransactionDto accountTransactionDto);

    void doTransferTransaction (TransferTransactionDto transferTransactionDto);
}
