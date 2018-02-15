package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;
import java.util.Iterator;

/**
 * 2. Set реализованный на связном списке. [#997]
 * @author Ayup Bariev.
 * @since 07.02.2018.
 */
public class SimpleLinkedSet<E> {
    SimpleLinkedList<E> simpleLinkedList = new SimpleLinkedList<E>();
    /**
     * add element.
     * @param value abs value.
     */
    public void addLinkedSet(E value) {
        if (!simpleLinkedList.contains(value)) {
            simpleLinkedList.add(value);
        }
    }

    public Iterator<E> iterator() {
        return simpleLinkedList.iterator();
    }
}


