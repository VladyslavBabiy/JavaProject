package ua.model.dao.impl;

import ua.model.dao.RequestDAO;
import ua.model.dao.mapper.RequestMapper;
import ua.model.dto.BookingRequestDTO;
import ua.model.entity.Request;

import java.sql.*;
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
    public void add(Request request) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(add)) {
            preparedStatementSet(request, preparedStatement, true);
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
            } catch (SQLException e) {
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
            } catch (SQLException e) {
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

            preparedStatementSet(request, preparedStatement, false);

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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void preparedStatementSet(Request request, PreparedStatement preparedStatement, boolean add) throws SQLException {
        if (!add) {
            preparedStatement.setLong(1, request.getSeats_number());
            preparedStatement.setString(2, String.valueOf(request.getApartmentClass()));
            preparedStatement.setObject(3, request.getDateSettlement());
            preparedStatement.setObject(4, request.getDateEviction());
            preparedStatement.setObject(5, request.getUserFk());
            preparedStatement.setLong(6, request.getId());
        } else {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<BookingRequestDTO> getBookingRequestList(int currentPage, int recordsPerPage, String sql) {
        List<BookingRequestDTO> boolingList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM request INNER JOIN user ON request.USERFK = user.ID");
            while (resultSet.next()) {
                BookingRequestDTO request = requestMapper.createBookingRequestFromResultSet(resultSet);
                boolingList.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boolingList;
    }

    @Override
    public List<BookingRequestDTO> findRequests(int currentPage, int recordsPerPage, String sql) {
        List<BookingRequestDTO> requests = new ArrayList<>();
        int start = currentPage * recordsPerPage - recordsPerPage;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, start);
            preparedStatement.setInt(2, recordsPerPage);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookingRequestDTO bookingRequestDTO = requestMapper.createBookingRequestFromResultSet(resultSet);
                requests.add(bookingRequestDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public Optional<BookingRequestDTO> getByIdBookingRequest(Long id) {
        String getByIdBookingRequest = "SELECT request.ID as ID, SEATS_NUMBER, APARTMENT_CLASS, DATE_SETTLEMENT, DATE_EVICTION, USERFK,\n" +
                "       LOGIN, PASSWORD, ROLE, EMAIL, FIRST_NAME, LAST_NAME, MIDDLE_NAME FROM request,user\n" +
                "where USERFK = user.ID and request.ID = ?";
        BookingRequestDTO bookingRequestDTO = null;
        try( PreparedStatement  ps = connection.prepareStatement(getByIdBookingRequest)) {
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next())
            {
                bookingRequestDTO = requestMapper.createBookingRequestFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(bookingRequestDTO);
    }

    @Override
    public Integer getNumberOfRows() {
        try (Statement s = connection.createStatement()) {
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM request");
            r.next();
            int count = r.getInt("rowcount");
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
