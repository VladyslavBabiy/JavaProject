package ua.model.service;


import ua.model.dao.UserDAO;
import ua.model.entity.User;
import ua.model.dao.impl.JDBCDaoFactory;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    public List<User> getAllUser(){
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        UserDAO dao = jdbcDaoFactory.createUserDAO();
        try {
            return dao.geAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user)
    {
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        UserDAO dao = jdbcDaoFactory.createUserDAO();
        try {
            dao.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getById(Long id) throws SQLException {
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        UserDAO userDAO = jdbcDaoFactory.createUserDAO();
        return userDAO.getById(id);
    }

    public void update(User user) throws SQLException {
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        UserDAO userDAO = jdbcDaoFactory.createUserDAO();
        userDAO.update(user);
    }

    public void remove(User user) throws SQLException {
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        UserDAO userDAO = jdbcDaoFactory.createUserDAO();
        userDAO.remove(user);
    }
    public User findByLogin(String login)  {
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        UserDAO userDAO = jdbcDaoFactory.createUserDAO();
        try {
            return userDAO.findByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
