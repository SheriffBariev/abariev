package ru.job4j.set;

import java.util.Arrays;

/**
 * 3. Реализовать коллекцию типа Set на базе хэш-таблицы [#998].
 * @author Ayup Bariev.
 * @since 19.02.2018
 */
public class SetOnHashTable<E> {
    private int size;
    private Object[] array;
    private int count = 0;

    /**
     * Hash function of element.
     * @param e element.
     * @return hashFunc.
     */
    private int hashFunc(E e) {
        return e.hashCode() % size;
    }

    /**
     * Constructor.
     * @param size size.
     */
    public SetOnHashTable(int size) {
        this.size = size;
        array = new Object[size];
    }

    /**
     * Increase array.
     */
    private void reSize() {
        array = Arrays.copyOf(array, size * 2);
    }

    /**
     * Put element.
     * @param e element.
     * @return boolean.
     */
    public boolean add(E e) {
        if (count == size) {
            reSize();
        }
        if (!contains(e)) {
            array[hashFunc(e)] = e;
            count++;
            return true;
        }
        return false;
    }

    /**
     * array have element or not.
     * @param e element.
     * @return boolean.
     */
    public boolean contains(E e) {
        return array[hashFunc(e)] == e;
    }

    /**
     * remove object.
     * @param e element.
     * @return boolean.
     */
    public boolean remove(E e) {
        int hash = hashFunc(e);
        if (contains(e)) {
            array[hash] = null;
            count--;
            return true;
        }
        return false;
    }
}
