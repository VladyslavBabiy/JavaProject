package ua.model.dao.mapper;


import ua.model.entity.enums.ApartmentClass;
import ua.model.entity.Request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

public class RequestMapper implements ObjectMapper<Request> {
    @Override
    public Request extractFromResultSet(ResultSet resultSet) throws SQLException {
        Request request = new Request();
        request.setId(resultSet.getLong("ID"));
        request.setSeats_number(resultSet.getLong("SEATS_NUMBER"));
        request.setApartmentClass(ApartmentClass.valueOf(resultSet.getString("APARTMENT_CLASS")));
        request.setDateSettlement((LocalDateTime)resultSet.getObject("DATE_SETTLEMENT"));
        request.setDateEviction((LocalDateTime)resultSet.getObject("DATE_EVICTION"));
        return request;
    }

    @Override
    public Request makeUnique(Map<Integer, Request> cache, Request teacher) {
        return null;
    }
}