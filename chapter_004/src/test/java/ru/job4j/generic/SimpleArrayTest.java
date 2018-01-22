package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test for Generic.
 */
public class SimpleArrayTest {
    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleArray<String> simpleArray = new SimpleArray(3);
        simpleArray.add("Developer");
        simpleArray.add("Ayup");
        simpleArray.add("User");
        simpleArray.set(1, "Tester");
        String result = simpleArray.get(1);

        assertThat(result, is("Tester"));
    }

    @Test
    public void whenTypeIntShouldReturnInt() {
        SimpleArray<Integer> simpleArray = new SimpleArray(3);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.delete(0);
        Integer result = simpleArray.get(0);

        assertThat(result, is(nullValue()));
    }
}
