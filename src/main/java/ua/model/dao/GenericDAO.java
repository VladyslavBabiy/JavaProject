package ua.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    void add(T entity) throws SQLException;
    List<T> geAll() throws SQLException;
    T getById(Long id) throws SQLException;
    void update(T entity) throws SQLException;
    void remove(T entity)throws SQLException;
}
