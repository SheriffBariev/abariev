package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test has Cycle.
 */
public class NodeTest {
    @Test
    public void whenHasCycleShouldTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = five;
        assertThat(first.hasCycle(first), is(true));
    }

    @Test
    public void whenNodeEqualNullShouldResultFalse() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(13);
        first.next = two;
        two.next = third;
        third.next = null;
        assertThat(first.hasCycle(first), is(false));
    }
}