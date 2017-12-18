package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3. Конвертация двумерного массива в ArrayList и наоборот
 */
public class ConvertList {
    /**
     * Конвертация в коллекци.
     * @param array массив.
     * @return коллекция.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] matrix : array) {
            for (int index : matrix) {
                list.add(index);
            }
        }
        return list;
    }

    /**
     * Конвертация в массив.
     * @param list коллекция.
     * @param rows длина внутреннего массива.
     * @return массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int x = list.size() / rows;
        int index = list.size() % rows != 0 ? x + 1 : x;
        int[][] resultArray = new int[index][rows];
        int key = 0;
        for (int value = 0; value < index; value++) {
            for (int cell = 0; cell < rows; cell++) {
                if (key <= list.size() - 1) {
                    resultArray[value][cell] = list.get(key);
                    key++;
                }
            }
        }
        return resultArray;
    }


    public static void main(String[] args) {
        /**
         * тест первого метода.
         */
        ConvertList convertList = new ConvertList();
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> listArray = convertList.toList(array);
        System.out.println(listArray);

        /**
         * тест второго метода.
         */
        List<Integer> list = new ArrayList<>();
        for (int index = 1; index < 10; index++) {
            list.add(index);
        }
        int[][] matrix = convertList.toArray(list, 3);
        System.out.println(Arrays.deepToString(matrix));

    }
}
