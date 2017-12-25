package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Шахматная доска.
 * @author Ayup Bariev.
 * @since 28.09.2017
 */
public class BoardTest {
    /**
     * Test board 3x3.
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x\n x \nx x\n", line, line, line);
        assertThat(result, is(expected));
    }

    /**
     * Test board 5x4.
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String outcome = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x x\n x x \nx x x\n x x \n", line, line, line, line);
        assertThat(outcome, is(expected));
    }
}
