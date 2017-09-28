package ru.job4j.loop;

/**
 * Подсчет суммы чётных чисел в диапазоне.
 *
 * @author Ayup Bariev (mailto:abdullaiman06@gmail.com)
 * @since 28.09.2017
 */
public class Counter {
    /**
     * Метод вычисляет сумму четныx чисел.
     * @param start начальное значение.
     * @param finish конечное значение.
     * @return результат.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (start = 0; start <= finish; start++) {
            if (start % 2 == 0) {
                sum = sum + start;
            }
        }
        return sum;
    }
}
