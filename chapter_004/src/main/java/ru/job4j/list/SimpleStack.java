package ru.job4j.list;

/**
 * LIFO - last input first output.
 * @author Ayup Bariev.
 * @since 30.01.2018.
 */
public class SimpleStack<T> extends SimpleQueue<T> {
    /**
     * Retrieves and removes the last element of this deque.
     * @return element.
     */
    private T retrievesAndRemove() {
        T element = last.element;
        Node<T> prev = last.prev;
        last.element = null;
        last.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
        modCount++;
        return element;
    }

    public T poll() {
        return this.retrievesAndRemove();
    }
}
