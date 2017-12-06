package ru.job4j.test;

import java.util.ArrayList;

/**
 * Тестовое задание выдача машины.
 */
public class CoffeeMachine {
    /**
     * Метод выдачи сдачи, с наименшим кол-вом монет.
     * @param value купюра
     * @param price стоимость кофе
     * @return возврат массива.
     */
    ArrayList<Integer> changes(int value, int price) {
        int delivery = value - price;
        int[] array = new int[]{1, 2, 5, 10};
        ArrayList<Integer> matrix = new ArrayList<>();

        for (int index = array.length - 1; index >= 0; index--) {
            for (int count = 0; count < delivery; count++) {
                if (delivery >= array[index]) {
                    delivery -= array[index];
                    matrix.add(array[index]);
                }
            }
        }
        return matrix;
    }
}
