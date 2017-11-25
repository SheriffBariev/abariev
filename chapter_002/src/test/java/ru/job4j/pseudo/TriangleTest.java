package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author abariev
 * @since 25.11.2017
 */
public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.pic(),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(" + + ")
                                .append("+++++")
                                .toString()
                )
        );
    }
}
