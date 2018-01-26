package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 * @author Ayup Bariev.
 * @since 26.01.2018.
 */
public class SimpleListTest {
    private SimpleList<Integer> list;

    @Test
    public void whenFullContainerShouldContainerIsIncreasedTwice() {
        list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertThat(list.get(4), is(5));
        assertThat(list.length(), is(5));
        list.add(6);
        assertThat(list.length(), is(10));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorWhenGoesOverBorderShouldThrowException() {
        list = new SimpleList<>();
        list.add(5);
        list.add(6);
        list.add(3);
        Iterator it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void givenIteratorWhenModifyListThenThrowException() {
        list = new SimpleList<>();
        list.add(5);
        list.add(6);
        list.add(3);
        Iterator it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        list.add(10);
        it.next();
    }
}