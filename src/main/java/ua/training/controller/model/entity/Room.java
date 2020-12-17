package ua.training.controller.model.entity;


import ua.training.controller.model.entity.enums.ApartmentClass;

import java.util.Objects;

public class Room {
    private Long Id;
    private Long seatsNumber;
    private ApartmentClass apartmentClass;
    private String apartmentName;

    public Room() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Id.equals(room.Id) && seatsNumber.equals(room.seatsNumber) && apartmentClass == room.apartmentClass && apartmentName.equals(room.apartmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, seatsNumber, apartmentClass, apartmentName);
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + Id +
                ", seats_number=" + seatsNumber +
                ", apartment_class=" + apartmentClass +
                ", ApartmentName='" + apartmentName + '\'' +
                '}';
    }
}
