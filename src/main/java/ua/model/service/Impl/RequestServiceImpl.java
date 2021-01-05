package ua.model.service.Impl;

import ua.model.dto.RequestDTO;
import ua.model.entity.Request;
import ua.model.service.RequestService;

import java.util.List;
import java.util.Optional;

public class RequestServiceImpl extends RequestService {
    @Override
    public void addRequest(RequestDTO requestDTO) {
        System.out.println(requestDTO);
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

    private Request BuildRequestDTOtoRequest(RequestDTO requestDTO)
    {
        return Request.builder()
                .seats_number(requestDTO.getSeatsNumber())
                .apartmentClass(requestDTO.getApartmentClass())
                .dateEviction(requestDTO.getDateEviction())
                .dateSettlement(requestDTO.getDateSettlement())
                .build();
    }
}
