package ua.model.service;

import ua.model.dao.BookingDAO;
import ua.model.dao.DaoFactory;
import ua.model.entity.Booking;

import java.util.List;
import java.util.Optional;

public abstract class BookingService {
    protected final BookingDAO bookingDAO = DaoFactory.getInstance().createBookingDAO();
    public abstract void add(int roomFk,int requestFk);
    public abstract List<Booking> geAll();
    public abstract Optional<Booking> getById(Long id);
    public abstract void update(Booking entity);
    public abstract void remove(Booking entity);
}
