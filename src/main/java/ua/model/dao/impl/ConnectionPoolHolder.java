package ua.model.dao.impl;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {

        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    FileInputStream fis;
                    Properties property = null;
                    try {
                        fis = new FileInputStream("/home/vlad/IdeaProjects/HotelProject/src/main/resources/config.properties");
                        property = new Properties();
                        property.load(fis);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl(property.getProperty("db.url"));
                    ds.setUsername(property.getProperty("db.username"));
                    ds.setPassword(property.getProperty("db.password"));
                    ds.setDriverClassName(property.getProperty("db.driver"));
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }
}
