package ua.model.dao.impl;


import ua.model.dao.RoomDAO;
import ua.model.dao.mapper.RoomMapper;
import ua.model.entity.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRoomDAO implements RoomDAO {
    JDBCConnectorMySql jdbcConnectorMySql;
    RoomMapper roomMapper;
    public JDBCRoomDAO()
    {
        jdbcConnectorMySql = new JDBCConnectorMySql();
        roomMapper = new RoomMapper();
        connection = jdbcConnectorMySql.getConnection();
    }
    private Connection connection;

    @Override
    public void add(Room room) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO ROOM(SEATS_NUMBER, APARTMENT_CLASS,APARTMENT_NAME,ID)value (?,?,?,?)");
            preparedStatementSet(room,preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Room> geAll() throws SQLException {
        List<Room> addressList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT ID, SEATS_NUMBER, APARTMENT_CLASS,APARTMENT_NAME FROM ROOM");

            while (resultSet.next()) {
                Room room = roomMapper.extractFromResultSet(resultSet);
                addressList.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return addressList;
    }

    @Override
    public Room getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Room room = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, SEATS_NUMBER, APARTMENT_CLASS,APARTMENT_NAME FROM ROOM WHERE ID=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            room = roomMapper.extractFromResultSet(resultSet);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return room;
    }

    @Override
    public void update(Room room) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE ROOM SET SEATS_NUMBER=?, APARTMENT_CLASS=?, APARTMENT_NAME=? WHERE ID=?");
            preparedStatementSet(room, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    private void preparedStatementSet(Room room, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, room.getSeatsNumber());
        preparedStatement.setString(2, String.valueOf(room.getApartmentClass()));
        preparedStatement.setString(3, String.valueOf(room.getApartmentName()));
        preparedStatement.setLong(4, room.getId());
    }

    @Override
    public void remove(Room room) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
             preparedStatement = connection.prepareStatement("DELETE FROM ROOM WHERE ID=?");

            preparedStatement.setLong(1, room.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
