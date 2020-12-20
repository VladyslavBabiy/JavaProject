package ua.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {
    void add(T entity);
    List<T> geAll();
    Optional<T> getById(Long id);
    void update(T entity);
    void remove(T entity);
}
