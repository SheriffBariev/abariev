package ru.job4j.test;

import org.junit.Test;
import ru.job4j.test.exception.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test board.
 * @author Ayup Bariev.
 */
public class BoardTest {
    @Test
    public void whenAddFigureAndMoveThenFigureNewPosition() throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Bishop bishop = new Bishop(new Cell(2, 0));
        board.addFigure(bishop);
        boolean result = board.move(bishop.position, new Cell(0, 2));
        assertThat(result, is(true));
    }


}