package ru.job4j.set;

import ru.job4j.list.SimpleList;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 1. Реализовать коллекцию Set на массиве [#996].
 * @author Ayup Bariev.
 * @since 07.02.2018. Changed 11.02.2018.
 */
public class SimpleSet<E> {
    SimpleList<E> simple = new SimpleList<>();
    /**
     * Duplicate search.
     * return boolean.
     */
    private boolean checkDuplicate(E e) {
        boolean count = false;
        for (Object o : simple.container) {
            if (e.equals(o)) {
                count = true;
            }
        }
        return count;
    }

    /**
     * Добавление в список элемента.
     * @param e
     */
    private void addSet(E e) {
        if (!checkDuplicate(e)) {
            simple.add(e);
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
        return Arrays.copyOf(simple.container, simple.modCount);
    }

    /**
     * Iterator.
     * @return iterator.
     */
    public Iterator<E> getIterator() {
        return simple.iterator();
    }
}
