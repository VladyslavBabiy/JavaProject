package ua.model.dao;


import ua.model.entity.User;
import java.util.Optional;

public interface UserDAO extends GenericDAO<User> {
    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String login);
}
