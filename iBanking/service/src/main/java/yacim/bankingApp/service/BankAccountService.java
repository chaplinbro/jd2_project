package yacim.bankingApp.service;

import yacim.bankingApp.data.model.BankAccountDto;

public interface BankAccountService {

    void createBankAccount(BankAccountDto bankAccountDto,String userId);
}
