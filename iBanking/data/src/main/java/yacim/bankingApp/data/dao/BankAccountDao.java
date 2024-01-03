package yacim.bankingApp.data.dao;

import yacim.bankingApp.data.entity.BankAccount;

import java.sql.SQLException;

public interface BankAccountDao {

    void createBankAccount(BankAccount bankAccount);

    BankAccount getBankCardById(String id);

    void updateBankAccount(BankAccount bankAccount);

    boolean deleteBankAccount(BankAccount bankAccount);

    BankAccount getBankAccountByAccountNumber(String accountNumber) ;
}
