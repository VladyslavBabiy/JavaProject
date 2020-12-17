package ua.model.entity;


import ua.model.entity.enums.ApartmentClass;

import java.sql.Date;
import java.util.Objects;

public class Request {
    private Long Id;
    private Long seats_number;
    private ApartmentClass apartmentClass;
    private Date dateSettlement;
    private Date dateEviction;

    public Request(){
    }

    public Long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public Date getDateSettlement() {
        return dateSettlement;
    }

    public void setDateSettlement(Date dateSettlement) {
        this.dateSettlement = dateSettlement;
    }

    public Date getDateEviction() {
        return dateEviction;
    }

    public void setDateEviction(Date dateEviction) {
        this.dateEviction = dateEviction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Id == request.Id && seats_number == request.seats_number && apartmentClass == request.apartmentClass && Objects.equals(dateSettlement, request.dateSettlement) && Objects.equals(dateEviction, request.dateEviction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, seats_number, apartmentClass, dateSettlement, dateEviction);
    }

    @Override
    public String toString() {
        return "Request{" +
                "Id=" + Id +
                ", seats_number=" + seats_number +
                ", apartmentClass=" + apartmentClass +
                ", dateSettlement=" + dateSettlement +
                ", date_eviction=" + dateEviction +
                '}';
    }
}
