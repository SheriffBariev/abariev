package ru.job4j.map;

import com.sun.javafx.runtime.async.AbstractRemoteResource;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * HashMap.
 * @author Ayup Bariev.
 * @since 27.02.2018.
 */
public class NewHashMap<K, V> {
    private int size;
    private int modCount = 0;
    private Object[][] array;
    private int count = 0; //for Iterator

    /**
     * Constructor.
     * @param size array length.
     */
    public NewHashMap(int size) {
        this.size = size;
        array = new Object[2][size];
    }

    public int getSize() {
        return array[0].length;
    }

    /**
     * Hash function.
     * @param key key.
     * @return value.
     */
    private int hashFunc(K key) {
        return key.hashCode() % size;
    }

    /**
     * reSize.
     */
    private void resize() {
        Object[][] newArray = new Object[2][array[0].length * 2];
        size = newArray[0].length;
        for (int i = 0; i < array[0].length; i++) {
            newArray[0][hashFunc((K) array[0][i])] = array[0][i];
            newArray[1][hashFunc((K) array[0][i])] = array[1][i];
        }
        array = newArray;
    }

    /**
     * put element.
     * @param key key.
     * @param value value.
     * @return boolean.
     */
    private boolean insert(K key, V value) {
        if (modCount == size) {
            resize();
        }
        int index = hashFunc(key);
        if (array[0][index] == null) {
            array[0][index] = key;
            array[1][index] = value;
            modCount++;
            return true;
        }
        return false;
    }

    public boolean put(K key, V value) {
        return insert(key, value);
    }

    public V get(K key) {
        if (array[0][hashFunc(key)] != null) {
            return (V) array[1][hashFunc(key)];
        }
        return null;
    }

    /**
     * delete.
     * @param key key.
     * @return boolean.
     */
    private boolean delete(K key) {
        int index = hashFunc(key);
        if (array[0][index] != null) {
            array[0][index] = null;
            array[1][index] = null;
            modCount--;
            return true;
        }
        return false;
    }

    public boolean remove(K key) {
        return delete(key);
    }

    public Iterator<V> iterator() {

        int expectedModCount =  modCount;
        return new Iterator<V>() {

            @Override
            public boolean hasNext() {
                checkModification();
                if (count == size) {
                    return false;
                }
                while (array[0][count] == null) {
                        count++;
                }
                return array[0][count] != null;
            }

            @Override
            public V next() {
                checkModification();
                if (hasNext()) {
                    Object item = array[1][count++];
                    return (V) item;
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
