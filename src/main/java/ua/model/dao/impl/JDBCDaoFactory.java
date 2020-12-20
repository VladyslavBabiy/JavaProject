package ua.model.dao.impl;


import ua.model.dao.DaoFactory;
import ua.model.dao.RequestDAO;
import ua.model.dao.RoomDAO;
import ua.model.dao.UserDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCDaoFactory  extends DaoFactory {
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
    public Connection getConnection() {
        FileInputStream fis;
        Properties property = new Properties();
        Connection connection = null;
        try{
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            String DB_DRIVER = property.getProperty("db.driver");
            String DB_USERNAME = property.getProperty("db.username");
            String DB_URL = property.getProperty("db.url");
            String DB_PASSWORD = property.getProperty("db.password");
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
