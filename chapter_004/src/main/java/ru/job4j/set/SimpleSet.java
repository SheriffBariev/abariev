package ru.job4j.set;

import ru.job4j.list.SimpleList;

import java.util.Arrays;

/**
 * 1. Реализовать коллекцию Set на массиве [#996].
 * @author Ayup Bariev.
 * @since 07.02.2018.
 */
public class SimpleSet<E> extends SimpleList<E> {
    /**
     * Добавление в список элемента.
     * @param e
     */
    private void addSet(E e) {
        boolean count = false;
        for (Object o : container) {
            if (o == e) {
                count = true;
            }
        }
        if (!count) {
            add(e);
        }
    }

    /**
     * Add element.
     * @param e e.
     */
    public void setElement(E e) {
        this.addSet(e);
    }

    public Object[] getContainer() {
        container = Arrays.copyOf(container, modCount);
        return container;
    }
}
