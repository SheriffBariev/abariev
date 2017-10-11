package ru.job4j.array;

import java.util.Arrays;

/**
 * Убрать все дубликаты строк из массива.
 * @author Ayup Bariev.
 * @since 11.10.2017
 */
public class ArrayDuplicate {
    /**
     * Удаление повторяющихся строк.
     * @param array массив.
     * @return возравт массива.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[in].equals(array[out])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
