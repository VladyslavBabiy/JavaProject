package ua.model.dao.impl;

import ua.model.dao.BookingDAO;
import ua.model.entity.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class JDBCBookingDAO implements BookingDAO {
    private Connection connection;
    public JDBCBookingDAO(Connection connection)
    {
        this.connection=connection;
    }

    @Override
    public void add(Booking entity) {
        String add = "INSERT INTO bookings(ROOM_FK,REQUEST_FK,DATETIME_BOOKING,ID)value (?,?,?,DEFAULT)";
        String update = "UPDATE room SET STATUS_ROOM = 'booked' WHERE ID = ?";
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setInt(1,entity.getRoomFk());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(add);
            preparedStatement.setInt(1,entity.getRoomFk());
            preparedStatement.setInt(2,entity.getRequestFk());
            preparedStatement.setObject(3,entity.getDateTimeBooking());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Booking> geAll() {
        return null;
    }

    @Override
    public Optional<Booking> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Booking entity) {

    }

    @Override
    public void remove(Booking entity) {

    }
}
