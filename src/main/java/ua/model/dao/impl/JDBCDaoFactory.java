package ua.model.dao.impl;


import ua.model.dao.DAOFactory;
import ua.model.dao.RequestDAO;
import ua.model.dao.RoomDAO;
import ua.model.dao.UserDAO;

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
