package ua.model.dao.impl;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectorMySql {
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
            System.out.println("Connection OK");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
}
