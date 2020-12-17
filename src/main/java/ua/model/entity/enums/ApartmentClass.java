package ua.model.entity.enums;

public enum ApartmentClass {
    //стандартная комната
    Standart("standart"),
    //номер со спальней
    Bedroom("bedroom"),
    //номер (больше чем стандартный) с гостиной и спальней, с мебелью и оборудованием высокого качества
    Suite("suite"),
    //такой же номер, но с более дорогой обстановкой
    DeLuxe("deLuxe"),
    //
    Apartment("apartment");
    private String apartmentClass;

    ApartmentClass(String apartmentClass) {
        this.apartmentClass = apartmentClass;
    }
}
