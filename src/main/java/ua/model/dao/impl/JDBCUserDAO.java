package ua.model.dao.impl;


import ua.model.dao.UserDAO;
import ua.model.dao.mapper.UserMapper;
import ua.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDAO implements UserDAO {
    private UserMapper userMapper;
    private Connection connection;

    public JDBCUserDAO(Connection connection) {
        this.connection = connection;
        userMapper = new UserMapper();
    }

    @Override
    public void add(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO user(LOGIN,PASSWORD,ROLE,EMAIL,FIST_NAME,MIDDLE_NAME,LAST_NAME,ID)value (?,?,?,?,?,?,?,DEFAULT)");
            preparedStatementSet(user, preparedStatement, true);
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
    public List<User> geAll() {
        List<User> userList = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT ID, LOGIN, PASSWORD, ROLE, EMAIL,FIST_NAME,MIDDLE_NAME,LAST_NAME FROM user");

            while (resultSet.next()) {
                User user = userMapper.extractFromResultSet(resultSet);

                userList.add(user);
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
        return userList;
    }

    @Override
    public Optional<User> getById(Long id) {
        PreparedStatement preparedStatement = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT ID, LOGIN, PASSWORD, ROLE, EMAIL, FIRST_NAME, MIDDLE_NAME, LAST_NAME FROM user WHERE ID=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            user = userMapper.extractFromResultSet(resultSet);
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

        return Optional.of(user);
    }

    @Override
    public void update(User user) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE user SET LOGIN=?, PASSWORD=?, ROLE=?, EMAIL=?,FIRST_NAME = ?,MIDDLE_NAME = ?,LAST_NAME = ? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatementSet(user, preparedStatement, false);

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
    public void remove(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE ID=?");

            preparedStatement.setLong(1, user.getId());

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
    public Optional<User> findByLogin(String login) {
        PreparedStatement preparedStatement = null;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement("SELECT LOGIN, PASSWORD, ROLE, EMAIL, ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME FROM user WHERE LOGIN=?");
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(userMapper.extractFromResultSet(resultSet));
            }
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

        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        PreparedStatement preparedStatement = null;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement("SELECT LOGIN, PASSWORD, ROLE, EMAIL, ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME FROM user WHERE EMAIL=?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(userMapper.extractFromResultSet(resultSet));
            }
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

        return Optional.empty();
    }

    private void preparedStatementSet(User user, PreparedStatement preparedStatement, boolean add) throws SQLException {
        if (!add) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, String.valueOf(user.getRole()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getFirst_name());
            preparedStatement.setString(6, user.getMiddle_name());
            preparedStatement.setString(7, user.getLast_name());
            preparedStatement.setLong(8, user.getId());
        } else {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, String.valueOf(user.getRole()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getFirst_name());
            preparedStatement.setString(6, user.getMiddle_name());
            preparedStatement.setString(7, user.getLast_name());
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
