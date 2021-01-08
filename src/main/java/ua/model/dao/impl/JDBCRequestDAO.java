package ua.model.dao.impl;

import ua.model.dao.RequestDAO;
import ua.model.dao.mapper.RequestMapper;
import ua.model.dto.BookingRequestDTO;
import ua.model.entity.Request;
import ua.model.entity.enums.ApartmentClass;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCRequestDAO implements RequestDAO {
    private RequestMapper requestMapper;
    private Connection connection;
    private final String add = "INSERT INTO request(SEATS_NUMBER, APARTMENT_CLASS,DATE_SETTLEMENT,DATE_EVICTION,USERFK, ID)value (?,?,?,?,?,DEFAULT)";

    public JDBCRequestDAO(Connection connection) {
        this.connection = connection;
        requestMapper = new RequestMapper();
    }

    @Override
    public void add(Request request){
        try (PreparedStatement preparedStatement = connection.prepareStatement(add)){
            preparedStatementSet(request, preparedStatement,true);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Request> geAll() {
        List<Request> requestList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT ID, SEATS_NUMBER, APARTMENT_CLASS,DATE_SETTLEMENT,DATE_EVICTION FROM REQUEST");

            while (resultSet.next()) {
                Request request = requestMapper.extractFromResultSet(resultSet);
                requestList.add(request);
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
        return requestList;
    }

    @Override
    public Optional<Request> getById(Long id) {
        PreparedStatement preparedStatement = null;
        Request request = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, SEATS_NUMBER, APARTMENT_CLASS,DATE_SETTLEMENT,DATE_EVICTION FROM REQUEST WHERE ID=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            request = requestMapper.extractFromResultSet(resultSet);
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
        return Optional.of(request);
    }

    @Override
    public void update(Request request) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE REQUEST SET SEATS_NUMBER=?, APARTMENT_CLASS=?, DATE_SETTLEMENT=?, DATE_EVICTION=? WHERE ID=?");

            preparedStatementSet(request, preparedStatement,false);

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

    private void preparedStatementSet(Request request, PreparedStatement preparedStatement,boolean add) throws SQLException {
        if (!add){
            preparedStatement.setLong(1, request.getSeats_number());
            preparedStatement.setString(2, String.valueOf(request.getApartmentClass()));
            preparedStatement.setObject(3, request.getDateSettlement());
            preparedStatement.setObject(4, request.getDateEviction());
            preparedStatement.setObject(5, request.getUserFk());
            preparedStatement.setLong(6, request.getId());
        }
        else {
            preparedStatement.setLong(1, request.getSeats_number());
            preparedStatement.setString(2, String.valueOf(request.getApartmentClass()));
            preparedStatement.setObject(3, request.getDateSettlement());
            preparedStatement.setObject(4, request.getDateEviction());
            preparedStatement.setObject(5, request.getUserFk());
        }
    }

    @Override
    public void remove(Request request) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM ROOM WHERE ID=?");

            preparedStatement.setLong(1, request.getId());

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
    public List<BookingRequestDTO> getBookingRequestList() {
        List<BookingRequestDTO> boolingList = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM request INNER JOIN user ON request.USERFK = user.ID");
            while (resultSet.next()) {
                BookingRequestDTO request = createBookingRequestFromResultSet(resultSet);
                boolingList.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boolingList;
    }

    private BookingRequestDTO createBookingRequestFromResultSet(ResultSet resultSet) throws SQLException {
        return BookingRequestDTO.builder()
                .ID(resultSet.getLong("ID"))
                .seats_number(resultSet.getLong("SEATS_NUMBER"))
                .apartmentClass(ApartmentClass.valueOf(resultSet.getString("APARTMENT_CLASS")))
                .dateEviction((LocalDate)resultSet.getObject("DATE_EVICTION"))
                .dateSettlement((LocalDate) resultSet.getObject("DATE_SETTLEMENT"))
                .userFk(resultSet.getLong("USERFK"))
                .login(resultSet.getString("LOGIN"))
                .email(resultSet.getString("EMAIL"))
                .firs_name(resultSet.getString("FIRST_NAME"))
                .middle_name(resultSet.getString("MIDDLE_NAME"))
                .last_name(resultSet.getString("LAST_NAME"))
                .build();
    }
}
