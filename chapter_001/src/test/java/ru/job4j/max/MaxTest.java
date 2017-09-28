package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MaxTest.
 *
 * @author Ayup Bariev (mailto: abdullaiman06@gmail.com)
 * @since 24.09.2017
 */
public class MaxTest {
    /**
     *Test max.
     */
    @Test
    public void whenFirstLessSecond() {
        Max max = new Max();
        int result = max.max(123, 121);
        assertThat(result, is(123));
    }

    /**
     *Test peak value.
     */

    @Test
    public void whenValueMaxLessOutcomeThat() {
        Max peak = new Max();
        int outcome = peak.max(1000, 2000, 2017);
        assertThat(outcome, is(2017));
    }

}
