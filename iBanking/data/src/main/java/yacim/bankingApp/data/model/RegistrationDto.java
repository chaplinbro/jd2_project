package yacim.bankingApp.data.model;

public class RegistrationDto {

    private String username;

    private String name;

    private String surname;

    private String password;

    private UserRole role;

    public RegistrationDto() {
    }

    public RegistrationDto(String email, String name, String surname, String password, UserRole role) {
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
