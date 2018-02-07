package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test SimpleSet implementation with SimpleList.
 */
public class SimpleSetTest {
    @Test
    public void whenWeAddDuplicateValuesThenValuesAreNotDuplicated() {
        SimpleSet<String> simpleSet = new SimpleSet();
        simpleSet.setElement("First");
        simpleSet.setElement("Tree");
        simpleSet.setElement("Tree");
        simpleSet.setElement("Second");
        simpleSet.setElement("Third");
        String[] expected = new String[]{"First", "Tree", "Second", "Third"};
        assertThat(simpleSet.getContainer(), is(expected));
    }

    @Test
    public void whenHasNextShouldReturnTrue() {
        SimpleSet<String> simpleSet = new SimpleSet();
        simpleSet.setElement("First");
        simpleSet.setElement("Tree");
        simpleSet.setElement("Tree");
        simpleSet.setElement("Second");
        simpleSet.setElement("Third");
        Iterator<String> it = simpleSet.iterator();
        assertThat(it.hasNext(), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenHasNextNotElementThenShowException() {
        SimpleSet<String> simpleSet = new SimpleSet();
        simpleSet.setElement("First");
        simpleSet.setElement("Tree");
        simpleSet.setElement("Tree");
        simpleSet.setElement("Second");
        simpleSet.setElement("Third");

        Iterator<String> it = simpleSet.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
        it.next();
    }


}