package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 * @author Ayup Bariev.
 * @since 19.12.2017.
 */
public class ConvertListTest {
    /**
     * Тест конвертация двумерного массива в Arraylist.
     */
    @Test
    public void whenSetDoubleArrayThenConvertToArrayList() {
        ConvertList convertList = new ConvertList();
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> listArray = convertList.toList(array);
        List<Integer> expectedList = new ArrayList<>();
        for (int index = 1; index < 7; index++) {
        expectedList.add(index);
        }
        assertThat(listArray, is(expectedList));
    }

    /**
     * Тест конвертация ArrayList в двумерный массив.
     */
    @Test
    public void whenSetArrayListThenConvertToDoubleArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int index = 1; index < 10; index++) {
            list.add(index);
        }
        int[][] matrix = convertList.toArray(list, 3);
        int[][] expectedArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertThat(matrix, is(expectedArray));
    }

    /**
     * Конвертация листа массивов в один лист.
     */

    @Test
    public void whenSetArraySheetThenCovertArrayList() {
        ConvertList convertList = new ConvertList();
        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[]{1, 2});
        arrayList.add(new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(arrayList);
        List<Integer> expected = new ArrayList<>();
        for (int index = 1; index < 7; index++) {
            expected.add(index);
        }
        assertThat(result, is(expected));
    }
}