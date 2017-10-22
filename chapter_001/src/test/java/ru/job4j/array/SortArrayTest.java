package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 * @author Ayup Bariev.
 * @since 22.10.2017.
 */
public class SortArrayTest {
    /**
     * Test first is in another.
     */
    @Test
    public void whenFirstWordIsInAnotherWordThenBooleanResult() {
        SortArray sortArray = new SortArray();
        int[] array = {0, 1, 2, 3, 4};
        boolean result = sortArray.contains(array);
        boolean expected = true;
        assertThat(result, is(expected));
    }
    /**
     * Test sort.
     */
    @Test
    public void whenTwoArraysThenSortIntoTheThird() {
        SortArray sort = new SortArray();
        int[] array = {1, 2, 3};
        int[] matrix = {5, 1, 6};
        int[] result = sort.merge(array, matrix);
        int[] expected = {1, 1, 2, 3, 5, 6};
        assertThat(result, is(expected));
    }
}