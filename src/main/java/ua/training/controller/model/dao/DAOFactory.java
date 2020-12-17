package ua.training.controller.model.dao;

public interface DAOFactory {
    UserDAO createUserDAO();

    RequestDAO createRequestDAO();

    RoomDAO createRoomDAO();
}
