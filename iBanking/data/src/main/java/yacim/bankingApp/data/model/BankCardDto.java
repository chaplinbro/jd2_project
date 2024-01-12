package yacim.bankingApp.data.model;

import jakarta.persistence.Column;
import yacim.bankingApp.data.entity.BankAccount;

import java.time.LocalDate;

public class BankCardDto {

    private String id;

    private String cardNumber;

    private String cardholderName;

    private double card_balance;

    private String cardCurrency;

    private String cvv;

    private BankAccount bankAccount;


    public BankCardDto() {
    }

    public BankCardDto(String id, String cardNumber, String cardholderName, double card_balance, String cardCurrency, String cvv, BankAccount bankAccount) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.card_balance = card_balance;
        this.cardCurrency = cardCurrency;
        this.cvv = cvv;
        this.bankAccount = bankAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getCard_balance() {
        return card_balance;
    }

    public void setCard_balance(double card_balance) {
        this.card_balance = card_balance;
    }

    public String getCardCurrency() {
        return cardCurrency;
    }

    public void setCardCurrency(String cardCurrency) {
        this.cardCurrency = cardCurrency;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
