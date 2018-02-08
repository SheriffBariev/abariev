package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkedSetTest {

    @Test (expected = NoSuchElementException.class)
    public void whenThen() {
        SimpleLinkedSet<String> linkedSet = new SimpleLinkedSet<>();

        linkedSet.addLinkedSet("one");
        linkedSet.addLinkedSet("two");
        linkedSet.addLinkedSet("two");
        linkedSet.addLinkedSet("three");
        Iterator<String> it = linkedSet.iterator();
        assertThat(it.next(), is("one"));
        assertThat(it.next(), is("two"));
        assertThat(it.next(), is("three"));
        it.next();

    }

}