package ua.model.entity;

import java.util.Objects;

public class User {
    private Long Id;
    private String login;
    private String password;
    private Role role;
    private String email;
    public User (){
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && role == user.role && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, login, password, role, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                '}';
    }

    public enum Role {
        Admin,
        User,
        Unknown;
    }
}
