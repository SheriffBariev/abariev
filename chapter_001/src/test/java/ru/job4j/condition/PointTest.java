package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PointTest.
 * @author Ayup Bariev (mailto:abdullaiman06@gmail.com)
 * @since 24.09.2017
 */
public class PointTest {

    /**
     *Test is point on line.
     */

    @Test
    public void whenPointOnLineThenTrue() {
        Point point = new Point(5, 6);
        boolean assay = point.is(1, 1);
        assertThat(assay, is(true));
    }
}
