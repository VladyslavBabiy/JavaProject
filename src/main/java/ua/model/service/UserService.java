package ua.model.service;

import ua.model.dao.DaoFactory;
import ua.model.dao.UserDAO;
import ua.model.dto.UserDTO;
import ua.model.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class UserService {
    protected final UserDAO userDao = DaoFactory.getInstance().createUserDAO();

    public abstract void addUser(UserDTO user);

    public abstract Optional<User> getById(Long id);

    public abstract void update(UserDTO userDTO);

    public abstract void remove(UserDTO userDTO);

    public abstract Optional<User> findByLogin(String login);

    public abstract Optional<User> findByEmail(String email);

    public abstract List<User> getAll();
}
