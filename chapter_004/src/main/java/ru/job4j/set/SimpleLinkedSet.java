package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2. Set реализованный на связном списке. [#997]
 * @author Ayup Bariev.
 * @since 07.02.2018.
 */
public class SimpleLinkedSet<E> extends SimpleLinkedList<E> {
    /**
     * add element.
     * @param value abs value.
     */
    public void addLinkedSet(E value) {
        boolean result = false;
        Node<E> node = first;
        for (int index = 0; index < size; index++) {
            if (value.equals(node.getElement())) {
                result = true;
            }
            node = first.next;
        }
        if (!result) {
            add(value);
        }
    }
}


