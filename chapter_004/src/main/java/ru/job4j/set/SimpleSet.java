package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1. Реализовать коллекцию Set на массиве [#996].
 * @author Ayup Bariev.
 * @since 07.02.2018.
 */
public class SimpleSet<E> {
    private Object[] container;
    private int index = 0;
    int modCount = 0; //Счетчик.
    int position = 0; //Счетчик для итератора.
    /**
     * Конструтор.
     */
    public SimpleSet() {
        this.container = new Object[5];
    }

    /**
     * Добавление в список элемента.
     * @param e
     */
    private void add(E e) {
        boolean count = false;
        for (Object o : container) {
            if (o == e) {
                count = true;
            }
        }
        if (!count) {
            container[index++] = e;
            modCount++;
        }
    }

    /**
     * Add element.
     * @param e e.
     */
    public void setElement(E e) {
        this.add(e);
    }

    public Object[] getContainer() {
        container = Arrays.copyOf(container, modCount);
        return container;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return position < index;
            }
            @Override
            public E next() {
                if (hasNext()) {
                    Object item = container[position++];
                    return (E) item;
                }
                throw new NoSuchElementException("");
            }
        };
    }
}
