package ua.model.entity;

import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String password;
    private Role role;
    private String email;
    private String first_name;
    private String last_name;
    private String middle_name;

    public User() {
    }

    public User(Long Id, String login, String password, Role role, String email, String first_name, String last_name, String middle_name) {
        this.id = Id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && login.equals(user.login) && password.equals(user.password) && role == user.role && email.equals(user.email) && first_name.equals(user.first_name) && last_name.equals(user.last_name) && middle_name.equals(user.middle_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role, email, first_name, last_name, middle_name);
    }

    public enum Role {
        Admin,
        User,
        Unknown;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                '}';
    }

    public static class UserBuilder {
        private Long id;
        private String login;
        private String password;
        private Role role;
        private String email;
        private String first_name;
        private String last_name;
        private String middle_name;

        UserBuilder() {
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder firs_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public UserBuilder last_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public UserBuilder middle_name(String middle_name) {
            this.middle_name = middle_name;
            return this;
        }

        public User build() {
            return new User(id, login, password, role, email,first_name,last_name,middle_name);
        }

        @Override
        public String toString() {
            return "UserBuilder{" +
                    "id=" + id +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", role=" + role +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}
