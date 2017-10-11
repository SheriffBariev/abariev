package ru.job4j.array;

/**
 * Rotate array.
 * @author Ayup Bariev.
 * @since 06.10.2017.
 */
public class RotateArray {

    /**
     * Поворот массива.
     *
     * @param array массив.
     * @return возвращаем дополнительный массив.
     */
    public int[][] rotate(int[][] array) {
        int[][] matrix = new int[array.length][array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array.length; j++) {
                if (i == 0) {
                    matrix[j][array.length - 1] = array[i][j];
                } else {
                    matrix[j][array.length - 1 - i] = array[i][j];
                }
            }
        }
        return matrix;
    }
}
