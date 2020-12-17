package ua.training.controller.model.dao.impl;


import ua.training.controller.model.dao.DAOFactory;
import ua.training.controller.model.dao.RequestDAO;
import ua.training.controller.model.dao.RoomDAO;
import ua.training.controller.model.dao.UserDAO;

public class JDBCDaoFactory  implements DAOFactory {
    JDBCConnectorMySql jdbcConnectorMySql = new JDBCConnectorMySql();
    @Override
    public UserDAO createUserDAO() {
        JDBCUserDAO jdbcUserDAO = new JDBCUserDAO();
        jdbcUserDAO.setConnection(jdbcConnectorMySql.getConnection());
        return jdbcUserDAO;
    }

    @Override
    public RequestDAO createRequestDAO() {
        JDBCRequestDAO jdbcRequestDAO = new JDBCRequestDAO();
        jdbcRequestDAO.setConnection(jdbcConnectorMySql.getConnection());
        return jdbcRequestDAO;
    }

    @Override
    public RoomDAO createRoomDAO() {
        JDBCRoomDAO jdbcRoomDAO = new JDBCRoomDAO();
        jdbcRoomDAO.setConnection(jdbcConnectorMySql.getConnection());
        return jdbcRoomDAO;
    }
}
