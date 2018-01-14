package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.1.2. Создать итератор четные числа
 * @author Ayup Bariev.
 * @since 14.01.2018.
 */
public class EvenNumbersIterator implements Iterator {
    public final int[] values;
    int index = 0;
    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        while (values[index] % 2 != 0 && values[index] != values.length) {
            index++;
        }
        return values[index] % 2 == 0;
    }

    @Override
    public Object next() {
        while (values[index] % 2 != 0) {
            if (index == values.length - 1) {
                throw new NoSuchElementException("Out of Array");
            }
            index++;
        }
        return values[index++];
    }
}
