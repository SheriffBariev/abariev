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
    public T poll() {
        return getRemoveTail();
    }
}
