package ru.job4j.calculator;

/**
 * Calculator.
 * @author Ayup Bariev (mailto:abdullaiman06@gmail.com)
 * @since 21.09.2017
 */
public class Calculator {
    /**
     * @param result внутренняя двоичная переменная
     */

    private double result;

    /**
     * Addition.
     *
     * @param first первый аргумент.
     * @param second второй аргумент.
     */

    public void add(double first, double second) {

        this.result = first + second;
    }
    /**
     * Subract.
     *
     * @param first первый аргумент.
     * @param second второй аргумент.
     */

    public void subtract(double first, double second) {

        this.result = first - second;
    }
    /**
     * Division.
     *
     * @param first первый аргумент.
     * @param second второй аргумент.
     */

    public void div(double first, double second) {

        this.result = first / second;
    }
    /**
     * Multiple.
     *
     * @param first первый аргумент.
     * @param second второй аргумент.
     */

    public void multiple(double first, double second) {

        this.result = first * second;
    }
    /**
     *Return.
     *@return результат.
     */

    public double getResult() {

        return this.result;
    }
}
