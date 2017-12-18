package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
     * Конвертация листа массивов в один лист Integer.
     * @param list коллекция листа массивов.
     * @return возврат одного листа.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> arrayList = new ArrayList<>();
        for (int[] i : list) {
            for (int j : i) {
                arrayList.add(j);
            }
        }
        return arrayList;
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
}
