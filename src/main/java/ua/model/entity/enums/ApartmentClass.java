package ua.model.entity.enums;

public enum ApartmentClass {
    //стандартная комната
    Standard(1),
    //номер со спальней
    Bedroom(2),
    //номер (больше чем стандартный) с гостиной и спальней, с мебелью и оборудованием высокого качества
    Suite(3),
    //такой же номер, но с более дорогой обстановкой
    DeLuxe(4),
    //
    Apartment(5);
    private int apartmentClass;

    ApartmentClass(int apartmentClass) {
        this.apartmentClass = apartmentClass;
    }

    public int getApartmentClass() {
        return apartmentClass;
    }
}
