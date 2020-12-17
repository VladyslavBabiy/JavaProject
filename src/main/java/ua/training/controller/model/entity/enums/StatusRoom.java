package ua.training.controller.model.entity.enums;

public enum StatusRoom {
    free(1),
    booked(2),
    busy(3),
    unavailable(4);
    private int status;
    StatusRoom(int status)
    {
        this.status = status;
    }
}
