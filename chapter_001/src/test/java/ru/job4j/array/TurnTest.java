package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * TurnTest.
 *
 * @author Ayup Bariev (mailto: abdullaiman06@gmail.com)
 * @since 02.10.2017
 */
public class TurnTest {
    /**
     * Переворот массива с четным индексом.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] array = {2, 6, 1, 4};
        int[] result = turn.back(array);
        int[] expected = {4, 1, 6, 2};
        assertThat(result, is(expected));
        //напишите здесь тест, проверяющий переворот массива с чётным числом элементов, например {2, 6, 1, 4}.
    }
    /**
     * Переворот массива с нечетным индексом.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] array = {1, 2, 3, 4, 5};
        int[] result = turn.back(array);
        int[] expected = {5, 4, 3, 2, 1};
        assertThat(result, is(expected));
        //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов, например {1, 2, 3, 4, 5}.
    }
}
