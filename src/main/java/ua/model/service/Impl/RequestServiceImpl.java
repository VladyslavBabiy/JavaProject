package ua.model.service.Impl;

import ua.model.dto.BookingRequestDTO;
import ua.model.dto.RequestDTO;
import ua.model.entity.Request;
import ua.model.service.RequestService;

import java.util.List;
import java.util.Optional;

public class RequestServiceImpl extends RequestService {
    @Override
    public void addRequest(RequestDTO requestDTO) {
        requestDAO.add(BuildRequestDTOtoRequest(requestDTO));
    }

    @Override
    public Optional<Request> getById(Long id) {
        return requestDAO.getById(id);
    }

    @Override
    public void update(RequestDTO requestDTO) {
        requestDAO.update(BuildRequestDTOtoRequest(requestDTO));
    }

    @Override
    public void remove(RequestDTO requestDTO) {
        requestDAO.remove(BuildRequestDTOtoRequest(requestDTO));
    }

    @Override
    public List<Request> getAll() {
        return requestDAO.geAll();
    }


    @Override
    public Integer getNumberOfRows() {
        return requestDAO.getNumberOfRows();
    }

    @Override
    public Optional<BookingRequestDTO> getByIdBookingRequest(Long id) {
        return requestDAO.getByIdBookingRequest(id);
    }


    @Override
    public List<BookingRequestDTO> findRequests(int currentPage, int recordsPerPage, String Sql) {
        return requestDAO.findRequests(currentPage,recordsPerPage,Sql);
    }

    private Request BuildRequestDTOtoRequest(RequestDTO requestDTO) {
        return Request.builder()
                .seats_number(requestDTO.getSeatsNumber())
                .apartmentClass(requestDTO.getApartmentClass())
                .dateEviction(requestDTO.getDateEviction())
                .dateSettlement(requestDTO.getDateSettlement())
                .userFk(requestDTO.getUserFk())
                .build();
    }
}
