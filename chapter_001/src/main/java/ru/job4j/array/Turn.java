package ru.job4j.array;

/**
 * Перевернуть массив.
 *
 * @author Ayup Bariev.
 * @since 02.10.2017.
 */
public class Turn {
    /**
     * Method back.
     * @param array массив.
     * @return array.
     */
    public int[] back(int[] array) {
        int value;
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            value = array[i];
            array[i] = array[j];
            array[j] = value;
        }
        return array;
    }
}
