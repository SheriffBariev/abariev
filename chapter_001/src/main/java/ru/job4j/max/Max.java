package ru.job4j.max;

/**
 * Максимум из двух чисел.
 * @author Ayup Bariev (mailto: abdullaiman06@gmail.com)
 * @since 24.09.2017
 */
public class Max {
    /**
     * Метод возвращающий большее число.
     * @param first первое значение.
     * @param second второе значение.
     * @return возврат большего значения.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
