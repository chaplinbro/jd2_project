package yacim.bankingApp.data.entity;

import jakarta.persistence.*;
import yacim.bankingApp.data.entity.common.BaseEntity;

import java.util.List;

@Entity
@Table(name = "bank_account")
public class BankAccount extends BaseEntity {

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Column(name = "account_balance")
    private double accountBalance;

    @Column(name = "account_currency")
    private String accountCurrency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User accountOwner;

    @OneToMany(mappedBy ="bankAccount")
    private List<BankCard> bankCards;


    public BankAccount() {
    }

    public BankAccount(String accountNumber, double accountBalance, String accountCurrency) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountCurrency = accountCurrency;
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

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
    }

}