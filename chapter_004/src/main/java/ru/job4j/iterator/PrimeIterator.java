package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.1.3. Создать итератор простые числа.
 * @author Ayup Bariev.
 * @since 18.01.2018.
 */
public class PrimeIterator implements Iterator {
    private final int[] values;
    int index = 0;
    public PrimeIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (index == values.length) {
            throw new NoSuchElementException("There is no any prime number");
        }
        for (; index < values.length; index++) {
            for (int count = values[index]; count > 1; count--) {
                if (values[index] / count > 1 && values[index] % count == 0) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            new NoSuchElementException("There is no any prime number");
        }
        return values[index++];
    }
}
