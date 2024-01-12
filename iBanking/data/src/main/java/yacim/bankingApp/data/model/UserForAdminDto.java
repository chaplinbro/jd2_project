package yacim.bankingApp.data.model;

public class UserForAdminDto {

    private String id;

    private String username;

    private String name;

    private String surname;

    public UserForAdminDto() {
    }

    public UserForAdminDto(String id, String username, String name, String surname) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
