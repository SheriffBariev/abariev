package ru.job4j.list;

import java.util.Objects;

/**
 * 5.3.4. Задан связанный список. Определить цикличность.
 * @author Ayup Bariev.
 * @since 03.02.2018.
 */
public class Node<T> {
    private T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    /**
     * Метод поиска цикла в списке.
     * @param first первый узел в списке.
     * @return  true если односвязный список имеет зацикливания, в противном случае возвращает false.
     */
    public boolean hasCycle(Node first) {
        boolean result = false;
        Node<T> slowly = null;
        Node<T> quickly = null;
        if (first != null) {
            slowly = first;
            quickly = first.next;
        }
        while (!result && quickly != null) {
            if (quickly.next != null
                    && quickly.next.next != null) {
                if (slowly == quickly
                        || slowly == quickly.next
                        || slowly == quickly.next.next) {
                    result = true;
                }
                quickly = quickly.next.next.next;
                slowly = slowly.next;
            } else {
                quickly = null;
            }
        }
        return result;
    }

}
