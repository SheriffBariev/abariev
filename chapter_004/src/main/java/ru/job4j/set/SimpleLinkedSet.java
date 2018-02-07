package ru.job4j.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2. Set реализованный на связном списке. [#997]
 * @author Ayup Bariev.
 * @since 07.02.2018.
 */
public class SimpleLinkedSet<E> {

    int size = 0;
    int modCount = 0;
    int position = 0;

    /**
     * Class Node.
     * @param <E> element.
     */
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        /**
         * Get node.
         * @return node.
         */
        public Node<E> getNext() {
            return this.next;
        }

        /**
         * Next node.
         * @param next next.
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * get element.
         * @return element.
         */
        public E getElement() {
            return element;
        }
    }
    Node<E> first;
    Node<E> last;

    /**
     * add element.
     * @param value abs value.
     */
    public void add(E value) {
        boolean result = false;
        Node<E> node = first;
        for (int index = 0; index < size; index++) {
            if (value.equals(node.getElement())) {
                result = true;
            }
            node = first.next;
        }
        if (!result) {
            final Node<E> lastAdd = last;
            final Node<E> early = new Node<>(lastAdd, value, null);
            last = early;
            if (lastAdd == null) {
                first = early;
            } else {
                lastAdd.setNext(early);
            }
            size++;
            modCount++;
        }
        node = first;
    }

    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return position < size && last != null;
            }

            @Override
            public E next() {
                E result;
                if (hasNext()) {
                    result = first.getElement(); //element node.
                    first = first.getNext(); //decreasing value of
                    position++;
                    return result;
                }
                throw new NoSuchElementException();

            }
        };
    }
}


