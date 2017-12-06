package ru.job4j.test;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест.
 * @author abariev.
 */
public class CoffeeMachineTest {
    /**
     * Тест выдачи сдачи.
     */
    @Test
    public void whenBuyingCoffeeThenGiveChange() {
        CoffeeMachine coffee = new CoffeeMachine();
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(10);
        expected.add(10);
        expected.add(5);
        expected.add(2);
        assertThat(coffee.changes(100, 63), is(expected));

    }

}