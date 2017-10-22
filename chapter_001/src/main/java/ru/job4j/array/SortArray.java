package ru.job4j.array;

import java.util.Arrays;

/**
 * Проверка остортирован массив иль нет.
 * @author Ayup Bariev.
 * @since 22.10.2017.
 */
public class SortArray {
    /**
     * Метод проверки сортированного массив.
     *
     * @param array массив.
     * @return булевое значение.
     */
    boolean contains(int[] array) {
        int[] massive = new int[array.length];
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    massive[j + 1] = array[j];
                    massive[j] = array[j + 1];
                } else {
                    massive[j] = array[j];
                }
            }
        }
        massive[massive.length - 1] = array[array.length - 1];
        return Arrays.equals(massive, array) ? true : false;
    }
    /**
     * Сортировка.
     * @param array первый массив.
     * @param matrix второй массив.
     * @return возврат сортированного массива.
     */
    public int[] merge(int[] array, int[] matrix) {
        BubbleSort sort = new BubbleSort();
        array = sort.sort(array);
        matrix = sort.sort(matrix);
        int a = 0, b = 0; // a, b - счетчики в массивах
        int len = array.length + matrix.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < matrix.length && a < array.length) {
                if (array[a] > matrix[b]) {
                    result[i] = matrix[b++];
                } else {
                    result[i] = array[a++];
                }
            } else if (b < matrix.length) {
                result[i] = matrix[b++];
            } else {
                result[i] = array[a++];
            }
        }
        return result;
    }
    //    int[] sortArray(int[] array, int[] matrix) {
    //        int[] massive = new int[array.length + matrix.length];
    //
    //        return massive;
    //    }
}