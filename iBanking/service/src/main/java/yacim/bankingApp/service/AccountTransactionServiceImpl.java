package yacim.bankingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yacim.bankingApp.data.dao.AccountTransactionDao;
import yacim.bankingApp.data.dao.BankAccountDao;
import yacim.bankingApp.data.entity.AccountTransaction;
import yacim.bankingApp.data.entity.BankAccount;
import yacim.bankingApp.data.entity.TransferTransaction;
import yacim.bankingApp.data.model.AccountTransactionDto;
import yacim.bankingApp.data.model.TransferTransactionDto;

import java.time.LocalDateTime;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {


    private final AccountTransactionDao accountTransactionDao;

    private final BankAccountDao bankAccountDao;

    @Autowired
    public AccountTransactionServiceImpl(AccountTransactionDao accountTransactionDao, BankAccountDao bankAccountDao) {
        this.accountTransactionDao = accountTransactionDao;
        this.bankAccountDao = bankAccountDao;
    }

    @Override
    public void doTransactionForReplenish(AccountTransactionDto accountTransactionDto)  {

        String accountNumber = accountTransactionDto.getAccountNumber();
        BankAccount bankAccount = bankAccountDao.getBankAccountByAccountNumber(accountNumber);

        if (bankAccount != null) {
            double newBalance = bankAccount.getAccountBalance() + accountTransactionDto.getReplenishmentAmount();
            bankAccount.setAccountBalance(newBalance);

            AccountTransaction accountTransaction = new AccountTransaction();
            accountTransaction.setAccountNumber(accountTransactionDto.getAccountNumber());
            accountTransaction.setTransactionDate(LocalDateTime.now());
            accountTransaction.setReplenishmentAmount(accountTransactionDto.getReplenishmentAmount());
            accountTransaction.setTransactionCurrency(accountTransactionDto.getTransactionCurrency());
            accountTransaction.setTransactionType("replenishment");

            bankAccountDao.updateBankAccount(bankAccount);
            accountTransactionDao.saveTransaction(accountTransaction);
        } else  {
            System.out.println("Счет с номером " + accountNumber + " не найден");
        }
    }

    @Override
    public void doTransactionForCredit(AccountTransactionDto accountTransactionDto) {

        String accountNumber = accountTransactionDto.getAccountNumber();
        BankAccount bankAccount = bankAccountDao.getBankAccountByAccountNumber(accountNumber);

        if (bankAccount != null) {
            double newBalance = bankAccount.getAccountBalance() + accountTransactionDto.getReplenishmentAmount();
            bankAccount.setAccountBalance(newBalance);

            AccountTransaction accountTransaction = new AccountTransaction();
            accountTransaction.setAccountNumber(accountTransactionDto.getAccountNumber());
            accountTransaction.setTransactionDate(LocalDateTime.now());
            accountTransaction.setReplenishmentAmount(accountTransactionDto.getReplenishmentAmount());
            accountTransaction.setTransactionCurrency(accountTransactionDto.getTransactionCurrency());
            accountTransaction.setTransactionType("credit");

            bankAccountDao.updateBankAccount(bankAccount);
            accountTransactionDao.saveTransaction(accountTransaction);
        } else  {
            System.out.println("Счет с номером " + accountNumber + " не найден");
        }
    }

    @Override
    public void doTransferTransaction(TransferTransactionDto transferTransactionDto) {

        String accountNumberFrom = transferTransactionDto.getAccountNumberFrom();
        BankAccount bankAccountFrom = bankAccountDao.getBankAccountByAccountNumber(accountNumberFrom);

        String accountNumberTo = transferTransactionDto.getAccountNumberTo();
        BankAccount bankAccountTo = bankAccountDao.getBankAccountByAccountNumber(accountNumberTo);

        if (bankAccountFrom != null) {

            double transferAmount = transferTransactionDto.getReplenishmentAmount();

            if (bankAccountFrom.getAccountBalance() >= transferAmount) {

                double newBalanceFrom = bankAccountFrom.getAccountBalance() - transferTransactionDto.getReplenishmentAmount();
                bankAccountFrom.setAccountBalance(newBalanceFrom);

                double newBalanceTo = bankAccountTo.getAccountBalance() + transferTransactionDto.getReplenishmentAmount();
                bankAccountTo.setAccountBalance(newBalanceTo);

                TransferTransaction transferTransaction = new TransferTransaction();
                transferTransaction.setAccountNumberFrom(transferTransactionDto.getAccountNumberFrom());
                transferTransaction.setAccountNumberTo(transferTransactionDto.getAccountNumberTo());
                transferTransaction.setTransactionDate(LocalDateTime.now());
                transferTransaction.setReplenishmentAmount(transferTransactionDto.getReplenishmentAmount());
                transferTransaction.setTransactionCurrency(transferTransactionDto.getTransactionCurrency());

                AccountTransaction accountTransactionFrom = new AccountTransaction();
                accountTransactionFrom.setAccountNumber(transferTransactionDto.getAccountNumberFrom());
                accountTransactionFrom.setTransactionDate(LocalDateTime.now());
                accountTransactionFrom.setReplenishmentAmount( - transferTransactionDto.getReplenishmentAmount());
                accountTransactionFrom.setTransactionCurrency(transferTransactionDto.getTransactionCurrency());
                accountTransactionFrom.setTransactionType("transfer");

                AccountTransaction accountTransactionTo = new AccountTransaction();
                accountTransactionTo.setAccountNumber(transferTransactionDto.getAccountNumberTo());
                accountTransactionTo.setTransactionDate(LocalDateTime.now());
                accountTransactionTo.setReplenishmentAmount(transferTransactionDto.getReplenishmentAmount());
                accountTransactionTo.setTransactionCurrency(transferTransactionDto.getTransactionCurrency());
                accountTransactionTo.setTransactionType("transfer");

                bankAccountDao.updateBankAccount(bankAccountFrom);
                bankAccountDao.updateBankAccount(bankAccountTo);
                accountTransactionDao.saveTransaction(transferTransaction);
                accountTransactionDao.saveTransaction(accountTransactionFrom);
                accountTransactionDao.saveTransaction(accountTransactionTo);

            } else {
                System.out.println("Недостаточно средств для перевода счета " + accountNumberFrom);
            }
        } else {
            System.out.println("Счет с номером " + accountNumberFrom + " не найден");
        }
    }

}
