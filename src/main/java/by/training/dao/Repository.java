package by.training.dao;

import by.training.exception.DAOException;

import java.util.List;

public interface Repository<T> {
    void add(T bean) throws DAOException;
    void add(List<T> beans) throws DAOException;
    void update(List<T> beans) throws DAOException;
    void remove();
    void remove(T bean);
    void remove(Specification<T> ... specifications);
    List<T> find(Specification<T> ... specifications);
    List<T> find() throws DAOException;
    void save();
}
