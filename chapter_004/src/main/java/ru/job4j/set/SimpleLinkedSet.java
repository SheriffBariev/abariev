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
     * Check duplicate.
     * @param e element.
     * @return boolean.
     */
    private boolean checkDuplicate(E e) {
        boolean result = false;
        SimpleLinkedList.Node<E> node = simpleLinkedList.first;
        for (int index = 0; index < simpleLinkedList.size; index++) {
            if (e.equals(node.getElement())) {
                result = true;
            }
            node = simpleLinkedList.first.next;
        }
        return result;
    }
    /**
     * add element.
     * @param value abs value.
     */
    public void addLinkedSet(E value) {
        if (!checkDuplicate(value)) {
            simpleLinkedList.add(value);
        }
    }

    public Iterator<E> iterator() {
        return simpleLinkedList.iterator();
    }
}


