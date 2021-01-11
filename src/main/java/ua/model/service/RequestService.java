package ua.model.service;

import ua.model.dao.DaoFactory;
import ua.model.dao.RequestDAO;
import ua.model.dto.BookingRequestDTO;
import ua.model.dto.RequestDTO;
import ua.model.dto.UserDTO;
import ua.model.entity.Request;
import ua.model.entity.User;

import java.util.List;
import java.util.Optional;

public abstract class RequestService {
    protected final RequestDAO requestDAO = DaoFactory.getInstance().createRequestDAO();

    public abstract void addRequest(RequestDTO requestDTO);

    public abstract Optional<Request> getById(Long id);

    public abstract void update(RequestDTO requestDTO);

    public abstract void remove(RequestDTO requestDTO);

    public abstract List<Request> getAll();

    public abstract Integer getNumberOfRows();

    public abstract Optional<BookingRequestDTO> getByIdBookingRequest(Long id);

    public abstract List<BookingRequestDTO> findRequests(int currentPage, int recordsPerPage, String Sql);
}
