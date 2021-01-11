package ua.model.dto;


import ua.model.entity.User;

import javax.validation.constraints.*;
import java.util.Objects;

public class UserDTO {
    @NotNull(message = "Login field null!")
    @NotBlank(message = "Login field blank!")
    @Pattern(regexp = "^[а-яА-Яa-zA-Z0-9]+$")
    private String login;

    @NotNull(message = "Password field null!")
    @NotBlank(message = "Password field blank!")
    @Size(min = 8, max = 16, message = "Password field not in size 8 - 16")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$")
    private String password;

    @Email
    @NotBlank(message = "Email field blank!")
    private String email;

    @NotNull(message = "First name field null!")
    @NotBlank(message = "Fist name field blank")
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$")
    @Size(min = 3, max = 65, message = "First name field not in size 3 - 65")
    private String first_name;

    @NotNull(message = "Last name field null!")
    @NotBlank(message = "Last name field blank")
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$")
    @Size(min = 3, max = 65, message = "Last name field not in size 3 - 65")
    private String last_name;

    @NotNull(message = "Middle name field null!")
    @NotBlank(message = "Middle name field blank")
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$")
    @Size(min = 3, max = 65, message = "Middle name field not in size 3 - 65")
    private String middle_name;

    public UserDTO(String login, String password, String email, String first_name, String middle_name, String last_name) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
    }

    public UserDTO() {
    }

    public static UserDTOBuilder builder() {
        return new UserDTOBuilder();
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
        UserDTO userDTO = (UserDTO) o;
        return login.equals(userDTO.login) && password.equals(userDTO.password) && email.equals(userDTO.email) && first_name.equals(userDTO.first_name) && last_name.equals(userDTO.last_name) && middle_name.equals(userDTO.middle_name);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, email, first_name, last_name, middle_name);
    }

    public static class UserDTOBuilder {
        private String login;
        private String password;
        private String email;
        private String first_name;
        private String last_name;
        private String middle_name;

        UserDTOBuilder() {
        }

        public UserDTOBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserDTOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder firs_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public UserDTOBuilder last_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public UserDTOBuilder middle_name(String middle_name) {
            this.middle_name = middle_name;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(login, password, email, first_name, middle_name, last_name);
        }

        @Override
        public String toString() {
            return "UserDTOBuilder{" +
                    "login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", middle_name='" + middle_name + '\'' +
                    '}';
        }
    }

}
