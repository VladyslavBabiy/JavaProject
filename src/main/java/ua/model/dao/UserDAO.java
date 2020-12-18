package ua.model.dao;


import ua.model.entity.User;

import java.sql.SQLException;

public interface UserDAO extends GenericDAO<User> {
    User findByLogin(String login) throws SQLException;
}
