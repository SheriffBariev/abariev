package ru.job4j.list;

/**
 * FIFO - first input first output.
 * @author Ayup Bariev.
 * @since 30.01.2018.
 */
public class SimpleQueue<T> extends SimpleLinkedList<T> {
    /**
     * Retrieves and removes the first element of this Queue.
     * @return element.
     */
    private T retrievesAndRemove() {
        final T value = first.element;
        final Node<T> next = first.next;
        first.element = null;
        first.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        modCount++;
        return value;
    }

    public T poll() {
        return this.retrievesAndRemove();
    }

    /**
     * Inserts the specified element at the front of this Queue.
     * @param value element.
     */
    public void push(T value) {
       this.add(value);
    }
}
