package ru.job4j.adoration;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест.
 */
public class UserConvertTest {
    @Test
    public void whenProccesListThenConvertListToMap() {
        UserConvert userConvert = new UserConvert();
        User sheriff = new User(0, "Ayup");
        User guest = new User(1, "Ivan");
        User admin = new User(2, "Petr");
        List<User> listUsers = new ArrayList<>();
        listUsers.add(sheriff);
        listUsers.add(guest);
        listUsers.add(admin);
        HashMap<Integer, User> result = userConvert.process(listUsers);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(0, sheriff);
        expected.put(1, guest);
        expected.put(2, admin);
        assertThat(result, is(expected));
    }
}