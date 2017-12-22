package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test sort Users.
 */
public class SortUserTest {
    @Test
    public void whenSetListThenGetSortedSet() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Ivan", 45));
        list.add(new User("Ayup", 25));
        list.add(new User("Ramzan", 34));
        Set<User> expected = new TreeSet<>();
        expected.add(new User("Ayup", 25));
        expected.add(new User("Ramzan", 34));
        expected.add(new User("Ivan", 45));
        assertThat(sortUser.sort(list), is(expected));
    }

}