package ua.model.dao.mapper;

import ua.model.entity.enums.ApartmentClass;
import ua.model.entity.Room;
import ua.model.entity.enums.StatusRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RoomMapper implements ObjectMapper<Room> {
    @Override
    public Room extractFromResultSet(ResultSet resultSet) throws SQLException {
        Room room = new Room();
        room.setID(resultSet.getLong("ID"));
        room.setSeatsNumber(resultSet.getLong("SEATS_NUMBER"));
        room.setApartmentClass(ApartmentClass.valueOf(resultSet.getString("APARTMENT_CLASS")));
        room.setApartmentName(resultSet.getString("APARTMENT_NAME"));
        room.setStatusRoom(StatusRoom.valueOf(resultSet.getString("STATUS_ROOM")));
        room.setPrice(resultSet.getDouble("PRICE"));
        return room;
    }
}