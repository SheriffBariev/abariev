package ru.job4j.condition;

/**
 * Point.
 * @author Ayup Bariev (mailto: abdullaiman06@gmail.com)
 * @since 24.09.2017
 */
public class Point {

    /**
     * Приватные переменные x.
     */
    private int x;

    /**
     * Приватные переменные y.
     */
    private int y;

    /**
     * Point.
     * @param x переменная x.
     * @param y переменная y.
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x.
     * @return return x.
     */

    public int getX() {
        return this.x;
    }

    /**
     * Get y.
     * @return return y.
     */

    public int getY() {
        return this.y;
    }

    /**
     * Assay.
     * @param a переменная а.
     * @param b переменная b.
     * @return true or false.
     */

    public boolean is(int a, int b) {
        return y == a * x + b ? true : false;
    }
}
