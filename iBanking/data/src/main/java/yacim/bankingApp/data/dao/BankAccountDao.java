package yacim.bankingApp.data.dao;

import yacim.bankingApp.data.dao.common.BaseDao;
import yacim.bankingApp.data.entity.BankAccount;
import yacim.bankingApp.data.entity.BankCard;

import java.util.List;

public interface BankAccountDao extends BaseDao<BankAccount> {

    BankAccount getBankAccountByAccountNumber(String accountNumber) ;

    List<BankAccount> getAllBankAccounts();

    List<BankAccount> getBankAccountsByUserId (String userId);
}
