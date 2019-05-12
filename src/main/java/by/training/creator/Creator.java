package by.training.creator;

public interface Creator<T> {
    T create(String line);
}
