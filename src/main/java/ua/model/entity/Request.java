package ua.model.entity;


import ua.model.entity.enums.ApartmentClass;


import java.time.LocalDate;
import java.util.Objects;

public class Request {
    private Long id;
    private Long seats_number;
    private ApartmentClass apartmentClass;
    private LocalDate dateSettlement;
    private LocalDate dateEviction;
    private Long userFk;

    public Request() {
    }

    public Request(Long id, Long seatsNumber, ApartmentClass apartmentClass, LocalDate dateSettlement, LocalDate dateEviction, Long userFk) {
        this.id = id;
        this.seats_number = seatsNumber;
        this.apartmentClass = apartmentClass;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
        this.userFk = userFk;
    }

    public static RequestBuilder builder() {
        return new RequestBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeats_number() {
        return seats_number;
    }

    public void setSeats_number(Long seats_number) {
        this.seats_number = seats_number;
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
        Request request = (Request) o;
        return id == request.id && seats_number == request.seats_number && apartmentClass == request.apartmentClass && Objects.equals(dateSettlement, request.dateSettlement) && Objects.equals(dateEviction, request.dateEviction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seats_number, apartmentClass, dateSettlement, dateEviction);
    }

    @Override
    public String toString() {
        return "Request{" +
                "Id=" + id +
                ", seats_number=" + seats_number +
                ", apartmentClass=" + apartmentClass +
                ", dateSettlement=" + dateSettlement +
                ", date_eviction=" + dateEviction +
                '}';
    }

    public static class RequestBuilder {
        private Long id;
        private Long seats_number;
        private ApartmentClass apartmentClass;
        private LocalDate dateSettlement;
        private LocalDate dateEviction;
        private Long userFk;

        public RequestBuilder() {
        }

        public RequestBuilder ID(Long id) {
            this.id = id;
            return this;
        }

        public RequestBuilder seats_number(Long seats_number) {
            this.seats_number = seats_number;
            return this;
        }

        public RequestBuilder apartmentClass(ApartmentClass apartmentClass) {
            this.apartmentClass = apartmentClass;
            return this;
        }

        public RequestBuilder dateSettlement(LocalDate dateSettlement) {
            this.dateSettlement = dateSettlement;
            return this;
        }

        public RequestBuilder dateEviction(LocalDate dateEviction) {
            this.dateEviction = dateEviction;
            return this;
        }

        public RequestBuilder userFk(Long userFk) {
            this.userFk = userFk;
            return this;
        }

        public Request build() {
            return new Request(id, seats_number, apartmentClass, dateSettlement, dateEviction, userFk);
        }

        @Override
        public String toString() {
            return "RequestBuilder{" +
                    "id=" + id +
                    ", seats_number=" + seats_number +
                    ", apartmentClass=" + apartmentClass +
                    ", dateSettlement=" + dateSettlement +
                    ", dateEviction=" + dateEviction +
                    '}';
        }
    }
}
