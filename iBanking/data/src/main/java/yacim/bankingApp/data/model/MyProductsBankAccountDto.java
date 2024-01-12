package yacim.bankingApp.data.model;

import java.util.List;

public class MyProductsBankAccountDto {

    private String accountNumber;

    private double accountBalance;

    private String accountCurrency;

    private List<MyProductsBankCardDto> bankCards;

    public MyProductsBankAccountDto() {
    }

    public MyProductsBankAccountDto(String accountNumber, double accountBalance, String accountCurrency,
                                    List<MyProductsBankCardDto> bankCards) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountCurrency = accountCurrency;
        this.bankCards = bankCards;
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

    public List<MyProductsBankCardDto> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<MyProductsBankCardDto> bankCards) {
        this.bankCards = bankCards;
    }
}
