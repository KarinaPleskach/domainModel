package by.training.dao;

public interface Specification<T> {
    boolean match(T bean);
}
