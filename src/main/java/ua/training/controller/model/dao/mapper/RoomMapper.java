package ua.training.controller.model.dao.mapper;

import ua.training.controller.model.entity.Room;
import ua.training.controller.model.entity.enums.ApartmentClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RoomMapper implements ObjectMapper<Room> {
    @Override
    public Room extractFromResultSet(ResultSet resultSet) throws SQLException {
        Room room = new Room();
        room.setId(resultSet.getLong("ID"));
        room.setSeatsNumber(resultSet.getLong("SEATS_NUMBER"));
        room.setApartmentClass(ApartmentClass.valueOf(resultSet.getString("APARTMENT_CLASS")));
        room.setApartmentName(resultSet.getString("APARTMENT_NAME"));
        return room;
    }

    @Override
    public Room makeUnique(Map<Integer, Room> cache, Room teacher) {
        return null;
    }
}