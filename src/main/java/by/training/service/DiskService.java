package by.training.service;

import by.training.entity.music.Duration;
import by.training.exception.ServiceException;

import java.nio.file.Path;
import java.util.List;

public interface DiskService<T> {
    void add(List<T> beans) throws ServiceException;
    void update(Path path) throws ServiceException;
    List<T> show() throws ServiceException;
    List<T> find(String request) throws ServiceException;
    void delete(String request) throws ServiceException;
    void save(String path) throws ServiceException;
    List<T> get(Path path) throws ServiceException;
    List<T> get(List<String> lines) throws ServiceException;
    Duration sum(String request) throws ServiceException;
    void sort(String request) throws ServiceException;
}
