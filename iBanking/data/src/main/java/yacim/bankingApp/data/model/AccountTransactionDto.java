package yacim.bankingApp.data.model;

import java.time.LocalDateTime;

public class AccountTransactionDto {

    private String id;

    private String accountNumber;

    private LocalDateTime transactionDate;

    private double replenishmentAmount;

    private String  transactionCurrency;

    private String transactionType;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(String id, String accountNumber, LocalDateTime transactionDate,
                                 double replenishmentAmount, String transactionCurrency, String transactionType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.transactionDate = transactionDate;
        this.replenishmentAmount = replenishmentAmount;
        this.transactionCurrency = transactionCurrency;
        this.transactionType = transactionType;
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

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getReplenishmentAmount() {
        return replenishmentAmount;
    }

    public void setReplenishmentAmount(double replenishmentAmount) {
        this.replenishmentAmount = replenishmentAmount;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
