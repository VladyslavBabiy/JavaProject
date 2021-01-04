package ua.model.dto;

import ua.model.entity.enums.ApartmentClass;

public class RoomDTO {
    private Long seatsNumber;
    private ApartmentClass apartmentClass;
    private String apartmentName;

    public RoomDTO(Long seatsNumber, ApartmentClass apartmentClass, String apartmentName) {
        this.seatsNumber = seatsNumber;
        this.apartmentClass = apartmentClass;
        this.apartmentName = apartmentName;
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
    public static class RoomDTOBuilder
    {
        private Long seatsNumber;
        private ApartmentClass apartmentClass;
        private String apartmentName;

        public RoomDTOBuilder seatsNumber(Long seatsNumber)
        {
            this.seatsNumber = seatsNumber;
            return this;
        }
        public RoomDTOBuilder apartmentClass (ApartmentClass apartmentClass)
        {
            this.apartmentClass = apartmentClass;
            return this;
        }
        public RoomDTOBuilder apartmentName(String apartmentName)
        {
            this.apartmentName = apartmentName;
            return this;
        }
        public RoomDTO build(){return new RoomDTO(seatsNumber,apartmentClass,apartmentName);}

        @Override
        public String toString() {
            return "RoomDTOBuilder{" +
                    "seatsNumber=" + seatsNumber +
                    ", apartmentClass=" + apartmentClass +
                    ", apartmentName='" + apartmentName + '\'' +
                    '}';
        }
    }

}
