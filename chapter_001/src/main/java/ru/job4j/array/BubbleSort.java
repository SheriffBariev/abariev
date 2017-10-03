package ru.job4j.array;

/**
 * Сортировка массива методом перестановки.
 * @author Ayup Bariev.
 * @since 03.10.2017.
 */
public class BubbleSort {
    /**
     * Сортировка.
     * @param array массив.
     * @return возврат массива.
     */
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int back = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = back;
                }
            }
        }
        return array;
    }
}
