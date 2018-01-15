package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.1.1. Итератор для двухмерного массива int.
 * @author Ayup Bariev.
 * @since 14.01.2018.
 */
public class MatrixIterator implements Iterator {

    private final int[][] array;

    public MatrixIterator(final int[][] array) {
        this.array = array;
    }

    int index = 0;
    int value = -1;

    @Override
    public boolean hasNext() {
        if (index == array.length - 1 && value == array[index].length - 1) {
            throw new NoSuchElementException("Out of Array");
        }
        return index < array.length && value < array[index].length;
    }

    @Override
    public Object next() {
        if (value != array[index].length - 1 && index < array.length) {
            value++;
        } else if (value == array[index].length - 1 && index != array.length - 1) {
            value = 0;
            index++;
        } else {
            throw new NoSuchElementException("Out of Array");
        }
        return array[index][value];
    }
}
