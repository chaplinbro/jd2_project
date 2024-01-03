package yacim.bankingApp.data.entity;

import jakarta.persistence.*;
import yacim.bankingApp.data.entity.common.BaseEntity;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "currency_exchange_rate")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "digital_code")
    private int digitalCode;

    @Column(name = "letter_code")
    private String letterCode;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "exchange_rate")
    private double exchangeRate;

    @Column(name = "update_time")
    private Date updateTime;

    public Currency() {
    }

    public Currency(int id, int digitalCode, String letterCode, String name, int quantity, double exchangeRate, Date updateTime) {
        this.id = id;
        this.digitalCode = digitalCode;
        this.letterCode = letterCode;
        this.name = name;
        this.quantity = quantity;
        this.exchangeRate = exchangeRate;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDigitalCode() {
        return digitalCode;
    }

    public void setDigitalCode(int digitalCode) {
        this.digitalCode = digitalCode;
    }

    public String getLetterCode() {
        return letterCode;
    }

    public void setLetterCode(String letterCode) {
        this.letterCode = letterCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Currency currency = (Currency) object;
        return id == currency.id && digitalCode == currency.digitalCode && quantity == currency.quantity && Double.compare(exchangeRate, currency.exchangeRate) == 0 && Objects.equals(letterCode, currency.letterCode) && Objects.equals(name, currency.name) && Objects.equals(updateTime, currency.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, digitalCode, letterCode, name, quantity, exchangeRate, updateTime);
    }
}
