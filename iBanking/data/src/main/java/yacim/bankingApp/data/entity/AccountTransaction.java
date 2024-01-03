package yacim.bankingApp.data.entity;

import jakarta.persistence.*;
import yacim.bankingApp.data.entity.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "account_transaction")
public class AccountTransaction  extends BaseEntity {

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "replenishment_amount")
    private double replenishmentAmount;
    @Column(name = "transaction_currency")
    private String  transactionCurrency;

    @Column(name = "transaction_type")
    private String transactionType;

    public AccountTransaction() {
    }

    public AccountTransaction(String accountNumber, LocalDateTime transactionDate,
                              double replenishmentAmount, String transactionCurrency, String transactionType) {
        this.accountNumber = accountNumber;
        this.transactionDate = transactionDate;
        this.replenishmentAmount = replenishmentAmount;
        this.transactionCurrency = transactionCurrency;
        this.transactionType = transactionType;
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }
}
