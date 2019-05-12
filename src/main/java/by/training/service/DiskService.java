package by.training.service;

import by.training.exception.ServiceException;

import java.nio.file.Path;
import java.util.List;

public interface DiskService<T> {
    void update(Path path) throws ServiceException;
    List<T> show() throws ServiceException;
    List<T> find(String request) throws ServiceException;
}
