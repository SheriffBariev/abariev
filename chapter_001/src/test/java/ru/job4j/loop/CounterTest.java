package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *@author Ayup Bariev (mailto:abdullaiman06@gmail.com)
 *@since 28.09.2017
 */
public class CounterTest {

    /**
     *Test sum even numbers.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        int result = count.add(0, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}
