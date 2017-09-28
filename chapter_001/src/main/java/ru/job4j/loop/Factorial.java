package ru.job4j.loop;

/**
 * Factorial.
 * @author Ayup Bariev.
 * @since 28.09.2017
 */
public class Factorial {
    /**
     * Метод вычесляющий фактроиал.
     * @param n целочисленная переменная.
     * @return результат.
     */
    public int calc(int n) {
        if (n == 0) {
            return 1;
        } else {
            int multiplication = 1;
            for (int a = 1; a <= n; a++) {
                multiplication = multiplication * a;
            }
            return multiplication;
        }
    }
}
