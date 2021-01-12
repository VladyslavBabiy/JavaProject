package ua.model.dao.impl;


import ua.model.dao.*;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDAO createUserDAO() {
        return new JDBCUserDAO(getConnection());
    }

    @Override
    public RequestDAO createRequestDAO() {
        return new JDBCRequestDAO(getConnection());
    }

    @Override
    public RoomDAO createRoomDAO() {
        return new JDBCRoomDAO(getConnection());
    }

    @Override
    public BookingDAO createBookingDAO() {
        return new JDBCBookingDAO(getConnection());
    }


    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
