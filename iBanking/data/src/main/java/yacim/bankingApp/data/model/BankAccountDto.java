package yacim.bankingApp.data.model;

import yacim.bankingApp.data.entity.User;

public class BankAccountDto {

    private String id;

    private String accountNumber;

    private double accountBalance;

    private String accountCurrency;

    private User accountOwner;

    public BankAccountDto() {
    }

    public BankAccountDto(String id, String accountNumber, double accountBalance, String accountCurrency, User accountOwner) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountCurrency = accountCurrency;
        this.accountOwner = accountOwner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public User getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(User accountOwner) {
        this.accountOwner = accountOwner;
    }
}
