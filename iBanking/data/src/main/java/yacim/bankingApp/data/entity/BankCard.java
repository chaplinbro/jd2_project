package yacim.bankingApp.data.entity;

import jakarta.persistence.*;
import yacim.bankingApp.data.entity.common.BaseEntity;

@Entity
@Table(name = "bank_card")
public class BankCard extends BaseEntity {

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "card_balance")
    private double cardBalance;

    @Column(name = "card_currency")
    private String cardCurrency;

    @Column(name = "cvv")
    private int cvv;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    public BankCard() {
    }

    public BankCard(String cardNumber, String cardholderName, double card_balance, String cardCurrency, int cvv) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.cardBalance = card_balance;
        this.cardCurrency = cardCurrency;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCardCurrency() {
        return cardCurrency;
    }

    public void setCardCurrency(String cardCurrency) {
        this.cardCurrency = cardCurrency;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}