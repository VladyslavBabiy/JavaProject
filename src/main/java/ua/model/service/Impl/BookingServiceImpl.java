package ua.model.service.Impl;

import ua.model.entity.Booking;
import ua.model.service.BookingService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BookingServiceImpl extends BookingService {
    @Override
    public void add(int roomFk,int requestFk) {
        Booking entity = new Booking(roomFk,requestFk,LocalDateTime.now());
        bookingDAO.add(entity);
    }

    @Override
    public List<Booking> geAll() {
        return bookingDAO.geAll();
    }

    @Override
    public Optional<Booking> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Booking entity) {

    }

    @Override
    public void remove(Booking entity) {

    }
}
