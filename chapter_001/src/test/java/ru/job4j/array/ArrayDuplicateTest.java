package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Тест.
 * @author Ayup Bariev.
 * @since 11.10.2017
 */
public class ArrayDuplicateTest {
    /**
     * Удаление дубликатов.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDublicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] array = {"Volvo", "LADA", "Volvo", "Lada", "Mercedes-Benz", "Mercedes-Benz"};
        String[] expectedArray = {"Volvo", "LADA", "Mercedes-Benz", "Lada"};
        String[] resultArray = duplicate.remove(array);
        assertThat(resultArray, is(expectedArray));
    }

}
