package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

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
    @Test
    public void whenSetListThenSortedNameLength() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(
                Arrays.asList(
                        new User("SheriffPython", 25),
                        new User("Ivan", 30),
                        new User("KapitanGoshan", 20),
                        new User("Ayup", 25)
                )
        );
        List<User> expected = new ArrayList<>();
        expected.addAll(
                Arrays.asList(
                        new User("Ayup", 25),
                        new User("Ivan", 30),
                        new User("KapitanGoshan", 20),
                        new User("SheriffPython", 25)
                )
        );
        assertThat(sortUser.sortNameLength(list), is(expected));
    }

    @Test
    public void whenSetListThenSortedByAllFields() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(
                Arrays.asList(
                        new User("Сергей", 25),
                        new User("Иван", 30),
                        new User("Сергей", 20),
                        new User("Иван", 25)
                )
        );
        List<User> expected = new ArrayList<>();
        expected.addAll(
                Arrays.asList(
                        new User("Иван", 25),
                        new User("Иван", 30),
                        new User("Сергей", 20),
                        new User("Сергей", 25)
                )
        );
        assertThat(sortUser.sortByAllFields(list), is(expected));
    }


}