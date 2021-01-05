package ua.model.entity;


import ua.model.entity.enums.ApartmentClass;


import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;

public class Request {
    private Long id;
    private Long seats_number;
    private ApartmentClass apartmentClass;
    private LocalDateTime dateSettlement;
    private LocalDateTime dateEviction;

    public Request(){
    }

    public Request(Long id, Long seatsNumber, ApartmentClass apartmentClass, LocalDateTime dateSettlement, LocalDateTime dateEviction) {
        this.id = id;
        this.seats_number = seatsNumber;
        this.apartmentClass = apartmentClass;
        this.dateSettlement = dateSettlement;
        this.dateEviction = dateEviction;
    }
    public static RequestBuilder builder (){return new RequestBuilder();}
    public Long getId() {
        return id;
    }

    public void setId(long id) {
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
    public static class RequestBuilder
    {
        private Long id;
        private Long seats_number;
        private ApartmentClass apartmentClass;
        private LocalDateTime dateSettlement;
        private LocalDateTime dateEviction;

        public RequestBuilder() {
        }

        public RequestBuilder ID (Long id)
        {
            this.id = id;
            return this;
        }

        public RequestBuilder seats_number(Long seats_number)
        {
            this.seats_number = seats_number;
            return this;
        }
        public RequestBuilder apartmentClass(ApartmentClass apartmentClass)
        {
            this.apartmentClass = apartmentClass;
            return this;
        }
        public RequestBuilder dateSettlement (LocalDateTime dateSettlement)
        {
            this.dateSettlement = dateSettlement;
            return this;
        }
        public RequestBuilder dateEviction (LocalDateTime dateEviction)
        {
            this.dateEviction = dateEviction;
            return this;
        }
        public Request build (){return new Request(id,seats_number,apartmentClass,dateSettlement,dateEviction);}

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
