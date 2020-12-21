package ua.model.entity;


import ua.model.entity.enums.ApartmentClass;

import java.util.Objects;

public class Room {
    private Long ID;
    private Long seatsNumber;
    private ApartmentClass apartmentClass;
    private String apartmentName;


    public Room(Long ID, Long seatsNumber, ApartmentClass apartmentClass, String apartmentName) {
        this.ID = ID;
        this.seatsNumber = seatsNumber;
        this.apartmentClass = apartmentClass;
        this.apartmentName = apartmentName;
    }
    public static RoomBuilder RoomBuilder (){
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
        public Room build(){return new Room(ID,seatsNumber,apartmentClass,apartmentName);}
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
