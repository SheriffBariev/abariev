package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Sheriff on 30.01.2018.
 */
public class SimpleQueueTest {

    /**
     * Test Queue.
     */
    @Test
    public void whenInsertElementOfQueueThanRetrievesAndRemovesFirstElement() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }

    /**
     * Test Stack.
     */
    @Test
    public void whenInsertElementOfStackThanRetrievesAndRemovesLastElement() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
    }

}