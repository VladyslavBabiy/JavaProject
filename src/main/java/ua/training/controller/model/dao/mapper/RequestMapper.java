package ua.training.controller.model.dao.mapper;


import ua.training.controller.model.entity.Request;
import ua.training.controller.model.entity.enums.ApartmentClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RequestMapper implements ObjectMapper<Request> {
    @Override
    public Request extractFromResultSet(ResultSet resultSet) throws SQLException {
        Request request = new Request();
        request.setId(resultSet.getLong("ID"));
        request.setSeats_number(resultSet.getLong("SEATS_NUMBER"));
        request.setApartmentClass(ApartmentClass.valueOf(resultSet.getString("APARTMENT_CLASS")));
        request.setDateSettlement(resultSet.getDate("DATE_SETTLEMENT"));
        request.setDateEviction(resultSet.getDate("DATE_EVICTION"));
        return request;
    }

    @Override
    public Request makeUnique(Map<Integer, Request> cache, Request teacher) {
        return null;
    }
}