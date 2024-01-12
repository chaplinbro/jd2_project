package yacim.bankingApp.data.entity;

import jakarta.persistence.*;
import yacim.bankingApp.data.entity.common.BaseEntity;

import java.util.List;

@Entity
@Table(name = "t_user")
public class User extends BaseEntity {

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "accountOwner", cascade = CascadeType.ALL)
    private List<BankAccount> bankAccount;

    public User() {
    }

    public User(String email, String name, String surname, String password, String role) {
        this.username = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<BankAccount> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<BankAccount> bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        if (!username.equals(user.username)) return false;
        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;
        if (!password.equals(user.password)) return false;
        if (!role.equals(user.role)) return false;
        return bankAccount.equals(user.bankAccount);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + bankAccount.hashCode();
        return result;
    }
}