package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 * @author Ayup Bariev.
 * @since 07.10.2017.
 */
public class RotateArrayTest {
    /**
     * Test rotatearrayTwo.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int[][] array = {{1, 2}, {4, 5}};
        int[][] result = rotateArray.rotate(array);
        int[][] expected = {{4, 1}, {5, 2}};
        assertThat(result, is(expected));
    }
    /**
     * Test rotatearrayTwo.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = rotateArray.rotate(array);
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(result, is(expected));
    }
}
