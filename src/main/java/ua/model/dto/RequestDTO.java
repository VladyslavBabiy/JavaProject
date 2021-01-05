package ua.model.dto;

import ua.model.entity.enums.ApartmentClass;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Objects;

public class RequestDTO {
//    @Positive
    private Long seatsNumber;
    private ApartmentClass apartmentClass;
//    @FutureOrPresent
    private LocalDateTime dateSettlement;
//    @Future
    private LocalDateTime dateEviction;
    public RequestDTO(Long seatsNumber, ApartmentClass apartmentClass, LocalDateTime dateSettlement, LocalDateTime dateEviction) {
        this.seatsNumber = seatsNumber;
        this.apartmentClass = apartmentClass;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
    }

    public static RequestDTOBuilder builder (){return new RequestDTOBuilder();}

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

    public LocalDateTime getDateSettlement() {
        return dateSettlement;
    }

    public void setDateSettlement(LocalDateTime dateSettlement) {
        this.dateSettlement = dateSettlement;
    }

    public LocalDateTime getDateEviction() {
        return dateEviction;
    }

    public void setDateEviction(LocalDateTime dateEviction) {
        this.dateEviction = dateEviction;
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
    public static class RequestDTOBuilder
    {
        private Long seatsNumber;
        private ApartmentClass apartmentClass;
        private LocalDateTime dateSettlement;
        private LocalDateTime dateEviction;

        public RequestDTOBuilder() {
        }
        public RequestDTOBuilder seats_number(Long seatsNumber)
        {
            this.seatsNumber = seatsNumber;
            return this;
        }
        public RequestDTOBuilder apartmentClass(ApartmentClass apartmentClass)
        {
            this.apartmentClass = apartmentClass;
            return this;
        }
        public RequestDTOBuilder dateSettlement (LocalDateTime dateSettlement)
        {
            this.dateSettlement = dateSettlement;
            return this;
        }
        public RequestDTOBuilder dateEviction (LocalDateTime dateEviction)
        {
            this.dateEviction = dateEviction;
            return this;
        }
        public RequestDTO build (){return new RequestDTO(seatsNumber,apartmentClass,dateSettlement,dateEviction);}

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
