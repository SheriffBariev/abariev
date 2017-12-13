package ru.job4j.test;

import ru.job4j.test.exception.ImpossibleMoveException;

/**
 * Слон.
 */
public class Bishop extends Figure {
    /**
     * Конструткор.
     * @param dest позиция.
     */
    public Bishop(Cell dest) {
        super(dest);
    }

    /**
     * Путь.
     * @param source начальная клетка.
     * @param dest конечная точка.
     * @return пройденный клетки.
     * @throws ImpossibleMoveException ошибка.
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int destX = dest.getX();
        int destY = dest.getY();
        int sourceX = source.getX();
        int sourceY = source.getY();
        Cell[] cells = new Cell[Math.abs(sourceX - destX)];
        if (Math.abs(destX - sourceX) == Math.abs(destY - sourceY)) {
            if (destX < sourceX && destY > sourceY) {
                for (int index = 0; index < cells.length; index++) {
                    sourceX -= 1;
                    sourceY += 1;
                    cells[index] = new Cell(sourceX, sourceY);
                }
            } else if (destX > sourceX && destY > sourceY) {
                for (int index = 0; index < cells.length; index++) {
                    sourceX += 1;
                    sourceY += 1;
                    cells[index] = new Cell(sourceX, sourceY);
                }
            } else if (destX > sourceX && destY < sourceY) {
                for (int index = 0; index < cells.length; index++) {
                    sourceX += 1;
                    sourceY -= 1;
                    cells[index] = new Cell(sourceX, sourceY);
                }
            } else if (destX < sourceX && destY < sourceY) {
                for (int index = 0; index < cells.length; index++) {
                    sourceX -= 1;
                    sourceY -= 1;
                    cells[index] = new Cell(sourceX, sourceY);
                }
            }
        } else {
            throw new ImpossibleMoveException("Impossible move.");
        }
        return cells;
    }

    /**
     * Копия новой фигуры с конечной клеткой.
     * @param dest конечная клетка.
     * @return объект.
     */
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }

}
