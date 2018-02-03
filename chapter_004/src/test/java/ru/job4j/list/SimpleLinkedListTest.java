package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Sheriff on 27.01.2018.
 */
public class SimpleLinkedListTest {
    private  SimpleLinkedList<Integer> simple;

    @Test
    public void whenAddNodeShouldGetNodeWithIndex() {
        simple = new SimpleLinkedList<>();
        simple.add(1);
        simple.add(2);
        simple.add(3);
        assertThat(simple.get(2), is(3));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenIteratorGoesOverBorderShouldThrowException() {
        simple = new SimpleLinkedList<>();
        for (int index = 0; index < 4; index++) {
            simple.add(index);
        }
        Iterator<Integer> iterator = simple.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void givenIteratorWhenModifyListThenThrowException() {
        simple = new SimpleLinkedList<>();
        simple.add(4);
        simple.add(3);
        simple.add(7);
        Iterator it = simple.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        simple.add(10);
        it.next();
    }

    @Test
    public void shouldReturnThree() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(list.get(2), is(3));
    }
}