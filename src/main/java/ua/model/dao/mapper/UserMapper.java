package ua.model.dao.mapper;


import ua.model.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        return  User.builder()
                .id(resultSet.getLong("ID"))
                .email(resultSet.getString("EMAIL"))
                .password(resultSet.getString("PASSWORD"))
                .role(User.Role.valueOf(resultSet.getString("ROLE")))
                .firs_name(resultSet.getString("FIRST_NAME"))
                .middle_name(resultSet.getString("MIDDLE_NAME"))
                .last_name(resultSet.getString("LAST_NAME"))
                .build();
    }
    @Override
    public User makeUnique(Map<Integer, User> cache, User teacher) {
        return null;
    }
}