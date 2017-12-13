package ru.job4j.test;

import ru.job4j.test.exception.ImpossibleMoveException;

/**
 * Абстрактный класс.
 */
abstract class Figure {
    final Cell position;
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Абстрактный метод
     * @param source начальная точка.
     * @param dest конечная точка.
     * @return вернуть массив.
     * @throws ImpossibleMoveException ошибка.
     */
    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * абстрактный метод копирования обьекта.
     * @param dest конечная точка.
     * @return возврат.
     */
    abstract Figure copy(Cell dest);
}
