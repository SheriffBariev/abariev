package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 * @author Bariev Ayup.
 */
public class TreeBSTTest {
    @Test
    public void whenAddAnElementThenWeGetBinaryTree() {
        TreeBST<Integer> treeBST = new TreeBST<Integer>(10);
        treeBST.add(2);
        treeBST.add(3);
        treeBST.add(20);
        treeBST.add(5);
        treeBST.add(6);
        Iterator it = treeBST.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        assertThat(it.next(), is(6));
    }

    @Test
    public void whenHasNextShouldReturnTrue() {
        TreeBST<Integer> treeBST = new TreeBST<Integer>(100);
        treeBST.add(25);
        treeBST.add(35);
        treeBST.add(205);
        treeBST.add(55);
        treeBST.add(65);
        Iterator it = treeBST.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(55));
    }

}