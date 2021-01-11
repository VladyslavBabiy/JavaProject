package ua.model.dto;

import ua.model.entity.enums.ApartmentClass;

import java.time.LocalDate;
import java.util.Objects;

public class BookingRequestDTO {
    private Long ID;
    private Long seatsNumber;
    private ApartmentClass apartmentClass;
    private LocalDate dateSettlement;
    private LocalDate dateEviction;
    private Long userFk;
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;

    public BookingRequestDTO(Long ID, Long seatsNumber, ApartmentClass apartmentClass, LocalDate dateSettlement, LocalDate dateEviction,
                             Long userFk, String login, String email, String firstName, String middleName, String lastName) {
        this.ID = ID;
        this.seatsNumber = seatsNumber;
        this.apartmentClass = apartmentClass;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
        this.userFk = userFk;
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public static BookingRequestDTOBuilder builder() {
        return new BookingRequestDTOBuilder();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Long seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public ApartmentClass getApartmentClass() {
        return apartmentClass;
    }

    public void setApartmentClass(ApartmentClass apartmentClass) {
        this.apartmentClass = apartmentClass;
    }

    public LocalDate getDateSettlement() {
        return dateSettlement;
    }

    public void setDateSettlement(LocalDate dateSettlement) {
        this.dateSettlement = dateSettlement;
    }

    public LocalDate getDateEviction() {
        return dateEviction;
    }

    public void setDateEviction(LocalDate dateEviction) {
        this.dateEviction = dateEviction;
    }

    public Long getUserFk() {
        return userFk;
    }

    public void setUserFk(Long userFk) {
        this.userFk = userFk;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingRequestDTO that = (BookingRequestDTO) o;
        return Objects.equals(ID, that.ID) && Objects.equals(seatsNumber, that.seatsNumber) && apartmentClass == that.apartmentClass && Objects.equals(dateSettlement, that.dateSettlement) && Objects.equals(dateEviction, that.dateEviction) && Objects.equals(userFk, that.userFk) && Objects.equals(login, that.login) && Objects.equals(email, that.email) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(middleName, that.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, seatsNumber, apartmentClass, dateSettlement, dateEviction, userFk, login, email, firstName, lastName, middleName);
    }

    @Override
    public String toString() {
        return "BookingRequestDTO{" +
                "ID=" + ID +
                ", seatsNumber=" + seatsNumber +
                ", apartmentClass=" + apartmentClass +
                ", dateSettlement=" + dateSettlement +
                ", dateEviction=" + dateEviction +
                ", userFk=" + userFk +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }

    public static class BookingRequestDTOBuilder {
        private Long ID;
        private Long seatsNumber;
        private ApartmentClass apartmentClass;
        private LocalDate dateSettlement;
        private LocalDate dateEviction;
        private Long userFk;
        private String login;
        private String email;
        private String first_name;
        private String last_name;
        private String middle_name;

        public BookingRequestDTOBuilder() {
        }

        public BookingRequestDTOBuilder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public BookingRequestDTOBuilder seats_number(Long seatsNumber) {
            this.seatsNumber = seatsNumber;
            return this;
        }

        public BookingRequestDTOBuilder apartmentClass(ApartmentClass apartmentClass) {
            this.apartmentClass = apartmentClass;
            return this;
        }

        public BookingRequestDTOBuilder dateSettlement(LocalDate dateSettlement) {
            this.dateSettlement = dateSettlement;
            return this;
        }

        public BookingRequestDTOBuilder dateEviction(LocalDate dateEviction) {
            this.dateEviction = dateEviction;
            return this;
        }

        public BookingRequestDTOBuilder userFk(Long userFk) {
            this.userFk = userFk;
            return this;
        }

        public BookingRequestDTOBuilder login(String login) {
            this.login = login;
            return this;
        }


        public BookingRequestDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public BookingRequestDTOBuilder firs_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public BookingRequestDTOBuilder last_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public BookingRequestDTOBuilder middle_name(String middle_name) {
            this.middle_name = middle_name;
            return this;
        }

        public BookingRequestDTO build() {
            return new BookingRequestDTO(ID, seatsNumber, apartmentClass, dateSettlement, dateEviction,
                    userFk, login, email, first_name, middle_name, last_name);
        }

        @Override
        public String toString() {
            return "BookingRequestDTOBuilder{" +
                    "ID=" + ID +
                    ", seatsNumber=" + seatsNumber +
                    ", apartmentClass=" + apartmentClass +
                    ", dateSettlement=" + dateSettlement +
                    ", dateEviction=" + dateEviction +
                    ", userFk=" + userFk +
                    ", login='" + login + '\'' +
                    ", email='" + email + '\'' +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", middle_name='" + middle_name + '\'' +
                    '}';
        }
    }
}
