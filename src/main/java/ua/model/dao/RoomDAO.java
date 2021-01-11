package ua.model.dao;


import ua.model.entity.Room;

import java.util.List;

public interface RoomDAO extends GenericDAO<Room> {
    Integer getNumberOfRows();

    List<Room> findRooms(int currentPage, int recordsPerPage, String sql);
}
