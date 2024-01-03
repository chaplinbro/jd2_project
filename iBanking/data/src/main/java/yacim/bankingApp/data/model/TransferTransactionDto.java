package yacim.bankingApp.data.model;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class TransferTransactionDto {

    private String id;

    private String accountNumberFrom;

    private String accountNumberTo;

    private LocalDateTime transactionDate;

    private double replenishmentAmount;

    private String  transactionCurrency;

    public TransferTransactionDto() {
    }

    public TransferTransactionDto(String id, String accountNumberFrom, String accountNumberTo, LocalDateTime transactionDate,
                                  double replenishmentAmount, String transactionCurrency) {
        this.id = id;
        this.accountNumberFrom = accountNumberFrom;
        this.accountNumberTo = accountNumberTo;
        this.transactionDate = transactionDate;
        this.replenishmentAmount = replenishmentAmount;
        this.transactionCurrency = transactionCurrency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(String accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    public String getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(String accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
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
}
