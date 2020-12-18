package ua.model.dao.impl;


import ua.model.dao.UserDAO;
import ua.model.dao.mapper.UserMapper;
import ua.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDAO implements UserDAO {
    UserMapper userMapper;
    private Connection connection;
    public JDBCUserDAO()
    {
        userMapper = new UserMapper();
    }

    @Override
    public void add(User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO user(LOGIN,PASSWORD,ROLE,EMAIL,ID)value (?,?,?,?,DEFAULT)");
            preparedStatementSet(user,preparedStatement,true);
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
    public List<User> geAll() throws SQLException {
        List<User> addressList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT ID, LOGIN, PASSWORD, ROLE, EMAIL FROM user");

            while (resultSet.next()) {
                User user = userMapper.extractFromResultSet(resultSet);

                addressList.add(user);
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
    public User getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, LOGIN, PASSWORD, ROLE, EMAIL FROM user WHERE ID=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            user = userMapper.extractFromResultSet(resultSet);
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
       
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE user SET LOGIN=?, PASSWORD=?, ROLE=?, EMAIL=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatementSet(user, preparedStatement,false);

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
    public void remove(User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE ID=?");

            preparedStatement.setLong(1, user.getId());

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
    public User findByLogin(String login) throws SQLException {
        PreparedStatement preparedStatement = null;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement("SELECT LOGIN, PASSWORD, ROLE, EMAIL,ID FROM user WHERE LOGIN=?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                user.setLogin(resultSet.getString("LOGIN"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setRole(User.Role.valueOf(resultSet.getString("ROLE")));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setId(resultSet.getLong("ID"));
                preparedStatement.executeUpdate();
            }
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

        return user;
    }

    private void preparedStatementSet(User user, PreparedStatement preparedStatement,boolean add) throws SQLException {
        if (!add){
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, String.valueOf(user.getRole()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setLong(5,  user.getId());
        }
        else {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, String.valueOf(user.getRole()));
            preparedStatement.setString(4, user.getEmail());
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
