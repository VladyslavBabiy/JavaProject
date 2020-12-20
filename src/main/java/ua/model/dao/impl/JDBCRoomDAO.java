package ua.model.dao.impl;


import ua.model.dao.RoomDAO;
import ua.model.dao.mapper.RoomMapper;
import ua.model.entity.Room;
import ua.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCRoomDAO implements RoomDAO {
    private Connection connection;
    private RoomMapper roomMapper;
    public JDBCRoomDAO(Connection connection)
    {
        roomMapper = new RoomMapper();
       this.connection=connection;
    }

    @Override
    public void add(Room room) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO ROOM(SEATS_NUMBER, APARTMENT_CLASS,APARTMENT_NAME,ID)value (?,?,?,?)");
            preparedStatementSet(room,preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Room> geAll()  {
        List<Room> roomList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT ID, SEATS_NUMBER, APARTMENT_CLASS,APARTMENT_NAME FROM ROOM");

            while (resultSet.next()) {
                Room room = roomMapper.extractFromResultSet(resultSet);
                roomList.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
            if (statement != null) {

                    statement.close();
            }
            if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return roomList;
    }

    @Override
    public Optional<Room> getById(Long id) {
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
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return Optional.of(room);
    }

    @Override
    public void update(Room room){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE ROOM SET SEATS_NUMBER=?, APARTMENT_CLASS=?, APARTMENT_NAME=? WHERE ID=?");
            preparedStatementSet(room, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
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
    public void remove(Room room) {
        PreparedStatement preparedStatement = null;
        try {
             preparedStatement = connection.prepareStatement("DELETE FROM ROOM WHERE ID=?");

            preparedStatement.setLong(1, room.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
