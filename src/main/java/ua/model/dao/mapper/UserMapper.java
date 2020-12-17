package ua.model.dao.mapper;


import ua.model.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("ID"));
        user.setLogin(resultSet.getString("LOGIN"));
        user.setPassword(resultSet.getString("PASSWORD"));
        user.setRole(User.Role.valueOf(resultSet.getString("ROLE")));
        user.setEmail(resultSet.getString("EMAIL"));
        return user;
    }
    public void preparedStatementSet (PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getLogin());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, String.valueOf(user.getRole()));
        preparedStatement.setString(5, user.getEmail());
    }

    @Override
    public User makeUnique(Map<Integer, User> cache, User teacher) {
        return null;
    }
}