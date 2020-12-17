package ua.model.dao;

public interface DAOFactory {
    UserDAO createUserDAO();

    RequestDAO createRequestDAO();

    RoomDAO createRoomDAO();
}
