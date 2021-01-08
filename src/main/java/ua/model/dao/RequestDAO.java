package ua.model.dao;

import ua.model.dto.BookingRequestDTO;
import ua.model.entity.Request;

import java.util.List;


public interface RequestDAO extends GenericDAO<Request> {
    public abstract List<BookingRequestDTO> getBookingRequestList();
}
