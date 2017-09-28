package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * FactorialTest.
 * @author Ayup Bariev
 * @since 28.09.2017
 */
public class FactorialTest {
    /**
     * Test calculate factorial for five.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }

    /**
     * Test calculate factorial for zero.
     */

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial zero = new Factorial();
        int result = zero.calc(0);
        assertThat(result, is(1));
    }
}
