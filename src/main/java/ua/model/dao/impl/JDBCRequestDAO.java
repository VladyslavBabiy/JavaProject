package ua.model.dao.impl;
;


import ua.model.dao.RequestDAO;
import ua.model.dao.mapper.RequestMapper;
import ua.model.entity.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRequestDAO implements RequestDAO {
    JDBCConnectorMySql jdbcConnectorMySql;
    RequestMapper requestMapper;
    private Connection connection;
    public JDBCRequestDAO()
    {
        requestMapper = new RequestMapper();
        jdbcConnectorMySql = new JDBCConnectorMySql();
        connection = jdbcConnectorMySql.getConnection();
    }
    @Override
    public void add(Request request) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO REQUEST(SEATS_NUMBER, APARTMENT_CLASS,DATE_SETTLEMENT,DATE_EVICTION, ID)value (?,?,?,?,?)");
            preparedStatementSet(request, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    @Override
    public List<Request> geAll() throws SQLException {
        List<Request> addressList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT ID, SEATS_NUMBER, APARTMENT_CLASS,DATE_SETTLEMENT,DATE_EVICTION FROM REQUEST");

            while (resultSet.next()) {
                Request request = requestMapper.extractFromResultSet(resultSet);
                addressList.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return addressList;
    }

    @Override
    public Request getById(Long id) throws SQLException {
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
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return request;
    }

    @Override
    public void update(Request request) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE REQUEST SET SEATS_NUMBER=?, APARTMENT_CLASS=?, DATE_SETTLEMENT=?, DATE_EVICTION=? WHERE ID=?");

            preparedStatementSet(request, preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    private void preparedStatementSet(Request request, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, request.getSeats_number());
        preparedStatement.setString(2, String.valueOf(request.getApartmentClass()));
        preparedStatement.setDate(3, request.getDateSettlement());
        preparedStatement.setDate(4, request.getDateEviction());
        preparedStatement.setLong(5, request.getId());
    }

    @Override
    public void remove(Request request) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM ROOM WHERE ID=?");

            preparedStatement.setLong(1, request.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
