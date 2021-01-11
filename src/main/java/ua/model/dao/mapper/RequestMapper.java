package ua.model.dao.mapper;


import ua.model.dto.BookingRequestDTO;
import ua.model.entity.enums.ApartmentClass;
import ua.model.entity.Request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public class RequestMapper implements ObjectMapper<Request> {
    @Override
    public Request extractFromResultSet(ResultSet resultSet) throws SQLException {
        Request request = new Request();
        request.setId(resultSet.getLong("ID"));
        request.setSeats_number(resultSet.getLong("SEATS_NUMBER"));
        request.setApartmentClass(ApartmentClass.valueOf(resultSet.getString("APARTMENT_CLASS")));
        request.setDateSettlement((LocalDate)resultSet.getObject("DATE_SETTLEMENT"));
        request.setDateEviction((LocalDate)resultSet.getObject("DATE_EVICTION"));
        return request;
    }
    public BookingRequestDTO createBookingRequestFromResultSet(ResultSet resultSet) throws SQLException {
        System.out.println("request create ok");
        return BookingRequestDTO.builder()
                .ID(resultSet.getLong("ID"))
                .seats_number(resultSet.getLong("SEATS_NUMBER"))
                .apartmentClass(ApartmentClass.valueOf(resultSet.getString("APARTMENT_CLASS")))
                .dateEviction(resultSet.getDate("DATE_EVICTION").toLocalDate())
                .dateSettlement(resultSet.getDate("DATE_SETTLEMENT").toLocalDate())
                .userFk(resultSet.getLong("USERFK"))
                .login(resultSet.getString("LOGIN"))
                .email(resultSet.getString("EMAIL"))
                .firs_name(resultSet.getString("FIRST_NAME"))
                .middle_name(resultSet.getString("MIDDLE_NAME"))
                .last_name(resultSet.getString("LAST_NAME"))
                .build();
    }
    @Override
    public Request makeUnique(Map<Integer, Request> cache, Request teacher) {
        return null;
    }
}