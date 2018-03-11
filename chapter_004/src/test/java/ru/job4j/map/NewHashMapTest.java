package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

/**
 * Created by Sheriff on 27.02.2018.
 */
public class NewHashMapTest {
    @Test
    public void whenAddAndGetAndDeleteKeyAndValueThenCheckMethods() {
        NewHashMap<Integer, String> newMap = new NewHashMap<>(3);

        newMap.put(0, "Audi");
        newMap.put(1, "Toyota");
        newMap.put(2, "Saab");

        //Checking for doubles in arrays.
        assertThat(newMap.put(2, "Mitsubishi"), is(false));

        assertThat(newMap.remove(1), is(true));
        assertThat(newMap.get(1), is(nullValue()));
    }

    @Test
    public void whenOutOfBoundShouldIncreaseLength() {
        NewHashMap<Integer, String> newMap = new NewHashMap<>(2);
        newMap.put(1, "One");
        newMap.put(2, "Two");
        newMap.put(3, "Three");
        assertThat(newMap.getSize(), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenHasNextShouldNext() {
        NewHashMap<Integer, String> newMap = new NewHashMap<>(2);
        newMap.put(1, "Tune");
        newMap.put(2, "Harmony");
        Iterator it = newMap.iterator();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
