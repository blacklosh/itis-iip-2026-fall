package ru.itis.collections;

public interface MyList<T> {

    void add(T value);

    T findByIndex(int index);

    boolean delete(T value);

}
