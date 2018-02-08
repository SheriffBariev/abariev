package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.3.1. Создать динамический список на базе массива.
 * @author Ayup Bariev.
 * @since 26.01.2018.
 */
public class SimpleList<E> implements SimpleContainer<E> {
    public Object[] container;
    int index = 0;
    public int modCount = 0; //Счетчик
    int position = 0; //индекс для итератора

    /**
     * Конструтор.
     */
    public SimpleList() {
        this.container = new Object[5];
    }

    /**
     * Добавление в список элемента.
     * @param e
     */
    public void add(E e) {
        if (index == container.length) {
            Object[] simpleList = new Object[index * 2];
            System.arraycopy(container, 0, simpleList, 0, container.length); //полное копирование массива в simpleList.
            container = simpleList; // перезапись container.
        }
        modCount++;
        container[index++] = e;
    }

    public E get(int index) {
        return (E) container[index];
    }

    public int length() {
        return container.length;
    }

    public Iterator<E> iterator() {

        int expectedModCount =  modCount;
        return new Iterator<E>() {

            @Override
            public boolean hasNext() {
                checkModification();
                return position < index && container[position] != null;
            }

            @Override
            public E next() {
                checkModification();
                if (hasNext()) {
                    Object item = container[position++];
                    return (E) item;
                }
                throw new NoSuchElementException("");
            }

            /**
             * fail-fast поведение. Cравнение сохраненного значения, с текущим значением поля modCount.
             */
            public void checkModification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
