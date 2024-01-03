package yacim.bankingApp.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import yacim.bankingApp.data.entity.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "transfer_transaction")
public class TransferTransaction extends BaseEntity {

    @Column(name = "account_number_from")
    private String accountNumberFrom;

    @Column(name = "account_number_to")
    private String accountNumberTo;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "replenishment_amount")
    private double replenishmentAmount;

    @Column(name = "transaction_currency")
    private String  transactionCurrency;

    public TransferTransaction() {
    }

    public TransferTransaction(String accountNumberFrom, String accountNumberTo, LocalDateTime transactionDate,
                               double replenishmentAmount, String transactionCurrency) {
        this.accountNumberFrom = accountNumberFrom;
        this.accountNumberTo = accountNumberTo;
        this.transactionDate = transactionDate;
        this.replenishmentAmount = replenishmentAmount;
        this.transactionCurrency = transactionCurrency;
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
