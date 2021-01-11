package ua.model.dao;

import ua.model.dto.BookingRequestDTO;
import ua.model.entity.Request;

import java.util.List;


public interface RequestDAO extends GenericDAO<Request> {
    List<BookingRequestDTO> getBookingRequestList(int currentPage, int recordsPerPage, String sql);

    List<BookingRequestDTO> findRequests(int currentPage, int recordsPerPage, String sql);

    Integer getNumberOfRows();
}
