package ua.model.entity;

import java.time.LocalDateTime;

public class Booking {
    private int roomFk;
    private int requestFk;
    private LocalDateTime dateTimeBooking;

    public Booking(int roomFk, int requestFk, LocalDateTime dateTimeBooking) {
        this.roomFk = roomFk;
        this.requestFk = requestFk;
        this.dateTimeBooking = dateTimeBooking;
    }

    public int getRoomFk() {
        return roomFk;
    }

    public void setRoomFk(int roomFk) {
        this.roomFk = roomFk;
    }

    public int getRequestFk() {
        return requestFk;
    }

    public void setRequestFk(int requestFk) {
        this.requestFk = requestFk;
    }

    public LocalDateTime getDateTimeBooking() {
        return dateTimeBooking;
    }

    public void setDateTimeBooking(LocalDateTime dateTimeBooking) {
        this.dateTimeBooking = dateTimeBooking;
    }
}
