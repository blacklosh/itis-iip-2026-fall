package ru.itis.collections;

import java.util.Arrays;

public class MyListImpl<T> implements MyList<T> {

    private int capacity = 20;
    private Object[] array = new Object[capacity];
    private int current = 0;

    @Override
    public void add(T value) {
        if (current == capacity - 1) {
            array = Arrays.copyOf(array, capacity*2);
            capacity *= 2;
        }
        array[current++] = value;
    }

    @Override
    public T findByIndex(int index) {
        if (index > current || index < 0) {
            throw new IllegalArgumentException("Недопустимый индекс");
        }
        return (T) array[current];
    }

    @Override
    public boolean delete(T value) {
        return false;
    }

    @Override
    public String toString() {
        Object[] toStringObjects = new Object[current];
        for(int i = 0; i < current; i++) {
            toStringObjects[i] = array[i];
        }
        return "MyListImpl{" +
                "array=" + Arrays.toString(toStringObjects) +
                '}';
    }
}
