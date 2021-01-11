package ua.model.entity;


import ua.model.entity.enums.ApartmentClass;
import ua.model.entity.enums.StatusRoom;

import java.util.Objects;

public class Room {
    private Long ID;
    private Long seatsNumber;
    private ApartmentClass apartmentClass;
    private String apartmentName;
    private double price;
    private StatusRoom statusRoom;


    public Room(Long ID, Long seatsNumber, ApartmentClass apartmentClass, String apartmentName, double price, StatusRoom statusRoom) {
        this.ID = ID;
        this.seatsNumber = seatsNumber;
        this.apartmentClass = apartmentClass;
        this.apartmentName = apartmentName;
        this.price = price;
        this.statusRoom = statusRoom;
    }

    public Room() {

    }

    public static RoomBuilder RoomBuilder() {
        return new RoomBuilder();
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

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StatusRoom getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(StatusRoom statusRoom) {
        this.statusRoom = statusRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return ID.equals(room.ID) && seatsNumber.equals(room.seatsNumber) && apartmentClass == room.apartmentClass && apartmentName.equals(room.apartmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, seatsNumber, apartmentClass, apartmentName);
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id=" + ID +
                ", seats_number=" + seatsNumber +
                ", apartment_class=" + apartmentClass +
                ", ApartmentName='" + apartmentName + '\'' +
                '}';
    }

    public static class RoomBuilder {
        private Long ID;
        private Long seatsNumber;
        private ApartmentClass apartmentClass;
        private String apartmentName;
        private double price;
        private StatusRoom statusRoom;

        public RoomBuilder() {

        }

        public RoomBuilder ID(Long ID) {
            this.ID = ID;
            return this;
        }

        public RoomBuilder seatsNumber(Long seatsNumber) {
            this.seatsNumber = seatsNumber;
            return this;
        }

        public RoomBuilder apartmentClass(ApartmentClass apartmentClass) {
            this.apartmentClass = apartmentClass;
            return this;
        }

        public RoomBuilder apartmentName(String apartmentName) {
            this.apartmentName = apartmentName;
            return this;
        }

        public RoomBuilder statusRoom(StatusRoom statusRoom) {
            this.statusRoom = statusRoom;
            return this;
        }

        public RoomBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Room build() {
            return new Room(ID, seatsNumber, apartmentClass, apartmentName, price, statusRoom);
        }

        @Override
        public String toString() {
            return "RoomBuilder{" +
                    "ID=" + ID +
                    ", seatsNumber=" + seatsNumber +
                    ", apartmentClass=" + apartmentClass +
                    ", apartmentName='" + apartmentName + '\'' +
                    '}';
        }
    }
}
