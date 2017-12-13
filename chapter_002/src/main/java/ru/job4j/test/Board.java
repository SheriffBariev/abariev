package ru.job4j.test;

import ru.job4j.test.exception.*;

/**
 * Доска.
 */
public class Board {
    /**
     * Приватный 2-й массив.
     */
    private Figure[][] figures = new Figure[8][8];

    /**
     * Метод move.
     * @param source
     * @param dest
     * @return boolean value
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        boolean way = false;
        int sourceX = source.getX();
        int sourceY = source.getY();
        int destX = dest.getX();
        int destY = dest.getY();

        if (figures[sourceX][sourceY] != null) {
            result = true;
        } else {
            throw new FigureNotFoundException("Figure not found.");
        }

        if (result) {
            Cell[] pathExist = figures[sourceX][sourceY].way(source, dest);
            for (int index = 0; index < pathExist.length; index++) {
                if (figures[pathExist[index].getX()][pathExist[index].getY()] == null) {
                    way = true;
                } else {
                    throw new OccupiedWayException("Occupied Way.");
                }
            }
        }
        if (way) {
            figures[destX][destY] = figures[sourceX][sourceY].copy(dest);
            figures[sourceX][sourceY] = null;
        }
        return result;
    }

    /**
     * Добавление фигуры на доску.
     * @param figure фигура.
     */
    public void addFigure(Figure figure) {
        figures[figure.position.getX()][figure.position.getY()] = figure;
    }
}

/**Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
 - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
 - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
 - Если все отлично. Записать в ячейку новое новое положение Figure figure.copy(Cell dest)
 */

