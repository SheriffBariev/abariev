package ru.job4j.generic;

/**
 * 5.2.1. Реализовать SimpleArray<T>.
 */
public class SimpleArray<S> {
    Object[] objects;
    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(S model) {
        this.objects[index++] = model;
    }

    public void set(int index, S model) {
        this.objects[index] = model;
    }

    public void delete(int index) {
        this.objects[index] = null;
    }

    public S get(int index) {
        return (S) this.objects[index];
    }
}
