package ua.model.dto;

import ua.model.entity.enums.ApartmentClass;
import ua.model.entity.enums.StatusRoom;

import java.util.Objects;

public class RoomDTO {
    private Long seatsNumber;
    private ApartmentClass apartmentClass;
    private String apartmentName;
    private double price;
    private StatusRoom statusRoom;

    public RoomDTO(Long seatsNumber, ApartmentClass apartmentClass, String apartmentName, double price, StatusRoom statusRoom) {
        this.seatsNumber = seatsNumber;
        this.apartmentClass = apartmentClass;
        this.apartmentName = apartmentName;
        this.price = price;
        this.statusRoom = statusRoom;
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

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDTO roomDTO = (RoomDTO) o;
        return Double.compare(roomDTO.price, price) == 0 && Objects.equals(seatsNumber, roomDTO.seatsNumber) && apartmentClass == roomDTO.apartmentClass && Objects.equals(apartmentName, roomDTO.apartmentName) && statusRoom == roomDTO.statusRoom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatsNumber, apartmentClass, apartmentName, price, statusRoom);
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "seatsNumber=" + seatsNumber +
                ", apartmentClass=" + apartmentClass +
                ", apartmentName='" + apartmentName + '\'' +
                ", price=" + price +
                ", statusRoom=" + statusRoom +
                '}';
    }

    public static class RoomDTOBuilder {
        private Long seatsNumber;
        private ApartmentClass apartmentClass;
        private String apartmentName;
        private StatusRoom statusRoom;
        private double price;

        public RoomDTOBuilder seatsNumber(Long seatsNumber) {
            this.seatsNumber = seatsNumber;
            return this;
        }

        public RoomDTOBuilder apartmentClass(ApartmentClass apartmentClass) {
            this.apartmentClass = apartmentClass;
            return this;
        }

        public RoomDTOBuilder apartmentName(String apartmentName) {
            this.apartmentName = apartmentName;
            return this;
        }

        public RoomDTOBuilder statusRoom(StatusRoom statusRoom) {
            this.statusRoom = statusRoom;
            return this;
        }

        public RoomDTOBuilder price(double price) {
            this.price = price;
            return this;
        }

        public RoomDTO build() {
            return new RoomDTO(seatsNumber, apartmentClass, apartmentName, price, statusRoom);
        }

        @Override
        public String toString() {
            return "RoomDTOBuilder{" +
                    "seatsNumber=" + seatsNumber +
                    ", apartmentClass=" + apartmentClass +
                    ", apartmentName='" + apartmentName + '\'' +
                    ", statusRoom=" + statusRoom +
                    ", price=" + price +
                    '}';
        }
    }

}
