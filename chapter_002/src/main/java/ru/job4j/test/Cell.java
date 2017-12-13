package ru.job4j.test;

/**
 * Класс описывающий ячейки шахматной доски.
 */
public class Cell {
    int x;
    int y;

    /**
     * конструктор
     * @param x точка.
     * @param y точка.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * гет.
     * @return x.
     */
    public int getX() {
        return x;
    }

    /**
     * get.
     * @return y.
     */
    public int getY() {
        return y;
    }
}
