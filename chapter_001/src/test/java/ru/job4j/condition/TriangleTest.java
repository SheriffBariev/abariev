package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * TriangleTest.
 * @author Ayup Bariev
 * @since 24.09.2017
 */
public class TriangleTest {
    /**
     * Test.
     */
    @Test
    public void whenAreaSetThreePointThenTriangleArea() {
        Point a = new Point(2, 4);
        Point b = new Point(2, 6);
        Point c = new Point(3, 5);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 1D;
        assertThat(result, closeTo(expected, 0.1));
    }
}
