package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test fot class Paint.
 * @author Ayup Bariev.
 * @since 29.09.2017
 */
public class PaintTest {
    /**
     *Test with height 2.
     */
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^ \n^^^", System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
    /**
     * Test with height 3.
     */
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint draw = new Paint();
        String outcome = draw.piramid(3);
        String prospective = String.format("  ^  \n ^^^ \n^^^^^", System.getProperty("line.separator"), System.getProperty("line.separator"));
        assertThat(outcome, is(prospective));
    }
}
