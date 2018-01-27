package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.3.2. Создать контейнер на базе связанного списка.
 * @author Ayup Bariev.
 * @since 27.01.2018.
 */
public class SimpleLinkedList<E> implements SimpleContainer<E> {
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
     * adding a node to the end.
     * @param value abs value.
     */
    @Override
    public void add(E value) {
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

    @Override
    public E get(int index) {
        Node<E> i = first;
        for (int count = 0; count < index; count++) {
            i = i.next;
        }
        return i.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                checkMod();
                return position < size && last != null;
            }

            @Override
            public E next() {
                E result;
                checkMod();
                if (hasNext()) {
                    result = first.getElement(); //element node.
                    first = first.getNext(); //decreasing value of
                    position++;
                    return result;
                }
                throw new NoSuchElementException();

            }
            public void checkMod() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
