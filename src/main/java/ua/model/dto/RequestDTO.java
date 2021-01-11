package ua.model.dto;

import ua.model.entity.enums.ApartmentClass;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

public class RequestDTO {
    @Positive
    private Long seatsNumber;
    private ApartmentClass apartmentClass;
    @FutureOrPresent
    private LocalDate dateSettlement;
    @Future
    private LocalDate dateEviction;
    private Long userFk;

    public RequestDTO(Long seatsNumber, ApartmentClass apartmentClass, LocalDate dateSettlement, LocalDate dateEviction, Long userFk) {
        this.seatsNumber = seatsNumber;
        this.apartmentClass = apartmentClass;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
        this.userFk = userFk;
    }

    public static RequestDTOBuilder builder() {
        return new RequestDTOBuilder();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestDTO that = (RequestDTO) o;
        return Objects.equals(seatsNumber, that.seatsNumber) && apartmentClass == that.apartmentClass && Objects.equals(dateSettlement, that.dateSettlement) && Objects.equals(dateEviction, that.dateEviction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatsNumber, apartmentClass, dateSettlement, dateEviction);
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "seats_number=" + seatsNumber +
                ", apartmentClass=" + apartmentClass +
                ", dateSettlement=" + dateSettlement +
                ", dateEviction=" + dateEviction +
                '}';
    }

    public static class RequestDTOBuilder {
        private Long seatsNumber;
        private ApartmentClass apartmentClass;
        private LocalDate dateSettlement;
        private LocalDate dateEviction;
        private Long userFk;

        public RequestDTOBuilder() {
        }

        public RequestDTOBuilder seats_number(Long seatsNumber) {
            this.seatsNumber = seatsNumber;
            return this;
        }

        public RequestDTOBuilder apartmentClass(ApartmentClass apartmentClass) {
            this.apartmentClass = apartmentClass;
            return this;
        }

        public RequestDTOBuilder dateSettlement(LocalDate dateSettlement) {
            this.dateSettlement = dateSettlement;
            return this;
        }

        public RequestDTOBuilder dateEviction(LocalDate dateEviction) {
            this.dateEviction = dateEviction;
            return this;
        }

        public RequestDTOBuilder userFk(Long userFk) {
            this.userFk = userFk;
            return this;
        }

        public RequestDTO build() {
            return new RequestDTO(seatsNumber, apartmentClass, dateSettlement, dateEviction, userFk);
        }

        @Override
        public String toString() {
            return "RequestBuilder{" +
                    ", seats_number=" + seatsNumber +
                    ", apartmentClass=" + apartmentClass +
                    ", dateSettlement=" + dateSettlement +
                    ", dateEviction=" + dateEviction +
                    '}';
        }
    }
}
