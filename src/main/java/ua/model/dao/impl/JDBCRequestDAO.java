package ua.model.dao.impl;

;


import ua.model.dao.RequestDAO;
import ua.model.dao.mapper.RequestMapper;
import ua.model.entity.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCRequestDAO implements RequestDAO {
    private RequestMapper requestMapper;
    private Connection connection;
    private final String add = "INSERT INTO request(SEATS_NUMBER, APARTMENT_CLASS,DATE_SETTLEMENT,DATE_EVICTION, ID)value (?,?,?,?,?)";

    public JDBCRequestDAO(Connection connection) {
        this.connection = connection;
        requestMapper = new RequestMapper();
    }

    @Override
    public void add(Request request){
        try (PreparedStatement preparedStatement = connection.prepareStatement(add)){
            preparedStatementSet(request, preparedStatement,true);
            preparedStatement.executeQuery();
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

            preparedStatementSet(request, preparedStatement);

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

    private void preparedStatementSet(Request request, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, request.getSeats_number());
        preparedStatement.setString(2, String.valueOf(request.getApartmentClass()));
        preparedStatement.setObject(3, request.getDateSettlement());
        preparedStatement.setObject(4, request.getDateEviction());
        preparedStatement.setLong(5, request.getId());
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

}
