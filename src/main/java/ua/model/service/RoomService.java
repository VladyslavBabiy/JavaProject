package ua.model.service;

import ua.model.dao.DaoFactory;
import ua.model.dao.RoomDAO;
import ua.model.dao.UserDAO;
import ua.model.dto.RoomDTO;
import ua.model.dto.UserDTO;
import ua.model.entity.Room;
import ua.model.entity.User;

import java.util.List;
import java.util.Optional;

public abstract class RoomService {
    protected final RoomDAO roomDAO = DaoFactory.getInstance().createRoomDAO();
    public abstract void addRoom(RoomDTO roomDTO);
    public abstract Optional<Room> getById(Long id);
    public abstract void update(RoomDTO roomDAO);
    public abstract void remove(RoomDTO roomDAO);
    public abstract List<Room> getAll();

    public abstract List<Room> findRooms(int currentPage, int recordsPerPage);

    public abstract Integer getNumberOfRows();
}
