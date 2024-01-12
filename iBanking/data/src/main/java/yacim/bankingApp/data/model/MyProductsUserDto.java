package yacim.bankingApp.data.model;

import yacim.bankingApp.data.entity.BankAccount;

import java.util.List;

public class MyProductsUserDto {

    private String username;

    private String name;

    private String surname;

    private List<MyProductsBankAccountDto> bankAccount;

    public MyProductsUserDto() {
    }

    public MyProductsUserDto(String username, String name, String surname,
                             List<MyProductsBankAccountDto> bankAccount) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.bankAccount = bankAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<MyProductsBankAccountDto> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<MyProductsBankAccountDto> bankAccount) {
        this.bankAccount = bankAccount;
    }
}
