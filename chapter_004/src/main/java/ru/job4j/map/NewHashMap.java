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
    private Entry[] array;
    private int count = 0; //for Iterator
    private class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    /**
     * Constructor.
     * @param size array length.
     */
    public NewHashMap(int size) {
        this.size = size;
        array = new Entry[size];
    }

    public int getSize() {
        return array.length;
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
        array = Arrays.copyOf(array, size * 2);
        size = array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[hashFunc((K) array[i])] = array[i];
            }
        }
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
        if (array[index] == null) {
            array[index] = new Entry(key, value);
            modCount++;
            return true;
        }
        return false;
    }

    public boolean put(K key, V value) {
        return insert(key, value);
    }

    public V get(K key) {
        if (array[hashFunc(key)] != null) {
            return (V) array[hashFunc(key)].value;
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
        if (array[index] != null) {
            array[index] = null;
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
                while (array[count] == null && count < size - 1) {
                    count++;
                }
                return array[count] != null;
            }

            @Override
            public V next() {
                checkModification();
                if (hasNext()) {
                    Object item = array[count++];
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
