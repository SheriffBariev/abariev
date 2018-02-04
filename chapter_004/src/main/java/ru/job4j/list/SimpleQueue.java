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
    public T poll() {
        return getRemoveHead();
    }

    /**
     * Inserts the specified element at the front of this Queue.
     * @param value element.
     */
    public void push(T value) {
       this.add(value);
    }
}
